package com.feb.jdbc.dao;

import java.util.HashMap;

import com.feb.jdbc.entity.Member;

public interface MemberDao {
	
	public Member findMember(String memberId);
	
	public int insertMember(HashMap<String,String> params);


}
