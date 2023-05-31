package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

// @Repository : 스프링(root-context.xml)에 해당파일이 DAO의 동작을 하는 객체 등록


@Repository
public class MemberDAOImpl implements MemberDAO {
	
	  // => 1.2 디비연결 
	  // => SqlSessionFactory 객체 주입
	  // => 3. SQL 작성 & pstmt
	  //    ??? 추가
	  //    => memberMapper.xml SQL 작성
	  //    4. SQL 실행
	  //    5. (select) 데이터 처리
	
	@Inject
	private SqlSession sqlSession;
//	private SqlSessionFactory sqlFactory;
	
	
	@Override
	public String getTime() {
//      sqlSession.selectOne("SQL구문");
      String time
      = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		System.out.println("DB시간 정보 : "+time);
		return time;
	}

}
