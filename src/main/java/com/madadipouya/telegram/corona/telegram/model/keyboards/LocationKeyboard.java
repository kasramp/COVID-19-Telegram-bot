package com.madadipouya.telegram.corona.telegram.model.keyboards;

import java.util.List;

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

public class LocationKeyboard extends ReplyKeyboardMarkup implements Keyboard {

    public LocationKeyboard() {
        this(List.of(new KeyboardButton("Share your location", false, true),
                new KeyboardButton("/cancel", false, false)), true, true, false);
    }

    private LocationKeyboard(KeyboardButton keyboardButton, boolean resizeKeyboard, boolean oneTimeKeyboard, boolean selective) {
        this(List.of(keyboardButton), resizeKeyboard, oneTimeKeyboard, selective);
    }

    private LocationKeyboard(List<KeyboardButton> keyboards, boolean resizeKeyboard, boolean oneTimeKeyboard, boolean selective) {
        super(keyboards, resizeKeyboard, oneTimeKeyboard, selective);
    }
}
