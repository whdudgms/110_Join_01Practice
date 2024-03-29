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
	
	
	
	//회원정보를 가져와서 반환함.
	public boolean login(HashMap<String,String> params) {
		Sha512Encoder encoder = Sha512Encoder.getInstance();
		String inputPw = encoder.getSecurePassword(params.get("passwd"));
		
		Member result = memberDao.findMember(params.get("memberId"));		
		if(result.getPasswd().equals(inputPw)) {
			return true;
		}else {
			return false;
		}
	}
	
	//입력받은 회원정보를 알맞게 수정한 다음에 전송.
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
