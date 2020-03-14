package com.madadipouya.telegram.corona.telegram.model.inlinequery.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.madadipouya.telegram.corona.telegram.model.TextFormat;

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

public class InputTextMessageContent {

    @JsonProperty("message_text")
    private String messageText;

    @JsonProperty("parse_mode")
    private String parseMode;

    @JsonProperty("disable_web_page_preview")
    private boolean disableWebPagePreview;

    public InputTextMessageContent(String messageText, TextFormat parseMode) {
        this.messageText = messageText;
        this.parseMode = parseMode.getValue();
        this.disableWebPagePreview = true;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getParseMode() {
        return parseMode;
    }

    public boolean isDisableWebPagePreview() {
        return disableWebPagePreview;
    }
}
