package com.itwillbs.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		 locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {

	// 생성해놓은 기능 호출 
	
	// 로거 - 콘솔창에 메세지 출력
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	
	
	// DAO 객체가 필요 (의존관계) => 주입
	@Inject
	private MemberDAO mdao;
	
	
//	@Inject
//	private SqlSession sqlSession;

//	@Test
	public void 디비시간정보_조회() throws Exception {
		
	  System.out.println(mdao.getTime());
	     logger.info(mdao.getTime());
//	     logger.error(msg); 단계별 출력
//	     logger.warn(msg);
//		 logger.info(msg);
//		 logger.debug("msg");	     
//		 logger.trace("msg");
	}
//	 @Test
	 public void 로그레벨테스트() throws Exception{
		 logger.warn("warn레벨 실행");
		 logger.info("info레벨 실행");
		 logger.debug("debug레벨 실행");
		 
	 }
	 
//	 @Test
	 public void 회원가입테스트() throws Exception{
		 logger.debug(" 뷰에서 정보를 입력 받음 -> 생성");
		 
		 MemberVO vo = new MemberVO();
		 vo.setUserid("itwill2");
		 vo.setUserpw("1234");
		 vo.setUsername("사용자2");
         vo.setUseremail("user@naver.com");		 
	     
         logger.debug(" DAO - 회원가입 메서드 호출 ");
         // DAO 객체 주입 
         mdao.insertMember(vo);
	      
	 }
//	 @Test
	 public void 로그인테스트() throws Exception{
		 logger.debug("로그인 테스트 시작");
		 
		 // 로그인 계정
		 MemberVO vo = new MemberVO();
		 vo.setUserid("admin32");
		 vo.setUserpw("1234213");
		   
		 // DAO - 로그인 체크하는 메서드 호출
		 MemberVO resultVO = mdao.loginMember(vo);
		 
		 if(resultVO == null) {
			 logger.debug("로그인 실패");
		 }else {
			 logger.debug("로그인 성공");
		 }
	    logger.debug("로그인 테스트 끝");
		 
	 }
	
//	 @Test
	 public void 회원정보수정테스트() throws Exception{
		 logger.debug("회원정보수정 테스트 시작@@@@@@@@@");
	  
		 // 회원정보 수정
		 MemberVO uvo = new MemberVO();
		 
		 uvo.setUserid("admin2");
		 uvo.setUserpw("12343");
         uvo.setUsername("수정수정이름");
		 uvo.setUseremail("ADMIN(수정)@naver.com");
		 
         Integer result = mdao.updateMember(uvo);
		   
		 if(result == 1) {
			 logger.debug("수정성공오오오오오오오옹@@@@@");
		 }else {
		      logger.debug("수정실패!! ㅠㅠ"); 
		 }
		    
		 logger.debug("회원정보수정 테스트 끝@@@@@@@@@@@@@@@");
	    
	 }
	 @Test
	 public void 회원정보삭제()throws Exception{
		 
		 logger.debug("회원정보삭제 테스트 시작@@@@@@@@@@@@@@@@");
	       
		 // 회원정보 삭제
		 MemberVO dvo = new MemberVO();
		 
		 dvo.setUserid("itwill2");
		 dvo.setUserpw("1234");
		
		 Integer result = mdao.deleteMember(dvo);
		 
	     if(result == 1) {
	    	  logger.debug("삭제완료!!");
	    	 
	     }else {
	    	 logger.debug("삭제실패.... 다시@@@@@@@@@");
	     }
	     logger.debug("회원정보삭젲완료올오롱로아롱롤옹로");
	 }
	   
}
