<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function loginPOPUP(){
	window.open("/member/loginPopup","", "width=500, height=500, top=500, left=500");
}
</script>  <!--  새 창을 열게 만들어서 팝업이 자동으로 열리게 만들어줍니다.-->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지 입니다.</h1>
	<div align="left">
	<c:choose>
		<c:when test="${userId == null }">
			<input type="button" value="로그인 창" onclick="loginPOPUP()">	
		</c:when>
		<c:otherwise>
			<input type="button" value="마이페이지 창" onclick="loginPOPUP()">	
		</c:otherwise>
	</c:choose>
	
		
		
		
	</div>
		
</body>
</html>