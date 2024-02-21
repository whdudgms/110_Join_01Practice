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
	
	// 처음에 그냥 기본 요청페이지용으로 만
	@GetMapping("/hello.do")
	public ModelAndView hello(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("resultMsg","helloOk");

		return mv;
	}
	
	//가입하는 Controller
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

		
		if(memberService.login(params)) {
			mv.addObject("resultMsg","loginOk");
		}else {
			mv.addObject("resultMsg","loginOk");

		}
		
		return mv; 
		
	}

}
