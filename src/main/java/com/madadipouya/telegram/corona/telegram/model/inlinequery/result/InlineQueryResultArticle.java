package com.madadipouya.telegram.corona.telegram.model.inlinequery.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.madadipouya.telegram.corona.telegram.model.TextFormat;
import com.madadipouya.telegram.corona.telegram.model.inlinequery.content.InputTextMessageContent;

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

public class InlineQueryResultArticle {

    private final String type = "article";

    private String id;

    private String title;

    @JsonProperty("input_message_content")
    private InputTextMessageContent inputMessageContent;

    public InlineQueryResultArticle(String id, String title, String text, TextFormat format) {
        this(id, title, new InputTextMessageContent(text, format));
    }

    public InlineQueryResultArticle(String id, String title, InputTextMessageContent inputTextMessageContent) {
        this.id = id;
        this.title = title;
        this.inputMessageContent = inputTextMessageContent;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public InputTextMessageContent getInputMessageContent() {
        return inputMessageContent;
    }
}
