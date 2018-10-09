<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${context}/resources/js/pagination.js"></script>
<link rel="stylesheet" href="${context}/resources/css/home.css">
<link rel="stylesheet" href="${context}/resources/css/style.css">
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
       background-color: #cacfc0;
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

.details-wrapper-container{
	flex: 1;
}
.book-store-wrapper {
	display: flex;
	flex-direction: column;
    height: 100%;
}
.account-details {
	display: block;
}

.side-nav,
.main-wrapper {
	display: flex;
    flex: 1 1 100%;
    flex-direction: column;
    height: 100%;
}
.modal-dialog {
    width: 80%; 
}
.close {
       padding-left: 10px;
}
 
.badge {
       background-color: #de2728;
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
	    <div class="col-lg-3 side-nav" style="background-color: white; padding-bottom:600px ">
	    
	    </div>
	    <div class="col-lg-9 main-wrapper">
				
			
					<div id="test"></div>

					<div style="margin-left: 25%;">
						<h1>Update your password</h1>
					</div>
					<br>
					<hr>


					<form id="regForm" action="reset-password" method="post">


	
						<%
							session.setAttribute("message", null);
						%>
						<input type="hidden" name="userId" value="${userId}">
						<div class="inputData">
							<label id="label2">Type your New password <span class="color-red">*</span>
							</label> <input type="password" id="password1" name="password"  required><br>
						</div>
						<br>


						<div class="inputData">
							<label id="label2">Confirm your password!!!<span class="color-red">*</span>
							</label> <input style="margin-left: 5px;" type="password" id="confirm_password" name="password1" required><br>
						</div>
						<br>

						<button style="margin: auto; display: inline; margin-left: 20%"
							type="submit" class="btn btn-info" onclick="validatePassword()" id="btnSubmit">Update Password</button>

						<br>
						<br>
					</form>
					



					<br> <br> <br> <br> <br>
				</div>
</div>
	  </div>
 
	  <div class="row">
	    <div class="col-lg-12 footer-wrapper">
	       <%@ include file="footer.jsp"%> 
	    </div>
	  </div>
	  <script type="text/javascript">
		var password = document.getElementById("password1"), confirm_password = document.getElementById("confirm_password");

		function validatePassword() {
			if (password.value != confirm_password.value) {
				confirm_password.setCustomValidity("Passwords Don't Match");
			} else {
				confirm_password.setCustomValidity('');
			}
		}

		password.onchange = validatePassword;
		confirm_password.onkeyup = validatePassword;
	</script>
</body>
</html>
	