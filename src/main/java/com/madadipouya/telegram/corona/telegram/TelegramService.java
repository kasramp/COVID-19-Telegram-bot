package com.madadipouya.telegram.corona.telegram;

import com.madadipouya.telegram.corona.telegram.model.ActionType;
import com.madadipouya.telegram.corona.telegram.model.TextFormat;
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

public interface TelegramService {

    void reply(int to, String text, TextFormat format);

    void askLocation(int to, String text);

    void cancelAction(int to, int messageId);

    void replyInlineQuery(String queryId, String title, String text, TextFormat format);

    void replyInlineQueryArticles(String queryId, List<InlineQueryResultArticle> results);

    void sendAction(int chatId, ActionType action);
}