package com.madadipouya.telegram.corona.user.scheduler;

import com.madadipouya.telegram.corona.user.service.UserAuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
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
public class UserAuditCleaner {

    private static final Logger logger = LoggerFactory.getLogger(UserAuditCleaner.class);

    private final UserAuditService userAuditService;

    public UserAuditCleaner(UserAuditService userAuditService) {
        this.userAuditService = userAuditService;
    }

    // Every 15 minutes
    @Scheduled(cron = "0 0/15 * * * ?")
    public void deleteUserAuditOlderThanFiveMinutes() {
        logger.info("Start deleting user audits older than five minutes");
        userAuditService.deleteAuditsOlderThanFiveMinutes();
        logger.info("Finished deleting user audits older than five minutes");
    }
}
