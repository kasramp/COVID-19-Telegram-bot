package com.madadipouya.telegram.corona.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

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

@Entity
@Table(name = "user_audit",
        indexes = {@Index(columnList = "username", name = "idx_user_audit_username"),
                @Index(columnList = "created", name = "idx_user_audit_created")})
public class UserAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false)
    @NotBlank
    private String username;

    @Column(name = "created", nullable = false)
    @NotNull
    private ZonedDateTime created;

    public UserAudit() {

    }

    public UserAudit(String username) {
        this.username = username;
        this.created = ZonedDateTime.now(ZoneOffset.UTC);
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public ZonedDateTime getCreated() {
        return created;
    }
}
