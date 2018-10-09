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
			<div class="col-lg-3 col-sm-3 quicklinks"
				style="background-color: white; padding-right: 0; padding-left: 0;">
				<h2>Book Categories</h2>
				<c:forEach var="category" items="${categoriesList}">
					<%-- <h3 data-toggle="modal" data-target="#myModal">${category}</h3> --%>
					<c:choose>
						<c:when test="${category == selectedCategory}">
							<a href="${context}/all-books-by-category/${category}"
								class="account-details active"><h4>${category}</h4></a>
						</c:when>
						<c:otherwise>
							<a href="${context}/all-books-by-category/${category}"
								class="account-details"><h4 id="categoryId">${category}</h4></a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<div class="col-lg-9">
				<div class="container">

					<h2>SapeStore</h2>

					<c:choose>
						<c:when test="${quantity==0}">

							<h2 style="text-align: center">Wishlist is empty</h2>

						</c:when>
						<c:otherwise>
							<h2>Your wishlist</h2>
							<div class="table-responsive cart_info">
								<table class="table table-condensed">
									<thead>
										<tr>
											<th>Items</th>
											<th>Available</th>
											<th>Price</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="wishlist" items="${wishlistInfo}">


											<tr>
												<td>${wishlist.bookName}</td>
												<td><c:choose>
														<c:when test="${wishlist.quantity >5}">yes</c:when>
														<c:otherwise>No</c:otherwise>
													</c:choose></td>
												<td>${wishlist.bookPrice}</td>

												<td class="actions" data-th=""><a
													href="${context }/addToCartfromwishlist/${wishlist.isbn}/${wishlist.id}"
													class="btn btn-danger btn-sm">Add to Cart</a></td>

												<td class="actions" data-th=""><a
													href="${context }/delete-from-wishlist/${wishlist.id}"
													class="btn btn-danger btn-sm">Remove</a></td>

											</tr>



										</c:forEach>
									</tbody>

								</table>
							</div>
						</c:otherwise>
					</c:choose>
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
