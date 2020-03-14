package com.madadipouya.telegram.corona.general.rest.dto.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.madadipouya.telegram.corona.general.rest.dto.base.MessageEntity;
import com.madadipouya.telegram.corona.general.rest.dto.base.PhotoSize;

import java.io.Serializable;
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

public class Game implements Serializable {

    private String title;

    private String description;

    @JsonProperty("photo")
    private List<PhotoSize> photos;

    private String text;

    @JsonProperty("text_entities")
    private List<MessageEntity> textEntities;

    private Animation animation;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<PhotoSize> getPhotos() {
        return photos;
    }

    public String getText() {
        return text;
    }

    public List<MessageEntity> getTextEntities() {
        return textEntities;
    }

    public Animation getAnimation() {
        return animation;
    }
}
