<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction History</title>
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
		
			<div class="col-lg-3 side-nav" style="background-color: white; padding-right: 0;padding-left: 0;">
				
				<nav>
					<h2>My Account</h2>
					<a href="${context}/viewprofilepage" class="account-details">View Profile</a> <a
						href="${context}/updateprofilepage" class="account-details">Update
						Profile</a> <a href="${context}/transactionHistory"
						class="active account-details">Transaction History</a> <a
						href="${context}/orderStatusPage" class="account-details">Order
						Status</a>
				</nav>
				<%-- <c:forEach var="transaction" items="${transactions}">
				<br>
				</c:forEach> --%>
			</div>

			<div class="col-lg-9 main-wrapper">

				<h3>My Account</h3>

				<div class="">
					<table class="table">
						<tr>
							<th>TRANSACTION ID</th>
							<th>NAME AND AUTHOR</th>
							<th>ORDER DATE</th>
							<th>ORDER STATUS</th>
							<th>PRICE</th>

						</tr>


						<tbody>
							<c:forEach var="transaction" items="${transactions}">

								<tr>
									<td>${transaction.orderId}</td>
									<td>
										<div class="row">
											<div class="col-sm-4" style="display: inline;">
												<img src="${context}${transaction.bookImage}"
													style="width: 40px; height: 78px; display: inline;">
											</div>
											<div style="display: inline;">${transaction.name}</div>
										</div>
									</td>
									<td>${transaction.orderDate}</td>
									<td>${transaction.orderStatus}</td>
									<td>${transaction.price}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
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