package com.mars.json;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mars.model.DirectionEnum;
import com.mars.model.Hover;

@JsonSerialize
public class HoverJson {

    private final Integer x;
    private final Integer y;
    private final String direction;

    public HoverJson(Integer x, Integer y, DirectionEnum direction) {
        this.x = x;
        this.y = y;
        this.direction = direction.toString();
    }

    public HoverJson(Hover hover) {
        this(hover.getX(), hover.getY(), hover.getDirection());
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }
}
