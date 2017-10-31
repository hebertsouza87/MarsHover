package com.mars.controller;

import com.mars.exception.BadRequestException;
import com.mars.json.HoverJson;
import com.mars.model.Hover;
import com.mars.service.HoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarsController {

    @Autowired
    private HoverService service;

    @RequestMapping(path = "/rest/mars/{commands}", produces = "application/json")
    public HoverJson roverComandsInRest(@PathVariable("commands") String commands) throws BadRequestException {
        Hover hover = new Hover();
        service.processes(hover, commands);
        return hover.toJson();
    }

    @RequestMapping("/string/mars/{commands}")
    public String roverComandsInString(@PathVariable("commands") String commands) throws BadRequestException {
        Hover hover = new Hover();
        service.processes(hover, commands);
        return "(" + hover.getX()
                + "," + hover.getY()
                + "," + hover.getDirection().toString()
                + ")";
    }
}
