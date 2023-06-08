package com.itwillbs.web;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

// - 컨트롤러별 공통 주소(URI) 설계
// - 각 기능별 주소(URI) 설계
// - 각 URI별 호출 방식 설정(GET/POST)
//   -> 사용자의 정보 입력, 조회 (GET)
//   -> 데이터 처리, DB접근 (POST)
// - 결과처리, 페이지 이동 설계
// - 예외처리 

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
 
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 서비스정보 필요함 => 의존관계
	
	@Inject
	private MemberService mService;
    
	// 동작 구현 -> 메서드 설계 
	
	// http://localhost:8088/member/MemberJoin.me
	// http://localhost:8088/member/join
	// 회원가입 처리 - 정보입력
    @RequestMapping(value = "/join",method = RequestMethod.GET)
	public String memberJoinGET() {
    	logger.debug(" MemberJoinGET() 호출! ");
    	
    	logger.debug("/member/MemberJoin.me jsp 뷰 페이지 이동");
    
    	return "/member/MemberJoin";
    }
	
    // 회원가입 처리 - 정보처리
    @RequestMapping(value = "/join" , method = RequestMethod.POST)
 	public String memberJoinPOST(HttpServletRequest request, 
 		            	MemberVO vo) throws Exception {
    	           // 매개변수 선언 (vo) 관련정보 (파라메터) 자동 수집
     	logger.debug(" memberJoinPOST() 호출! ");
        
//     	  한글처리 -> 필터
//     	  request.setCharacterEncoding("UTF-8");
//     	  전달정보 저장(회원가입정보-파라메터)
//        MemberVO vo = new MemberVO();
//        vo.setUserid(request.getParameter("userid"));
        
        logger.debug(vo+"");
     	// 서비스-회원가입 => DAO - 회원가입메서드 호출
     	//   => DAO - 회원가입메서드 호출
        mService.memberJoin(vo);
        
     	// 페이지 이동 -> 로그인 페이지
        return "redirect:/member/login";
        
     }
    
    // 로그인 - 정보 입력(get)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void loginGET() {
    	
    	logger.debug(" loginGET() 호출");
        logger.debug(" 연결된 뷰페이지로 이동 (/member/login.jsp)");
    	
    }
    
    // 로그인 - 정보 처리(post)
    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String loginPOST(MemberVO vo) {
    	// 전달정보(로그인,ID,PW) 저장
    	logger.debug(vo+"");
    	// 서비스 => DAO - 로그인체크
    	MemberVO resultVO = mService.memberLogin(vo);
    	logger.debug(resultVO+"");
    	// 로그인 여부에 따라서 페이지 이동
    	// O
    	// 메인페이지로 이동 (redirect)
    	// 로그인 아이디를 세션에 저장
    	// X
    	// 다시 로그인페이지로 이동
    	return "";
    }
    
    
} // controller
