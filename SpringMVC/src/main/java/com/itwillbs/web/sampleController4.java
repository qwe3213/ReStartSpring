package com.itwillbs.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class sampleController4 {
	
	private static final Logger logger = LoggerFactory.getLogger(sampleController4.class);
     	
	//http://localhost:8088/doD
	//http://localhost:8088/doD?data=itwill
	@RequestMapping(value = "/doD",method = RequestMethod.GET)
	public String doD(RedirectAttributes rttr/*@ModelAttribute("data") String data*/) {
		logger.debug("doD() 메서드 호출 ! ");
//		logger.debug("data: " +data);
//      model.addAttribute("data","ITWILL");
        //  Model 객체
        //  RedirectAttributes 객체
	
		//  공통점 : 정보 전달
	    //  차이점
		//  Model 객체 : 전달 방식 상관없이 사용가능, URI에 값이 표시, F5 (데이터 유지)
		//  RedirectAttributes 객체 : redirect방식일때만 사용가능, URI에 값이 표시X, F5 (데이터 유지X, 1회성)
	
		
		// @ModelAttribute : 내부적으로 Model객체 생성후 그안에 저장해서 사용
		rttr.addFlashAttribute("data","ITWILL2");
		// 데이터를 doE주소 (메서드)로 전달
		
		
		
		
//		return "/doE"; 
		// redirect를 앞에 사용함으로써 doD를 실행후 doE로 이동하여 다시 doE메서드 실행함
//		return "redirect:/doE"; // 가상주소의 변화 O  화면 변화 O
//		return "forward:/doE";  // 가장주소의 변화 X  화면 변화 O
        return "redirect:/doE";
	}

    
	//http://localhost:8088/doE
	//http://localhost:8088/doE?data=itwill
	@RequestMapping(value = "/doE",method = RequestMethod.GET)
	public String doE(@ModelAttribute("data") String data) {
		logger.debug("doE() 메서드 호출 ! ");
		logger.debug("data: " + data);
        
		
	   return "";
	}
}
