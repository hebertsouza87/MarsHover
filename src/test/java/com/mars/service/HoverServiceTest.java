package com.mars.service;

import com.mars.exception.BadRequestException;
import com.mars.model.DirectionEnum;
import com.mars.model.Hover;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HoverServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testProcesses() throws Exception {
        Hover hover = new Hover();
        HoverService service = new HoverService();

        String commands = "M";
        Hover result = service.processes(hover, commands);

        assertEquals(Integer.valueOf(0), result.getX());
        assertEquals(Integer.valueOf(1), result.getY());
        assertEquals(DirectionEnum.NORTH, result.getDirection());

        hover = new Hover();
        commands = "MR";
        result = service.processes(hover, commands);

        assertEquals(Integer.valueOf(0), result.getX());
        assertEquals(Integer.valueOf(1), result.getY());
        assertEquals(DirectionEnum.EAST, result.getDirection());

        hover = new Hover();
        commands = "MRMM";
        result = service.processes(hover, commands);

        assertEquals(Integer.valueOf(2), result.getX());
        assertEquals(Integer.valueOf(1), result.getY());
        assertEquals(DirectionEnum.EAST, result.getDirection());

        hover = new Hover();
        commands = "MRMMLMM";
        result = service.processes(hover, commands);

        assertEquals(Integer.valueOf(2), result.getX());
        assertEquals(Integer.valueOf(3), result.getY());
        assertEquals(DirectionEnum.NORTH, result.getDirection());

        hover = new Hover();
        commands = "MRMMLMMLM";
        result = service.processes(hover, commands);

        assertEquals(Integer.valueOf(1), result.getX());
        assertEquals(Integer.valueOf(3), result.getY());
        assertEquals(DirectionEnum.WEST, result.getDirection());

        hover = new Hover();
        commands = "MRMMLMMRRM";
        result = service.processes(hover, commands);

        assertEquals(Integer.valueOf(2), result.getX());
        assertEquals(Integer.valueOf(2), result.getY());
        assertEquals(DirectionEnum.SOUTH, result.getDirection());
    }

    @Test(expected = BadRequestException.class)
    public void testProcessesInvalidCommand() throws BadRequestException {
        Hover hover = new Hover();
        HoverService service = new HoverService();

        String commands = "A";

        service.processes(hover, commands);
    }

    @Test(expected = BadRequestException.class)
    public void testProcessesInvalidCommandA() throws BadRequestException {
        Hover hover = new Hover();
        HoverService service = new HoverService();

        String commands = "A";

        service.processes(hover, commands);
    }

    @Test(expected = BadRequestException.class)
    public void testProcessesInvalidCommandm() throws BadRequestException {
        Hover hover = new Hover();
        HoverService service = new HoverService();

        String commands = "m";

        service.processes(hover, commands);
    }

    @Test(expected = BadRequestException.class)
    public void testProcessesInvalidCommand2() throws BadRequestException {
        Hover hover = new Hover();
        HoverService service = new HoverService();

        String commands = "2";

        service.processes(hover, commands);
    }

    @Test(expected = BadRequestException.class)
    public void testProcessesOutOfLimitY() throws BadRequestException {
        Hover hover = new Hover();
        HoverService service = new HoverService();

        String commands = "MMMMM";

        service.processes(hover, commands);
    }

    @Test(expected = BadRequestException.class)
    public void testProcessesOutOfLimitYNegative() throws BadRequestException {
        Hover hover = new Hover();
        HoverService service = new HoverService();

        String commands = "RRM";

        service.processes(hover, commands);
    }

    @Test(expected = BadRequestException.class)
    public void testProcessesOutOfLimitX() throws BadRequestException {
        Hover hover = new Hover();
        HoverService service = new HoverService();

        String commands = "RMMMMM";

        service.processes(hover, commands);
    }

    @Test(expected = BadRequestException.class)
    public void testProcessesOutOfLimitXNegative() throws BadRequestException {
        Hover hover = new Hover();
        HoverService service = new HoverService();

        String commands = "LM";

        service.processes(hover, commands);
    }

}
