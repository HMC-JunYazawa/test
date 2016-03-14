package jp.co.sample.entity.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import jp.co.sample.entity.EmpEntity;

public class EmpEntityFieldSetMapper implements FieldSetMapper<EmpEntity> {
	public EmpEntity mapFieldSet(FieldSet fieldSet) throws BindException {
		if (fieldSet == null) {
			return null;
		}
		EmpEntity entity = new EmpEntity();
		entity.setId(fieldSet.readString("id"));
		entity.setName(fieldSet.readString("name"));
		return entity;
	}

}
