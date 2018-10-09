<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
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
	background-color: #dfe5e6;
	font-family: "Sapient Centro Slab";
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

.active {
	background-color: #dfe5e6;
	display: block;
	/* 	padding: 2px 1px 1px 16px; */
}

.account-details {
	display: block;
}
</style>

<body style="height: 13000; width: 1000">

	<div class="container-fluid book-store-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<%@ include file="header.jsp"%>
			</div>
		</div>
		<div class="row details-wrapper-container">
			<div class="col-lg-3"
				style="background-color: white; padding-bottom: 600px">
				<nav>


					<h2>Forgot Password</h2>
				</nav>
			</div>
			<div class="col-lg-9">
		<div style="margin-left: 25%;">

				<h1>Forgot Password</h1>



			</div>
			<br>
			<hr>
			

			<form id="regForm" action="forgot" method="get">




				
				<%
					session.setAttribute("message", null);
				%>

				<div class="inputData">
					<label id="label2">Email<span class="color-red">*</span></label> <input
						type="email" name="email" id="email" style="margin-left: 20%;"
						required><br>
				</div>
				<br>




				<button style="margin: auto; display: inline; margin-left: 29%"
					type="submit" class="btn btn-primary" id="btnSubmit">Submit</button>

				<br> <br>
			</form>
			<p id="forgotPassword" style="margin-right:61%";>
				Click if you forgot your <a href="forgot-Password-Form"
					style="color: dodgerblue">Forgot Password</a> To Sign up Please <a
					id="reg" href="${context}/registrationForm">Register</a>
			</p>

			<p style="margin-right: 67%";>
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

</body>
</html>