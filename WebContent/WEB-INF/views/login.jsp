<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Flat HTML5/CSS3 Login Form</title>
  

<!-- ===== Iconscout CSS ===== -->
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

<!-- ===== CSS 주의할점 : /resources/css/style.css resource안에 css파일 안에 style.css를 넣는다.  ===== -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<script>

	var resultMsg = '${resultMsg}';
	alert(resultMsg);

</script>
</head>	

<body>
<!-- partial:index.partial.html -->
<div class="login-page">
  <div class="form">
    <form  action="<c:url value='/join.do'/>" class="register-form"  method="post">
      <input type="text"  name = "memberId" placeholder="name"/>
      <input type="password" name = "passwd" placeholder="password"/>
      <input type="text" name = "email"  placeholder="email address"/>
      <button type="submit">create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
    <form action="<c:url value='/login.do'/>" class="login-form" method="post">
      <input type="text" name="memberId" placeholder="username"/>
      <input type="password" name="passwd" placeholder="password"/>
      
      <button type="submit">login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
  </div>
</div>
	<!-- partial -->
	<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	

</body>
</html>
