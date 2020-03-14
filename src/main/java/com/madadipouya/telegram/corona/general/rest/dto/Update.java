package com.madadipouya.telegram.corona.general.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.madadipouya.telegram.corona.general.rest.dto.base.CallbackQuery;
import com.madadipouya.telegram.corona.general.rest.dto.base.ChosenInlineResult;
import com.madadipouya.telegram.corona.general.rest.dto.base.InlineQuery;
import com.madadipouya.telegram.corona.general.rest.dto.base.Message;
import com.madadipouya.telegram.corona.general.rest.dto.internal.CommandArgumentPair;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

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

public class Update implements Serializable {

    @JsonProperty("update_id")
    private int updateId;

    private Message message;

    @JsonProperty("edited_message")
    private Message editedMessage;

    @JsonProperty("channel_post")
    private Message channelPost;

    @JsonProperty("edited_channel_post")
    private Message editedChannelPost;

    @JsonProperty("inline_query")
    private InlineQuery inlineQuery;

    @JsonProperty("chosen_inline_result")
    private ChosenInlineResult chosenInlineResult;

    @JsonProperty("callback_query")
    private CallbackQuery callbackQuery;

    private List<CommandArgumentPair> commandArgumentPairs;

    // TODO support inline,  etc. https://core.telegram.org/bots/api#update

    private void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    private void setMessage(Message message) {
        this.message = message;
    }

    private void setEditedMessage(Message editedMessage) {
        this.editedMessage = editedMessage;
    }

    private void setChannelPost(Message channelPost) {
        this.channelPost = channelPost;
    }

    private void setEditedChannelPost(Message editedChannelPost) {
        this.editedChannelPost = editedChannelPost;
    }

    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    public boolean hasCallbackQuery() {
        return Objects.nonNull(callbackQuery);
    }

    private void setCallbackQuery(CallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
    }

    public List<CommandArgumentPair> getCommandArgumentPairs() {
        return commandArgumentPairs;
    }

    public void setCommandArgumentPairs(List<CommandArgumentPair> commandArgumentPairs) {
        this.commandArgumentPairs = commandArgumentPairs;
    }

    public Message getFirstAvailableMessage() {
        return getMessages().filter(Objects::nonNull).findFirst().orElse(new Message());
    }

    public boolean hasInlineQuery() {
        return (inlineQuery != null) && message == null && editedMessage == null && callbackQuery == null;
    }

    private Stream<Message> getMessages() {
        return Stream.of(message, editedMessage, channelPost, editedChannelPost).filter(Objects::nonNull);
    }

    public InlineQuery getInlineQuery() {
        return inlineQuery;
    }

    public ChosenInlineResult getChosenInlineResult() {
        return chosenInlineResult;
    }
}
