package com.feb.jdbc.dao;

import java.util.HashMap;

import com.feb.jdbc.entity.Member;

public interface MemberDao {
	// select해서 회원정보를 가져올 메서드 mybatis랑 연동해서 사용할거니까 impl은 구현 안 함 
	public Member findMember(String memberId);
	// insert해서 회원가입을 하게 도와줄 메서드 	mybatis랑 연동해서 사용할거니까 impl은 구현 안 함 
	public int insertMember(HashMap<String,String> params);


}
