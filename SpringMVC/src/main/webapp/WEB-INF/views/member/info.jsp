<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>http://localhost:8088/member/info</h2>
	<h1>info.jsp</h1>
	
	  <h2> model 객체에 전달된 정보를 꺼내서 사용 </h2>
	  ${resultVO}
	  
	  <hr>
	  <h3> 아이디 : ${resultVO.userid}</h3>
	  <h3> 비밀번호 : ${resultVO.userpw}</h3>
	  <h3> 이름 : ${resultVO.username}</h3>
	  <h3> 이메일 : ${resultVO.useremail}</h3>
	  <h3> 회원가입일 : ${resultVO.regdate}</h3>
	  <hr>
	  <h2> model 객체의 정보이름이 없는경우</h2>
	  <h2><a href="/member/main">메인페이지로...</a></h2>
	  
</body>
</html>