<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="${context}/resources/js/pagination.js"></script>
<link rel="stylesheet" href="${context}/resources/css/home.css">

<link href="${context}/resources/styles/registrationform.css"rel="stylesheet">
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
	margin-right:0;
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
					<a href="${context}/viewprofilepage" class="active account-details" >View Profile</a>
					<a href="${context}/updateprofilepage" class="account-details">Update Profile</a>		
					<a href="${context}/transactionHistory" class="account-details">Transaction History</a>
					<a href="${context}/orderStatusPage" class="account-details">Order Status</a>
					
					
			
			</nav>
	    </div>
	    <div class="col-lg-9 main-wrapper">
	    
	    


				<div id="test"></div>
	
				<div>
					<h3>View Profile</h3>
				</div>
				
				<hr>
				<div class="inputData">
					<label id="label2">Name </label> 
					<input
						 name="email" id="email" value="${customer.name}" disabled><br>
				</div>
				<br> 


				<div class="inputData">

					<label id="label2">Mobile Number</label> <input 
						name="phoneNumber" id="mobileNo" value="${customer.phoneNumber}" disabled><br>
				</div>
				<br>
					
				
					
				

				<div class="inputData">
					<label id="label2">Email</label> <input
						 name="email" id="email" value="${customer.email}" disabled><br>
				</div>
				<br> 

			
							
			<div class="inputData">
				<label id="label2">Address Line 1</label>
				<input  name="addressLine1" id="addressLine1"
					value="${customer.addressLine1}" disabled><br>
			</div>
			<br>
			
			<div class="inputData">
				<label id="label2">Address Line 2</label> <input 
					name="addressLine2" id="addressLine2" value="${customer.addressLine2}" disabled><br>
			</div>
			<br>
			
			<div class="inputData">
				<label id="label2">City</label>
				<input  name="addressLine1" id="addressLine1"
					value="${customer.city}" disabled><br>
			</div>
			<br>
			
			<div class="inputData">
				<label id="label2">State</label>
				<input  name="addressLine1" id="addressLine1"
					value="${customer.state}" disabled><br>
			</div>
			<br>
			
			<div class="inputData">
				<label id="label2">Zip Code</label>
				<div class="zipsize">
					<input type="text" name="zipCode" id="zipCode" value="${customer.pin}" disabled><br>
				</div>
				</div>
				<br>
			</div>

	
			</div>
		</div>
	  
	  <div class="row">
	    <div class="col-lg-12 footer-wrapper">
	       <%@ include file="footer.jsp"%> 
	    </div>
	  </div>
</body>
</html>