package jp.co.sample.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import jp.co.sample.Member;
import jp.co.sample.dao.mapper.EmpMapper;
import jp.co.sample.entity.EmpEntity;

@Component
public class EmpDao extends SqlSessionDaoSupport {
	
	public List<EmpEntity> select(){
		
		SqlSession session = getSqlSession();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		return mapper.select();
		
	}
	
	public int insert(Member member){
		SqlSession session = getSqlSession();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		return mapper.insert(member);
		
		
	}

}
