package com.retroboard.enums.converters;

import com.retroboard.enums.CommentType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CommentTypeConverter implements AttributeConverter<CommentType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(CommentType type) {
        switch (type){
            case WENT_WELL:
                return 1;

            case TO_IMPROVE:
                return 2;

            case ACTION_ITEMS:
                return 3;

            default:
                throw new IllegalArgumentException("Comment type" + type + "not supported");
        }
    }

    @Override
    public CommentType convertToEntityAttribute(Integer dbData) {
             switch (dbData){
                 case 1:
                     return CommentType.TO_IMPROVE;

                 case 2:
                     return CommentType.WENT_WELL;

                 case 3:
                     return CommentType.ACTION_ITEMS;

                 default:
                     throw new IllegalArgumentException("Comment type" + dbData + "not supported");
             }
    }
}
