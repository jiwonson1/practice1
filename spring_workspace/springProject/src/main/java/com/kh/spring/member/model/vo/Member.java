package com.kh.spring.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * * Lombok(롬복)
 *   롬복은 자바에서 VO클래스를 만들 때 필드에 대한 getter/setter, toString, 생성자 등등
 *   반드시 필요하고 반복적으로 써야만하는 구문을
 *   단지 어노테이션 기술만으로 해당 구문이 자동으로 만들어지는 라이브러리임!
 *   
 *   => 즉, 후에 필드 수정한다거나, 새로운 필드 추가 및 삭제한다거나 할 때
 *	       일일히 set/getter, toString, 생성자같은걸 수정할 필요가 없어짐!!
 * 
 * 1. 라이브러리 추가 (Maven을 통해 dependency로 추가)
 * 2. 롬복은 라이브러리 추가만으로 쓸수없음!!
 *    설치해야됨!! (이 sts또는 이클립스에서 롬복을 쓸꺼임!)
 *    => 다운로드된 라이브러리 (.jar) 더블클릭하면 창 뜸 => install
 * 3. sts 또는 이클립스 재부팅
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Member {
		
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String gender;
	//private int age;
	private String age;
	private String phone;
	private String address;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
	//private String uName; // ${ uName } => 내부적으로 getuName() 메소드 찾음
	// 근데 롬복을 이용해서 만들게 되면 getUName() 메소드로 만들어짐 ㅠㅠ 찾지 못함
	// 즉, 롬복을 쓰고 싶다면 필드면 적어도 소문자 2개이상으로 시작되게 하셈!!!
	
}
