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

	//@Test
	public void 디비시간정보_조회() throws Exception {
		
	  System.out.println(mdao.getTime());
//	     logger.error(msg); 단계별 출력
//	     logger.warn(msg);
//		 logger.info(msg);
//		 logger.debug(msg);	     
//		 logger.trace(msg);
	}
//	 @Test
	 public void 로그레벨테스트() throws Exception{
		 logger.warn("warn레벨 실행");
		 logger.info("info레벨 실행");
		 logger.debug("debug레벨 실행");
		 
	 }
	 
	 @Test
	 public void 회원가입테스트() throws Exception{
		 logger.debug(" 뷰에서 정보를 입력 받음 -> 생성");
		 
		 MemberVO vo = new MemberVO();
		 vo.setUserid("admin");
		 vo.setUserpw("1234");
		 vo.setUsername("관리자");
         vo.setUseremail("admin@naver.com");		 
	     
         logger.debug(" DAO - 회원가입 메서드 호출 ");
         // DAO 객체 주입 
         mdao.insertMember(vo);
	      
         
	 }
	
}
