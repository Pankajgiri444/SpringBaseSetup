package com.base.code.persistence.type;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<java.time.LocalDate, java.sql.Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return attribute == null ? null : java.sql.Date.valueOf(attribute);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		return dbData == null ? null : dbData.toLocalDate();
	}
	
}
