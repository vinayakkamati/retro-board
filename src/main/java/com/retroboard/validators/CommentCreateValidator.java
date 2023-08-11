package com.retroboard.validators;

import com.retroboard.dtos.CommentDTO;
import com.retroboard.utils.FormatErrorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.retroboard.constants.CommentConstant.*;

@Component
public class CommentCreateValidator {
    @Autowired
    private FormatErrorUtil formatErrorUtil;
    public void validate(CommentDTO commentDTO) {
        Map<String, String> errors = new HashMap<>();
        validateCommentType(commentDTO.getCommentType(), errors);
        if(!errors.isEmpty()){
            formatErrorUtil.genericRequiredError(errors.toString());
        }
    }

    private void validateCommentType(String commentType, Map<String, String> errors) {
        if(!COMMENT_TYPES.contains(commentType)){
            errors.put(COMMENT_TYPE,COMMENT_TYPE_INVALID);
        }
    }
}
