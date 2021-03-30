package com.accenture.gqldemo.enums.converter;

import com.accenture.gqldemo.enums.BreedEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BreedEnumConverter implements AttributeConverter<BreedEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BreedEnum attribute) {
        return attribute != null ? attribute.getIdentifier() : null;
    }

    @Override
    public BreedEnum convertToEntityAttribute(Integer dbData) {
        return BreedEnum.findById(dbData);
    }
}
