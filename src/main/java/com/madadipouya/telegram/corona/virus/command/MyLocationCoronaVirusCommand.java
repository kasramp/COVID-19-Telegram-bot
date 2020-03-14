package com.madadipouya.telegram.corona.virus.command;

import com.madadipouya.telegram.corona.telegram.model.ActionType;
import com.madadipouya.telegram.corona.virus.integration.mathdro.MathdroIntegration;
import com.madadipouya.telegram.corona.virus.integration.openstreetmap.OpenStreetMapIntegration;
import com.madadipouya.telegram.corona.general.command.BotCommand;
import com.madadipouya.telegram.corona.general.command.CommandType;
import com.madadipouya.telegram.corona.general.rest.dto.base.Message;
import com.madadipouya.telegram.corona.i18n.service.I18nService;
import com.madadipouya.telegram.corona.telegram.TelegramService;
import org.springframework.stereotype.Component;

import static com.madadipouya.telegram.corona.general.command.CommandType.CORONA_VIRUS_MY_LOCATION_UPDATE;
import static com.madadipouya.telegram.corona.telegram.model.TextFormat.MARK_DOWN;

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
public class MyLocationCoronaVirusCommand implements BotCommand {

    private final TelegramService telegramService;

    private final I18nService i18nService;

    private final OpenStreetMapIntegration openStreetMapIntegration;

    private MathdroIntegration mathdroIntegration;

    public MyLocationCoronaVirusCommand(TelegramService telegramService, I18nService i18nService,
                                        OpenStreetMapIntegration openStreetMapIntegration, MathdroIntegration mathdroIntegration) {
        this.telegramService = telegramService;
        this.i18nService = i18nService;
        this.openStreetMapIntegration = openStreetMapIntegration;
        this.mathdroIntegration = mathdroIntegration;
    }

    @Override
    public void execute(Message message, String argument) {
        if (hasLocationInfo(message)) {
            telegramService.sendAction(message.getChat().getId(), ActionType.FIND_LOCATION);
            String countryCode = openStreetMapIntegration.getCountryCodeOfGeoLocation(message.getLocation().getLatitude(), message.getLocation().getLongitude());
            telegramService.reply(message.getChat().getId(), getCoronaVirusStatsForCountry(countryCode), MARK_DOWN);
        } else {
            telegramService.askLocation(message.getChat().getId(), i18nService.getMessage("command.corona.virus.location", CORONA_VIRUS_MY_LOCATION_UPDATE.getValue()));
        }
    }

    private String getCoronaVirusStatsForCountry(String countryCode) {
        return String.format("%s%n```%n%s%n```",
                i18nService.getMessage("command.corona.virus.latest.statistics.reply"),
                mathdroIntegration.getLatestCoronaStatisticsByCountry(countryCode));
    }

    @Override
    public CommandType getSupportedType() {
        return CORONA_VIRUS_MY_LOCATION_UPDATE;
    }

    private boolean hasLocationInfo(Message message) {
        return message.getLocation() != null;
    }
}
