package com.itwillbs.web;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" }
		)

public class MybatisTest {
         
	
	//DB 연결 (+ MyBatis) -> SqlSessionFactory 객체
	
	// 객체 의존 주입
	@Inject
	private SqlSessionFactory sqlFactory;
	
	// DAO 객체 생성 -> 객체 주입(MemberDAOImpl) 주입
	// MemberDAO dao = new MemberDAOImpl();
	@Inject
	private MemberDAO mdao;
	
	//@Test
	public void test_SqlSessionFactory() throws Exception{
		 
		System.out.println(sqlFactory);
	}
	

  // @Test    
   public void test_sqlDBConnect() throws Exception{
	     
	   // 디비연결 + SQL 실행
	   SqlSession sqlSession 
	               = sqlFactory.openSession();
  	   
	   System.out.println("SqlSession :"+sqlSession);
	   
   }
      @Test
      public void 디비시간정보조회() throws Exception{
//    	  SqlSession sqlSession 
//                         = sqlFactory.openSession();
//                 
//    	  sqlSession.selectOne(state);
//   => DAO 처리중이므로 DAO 메서드 들고오면됨    	   
        String time = mdao.getTime();
        System.out.println("시간정보 : " + time);
      }
   
   
   
}

