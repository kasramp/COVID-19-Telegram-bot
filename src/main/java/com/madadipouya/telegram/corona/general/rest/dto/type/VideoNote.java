package com.madadipouya.telegram.corona.general.rest.dto.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.madadipouya.telegram.corona.general.rest.dto.base.PhotoSize;

import java.io.Serializable;

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

public class VideoNote implements Serializable {

    @JsonProperty("file_id")
    private String fileId;

    private int length;

    private int duration;

    private PhotoSize thumb;

    @JsonProperty("file_size")
    private int fileSize;

    public String getFileId() {
        return fileId;
    }

    public int getLength() {
        return length;
    }

    public int getDuration() {
        return duration;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public int getFileSize() {
        return fileSize;
    }
}
