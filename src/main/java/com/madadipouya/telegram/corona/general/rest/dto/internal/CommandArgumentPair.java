package com.madadipouya.telegram.corona.general.rest.dto.internal;

import com.madadipouya.telegram.corona.general.command.Command;
import com.madadipouya.telegram.corona.general.rest.dto.base.Message;
import org.apache.commons.lang3.StringUtils;

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

public class CommandArgumentPair {

    private Command command;

    private String argument;

    private Message message;

    public CommandArgumentPair(Command command, Message message) {
        this(command, message, StringUtils.EMPTY);
    }

    public CommandArgumentPair(Command command, Message message, String argument) {
        this.command = command;
        this.message = message;
        this.argument = argument;
    }

    public Command getCommand() {
        return command;
    }

    public Message getMessage() {
        return message;
    }

    public String getArgument() {
        return argument;
    }
}
