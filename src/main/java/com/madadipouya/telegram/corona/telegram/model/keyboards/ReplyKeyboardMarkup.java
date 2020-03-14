package com.madadipouya.telegram.corona.telegram.model.keyboards;

import com.fasterxml.jackson.annotation.JsonProperty;

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

public class ReplyKeyboardMarkup implements Keyboard {

    @JsonProperty("keyboard")
    private final List<List<KeyboardButton>> keyboards;

    @JsonProperty("resize_keyboard")
    private final boolean resizeKeyboard;

    @JsonProperty("one_time_keyboard")
    private final boolean oneTimeKeyboard;

    private final boolean selective;

    protected ReplyKeyboardMarkup(KeyboardButton keyboardButton, boolean resizeKeyboard, boolean oneTimeKeyboard, boolean selective) {
        this(List.of(keyboardButton), resizeKeyboard, oneTimeKeyboard, selective);
    }

    protected ReplyKeyboardMarkup(List<KeyboardButton> keyboards, boolean resizeKeyboard, boolean oneTimeKeyboard, boolean selective) {
        this.keyboards = List.of(keyboards);
        this.resizeKeyboard = resizeKeyboard;
        this.oneTimeKeyboard = oneTimeKeyboard;
        this.selective = selective;
    }

    public List<List<KeyboardButton>> getKeyboards() {
        return keyboards;
    }

    public boolean isResizeKeyboard() {
        return resizeKeyboard;
    }

    public boolean isOneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    public boolean isSelective() {
        return selective;
    }


    public static class KeyboardButton {

        private final String text;

        @JsonProperty("request_contact")
        private final boolean requestContact;

        @JsonProperty("request_location")
        private final boolean requestLocation;

        public KeyboardButton(String text, boolean requestContact, boolean requestLocation) {
            this.text = text;
            this.requestContact = requestContact;
            this.requestLocation = requestLocation;
        }

        public String getText() {
            return text;
        }

        public boolean isRequestContact() {
            return requestContact;
        }

        public boolean isRequestLocation() {
            return requestLocation;
        }
    }
}
