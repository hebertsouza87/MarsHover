package com.mars.service;

import com.mars.exception.BadRequestException;
import com.mars.model.Hover;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class HoverService {

    private final int XSize = 4;
    private final int YSize = 4;

    public Hover processes(Hover hover, String commands) throws BadRequestException {
        validateComands(commands);
        for (char comand : commands.toCharArray()) {
            if (comand == 'M') {
                hover.move();
                validatePosition(hover);
            } else {
                hover.turn(comand);
            }
        }
        return hover;
    }

    private void validatePosition(Hover hover) throws BadRequestException {
        if (hover.getX() < 0 || hover.getX() > XSize
                || hover.getY() < 0 || hover.getY() > YSize) {
            throw new BadRequestException();
        }
    }

    private void validateComands(String commands) throws BadRequestException {
        Pattern MOVE_PATTERN = Pattern.compile("[RLM]+");
        if (commands == null || !MOVE_PATTERN.matcher(commands).matches()) {
            throw new BadRequestException();
        }
    }

}
