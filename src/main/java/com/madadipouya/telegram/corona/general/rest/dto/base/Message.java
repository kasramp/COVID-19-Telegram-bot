package com.madadipouya.telegram.corona.general.rest.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.madadipouya.telegram.corona.general.rest.dto.type.*;

import java.io.Serializable;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

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

public class Message implements Serializable {

    @JsonProperty("message_id")
    private int messageId;

    private User from;

    private int date;

    private Chat chat;

    @JsonProperty("forward_from")
    private User forwardFrom;

    @JsonProperty("forward_from_chat")
    private User forwardFromChat;

    @JsonProperty("forward_from_message_id")
    private int forwardFromMessageId;

    @JsonProperty("forward_signature")
    private String forwardSignature;

    @JsonProperty("forward_sender_name")
    private String forwardSenderName;

    @JsonProperty("forward_date")
    private int forwardDate;

    @JsonProperty("reply_to_message")
    private Message replyToMessage;

    @JsonProperty("edit_date")
    private int editDate;

    @JsonProperty("media_group_id")
    private String mediaGroupId;

    @JsonProperty("author_signature")
    private String authorSignature;

    private String text;

    private List<MessageEntity> entities;

    @JsonProperty("caption_entities")
    private List<MessageEntity> captionEntities;

    private Audio audio;

    private Document document;

    private Animation animation;

    private Game game;

    @JsonProperty("photo")
    private List<PhotoSize> photos;

    private Sticker sticker;

    private Video video;

    private Voice voice;

    @JsonProperty("video_note")
    private VideoNote videoNote;

    private String caption;

    private Contact contact;

    private Location location;

    private Venue venue;

    private Poll poll;

    @JsonProperty("new_chat_members")
    private List<User> newChatMembers;

    @JsonProperty("left_chat_member")
    private User leftChatMember;

    @JsonProperty("new_chat_title")
    private String newChatTitle;

    @JsonProperty("new_chat_photo")
    private List<PhotoSize> newChatPhotos;

    @JsonProperty("delete_chat_photo")
    private boolean deleteChatPhoto;

    @JsonProperty("group_chat_created")
    private boolean groupChatCreated;

    @JsonProperty("super_group_chat_created")
    private boolean superGroupChatCreated;

    @JsonProperty("channel_chat_created")
    private boolean channelChatCreated;

    @JsonProperty("migrate_to_chat_id")
    private int migrateToChatId;

    @JsonProperty("migrate_from_chat_id")
    private int migrateFromChatId;

    @JsonProperty("pinned_message")
    private Message pinnedMessage;

    private Invoice invoice;

    /*@JsonProperty("successful_payment")
    private SuccessfulPayment successfulPayment;*/

    @JsonProperty("connected_website")
    private String connectedWebsite;

    /*@JsonProperty("passport_data")
    private PassportData passportData;

    @JsonProperty("reply_markup")
    private InlineKeyboadMarkup replyMarkup;*/

    // TODO complete the mapping

    public int getMessageId() {
        return messageId;
    }

    public User getFrom() {
        return from;
    }

    public int getDate() {
        return date;
    }

    public Chat getChat() {
        return chat;
    }

    public User getForwardFrom() {
        return forwardFrom;
    }

    public User getForwardFromChat() {
        return forwardFromChat;
    }

    public int getForwardFromMessageId() {
        return forwardFromMessageId;
    }

    public String getForwardSignature() {
        return forwardSignature;
    }

    public String getForwardSenderName() {
        return forwardSenderName;
    }

    public int getForwardDate() {
        return forwardDate;
    }

    public Message getReplyToMessage() {
        return replyToMessage;
    }

    public int getEditDate() {
        return editDate;
    }

    public String getMediaGroupId() {
        return mediaGroupId;
    }

    public String getAuthorSignature() {
        return authorSignature;
    }

    public String getText() {
        return trimToEmpty(text);
    }

    public List<MessageEntity> getEntities() {
        return entities == null ? List.of() : entities;
    }

    public List<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

    public Audio getAudio() {
        return audio;
    }

    public Document getDocument() {
        return document;
    }

    public Animation getAnimation() {
        return animation;
    }

    public Game getGame() {
        return game;
    }

    public List<PhotoSize> getPhotos() {
        return photos;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public Video getVideo() {
        return video;
    }

    public Voice getVoice() {
        return voice;
    }

    public VideoNote getVideoNote() {
        return videoNote;
    }

    public String getCaption() {
        return caption;
    }

    public Contact getContact() {
        return contact;
    }

    public Location getLocation() {
        return location;
    }

    public Venue getVenue() {
        return venue;
    }

    public Poll getPoll() {
        return poll;
    }

    public List<User> getNewChatMembers() {
        return newChatMembers;
    }

    public User getLeftChatMember() {
        return leftChatMember;
    }

    public String getNewChatTitle() {
        return newChatTitle;
    }

    public List<PhotoSize> getNewChatPhotos() {
        return newChatPhotos;
    }

    public boolean isDeleteChatPhoto() {
        return deleteChatPhoto;
    }

    public boolean isGroupChatCreated() {
        return groupChatCreated;
    }

    public boolean isSuperGroupChatCreated() {
        return superGroupChatCreated;
    }

    public boolean isChannelChatCreated() {
        return channelChatCreated;
    }

    public int getMigrateToChatId() {
        return migrateToChatId;
    }

    public int getMigrateFromChatId() {
        return migrateFromChatId;
    }

    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public String getConnectedWebsite() {
        return connectedWebsite;
    }
}
