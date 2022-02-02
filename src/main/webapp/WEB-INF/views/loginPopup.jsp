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

<div align="center">
	<c:if test="${userId == null }">
	<h1>로그인 창입니다.</h1>
		<form action="${contextPath }/user/loginChk" method="post">
			<input type="text" name="userId" placeholder="input_id"> <br>
			<input type="password" name="userPw" placeholder="input_pw"> <br>
			<input type="submit" value="login">
			<button type="button" onclick="location.href='<%=request.getContextPath()%>/user/registerForm'">회원가입</button>
		</form>
	</c:if>
	<c:if test="${userId != null }">
	<h1>마이 페이지 입니다</h1>
	<!-- 마이페이지를 다른 곳에서 호출하는 것이 아닌 로그인 영역에서 마이페이지 기능까지 사용할 수 있도록 만들어줌 -->
		<input type="button" onclick="location.href='<%=request.getContextPath()%>/user/logout'" value="logout">
	</c:if>
</div>

</body>
</html>