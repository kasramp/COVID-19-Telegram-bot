package com.madadipouya.telegram.corona.i18n.service.impl;

import com.madadipouya.telegram.corona.i18n.service.I18nService;
import com.vdurmont.emoji.EmojiParser;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

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

@Service
public class DefaultI18nService implements I18nService {

    private final MessageSource messageSource;

    public DefaultI18nService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, Locale.getDefault());
    }

    @Override
    public String getMessageWithEmoji(String key, Object... args) {
        return EmojiParser.parseToUnicode(getMessage(key, args));
    }
}
