package com.madadipouya.telegram.corona.telegram.impl;

import com.madadipouya.telegram.corona.telegram.TelegramService;
import com.madadipouya.telegram.corona.telegram.model.ActionType;
import com.madadipouya.telegram.corona.telegram.model.ChatAction;
import com.madadipouya.telegram.corona.telegram.model.ReplyMessage;
import com.madadipouya.telegram.corona.telegram.model.TextFormat;
import com.madadipouya.telegram.corona.telegram.model.inlinequery.reply.InlineQueryReplyMessage;
import com.madadipouya.telegram.corona.telegram.model.inlinequery.result.InlineQueryResultArticle;
import com.madadipouya.telegram.corona.telegram.model.keyboards.Keyboard;
import com.madadipouya.telegram.corona.telegram.model.keyboards.LocationKeyboard;
import com.madadipouya.telegram.corona.telegram.model.keyboards.RemoveKeyboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.lang.String.format;

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
public class DefaultTelegramService implements TelegramService {

    private static final String BASE_URL = "https://api.telegram.org/bot%s/%s";

    private static final String SEND_MESSAGE = "sendMessage";

    private static final String ANSWER_INLINE_QUERY = "answerInlineQuery";

    private static final String CANCEL_MESSAGE = "Affirmative";

    private static final String SEND_CHAT_ACTION = "sendChatAction";

    private static final Logger logger = LoggerFactory.getLogger(DefaultTelegramService.class);

    @Value("${telegram.token}")
    private String token;

    private final RestTemplate restTemplate;

    public DefaultTelegramService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void reply(long to, String text, TextFormat format) {
        replyInternal(to, 0, text, format, new RemoveKeyboard());
    }

    @Override
    public void askLocation(long to, String text) {
        replyInternal(to, 0, text, TextFormat.PLAIN_TEXT, new LocationKeyboard());
    }

    @Override
    public void cancelAction(long to, int messageId) {
        replyInternal(to, messageId, CANCEL_MESSAGE, TextFormat.PLAIN_TEXT, new RemoveKeyboard());
    }

    @Override
    public void replyInlineQuery(String queryId, String title, String text, TextFormat format) {
        try {
            restTemplate.postForEntity(format(BASE_URL, token, ANSWER_INLINE_QUERY), new InlineQueryReplyMessage(queryId,
                    new InlineQueryResultArticle(queryId, title, text, format)), String.class);
        } catch (HttpStatusCodeException ex) {
            logger.error("Got error while sending sending edit reply message.");
            logger.error("Message = {}", text);
            logger.error("Response code = {}", ex.getResponseBodyAsString());
        }
    }

    @Override
    public void replyInlineQueryArticles(String queryId, List<InlineQueryResultArticle> results) {
        try {
            restTemplate.postForEntity(format(BASE_URL, token, ANSWER_INLINE_QUERY), new InlineQueryReplyMessage(queryId, results), String.class);
        } catch (HttpStatusCodeException ex) {
            logger.error("Got error while sending sending edit reply message.");
            logger.error("Response code = {}", ex.getResponseBodyAsString());
        }
    }

    private void replyInternal(long to, int messageId, String text, TextFormat format, Keyboard keyboard) {
        try {
            restTemplate.postForEntity(format(BASE_URL, token, SEND_MESSAGE), new ReplyMessage(to, messageId, text, format, keyboard, true), String.class);
        } catch (HttpStatusCodeException ex) {
            logger.error("Got error while sending sending edit reply message.");
            logger.error("Message = {}", text);
            logger.error("Response code = {}", ex.getResponseBodyAsString());
        }
    }

    @Override
    public void sendAction(long chatId, ActionType action) {
        try {
            restTemplate.postForEntity(format(BASE_URL, token, SEND_CHAT_ACTION), new ChatAction(chatId, action), String.class);
        } catch(HttpStatusCodeException ex) {
            logger.warn(ex.getResponseBodyAsString());
        }
    }
}