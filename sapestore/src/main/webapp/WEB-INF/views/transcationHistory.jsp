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
	/* padding: 2px 1px 1px 16px; */

} 
.account-details {
	display: block;
}

</style>

<body style="background-color: #cacfc0; height: 13000; width: 1000">

	<div class="container-fluid book-store-wrapper">
	  <div class="row">
	    <div class="col-lg-12">
	       <%@ include file="header.jsp"%>
	    </div>
	  </div>
	  <div class="row details-wrapper-container">
	    <div class="col-lg-3"style="background-color: white ;padding-bottom: 500px" >
		<nav>
			<h2>Account</h2>
					<a href="${context}/TransactionHistory" class=" active account-details">Transcation History</a>
					<a href="${context}/OrderStatus" class=" account-details">OrderStatus</a>
					<a href="${context}/updateprofilepage" class="account-details" >UpadteProfile</a>
					<a href="${context}/viewprofilepage" class="account-details" >ViewProfile</a>
			</nav>
			
		</div>
	    <div class="col-lg-9">
		
	  	<h3>Transcation History</h3>
				</div>



				<table border=1>
					<tr>
						<th>ORDER ID</th>
						<th>NAME AND AUTHOR</th>
						<th>ORDER DATE</th>

						<th>PRICE</th>

					</tr>


					<tbody>
					<c:forEach var="transaction" items="${transactions}">

						<tr>
							<td rowspan="${transaction.size}">${transaction.orderId}</td>
							<td>
								<div class="row">
									<div class="col-sm-4" style="display: inline;">
										<img src="${context}${transaction.bookImage}"
											style="width: 40px; height: 78px; display: inline;">
									</div>
									<div style="display: inline;">
										${transaction.name}
									</div>
								</div>
							</td>
							<td>${transaction.orderDate}</td>

							<td>${transaction.price}</td>
						</tr>
						</c:forEach>
						</tbody>
</table>
</div>
</div>
						<!-- <tr>

							<td>
								<div class="row">
									<div class="col-sm-4" style="display: inline;">
										<img src="resources/images/book.jpg"
											style="width: 40px; height: 78px; display: inline;">
									</div>
									<div style="display: inline;">
										Name<br> Author
									</div>
								</div>
							</td>
							<td>date</td>

							<td>price</td>
							<td>shipping address</td>
						</tr>
 -->
	  
	  
	  <div class="row">
	    <div class="col-lg-12 footer-wrapper">
	       <%@ include file="footer.jsp"%> 
	    </div>
	  </div>
	
</body>
</html>