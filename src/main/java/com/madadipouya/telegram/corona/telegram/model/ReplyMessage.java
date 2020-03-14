package com.madadipouya.telegram.corona.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.madadipouya.telegram.corona.telegram.model.keyboards.Keyboard;

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

public class ReplyMessage {

    @JsonProperty("chat_id")
    private final int chatId;

    @JsonProperty("reply_to_message_id")
    private final int messageId;

    private final String text;

    @JsonProperty("parse_mode")
    private final String textFormat;

    @JsonProperty("disable_web_page_preview")
    private final boolean disableWebPagePreview;

    @JsonProperty("reply_markup")
    private final Keyboard keyboard;

    public ReplyMessage(int chatId, int messageId, String text, TextFormat textFormat) {
        this(chatId, messageId, text, textFormat, null, false);
    }

    public ReplyMessage(int chatId, String text, Keyboard keyboard) {
        this(chatId, -1, text, TextFormat.PLAIN_TEXT, keyboard, false);
    }

    public ReplyMessage(int chatId, int messageId, String text, TextFormat textFormat,
                        Keyboard keyboard, boolean disableWebPagePreview) {
        this.chatId = chatId;
        this.text = text;
        this.messageId = messageId;
        this.textFormat = textFormat.getValue();
        this.keyboard = keyboard;
        this.disableWebPagePreview = disableWebPagePreview;
    }

    public int getChatId() {
        return chatId;
    }

    public int getMessageId() {
        return messageId;
    }

    public String getText() {
        return text;
    }

    public String getTextFormat() {
        return textFormat;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public boolean isDisableWebPagePreview() {
        return disableWebPagePreview;
    }

}

