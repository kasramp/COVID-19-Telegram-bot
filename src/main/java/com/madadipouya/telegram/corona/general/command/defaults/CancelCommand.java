package com.madadipouya.telegram.corona.general.command.defaults;

import com.madadipouya.telegram.corona.general.command.BotCommand;
import com.madadipouya.telegram.corona.general.command.CommandType;
import com.madadipouya.telegram.corona.general.rest.dto.base.Message;
import com.madadipouya.telegram.corona.telegram.TelegramService;
import org.springframework.stereotype.Component;

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
public class CancelCommand implements BotCommand {

    private final TelegramService telegramService;

    public CancelCommand(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @Override
    public void execute(Message message, String argument) {
        telegramService.cancelAction(message.getChat().getId(), message.getMessageId());
    }

    @Override
    public CommandType getSupportedType() {
        return CommandType.CANCEL;
    }
}