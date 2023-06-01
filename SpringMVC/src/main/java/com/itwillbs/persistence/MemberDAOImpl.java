package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

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
	
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";
	
	
     //  "mylog"  + ctrl + space 
	private static final Logger logger 
	             = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Override
	public String getTime() {
//      sqlSession.selectOne("SQL구문");
      String time
      = sqlSession.selectOne(NAMESPACE+".getTime");
		System.out.println("DB시간 정보 : "+time);
		return time;
	}


	@Override
	public void insertMember(MemberVO vo) {
		// 1.2. 디비연결
		//   3. sql 작성 & pstmt
		//   4. sql 실행
//		sqlSession.insert("com.itwillbs.mapper.MemberMapper.insertMember",parameter);
	    sqlSession.insert(NAMESPACE+".insertMember",vo);
	    logger.debug(" 회원가입 완료! ");
	         
	}

} // DAOImpl
