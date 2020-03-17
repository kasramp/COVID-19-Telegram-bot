package com.madadipouya.telegram.corona.telegram.model.inlinequery.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.madadipouya.telegram.corona.telegram.model.inlinequery.result.InlineQueryResultArticle;

import java.util.List;

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

public class InlineQueryReplyMessage {

    @JsonProperty("inline_query_id")
    private final String inlineQueryId;

    private final List<InlineQueryResultArticle> results;

    @JsonProperty("cache_time")
    private final int cacheTimeSeconds;

    public InlineQueryReplyMessage(String inlineQueryId, InlineQueryResultArticle inlineQueryResult) {
        this(inlineQueryId, List.of(inlineQueryResult));
    }

    public InlineQueryReplyMessage(String inlineQueryId, List<InlineQueryResultArticle> inlineQueryResult) {
        this.inlineQueryId = inlineQueryId;
        this.results = inlineQueryResult;
        this.cacheTimeSeconds = 120;
    }

    public String getInlineQueryId() {
        return inlineQueryId;
    }

    public List<InlineQueryResultArticle> getResults() {
        return results;
    }

    public int getCacheTimeSeconds() {
        return cacheTimeSeconds;
    }
}
