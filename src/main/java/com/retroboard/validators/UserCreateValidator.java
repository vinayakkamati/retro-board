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

    public void validate(Object target) {
        Map<String, String> error = new HashMap<>();
        UserDTO user = (UserDTO) target;
        validateEmail(user.getEmailId(), error);
        validateUserNameSize(user.getUserName(), error);
        validatePasswordSize(user.getPassword(), error);
        if(!error.isEmpty()){
            formatErrorUtil.genericRequiredError(error.toString());
        }
    }

    private void validateUserNameSize(String userName, Map<String, String> errors) {
        if(!(userName.length() < UserConstants.MAX_NAME_SIZE && userName.length() > UserConstants.MIN_NAME_SIZE)){
            errors.put(UserConstants.USER_NAME,UserConstants.USER_NAME_INVALID);
        }
    }

    private void validatePasswordSize(String password, Map<String, String> errors) {
        if(password.length() < UserConstants.PASSWORD_SIZE){
            errors.put(UserConstants.PASSWORD,UserConstants.PASSWORD_INVALID);
        }
    }

    public void validateEmail(String email, Map<String, String> errors){
        Matcher matcher = VALID_EMAIL_REGEX.matcher(email);
        if(!matcher.find()){
            errors.put(UserConstants.EMAIL,UserConstants.EMAIL_INVALID);
        }
    }
}
