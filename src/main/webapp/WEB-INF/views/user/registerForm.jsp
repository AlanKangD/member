<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
function daumpost() {
	new daum.Postcode({
		oncomplete : function(data) {
			// R : 도로명, J : 지번
			console.log("data.userSelectedType : " + data.userSelectedType)
			console.log("data.roadAddress : " + data.roadAddress)
			console.log("data.jibunAddress : " + data.jibunAddress)
			console.log("data.zonecode : " + data.zonecode)

			var addr = ""
			if (data.userSelectedType === 'R') {
				addr = data.roadAddress
			} else {
				addr = data.jibunAddress
			}
			document.getElementById("addr1").value = data.zonecode
			$("#addr2").val(addr)
			$("#addr3").focus()
		}
	}).open();
}
function register() {	
	email_1 = $("#email").val()
	email_2 = $("#email_2").val()
	emailAll = email_1 + "@" + email_2
	$("#email").val(emailAll)
	
	
	addr1 = $("#addr1").val()
	addr2 = $("#addr2").val()
	addr3 = $("#addr3").val()
	addr = addr1 + "/" + addr2 + "/" + addr3
	$("#addr1").val(addr)
	fo.submit()
	
	
}

function idChk() {
	$.ajax({
		url : "idChk",
		type : "GET",
		datatype : "json",
		data : { "id" : $("#id").val() },
		success : function(data){
			console.log(data.result)
			if(data.result == 1) {
				$("#idChk").css('color', 'red')
				$("#idChk").text("중복된 아이디 입니다")
			}else if(data.result == 0) {
				$("#idChk").attr("value", "Y")
				$("#idChk").css('color','blue')
				$("#idChk").text("사용 가능한 아이디 입니다")
			}
		}
	})
}
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 가입 페이지 입니다.</h1>

	<form id="fo" action="${contextPath }/user/register" method="post">
		<input type="text" name="id" id="id" placeholder="가입 할 아이디 "> 
		<input type="button" onclick="idChk()" value="아이디 중복 체크"><br>
		<span id="idChk"></span>
		 <br>
		
		<input type="password" name="pw" placeholder="가입 할 비밀번호"> <br>
		<input type="text" id="email" name="email" placeholder="가입 할 이메일">
		@
		<select id="email_2" name="email_2">
			<option selected>선텍하세요!</option>
			<option value="naver.com">naver.com</option>
			<option>daum.net</option>
			<option>google.com</option>
		</select>
		<input type="hidden" name="address">
		<input type="hidden" name="email">
		
		<input type="text" id="addr1" name="addr1"  readonly placeholder="우편번호" >	
		<input type="text" id="addr2" name="addr2" readonly placeholder="주소" ><br>
		<input type="text"id="addr3" name="addr3"  placeholder="상세주소"><br>
		<input type="button" onclick="daumpost()" value="우편번호 찾기"><br>
		<input type="button" onclick="register()" value="회원가입">
	</form>
</body>
</html>