package com.madadipouya.telegram.corona.telegram.model;

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

public enum TextFormat {

    MARK_DOWN("Markdown"),

    HTML("HTML"),

    PLAIN_TEXT("");

    private final String value;

    TextFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
