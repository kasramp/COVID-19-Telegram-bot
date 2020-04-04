package com.madadipouya.telegram.corona.virus.command;

import com.madadipouya.telegram.corona.virus.integration.mathdro.MathdroIntegration;
import com.madadipouya.telegram.corona.virus.integration.mathdro.remote.response.CoronaStatistics;
import com.madadipouya.telegram.corona.i18n.service.I18nService;
import com.madadipouya.telegram.corona.telegram.TelegramService;
import com.madadipouya.telegram.corona.telegram.model.TextFormat;
import com.madadipouya.telegram.corona.telegram.model.inlinequery.result.InlineQueryResultArticle;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.madadipouya.telegram.corona.utils.NumberUtils.formatThreeDecimal;

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

@Component
public class CoronaInlineEnquiryCommandHandler {

    private final MathdroIntegration mathdroIntegration;

    private final TelegramService telegramService;

    private final I18nService i18nService;

    public CoronaInlineEnquiryCommandHandler(MathdroIntegration mathdroIntegration, TelegramService telegramService,
                                             I18nService i18nService) {
        this.mathdroIntegration = mathdroIntegration;
        this.telegramService = telegramService;
        this.i18nService = i18nService;
    }


    public void handle(String id, String query) {
        if (StringUtils.isBlank(query)) {
            StringBuilder replyMessage = new StringBuilder("```");
            mathdroIntegration.getLatestCoronaStatisticsFlat().forEach(row -> {
                if(replyMessage.length() > 3800) {
                    replyMessage.append("\n```");
                    replyMessage.append(i18nService.getMessage("command.corona.virus.latest.statistics.reply"));
                    telegramService.replyInlineQuery(id, "All world", replyMessage.toString(), TextFormat.MARK_DOWN);
                    replyMessage.setLength(0);
                    replyMessage.append("```");
                }
                replyMessage.append(String.format("%n%s",row));
            });
            replyMessage.append("\n```");
            replyMessage.append(i18nService.getMessage("command.corona.virus.latest.statistics.reply"));
            telegramService.replyInlineQuery(id, "All world", replyMessage.toString(), TextFormat.MARK_DOWN);
        } else {
            List<InlineQueryResultArticle> results = mathdroIntegration.getLatestCoronaStatistics().stream()
                    .filter(r -> StringUtils.startsWithIgnoreCase(r.getCountry(), query)).limit(50)
                    .map(r -> new InlineQueryResultArticle(UUID.randomUUID().toString(),
                            r.getCountry(), constructDescription(r), TextFormat.MARK_DOWN))
                    .collect(Collectors.toList());
            telegramService.replyInlineQueryArticles(id, results);
        }
    }

    private String constructDescription(CoronaStatistics coronaStatistics) {
        return String.format("*Country:* %s %n*Confirmed:* %s %n*Deaths:* %s %n*Recovered:* %s",
                coronaStatistics.getCountry(), formatThreeDecimal(coronaStatistics.getConfirmed()),
                formatThreeDecimal(coronaStatistics.getDeaths()),
                formatThreeDecimal(coronaStatistics.getRecovered()));
    }
}
