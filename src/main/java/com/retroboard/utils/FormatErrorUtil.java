package com.retroboard.utils;

import com.retroboard.enums.ErrorReason;
import com.retroboard.exceptions.BadRequestException;
import com.retroboard.exceptions.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FormatErrorUtil {

    public void genericRequiredError(String errors){
        throw new BadRequestException(new ErrorMessage(HttpStatus.BAD_REQUEST, ErrorReason.BAD_REQUEST, errors));
    }
}
