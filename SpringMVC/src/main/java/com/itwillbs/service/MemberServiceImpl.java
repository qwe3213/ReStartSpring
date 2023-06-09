package com.itwillbs.service;

import javax.inject.Inject; 


import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;


// @Service : 스프링(root-context.xml)에서 해당 객체를 서비스 객체로 인식하도록 설정

@Service
public class MemberServiceImpl implements MemberService{

	 // DAO - Controller 연결
	 
	 // DAO 객체 접근필요함 => 의존관계
	 @Inject
	 private MemberDAO mdao;
	
// 회원가입
	@Override
	public void memberJoin(MemberVO vo) {
       
		 mdao.insertMember(vo);
	    	
	}

// 회원정보 로그인
	@Override
	public MemberVO memberLogin(MemberVO vo) {
	   
		MemberVO resultVO = mdao.loginMember(vo);
		
		return resultVO;
	}

// 회원정보 조회
	@Override
	public MemberVO getMember(String id) {
	    
		return mdao.getMember(id);
	}
	
// 회원정보 수정
	@Override
	public Integer memberModify(MemberVO uvo) {
	
		return mdao.updateMember(uvo);
	}
	

}
