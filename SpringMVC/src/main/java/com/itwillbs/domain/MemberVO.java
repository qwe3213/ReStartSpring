package com.itwillbs.domain;


import java.sql.Timestamp;

/**
 *  도메인 객체 
 *  
 *    도메인 : 프로젝트에 중요한 개념(명사) 회원, 게시판, 상품, 주문,....  
 *     => DB정보 저장하기 위해서 DTO 
 *     => 물리적응으로 분리가 가능한지 판단
 *     
 *     
 *     DTO(Data Transfer Object) : 데이터를 전달하기위한 객체 
 *                                 [ set/get 포함 ] 
 *                                 
 *     VO(Value Object) : 값 자체를 표현하는 객체 
 *                        [ get 포함, equal(), hashCode() 포함 ]
 */
public class MemberVO {

	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Timestamp regdate;
	private Timestamp updatedate;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useremail="
				+ useremail + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	
	
	

	
}
