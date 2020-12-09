package com.kh.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.ajax.model.vo.Member;

@Controller
public class AjaxController {
	
	
	/*
	 * 1. HttpServletResponse 객체를 이용해서 응답데이터 응답하기 (기존에 jsp/servlet때 했던 방식)
	 */
	/*
	@RequestMapping("ajax1.do")
	public void ajaxMethod1(String name, int age, HttpServletResponse response) throws IOException {
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
		// 요청 처리 다 했다는 가정 하에 요청한 그 페이지에 응답할 데이터가 있을경우
		String responseData = "응답데이터 : " + name + "은(는) " + age + "살 입니다. ";
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(responseData);
		
	}
	*/
	
	
	/*
	 * 2. @ResponseBody를 이용한 방식 == HttpServletResponse 객체를 굳이 안써도 되는 방법
	 *    응답할 데이터를 문자열로 return하면 끝 
	 *    단, 주의할 점이라고 한다면 
	 *    보통 문자열 리턴하게 되면 포워딩하고자 하는 뷰명으로 인식해버림!!! /WEB-INF/views/  .jsp 붙여서 포워딩하려들꺼임
	 *    따라서 내가 리턴하는 문자열이 포워딩할 뷰 명이 아닌 응답데이터야 라는 걸 지정하는 
	 *    어노테이션인 @ResponseBody를 꼭 붙여야됨!!
	 *    
	 * 	  뿐만아니라, 응답데이터에 한글이 있을 경우 응답데이터에 대한 contentType을 기술해야됨!!
	 * => @RequestMapping의 produces 속성의 값으로 지정
	 */
	@ResponseBody
	@RequestMapping(value="ajax1.do", produces="text/html; charset=utf-8")
	public String ajaxMethod1(String name, int age) {
		// 요청처리 다 했다는 가정하에
		String responseData = "응답문자열 : " + name + "은(는) " + age + "살 입니다.";
		return responseData;
	}
	
	
	/*
	@RequestMapping("ajax2.do")
	public void ajaxMethod2(int userNo, HttpServletResponse response) throws IOException {
		
		//Member m = mService.selectMember(userNo);
		Member m = new Member("user01", "pass01", "홍길동", 20, "aaa@naver.com", "01011112222");
		// DB로 부터 조회된 결과가 위와 같다는 가정하에
		// 저 Member 객체를 응답하고자 한다면!
		
		//PrintWriter out = response.getWriter();
		//out.print(m.toString());
		
		// JSON (JavaScript Object Notation) 객체에 담아서 응답해야됨! {속성:속성값, 속성:속성값}
		// Member ===> JSON
		JSONObject jObj = new JSONObject(); // {}
		jObj.put("userId", m.getUserId());
		jObj.put("userName", m.getUserName());
		jObj.put("age", m.getAge());
		jObj.put("email", m.getEmail());
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jObj);
		
		
	}
	*/
	
	/*
	@RequestMapping("ajax2.do")
	public void ajaxMethod2(int userNo, HttpServletResponse response) throws IOException {
		
		//Member m = mService.selectMember(userNo);
		Member m = new Member("user01", "pass01", "홍길동", 20, "aaa@naver.com", "01011112222");
		
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		gson.toJson(m, response.getWriter()); // m => JSONObject => JSONString
		
	}
	*/
	
	@ResponseBody
	@RequestMapping(value="ajax2.do", produces="application/json; charset=utf-8")
	public String ajaxMethod2(int userNo) {
		
		//Member m = mService.selectMember(userNo);
		Member m = new Member("user01", "pass01", "홍길동", 20, "aaa@naver.com", "01011112222");
		
		/*
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		gson.toJson(m, response.getWriter()); // m => JSONObject => JSONString
		*/
		
		// m => JSONObject => JSONString
		return new Gson().toJson(m);
		
	}
	
	@ResponseBody
	@RequestMapping(value="ajax3.do", produces="application/json; charset=utf-8")
	public String ajaxMethod3() {
		
		//ArrayList<Member> list = mService.selectList();
		ArrayList<Member> list = new ArrayList<>();
		list.add(new Member("user01", "pass01", "홍길동", 20, "aaa@naver.com", "01011112222"));
		list.add(new Member("user02", "pass02", "홍길녀", 30, "bbb@naver.com", "01055553322"));
		list.add(new Member("user03", "pass03", "홍길순", 27, "ccc@naver.com", "01015588622"));
		list.add(new Member("user04", "pass04", "홍말동", 29, "ddd@naver.com", "01055112244"));
		list.add(new Member("user05", "pass05", "홍말순", 40, "eee@naver.com", "01014486222"));
		
		
		// list => JSON => JSONString
		return new Gson().toJson(list);
		
	}
	
	
	

}








