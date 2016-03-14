package jp.co.sample;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException; 
 

public class MemberFieldSetMapper implements FieldSetMapper<Member> {

  @Override
  public Member mapFieldSet(FieldSet fs) throws BindException {
     Member member = new Member();
     member.setId(fs.readString("id"));
     member.setName(fs.readString("name"));
     return member;
  }

}
