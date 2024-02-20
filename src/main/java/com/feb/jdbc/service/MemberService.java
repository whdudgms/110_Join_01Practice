package com.feb.jdbc.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.jdbc.dao.MemberDao;
import com.feb.jdbc.entity.Member;
import com.feb.jdbc.util.Sha512Encoder;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	
	
	
	public Member findMember(String memberId) {
		
		Member result = memberDao.findMember(memberId);
		return result;
	}
	
	
	public int insertMember(HashMap<String,String> params) {
		int result = 0;
		Sha512Encoder sha512 = Sha512Encoder.getInstance();
		String passwd = params.get("passwd");
		String encodeTxt = sha512.getSecurePassword(passwd);
		params.put("passwd", encodeTxt);
		
		result =memberDao.insertMember(params);
		return result;
	}

}
