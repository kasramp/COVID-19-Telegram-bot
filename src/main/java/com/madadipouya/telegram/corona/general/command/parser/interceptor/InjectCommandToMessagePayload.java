package com.madadipouya.telegram.corona.general.command.parser.interceptor;

import com.madadipouya.telegram.corona.general.command.parser.CommandParser;
import com.madadipouya.telegram.corona.general.rest.dto.Update;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
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

@Order(0)
@Aspect
@Component
public class InjectCommandToMessagePayload {

    private final CommandParser commandParser;

    public InjectCommandToMessagePayload(CommandParser commandParser) {
        this.commandParser = commandParser;
    }

    @Before(value = "execution(* com.madadipouya.telegram.corona.general.rest.TelegramHookController.listen(..)) && args(update)")
    public void addCommandDetailsToMessage(JoinPoint joinPoint, Update update) {
        commandParser.parse(update);
    }
}
