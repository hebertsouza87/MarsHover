package com.mars.model;

import com.mars.json.HoverJson;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HoverTest {

    @Test
    public void testDefaultConstructor() {
        Hover hover = new Hover();
        assertEquals(Integer.valueOf(0), hover.getX());
        assertEquals(Integer.valueOf(0), hover.getY());
        assertEquals(DirectionEnum.NORTH, hover.getDirection());
    }

    @Test
    public void testTurnRight() {
        Hover hover = new Hover();
        hover.turn('R');
        assertEquals(DirectionEnum.EAST, hover.getDirection());
        hover.turn('R');
        assertEquals(DirectionEnum.SOUTH, hover.getDirection());
        hover.turn('R');
        assertEquals(DirectionEnum.WEST, hover.getDirection());
        hover.turn('R');
        assertEquals(DirectionEnum.NORTH, hover.getDirection());

        assertEquals(Integer.valueOf(0), hover.getY());
        assertEquals(Integer.valueOf(0), hover.getX());
    }

    @Test
    public void testTurnLeft() {
        Hover hover = new Hover();
        hover.turn('L');
        assertEquals(DirectionEnum.WEST, hover.getDirection());
        hover.turn('L');
        assertEquals(DirectionEnum.SOUTH, hover.getDirection());
        hover.turn('L');
        assertEquals(DirectionEnum.EAST, hover.getDirection());
        hover.turn('L');
        assertEquals(DirectionEnum.NORTH, hover.getDirection());

        assertEquals(Integer.valueOf(0), hover.getY());
        assertEquals(Integer.valueOf(0), hover.getX());
    }

    @Test
    public void testMoveNorth() {
        Hover hover = new Hover();
        hover.move();
        assertEquals(Integer.valueOf(1), hover.getY());
        assertEquals(Integer.valueOf(0), hover.getX());
        assertEquals(DirectionEnum.NORTH, hover.getDirection());
    }

    @Test
    public void testMoveSouth() {
        Hover hover = new Hover();
        hover.setDirection(DirectionEnum.SOUTH);
        hover.move();
        assertEquals(Integer.valueOf(-1), hover.getY());
        assertEquals(Integer.valueOf(0), hover.getX());
        assertEquals(DirectionEnum.SOUTH, hover.getDirection());
    }

    @Test
    public void testMoveEast() {
        Hover hover = new Hover();
        hover.setDirection(DirectionEnum.EAST);
        hover.move();
        assertEquals(Integer.valueOf(0), hover.getY());
        assertEquals(Integer.valueOf(1), hover.getX());
        assertEquals(DirectionEnum.EAST, hover.getDirection());
    }

    @Test
    public void testMoveWest() {
        Hover hover = new Hover();
        hover.setDirection(DirectionEnum.WEST);
        hover.move();
        assertEquals(Integer.valueOf(0), hover.getY());
        assertEquals(Integer.valueOf(-1), hover.getX());
        assertEquals(DirectionEnum.WEST, hover.getDirection());
    }

    @Test
    public void testToJson() {
        Hover hover = new Hover();
        HoverJson json = hover.toJson();

        assertEquals(Integer.valueOf(0), json.getY());
        assertEquals(Integer.valueOf(0), json.getX());
        assertEquals("N", json.getDirection());

        hover.setX(2);
        hover.setY(4);
        hover.setDirection(DirectionEnum.EAST);

        json = hover.toJson();

        assertEquals(Integer.valueOf(2), json.getX());
        assertEquals(Integer.valueOf(4), json.getY());
        assertEquals("E", json.getDirection());

    }
}
