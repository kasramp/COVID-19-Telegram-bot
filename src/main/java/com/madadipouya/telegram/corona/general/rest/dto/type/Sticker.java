package com.madadipouya.telegram.corona.general.rest.dto.type;

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

public class Sticker extends AbstractType implements Serializable {

    private int width;

    private int height;

    @JsonProperty("is_animated")
    private boolean animated;

    private String emoji;

    @JsonProperty("set_name")
    private String name;

    @JsonProperty("mask_position")
    private MaskPosition maskPosition;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isAnimated() {
        return animated;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getName() {
        return name;
    }

    public MaskPosition getMaskPosition() {
        return maskPosition;
    }

    public static class MaskPosition implements Serializable {

        private String point;

        @JsonProperty("x_shift")
        private double xShift;

        @JsonProperty("y_shift")
        private double yShift;

        private double scale;

        public String getPoint() {
            return point;
        }

        public double getxShift() {
            return xShift;
        }

        public double getyShift() {
            return yShift;
        }

        public double getScale() {
            return scale;
        }
    }
}
