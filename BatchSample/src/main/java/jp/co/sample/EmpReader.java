package jp.co.sample;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.sample.dao.EmpDao;
import jp.co.sample.entity.EmpEntity;

@Component("empReader")
public class EmpReader implements ItemReader<EmpEntity> {
	
	@Autowired
	private EmpDao dao;
	
	private int index = 0;

	@Override
	public EmpEntity read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		List<EmpEntity> list = dao.select();

		if (index < list.size()) {
			EmpEntity returnEntity = list.get(index);
			index++;

			return returnEntity;
		} else {
			return null;
		}

	}

}
