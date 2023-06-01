package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

// persistence 영속성 -> DB관련 처리 

public interface MemberDAO {
	// 필요한 동작들을 추상메서드 사용하여 정의
	
	// 디비 시간정보 조회
	public String getTime();
	
	//    C - 회원정보 가입
  
	public  void insertMember(MemberVO vo);
	
	

}
