package com.madadipouya.telegram.corona.general.command.resolver.impl;

import com.madadipouya.telegram.corona.general.command.BotCommand;
import com.madadipouya.telegram.corona.general.command.Command;
import com.madadipouya.telegram.corona.general.command.CommandType;
import com.madadipouya.telegram.corona.general.command.resolver.CommandResolver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
public class DefaultCommandResolver implements CommandResolver {

    private final Map<CommandType, BotCommand> botCommandMap;

    public DefaultCommandResolver(List<BotCommand> botCommands) {
        botCommandMap = botCommands.stream().map(command -> Map.entry(command.getSupportedType(), command))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public Command resolve(String commandName) {
        return resolveBotCommand(commandName).orElse(botCommandMap.get(CommandType.NO_OP));
    }

    private Optional<Command> resolveBotCommand(String commandName) {
        try {
            return Optional.ofNullable(botCommandMap.get(CommandType.getCommand(commandName)));
        } catch (IllegalArgumentException noCommandTypeFoundException) {
            return Optional.empty();
        }
    }
}
