package com.madadipouya.telegram.corona.user.service;

import com.madadipouya.telegram.corona.user.model.User;

import java.util.List;
import java.util.Optional;

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

public interface UserService {

    boolean isUserExist(String username);

    User createUser(User user);

    Optional<User> getUser(String username);

    Optional<User> getUser(long userId);

    List<User> getAllUsers();

    User getOrCreate(String username);
}
