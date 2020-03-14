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

public class ChatPermissions implements Serializable {

    @JsonProperty("can_send_messages")
    private boolean canSendMessages;

    @JsonProperty("can_send_media_messages")
    private boolean canSendMediaMessages;

    @JsonProperty("can_send_polls")
    private boolean canSendPolls;

    @JsonProperty("can_send_other_messages")
    private boolean canSendOtherMessages;

    @JsonProperty("can_add_web_pages_previews")
    private boolean canAddWebPagesPreviews;

    @JsonProperty("can_change_info")
    private boolean canChangeInfo;

    @JsonProperty("can_invite_users")
    private boolean canInviteUsers;

    @JsonProperty("can_pin_messages")
    private boolean canPinMessages;

    public boolean hasPermissionToSendMessages() {
        return canSendMessages;
    }

    public boolean hasPermissionToSendMediaMessages() {
        return canSendMediaMessages;
    }

    public boolean hasPermissionToSendPolls() {
        return canSendPolls;
    }

    public boolean hasPermissionToSendOtherMessages() {
        return canSendOtherMessages;
    }

    public boolean hasPermissionToAddWebPagesPreviews() {
        return canAddWebPagesPreviews;
    }

    public boolean hasPermissionToChangeInfo() {
        return canChangeInfo;
    }

    public boolean hasPermissionToInviteUsers() {
        return canInviteUsers;
    }

    public boolean hasPermissionToPinMessages() {
        return canPinMessages;
    }
}
