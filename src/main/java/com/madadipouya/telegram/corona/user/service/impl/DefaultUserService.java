package com.madadipouya.telegram.corona.user.service.impl;

import com.madadipouya.telegram.corona.user.model.User;
import com.madadipouya.telegram.corona.user.repository.UserRepository;
import com.madadipouya.telegram.corona.user.service.UserService;
import org.springframework.stereotype.Service;

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

@Service
public class DefaultUserService implements UserService {

    private UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isUserExist(String username) {
        return userRepository.countByUsername(username) > 0;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public Optional<User> getUser(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getOrCreate(String username) {
        return getUser(username).orElseGet(() -> createUser(new User(username)));
    }
}