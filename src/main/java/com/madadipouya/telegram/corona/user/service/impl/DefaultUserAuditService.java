package com.madadipouya.telegram.corona.user.service.impl;

import com.madadipouya.telegram.corona.user.model.BlockedUser;
import com.madadipouya.telegram.corona.user.model.UserAudit;
import com.madadipouya.telegram.corona.user.repository.BlockedUserRepository;
import com.madadipouya.telegram.corona.user.repository.UserAuditRepository;
import com.madadipouya.telegram.corona.user.service.UserAuditService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.madadipouya.telegram.corona.utils.DateTimeUtils.getFiveMinutesAgoTime;
import static com.madadipouya.telegram.corona.utils.DateTimeUtils.getOneMinuteAgoTime;

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
public class DefaultUserAuditService implements UserAuditService {

    private static final int MAXIMUM_ALLOWED_MESSAGE_PER_MINUTE = 60;

    private final BlockedUserRepository blockedUserRepository;

    private final UserAuditRepository userAuditRepository;

    public DefaultUserAuditService(BlockedUserRepository blockedUserRepository, UserAuditRepository userAuditRepository) {
        this.blockedUserRepository = blockedUserRepository;
        this.userAuditRepository = userAuditRepository;
    }

    @Override
    public boolean isAlreadyBlocked(String username) {
        return blockedUserRepository.countByUsername(username) > 0;
    }

    @Override
    public void block(String username) {
        blockedUserRepository.save(new BlockedUser(username));
    }

    @Override
    public boolean shouldBeBlocked(String username) {
        return isBlockable(userAuditRepository.countByUsernameAndCreatedGreaterThanEqual(username, getOneMinuteAgoTime()));
    }

    @Override
    public void log(String username) {
        userAuditRepository.save(new UserAudit(username));
    }

    @Transactional
    @Override
    public void deleteAuditsOlderThanFiveMinutes() {
        userAuditRepository.deleteByCreatedBefore(getFiveMinutesAgoTime());
    }

    private boolean isBlockable(int messagePerMinute) {
        return messagePerMinute > MAXIMUM_ALLOWED_MESSAGE_PER_MINUTE;
    }
}
