package com.madadipouya.telegram.corona.general.rest.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;

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

public class Chat implements Serializable {

    private int id;

    // TODO Replace with enum 'Type of chat, can be either “private”, “group”, “supergroup” or “channel”'
    private String type;

    private String title;

    private String username;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private ChatPhoto photo;

    private String description;

    @JsonProperty("invite_link")
    private String inviteLink;

    @JsonProperty("pinned_message")
    private Message pinnedMessage;

    private ChatPermissions permissions;

    @JsonProperty("sticker_set_name")
    private String stickerSetName;

    @JsonProperty("can_set_sticker_set")
    private boolean stickerSetAssignable;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ChatPhoto getPhoto() {
        return photo;
    }

    public String getDescription() {
        return description;
    }

    public String getInviteLink() {
        return inviteLink;
    }

    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    public ChatPermissions getPermissions() {
        return permissions;
    }

    public String getStickerSetName() {
        return stickerSetName;
    }

    public boolean isStickerSetAssignable() {
        return stickerSetAssignable;
    }
}
