package com.base.code.persistence.type;

import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp> {

	@Override
	public java.sql.Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		return attribute == null ? null : java.sql.Timestamp.valueOf(attribute);
	}

	@Override
	public java.time.LocalDateTime convertToEntityAttribute(java.sql.Timestamp dbData) {
		return dbData == null ? null : dbData.toLocalDateTime();
	}

}
