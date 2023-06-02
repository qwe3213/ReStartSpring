<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>doC.jsp</title>
</head>
<body>
  
  <h1>doC.jsp</h1>
  
 http://localhost:8088/doC?msg=hello
   <hr>
   
   jsp 표현식(파라메터) : <%= request.getParameter("msg") %> <hr>
   el 표현식(파라메터) : ${param.msg }<hr> 
   el 표현식(파라메터) : ${msg }<hr> 
   el 표현식(파라메터) : ${age }<hr> 
   @${vo }<br>
   
   MemberVO 객체의 경우 @ModelAttribute("이름") 생략,
   => 이름이 없는 경우 전달되는 데이터 타입의 첫글자를 소문자로 변경한 이름을 사용
   
   @${memberVO}@<hr>

   @${tel }@<hr>
   
       
</body>
</html>