package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;

@Controller
public class sampleController3 {
  
	private static final Logger logger = LoggerFactory.getLogger(sampleController3.class);
  
    // doC
	// http://localhost:8088/doC
	// http://localhost:8088/doC?msg=hello
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public String doC(@ModelAttribute("msg") String tmp) {
	              // @ModelAttribute("msg") => 주소줄의 데이터를 저장
		          // 저장한 데이터를 자동으로 뷰페이지에서 사용가능 (el표현식사용)
		logger.debug("doC 호출!!!!!!!!!");
		
		logger.debug("msg : " + tmp);
		
		return "doC";
		
	}
	
	// http://localhost:8088/doC1?msg=hello&age=20
		@RequestMapping(value = "/doC1", method = RequestMethod.GET)
		public String doC1(@ModelAttribute("msg") String tmp
				, @ModelAttribute("age") int age) {
		              // @ModelAttribute("msg") => 주소줄의 데이터를 저장
			          // 저장한 데이터를 자동으로 뷰페이지에서 사용가능 (el표현식사용)
			logger.debug("doC2 호출!!!!!!!!!");
			
			logger.debug("msg : " + tmp);
			logger.debug("age : " +(age+100));
			
			return "doC1";
			
		}
		
		
		// http://localhost:8088/doC2?userid=admin&userpw=1234&tel=010-1234-1234
			@RequestMapping(value = "/doC2", method = RequestMethod.GET)
			public String doC2(MemberVO vo, @ModelAttribute("tel") String tel) {
				logger.debug("doC2 호출!!!!!!!!!");
				
				logger.debug(" userid : " + vo.getUserid());
				logger.debug(" userpw : " + vo.getUserpw());
				logger.debug(vo+"");
				logger.debug("tel : " + tel);
				
				return "doC";
				
			}
			// http://localhost:8088/doC3
			@RequestMapping(value = "/doC3", method = RequestMethod.GET)
			public String doC3(Model model ) {
				logger.debug(" doC3호출! - 파라마테가 아닌 정보를 뷰페이지로 전달");
				
				// DB데이터(임시)
				MemberVO vo = new MemberVO();
				vo.setUserid("admin");
				vo.setUserpw("1234");
				
				// 영역에 저장 (X) => Model 객체 사용 
				// Model : 스프링에서 제공하는 컨테이너(박스)
				
				model.addAttribute("vo", vo);
				
		     // model.addAttribute(vo); 전달하는 키가 없음
			 // => 키(이름)가 없을경우 전달하는 타입의 클래스명을 첫글자소문자로 변경해서 호출
				
				return "doC";
				
			}
	
}
