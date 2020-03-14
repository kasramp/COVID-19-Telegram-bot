package com.madadipouya.telegram.corona.user.interceptor;

import com.madadipouya.telegram.corona.general.rest.dto.Update;
import com.madadipouya.telegram.corona.general.rest.dto.base.Chat;
import com.madadipouya.telegram.corona.i18n.service.I18nService;
import com.madadipouya.telegram.corona.telegram.TelegramService;
import com.madadipouya.telegram.corona.telegram.model.TextFormat;
import com.madadipouya.telegram.corona.user.service.UserAuditService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/*
 * This file is part of COVID-19-Telegram-bot.
 *
 * COVID-19-Telegram-bot is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation.
 *
 * COVID-19-Telegram-bot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.  <http://www.gnu.org/licenses/>
 *
 * Author(s):
 *
 * © 2020 Kasra Madadipouya <kasra@madadipouya.com>
 */

@Order(-1)
@Aspect
@Component
public class UserAuditingInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserAuditingInterceptor.class);

    private final UserAuditService userAuditService;

    private final TelegramService telegramService;

    private final I18nService i18nService;

    public UserAuditingInterceptor(UserAuditService userAuditService, TelegramService telegramService,
                                   I18nService i18nService) {
        this.userAuditService = userAuditService;
        this.telegramService = telegramService;
        this.i18nService = i18nService;
    }

    @Around(value = "execution(* com.madadipouya.telegram.corona.general.rest.TelegramHookController.listen(..)) && args(update)")
    public void addCommandDetailsToMessage(ProceedingJoinPoint proceedingJoinPoint, Update update) throws Throwable {
        String username = getUsername(update);
        if (userAuditService.isAlreadyBlocked(username)) {
            return;
        }
        if (userAuditService.shouldBeBlocked(username)) {
            logger.info("Blocking user: {} because he sent more than 30 request per minute", username);
            userAuditService.block(username);
            if (!update.hasInlineQuery()) {
                telegramService.reply(update.getFirstAvailableMessage().getChat().getId(),
                        i18nService.getMessageWithEmoji("audit.user.interceptor.user.is.blocked.message"),
                        TextFormat.MARK_DOWN);
            }
        } else {
            userAuditService.log(username);
            proceedingJoinPoint.proceed();
        }
    }

    private String getUsername(Update update) {
        if (update.hasInlineQuery()) {
            return update.getInlineQuery().getFrom().getUsername();
        }
        Chat chat = update.getFirstAvailableMessage().getChat();
        return Objects.nonNull(chat) ? chat.getUsername() : update.getCallbackQuery().getFrom().getUsername();
    }
}
