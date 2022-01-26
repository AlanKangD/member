<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 창입니다.</h1>
<div align="center">
	<form action="">
		<input type="text" name="userId" placeholder="input_id"> <br>
		<input type="password" name="userPw" placeholder="input_pw"> <br>
		<input type="submit" value="login">
		<button type="button" onclick="location.href='<%=request.getContextPath()%>/user/registerForm'">회원가입</button>
	</form>
</div>

</body>
</html>