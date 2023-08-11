package com.retroboard.validators;

import com.retroboard.constants.UserConstants;
import com.retroboard.dtos.UserDTO;
import com.retroboard.utils.FormatErrorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserCreateValidator {

    @Autowired
    private FormatErrorUtil formatErrorUtil;
    private static final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9]+[A-Z0-9.-]+\\.[A-Z]{2,}$", Pattern.CASE_INSENSITIVE);

    public void validate(UserDTO user) {
        validateEmail(user.getEmailId());
        validateUserNameSize(user.getUserName());
        validatePasswordSize(user.getPassword());
    }

    private void validateUserNameSize(String userName) {
        if(!(userName.length() < UserConstants.MAX_NAME_SIZE && userName.length() > UserConstants.MIN_NAME_SIZE)){
            formatErrorUtil.genericRequiredError(UserConstants.USER_NAME_INVALID);
        }
    }

    private void validatePasswordSize(String password) {
        if(password.length() < UserConstants.PASSWORD_SIZE){
            formatErrorUtil.genericRequiredError(UserConstants.PASSWORD_INVALID);
        }
    }

    public void validateEmail(String email){
        Matcher matcher = VALID_EMAIL_REGEX.matcher(email);
        if(!matcher.find()){
            formatErrorUtil.genericRequiredError(UserConstants.PASSWORD_INVALID);
        }
    }
}
