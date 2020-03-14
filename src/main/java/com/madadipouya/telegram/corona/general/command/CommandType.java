package com.madadipouya.telegram.corona.general.command;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

public enum CommandType {
    CANCEL("/cancel"),
    START("/start"),
    CORONA_VIRUS_LATEST("/latest"),
    CORONA_VIRUS_MY_LOCATION_UPDATE("/my_location"),
    NO_OP(StringUtils.EMPTY);

    private final String value;

    private static Map<String, CommandType> commands = new HashMap<>();

    static {
        Arrays.stream(CommandType.values()).forEach(command -> commands.put(command.value, command));
    }

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CommandType getCommand(String command) {
        CommandType enumCommand = commands.get(command);
        if (enumCommand == null) {
            throw new IllegalArgumentException(String.format("No constant with text %s found", command));
        }
        return enumCommand;
    }
}
