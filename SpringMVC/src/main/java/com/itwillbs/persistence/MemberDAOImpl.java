package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


	@Override
	public MemberVO loginMember(MemberVO vo) {
        logger.debug("테스트 -> DAO 호출 : 로그인 동작 수행 ");
        
        // SQL구문 작성  Mapper에서 마무리함
        // SQL 실행
        logger.debug(" DAO -> mapper 사용 SQL 실행");
        MemberVO resultVO 
             = sqlSession.selectOne(NAMESPACE+".login", vo); // vo에 id,pw 만 전달됨
		
        logger.debug("SQL 실행결과를 리턴 -> 테스트 ");
        logger.debug(String.valueOf(resultVO)); // null 값이 올때 toString은 안됨
                                                // resultVO +" " 또는 String.valueOf사용
        
		return resultVO;
		
	}


	@Override
	public MemberVO loginMember(String id, String pw) {

		// 아이디, 비밀번호 전달받아서 사용 
		// (2개 이상의 정보를 mapper 각각 전달 불가)
		//   => VO 객체 저장하면 처리가능
		//   => 전달정보(파라메터정보)는 객체단위로 전달
//		MemberVO vo = new MemberVO();
//		vo.setUserid(userid);
//		vo.setUserpw(userpw);
	    // 만약에 전달된 정보가 하나의 객체에 저장이 불가능한 경우!
		Map<String, Object> params = new HashMap<String, Object>();	
		
//		params.put("mapper 매핑된 이름", 전달되는 값 );
		params.put("userid", id);
		params.put("userpw", pw);
		
		
		// SQL 호출, 실행
		sqlSession.selectOne(NAMESPACE+".login",params);
		
		return null;
	}


	@Override
	public Integer updateMember(MemberVO uvo) {
	     
		logger.debug(" 테스트 -> DAO 호출 : 회원정보 수정 ");
		// 수정할 정보를 가져옴(uvo)
	    logger.debug("DAO -> mapper 호출 -> SQL 실행 ");
		Integer result = sqlSession.update(NAMESPACE+".update",uvo);
		logger.debug(" SQL 실행결과를 리턴 ");
		
		return result;
	}


	@Override
	public Integer deleteMember(MemberVO dvo) {
	
		logger.debug("테스트 -> DAO 호출 : 회원정보 삭제 ");
        logger.debug("DAO -> mapper 호출 -> SQL 실행");
        
        Integer result = sqlSession.delete(NAMESPACE+".delete",dvo);
		return result;
	}


	@Override
	public MemberVO getMember(String id) {
		
		logger.debug("회원정보 조회! mapper 호출!");
		return sqlSession.selectOne(NAMESPACE + ".getMember",id);
	}


	@Override
	public List<MemberVO> getMemberList() {
	
		return sqlSession.selectList(NAMESPACE + ".memberList");
	}
	
	
	

} // DAOImpl
