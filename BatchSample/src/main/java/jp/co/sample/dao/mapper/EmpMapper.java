package jp.co.sample.dao.mapper;

import java.util.List;

import jp.co.sample.Member;
import jp.co.sample.entity.EmpEntity;

public interface EmpMapper {
	
	
	List<EmpEntity> select();
	
	int insert(Member member);

}
