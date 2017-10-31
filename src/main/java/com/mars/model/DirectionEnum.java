package com.mars.model;

public enum DirectionEnum {
    NORTH("N", 1),
    EAST("E", 2),
    SOUTH("S", 3),
    WEST("W", 4);

    private final String direction;
    private final int value;

    DirectionEnum(String direction, int value) {
        this.direction = direction;
        this.value = value;
    }

    public static DirectionEnum getByValue(int value) {
        for (DirectionEnum direction : DirectionEnum.values()) {
            if (direction.getValue() == value) {
                return direction;
            }
        }

        return null;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return direction;
    }
}
