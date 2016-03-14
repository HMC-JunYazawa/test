package jp.co.sample;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.sample.dao.EmpDao;


@Component("memberWriter")
public class MemberWriter implements ItemWriter<Member> {
	
	@Autowired
	private EmpDao dao;

	@Override
	public void write(List<? extends Member> items) throws Exception {
		
		
		for (Member member : items) {
			// バリデーションフラグ
			boolean errFlg = false;
			
			// バリデーションチェック
			ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
			Validator v = vf.getValidator();
			Set<ConstraintViolation<Member>> results = v.validate(member);
			for (ConstraintViolation<Member> result : results) {
				System.out.println(result.getMessage());
				errFlg = true;
			}
			// DAOに書き込む
			if (!errFlg) {
				dao.insert(member);

			}
		}
			
		
	}
}
