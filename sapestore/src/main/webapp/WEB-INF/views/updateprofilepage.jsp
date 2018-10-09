<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${context}/resources/js/pagination.js"></script>
<link rel="stylesheet" href="${context}/resources/css/home.css">
<link rel="stylesheet" href="${context}/resources/css/style.css">
<link href="${context}/resources/styles/registrationform.css"rel="stylesheet">
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
 .active {
	    color: #23527c;
	    text-decoration: underline;
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

.details-wrapper-container{
	flex: 1;
}


.book-store-wrapper {
	display: flex;
	flex-direction: column;
    height: 100%;
}
.active { 
    background-color:#dfe5e6;
	display: block;
/* 	padding: 2px 1px 1px 16px; */

}  

.account-details {
	color: #1d1d1d;
    font-weight: regular;
    font-size: 18px;
    font-family: SapientSansRegular;
    text-decoration: none;
    height: auto;
    margin-top: 10px;
    margin-bottom: 10px;
	display: block
} 

.side-nav,
.main-wrapper {
	display: flex;
    flex: 1 1 100%;
    flex-direction: column;
    height: 100%;
}
.book-list {
	padding-left: 0;
	margin: 0;
	
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
	    <div class="col-lg-3 side-nav" style="background-color: white; padding-right:0;padding-left:0; ">
	    <nav>

				<h2>My Account</h2>
				<a href="${context}/viewprofilepage" class="account-details">View Profile</a>
				<a href="${context}/updateprofilepage" class="active account-details">Update Profile</a>
				<a href="${context}/transactionHistory" class="account-details">Transaction History</a>
				<a href="${context}/orderStatusPage" class="account-details">Order Status</a>
				

			</nav>
			</div>
	    <div class="col-lg-9 main-wrapper">
			
		

					<div id="test"></div>

					<div>
						<h3>Update Profile</h3>
					</div>
					
					<hr>
					<h4 style="color: green;">${message.successMessage}</h4>
					<h4 style="color: red;">${message.failiureMessage}</h4>
					<% session.setAttribute("message",null); %>

					<form id="regForm" action="updateuser" method="post">

						<input type="hidden" id="stateval" value='${statesel}'
							readonly="readonly" />

						<div class="inputData">
							<label id="label2">Name <span class="color-red">*</span></label>
							<input type="text" name="name" value="${customer.name}"
								id="email" required><br>
						</div>
						<br>
						<div class="inputData">
							<label id="label2">Password <span class="color-red">*</span></label>
							<input type="password" name="password" value="${customer.password}"
								id="password1" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,16}" title="password should have Minimum eight and maximum 16 characters, at least one uppercase letter, one lowercase letter, one number and one special character"><br>
						</div>
						<br>
						<div class="inputData">
							<label id="label2">Retype Password <span class="color-red">*</span></label>
							<input type="password" name="password1" value="${customer.password}"
								id="confirm_password" required><br>
						</div>
						<br>

						<div class="inputData">

							<label id="label2">Mobile Number<span class="color-red">*</span></label>
							<input type="number" name="phoneNumber"
								value="${customer.phoneNumber}" id="mobileNo" required pattern="[7-9]{1}[0-9]{9}" title="please provide a proper phone number"><br>
						</div>
						<br>
						<div class="inputData">
							<label id="label2">City<span class="color-red">*</span></label>
							<div class="zipsize">
								<input type="text" name="city" id="city"
									value="${customer.city}" required><br>
							</div>
						</div>
						<br>
						<div class="inputData">
							<label id="label2">State<span class="color-red">*</span></label>
							<div class="zipsize">
								<input type="text" name="state" id="state"
									value="${customer.state}" required><br>
							</div>
						</div>
						<br>

						<div class="inputData">
							<label id="label2">Address Line 1<span class="color-red">*</span></label>
							<input type="text" name="addressLine1" id="addressLine1"
								value="${customer.addressLine1}" required><br>
						</div>
						<br>

						<div class="inputData">
							<label id="label2">Address Line 2 </label>
							<input type="text" name="addressLine2" id="addressLine2"
								value="${customer.addressLine2 }" ><br>
						</div>
						<br>

						<div class="inputData">
							<label id="label2">Zip Code <span class="color-red">*</span></label>
							<div class="zipsize">
								<input type="number" name="pin" id="zipCode"
									value="${customer.pin}" required><br>
							</div>

						</div>

						<br>
						<button style="margin: auto; displa y: inline; margin-left: 30%"
							type="submit" class="btn btn-info" id="btnSubmit">Update
						</button>
						<!--  <input type="submit" value="Create Profile" id="subButton"> -->


						<br>


					</form>

					<br>
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