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
	<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

.bodyContent {
	background-color: lightgrey;
}
.error{
	color:red;
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

			<div class="row details-wrapper-container">
				<center>
					<h2>Order Report Page</h2>
				</center>
				<br>
				<br>
				<div class="container">



					<form action="reportManagement" method="get">
						<center>
							<label>Date To: </label> <input type="date" name="dateto"
								required /> <label>Date From: </label> <input type="date"
								name="datefrom" required /> <br> <input type="submit"
								value="Submit">
							</center>
					</form>



					<br>
					<br>
				</div>
				<div class="container">
				
				<div id="msg" class="row">
        		 <h2 class="error"> ${errorMsg}</h2>
                </div>
                <br>
                <br>
					<div class="table-responsive">
				
						<table class="table">
							<thead>

								<tr>

									<th>Order_Id</th>
									<th>User_Id</th>
									<th>Quantity</th>
									<th>Total Payment</th>
									<th>Status</th>
								</tr>
							</thead>

							<c:forEach var="report" items="${orderList}">
								<tbody>
								<h2>${error}</h2>
									<tr>


										<td>${report.orderId}</td>
										<td>${report.userId}</td>
										<td>${report.orderQuantity}</td>
										<td> <i class="fa">&#xf156;</i> ${report.totalPayment}</td>
										<td>${report.orderStatus}</td>
									</tr>
								</tbody>
							</c:forEach>




						</table>
						
					</div>
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