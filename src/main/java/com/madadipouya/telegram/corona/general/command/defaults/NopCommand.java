package com.madadipouya.telegram.corona.general.command.defaults;

import com.madadipouya.telegram.corona.general.command.Command;
import com.madadipouya.telegram.corona.general.rest.dto.base.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class NopCommand implements Command {

    private static final Logger logger = LoggerFactory.getLogger(NopCommand.class);

    /*
     * It performs no operation, keep the method body empty
     * or just log a debug
     */
    @Override
    public void execute(Message message, String argument) {
        logger.debug("do nothing");
    }
}
