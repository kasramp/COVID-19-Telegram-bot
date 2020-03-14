package com.madadipouya.telegram.corona.general.command.parser.impl;

import com.google.common.collect.Iterables;
import com.madadipouya.telegram.corona.general.command.Command;
import com.madadipouya.telegram.corona.general.command.resolver.CommandResolver;
import com.madadipouya.telegram.corona.general.command.parser.CommandParser;
import com.madadipouya.telegram.corona.general.rest.dto.Update;
import com.madadipouya.telegram.corona.general.rest.dto.base.CallbackQuery;
import com.madadipouya.telegram.corona.general.rest.dto.base.Message;
import com.madadipouya.telegram.corona.general.rest.dto.base.MessageEntity;
import com.madadipouya.telegram.corona.general.rest.dto.internal.CommandArgumentPair;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.substring;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;

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
public class DefaultCommandParser implements CommandParser {

    private static final String BOT_COMMAND = "bot_command";

    private final CommandResolver commandResolver;

    public DefaultCommandParser(CommandResolver commandResolver) {
        this.commandResolver = commandResolver;
    }

    @Override
    public void parse(Update update) {
        Message message = update.getFirstAvailableMessage();
        update.setCommandArgumentPairs(List.of(parseMessage(message), parseReplyMessage(message),
                parseCallbackQueryByMessage(update), parseCallbackQueryByCallbackData(update))
                .stream().flatMap(List::stream).collect(Collectors.toList()));
    }

    private List<CommandArgumentPair> parseMessage(Message message) {
        return isBlank(message.getText()) && isNull(message.getEntities()) ? List.of() :
                extractCommandArgumentPairs(message);
    }

    private List<CommandArgumentPair> parseReplyMessage(Message message) {
        return nonNull(message.getReplyToMessage()) ?
                extractCommandArgumentPairs(message.getReplyToMessage(), Optional.of(message)) :
                List.of();
    }

    private List<CommandArgumentPair> parseCallbackQueryByMessage(Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            return List.of(new CommandArgumentPair(
                    commandResolver.resolve(callbackQuery.getMessageText()),
                    SerializationUtils.clone(callbackQuery.getMessage()),
                    callbackQuery.getData()));
        }
        return List.of();
    }

    private List<CommandArgumentPair> parseCallbackQueryByCallbackData(Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            return List.of(new CommandArgumentPair(commandResolver.resolve(callbackQuery.getData()),
                    SerializationUtils.clone(callbackQuery.getMessage()),
                    callbackQuery.getData()));
        }
        return List.of();
    }

    private List<CommandArgumentPair> extractCommandArgumentPairs(Message message) {
        return extractCommandArgumentPairs(message, Optional.empty());
    }

    private List<CommandArgumentPair> extractCommandArgumentPairs(Message message, Optional<Message> messageToSet) {
        Message commandArgMessage = messageToSet.orElse(message);
        List<MessageEntity> entities = message.getEntities();
        List<CommandArgumentPair> commandArgumentPairs = new ArrayList<>();
        int entitiesSize = entities.size();
        for (int i = 0; i < entitiesSize; i++) {
            MessageEntity entity = entities.get(i);
            if (isBotEntity(entity)) {
                String argument = isLastEntity(i, entitiesSize) ?
                        trimToEmpty(substring(message.getText(), entity.getOffset() + entity.getLength(), message.getText().length())) :
                        extractArgument(message, i);
                commandArgumentPairs.add(new CommandArgumentPair(resolveCommand(message, i), SerializationUtils.clone(commandArgMessage), argument));
            } else if (!commandArgumentPairs.isEmpty()) {
                CommandArgumentPair lastBotCommand = Iterables.getLast(commandArgumentPairs);
                commandArgumentPairs.remove((commandArgumentPairs.size() - 1));
                commandArgumentPairs.add(new CommandArgumentPair(lastBotCommand.getCommand(), lastBotCommand.getMessage(),
                        String.format("%s %s", lastBotCommand.getArgument(), isLastEntity(i, entitiesSize) ?
                                trimToEmpty(substring(message.getText(), entity.getOffset(), message.getText().length())) :
                                extractArgument(message, i))));
            }
        }
        return commandArgumentPairs;
    }

    private Command resolveCommand(Message message, int offset) {
        return commandResolver.resolve(extractCommand(message, offset));
    }

    private String extractCommand(Message message, int offset) {
        MessageEntity messageEntity = message.getEntities().get(offset);
        return trimToEmpty(substring(message.getText(), messageEntity.getOffset(),
                messageEntity.getOffset() + messageEntity.getLength()));
    }

    private String extractArgument(Message message, int offset) {
        MessageEntity messageEntity = message.getEntities().get(offset);
        return trimToEmpty(substring(message.getText(),
                messageEntity.getOffset() + messageEntity.getLength(), message.getEntities().get(offset + 1).getOffset()));
    }

    private boolean isBotEntity(MessageEntity messageEntity) {
        return BOT_COMMAND.equals(messageEntity.getType());
    }

    private boolean isLastEntity(int offset, int entityListSize) {
        return offset + 1 == entityListSize;
    }
}