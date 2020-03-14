package com.madadipouya.telegram.corona.general.rest.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;

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

public class Poll implements Serializable {

    private String id;

    private String question;

    private List<PollOption> options;

    @JsonProperty("is_closed")
    private boolean closed;

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<PollOption> getOptions() {
        return options;
    }

    public boolean isClosed() {
        return closed;
    }

    public static class PollOption implements Serializable {

        private String text;

        @JsonProperty("voter_count")
        private int voterCount;

        public String getText() {
            return text;
        }

        public int getVoterCount() {
            return voterCount;
        }
    }
}
