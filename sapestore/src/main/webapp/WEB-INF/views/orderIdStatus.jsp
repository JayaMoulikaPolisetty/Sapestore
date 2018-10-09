<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:set var="context" value="${pageContext.request.contextPath}" />

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
.error
{
color:red;
}
</style>
</head>
<body>
	<div class="container-fluid book-store-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<%@ include file="header.jsp"%>
			</div>
		</div>

		<!-- <div id="header"></div> -->

		<!-- 
<div id="tabs" style="height: 615px; margin-left: -12px; border: none;">
   <ul style="padding-top: 20px; padding-left: 22px; padding-right: 3px;font-family:SapientSansMedium;font-size: 20px;"> 
<li><a href="purchase" style="outline: none">Purchased/Rented</a> </li>
<li><a href="defaulter" style="outline: none">Defaulter List</a> </li>
	
  </ul> -->

		<h2
			style="border-bottom: 1px solid black; position: relative; left: 30px;">Order
			Status Tracking</h2>
		<br>
		<div class="container">
			<h4>Order ID</h4>
			
			<form action="ordertrackingbyorderid" method="get">
				<input type="text" name="orderId"   required pattern="[0-9]{0,9}" title="Enter Valid Order Id"> <input type="submit"
					value="Enter Order Id" class="button  btn-info">
			</form>
			<br>
			<br>
			<div id="msg" class="row">
				<h2 class="error">${errorMessage}</h2>

			</div>
			<br>
			<br>
			<c:if test="${order ne null }">
			<div class="pageheader">
			
				<h5>
					<b>Order Detail</b>
				</h5>
			</div>
		
			<table class="table">
				<%-- <c:forEach var="order" items="${allOrderList}"> --%>
				<thead>
					<tr>
						<th>Order Id</th>
						<th>User Id</th>
						
						<th>QUANTITY</th>
						<th>Price</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>${order.orderId }</td>
						<td>${order.userId }</td>
						<td>${order.orderQuantity }</td>
						<td> <i class="fa">&#xf156;</i>${order.totalPayment }</td>
						<td>${order.orderStatus}</td>
					</tr>



				</tbody>

			</table>

	</c:if>
		</div>
		
	</div>
	
		<div class="col-lg-12 footer-wrapper">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>