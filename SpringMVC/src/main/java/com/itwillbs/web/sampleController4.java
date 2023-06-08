package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class sampleController4 {
	
	private static final Logger logger = LoggerFactory.getLogger(sampleController4.class);
     
	//http://localhost:8088/doD
	@RequestMapping(value = "/doD",method = RequestMethod.GET)
	public String doD() {
		logger.debug("doD() 메서드 호출 ! ");

		
//		return "/doE"; 
		// redirect를 앞에 사용함으로써 doD를 실행후 doE로 이동하여 다시 doE메서드 실행함
//		return "redirect:/doE"; // 가상주소의 변화 O  화면 변화 O
//		return "forward:/doE";  // 가장주소의 변화 X  화면 변화 O
        return "redirect:/doE";
	}

    
	//http://localhost:8088/doE
	@RequestMapping(value = "/doE",method = RequestMethod.GET)
	public String doE() {
		logger.debug("doE() 메서드 호출 ! ");

		
	   return "";
	}
}
