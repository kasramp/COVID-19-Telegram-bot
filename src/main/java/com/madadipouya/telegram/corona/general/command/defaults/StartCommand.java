package com.madadipouya.telegram.corona.general.command.defaults;

import com.madadipouya.telegram.corona.general.command.BotCommand;
import com.madadipouya.telegram.corona.general.command.CommandType;
import com.madadipouya.telegram.corona.general.rest.dto.base.Message;
import com.madadipouya.telegram.corona.i18n.service.I18nService;
import com.madadipouya.telegram.corona.telegram.TelegramService;
import com.madadipouya.telegram.corona.telegram.model.TextFormat;
import org.springframework.stereotype.Component;

import static com.madadipouya.telegram.corona.general.command.CommandType.START;

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

@Component
public class StartCommand implements BotCommand {

    private final TelegramService telegramService;

    private I18nService i18nService;

    public StartCommand(TelegramService telegramService, I18nService i18nService) {
        this.telegramService = telegramService;
        this.i18nService = i18nService;
    }

    @Override
    public void execute(Message message, String argument) {
        telegramService.reply(message.getChat().getId(), i18nService.getMessageWithEmoji("command.start.message"), TextFormat.MARK_DOWN);
    }

    @Override
    public CommandType getSupportedType() {
        return START;
    }
}
