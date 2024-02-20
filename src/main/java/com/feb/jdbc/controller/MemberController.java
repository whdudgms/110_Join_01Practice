package com.feb.jdbc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.entity.Member;
import com.feb.jdbc.service.MemberService;
import com.feb.jdbc.util.Sha512Encoder;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/hello.do")
	public ModelAndView hello(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("resultMsg","helloOk");

		return mv;
	}
	
	@PostMapping("/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		int result = memberService.insertMember(params);
		
		if(result == 1) {
			mv.addObject("resultMsg","joinOk");
		}else {
			mv.addObject("resultMsg","joinFail");
		}
		
		
		
		return mv;
	}
	
	
	
	@PostMapping("login.do")
	public ModelAndView login(@RequestParam HashMap<String,String> params, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		// 로그인 정보 전송 로그인 정보랑 비교 service에서 할까??  그냥 controller에서 처리하는 걸로 
		Member equMember = memberService.findMember(params.get("memberId"));
		Sha512Encoder encoder = Sha512Encoder.getInstance();
		String inputpw = encoder.getSecurePassword(params.get("passwd"));
		
		if(inputpw.equals(equMember.getPasswd())) {
			mv.addObject("resultMsg","loginOk");
		}else {
			mv.addObject("resultMsg","loginOk");

		}
		
		return mv; 
		
	}

}
