package com.madadipouya.telegram.corona.general.rest;

import com.madadipouya.telegram.corona.virus.command.CoronaInlineEnquiryCommandHandler;
import com.madadipouya.telegram.corona.general.rest.dto.Update;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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

@RestController
@RequestMapping(value = "/v1")
public class TelegramHookController {

    private final CoronaInlineEnquiryCommandHandler coronaInlineEnquiryCommandHandler;

    public TelegramHookController(CoronaInlineEnquiryCommandHandler coronaInlineEnquiryCommandHandler) {
        this.coronaInlineEnquiryCommandHandler = coronaInlineEnquiryCommandHandler;
    }

    @PostMapping("/${telegram.token}")
    public void listen(@RequestBody Update update) {
        update.getCommandArgumentPairs().stream().filter(ca -> Objects.nonNull(ca.getCommand()))
                .forEach(ca -> ca.getCommand().execute(ca.getMessage(), ca.getArgument()));

        if (update.hasInlineQuery()) {
            coronaInlineEnquiryCommandHandler.handle(update.getInlineQuery().getId(), update.getInlineQuery().getQuery());
        }
    }
}