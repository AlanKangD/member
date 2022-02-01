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
<h1>프로필 사진 페이지입니다.</h1>
	<form action="${contextPath }/user/profileUpload" enctype="multipart/form-data" method="post">
		<input type="text" name="id" placeholder="프로필 설정할 아이디를 입력하세요"> <br>
		<input type="file" name="imageFileName"> <br>
		<input type="submit" value="프로필 사진 등록"> 
	</form>

<a href="${contextPath }/loginPopup">프로필 사진을 등록하지 않겠습니다.</a>
</body>
</html>