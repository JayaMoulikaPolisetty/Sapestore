<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</head>
<body>


<!-- <div id="header"></div> -->

 <!-- 
<div id="tabs" style="height: 615px; margin-left: -12px; border: none;">
   <ul style="padding-top: 20px; padding-left: 22px; padding-right: 3px;font-family:SapientSansMedium;font-size: 20px;"> 
<li><a href="purchase" style="outline: none">Purchased/Rented</a> </li>
<li><a href="defaulter" style="outline: none">Defaulter List</a> </li>
	
  </ul> -->
 
  <h2 style="border-bottom: 1px solid black;position: relative; left: 30px;">Order Status Tracking</h2>
  <br>
  <div class="container"  >
  <h4>Order ID</h4>
  <input type="text" name="status">
<input type="button" value="Update Status">
<br><br>

 <div class="pageheader">
		<h5><b>Order Detail</b></h5>
		</div>
		<table class="table">
		
<thead><tr>
    <th>Title</th>
    <th>ID</th>
<th>Price</th>
<th>Status</th>
</tr>
</thead> 
		 <tr>
		  <td>${book.title }</td>
		
		 
		 <td>${book.quantity }</td>
		 
		 
          <td>${book.price }</td>
          
          <td>${order.status}</td>
		 </tr>
		</table>
        </div>

</body>
</html>