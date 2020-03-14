package com.madadipouya.telegram.corona.virus.command;

import com.madadipouya.telegram.corona.telegram.model.ActionType;
import com.madadipouya.telegram.corona.virus.integration.mathdro.MathdroIntegration;
import com.madadipouya.telegram.corona.general.command.BotCommand;
import com.madadipouya.telegram.corona.general.command.CommandType;
import com.madadipouya.telegram.corona.general.rest.dto.base.Message;
import com.madadipouya.telegram.corona.i18n.service.I18nService;
import com.madadipouya.telegram.corona.telegram.TelegramService;
import com.madadipouya.telegram.corona.telegram.model.TextFormat;
import org.springframework.stereotype.Component;

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
public class CoronaVirusLatestDevelopmentCommand implements BotCommand {

    private final MathdroIntegration mathdroIntegration;

    private final TelegramService telegramService;

    private final I18nService i18nService;

    public CoronaVirusLatestDevelopmentCommand(MathdroIntegration mathdroIntegration, TelegramService telegramService,
                                               I18nService i18nService) {
        this.mathdroIntegration = mathdroIntegration;
        this.telegramService = telegramService;
        this.i18nService = i18nService;
    }

    @Override
    public void execute(Message message, String argument) {
        telegramService.sendAction(message.getChat().getId(), ActionType.TYPING);
        telegramService.reply(message.getChat().getId(), getLatestCoronaVirusDevelopmentStatistics(), TextFormat.MARK_DOWN);
    }

    @Override
    public CommandType getSupportedType() {
        return CommandType.CORONA_VIRUS_LATEST;
    }

    private String getLatestCoronaVirusDevelopmentStatistics() {
        return String.format("%s%n```%n%s%n```%s",
                i18nService.getMessage("command.corona.virus.latest.statistics.reply"),
                String.join("\n", mathdroIntegration.getLatestCoronaStatisticsFlat()),
                i18nService.getMessage("command.corona.virus.latest.statistics.reply"));
    }
}
