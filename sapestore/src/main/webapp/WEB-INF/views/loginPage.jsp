<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript"
	src="${context}/resources/js/pagination.js"></script>
<link rel="stylesheet" href="${context}/resources/css/home.css">
<link rel="stylesheet" href="${context}/resources/css/style.css">
<link href="${context}/resources/styles/fpc.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style>
.details-wrapper {
	display: flex;
	flex-wrap: wrap;
}

.book-list {
	display: flex;
	flex-direction: column;
}

.book-image {
	width: 100px
}

body {
	background-color: #cacfc0
}

.footer-wrapper {
	padding: 0
}

.container-footer {
	background-color: #000;
}

.container-footer {
	display: flex;
	justify-content: center;
}

.footer-privacy-details {
	flex: 1;
	justify-content: center;
}

.details-wrapper-container {
	flex: 1;
}

.book-store-wrapper {
	display: flex;
	flex-direction: column;
	height: 100%;
}
</style>

<body>
	<div class="container-fluid book-store-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<%@ include file="header.jsp"%>
			</div>
		</div>
		<div class="row details-wrapper-container">
			<div class="col-lg-3"
				style="background-color: white; padding-bottom: 45%">
				<h2>Login Page</h2>
			</div>
			<div class="col-lg-9">
				<div style="margin-left: 25%;">
					<h1>Login Page</h1>
				</div>
				<br>
				<hr>
<br>

				<form id="regForm" action="login" method="post">


					<input type="hidden" id="stateval" value='${statesel}'
						readonly="readonly" />

					<center>
						<h4 style="color: red;">${message.failiureMessage}</h4>
					</center>
					<%session.setAttribute("message", null);%>

					<div class="inputData">
						<label id="label2">Email <span class="color-red">*</span></label>
						<input style="margin-left: 20%;" type="email" name="email" id="email" required><br>
					</div>
					<br>


					<div class="inputData">
						<label id="label2">Login Password <span class="color-red">*</span>
						</label> <input id="password1" style="margin-left: 13.3%;" type="password" name="password" required><br>
					</div>
					<br>

					<button style="margin: auto; display: inline; margin-left: 30%"
						type="submit" class="btn btn-info" id="btnSubmit">Login</button>

					<br> <br>
				</form>

				<p  style="margin-right:60%; ">
					Click if you forgot your <a href="forgot-Password-Form"
						style="color: dodgerblue">Forgot Password</a> To Sign up Please <a
						id="reg" href="${context}/registrationForm">Register</a>
				</p>

				<p style="margin-right:63%; ">
					By creating an account you agree to our <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<br>

			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 footer-wrapper">
				<%@ include file="footer.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>
