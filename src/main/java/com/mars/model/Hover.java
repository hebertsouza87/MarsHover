package com.mars.model;

import com.mars.json.HoverJson;

public class Hover {

    private Integer x;
    private Integer y;
    private DirectionEnum direction;

    public Hover() {
        this.x = 0;
        this.y = 0;
        this.direction = DirectionEnum.NORTH;
    }

    public void move() {
        switch (getDirection().toString()) {
            case "N":
                setY(getY() + 1);
                break;
            case "S":
                setY(getY() - 1);
                break;
            case "E":
                setX(getX() + 1);
                break;
            case "W":
                setX(getX() - 1);
                break;
        }
    }

    public void turn(char side) {
        if (side == 'R') {
            DirectionEnum newDirection = DirectionEnum.getByValue(direction.getValue() + 1);
            if (newDirection == null) {
                newDirection = DirectionEnum.NORTH;
            }
            direction = newDirection;

        } else {
            DirectionEnum newDirection = DirectionEnum.getByValue(direction.getValue() - 1);
            if (newDirection == null) {
                newDirection = DirectionEnum.WEST;
            }
            direction = newDirection;
        }
    }

    public HoverJson toJson() {
        return new HoverJson(this);
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

}
