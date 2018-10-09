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
#thumbnail {
	background-color: #cacfc0;
}

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

.add-button-update {
	display: flex;
	align-items: center;
	justify-content: center;
}

#add {
	align-items: right;
	justify-content: right;
}

.data-list {
	cursor: pointer;
}

#screen {
	width: 100%;
}

.active {
	background-color: #dfe5e6;
	display: block;
	padding: 2px 1px 1px 16px;
	width: "330px"
}

.but {
	text-align: left;
}

.quicklinks {
	height: 100%;
}

input[value="true"] {
	background-color: green;
	width: 40px;
	height: 40px;
	border-radius: 20px;
	text-align: center;
	color: white;
	/*  value:Active; */
}

input[value*="false"] {
	background-color: red;
	/*  width: 50px;
 height:33px;
 border-radius: 20px; */
	width: 40px;
	height: 40px;
	border-radius: 20px;
	text-align: center;
	color: white;
}

#errorSnackbar {
	visibility: hidden;
	min-width: 250px;
	margin-left: -125px;
	background-color: #333;
	color: #fff;
	text-align: center;
	border-radius: 2px;
	padding: 16px;
	position: fixed;
	z-index: 1;
	left: 50%;
	bottom: 30px;
	font-size: 17px;
}

#errorSnackbar.show {
	visibility: visible;
	-webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
	animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@
-webkit-keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
keyframes fadein {
	from {bottom: 0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
-webkit-keyframes fadeout {
	from {bottom: 30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}

}
@
keyframes fadeout {
	from {bottom: 30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}

}
.checked {
	color: orange;
}
</style>
<body>
	<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<div class="container-fluid book-store-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<%@ include file="header.jsp"%>
			</div>
		</div>
		<div class="row details-wrapper-container">
			<div class="col-lg-3  col-sm-3 quicklinks"
				style="background-color: white"">
				<h3>
					<b>Book Categories</b>
				</h3>
				<c:forEach var="category" items="${category}">
					<%-- <h3 data-toggle="modal" data-target="#myModal">${category}</h3>
                     --%>
					<c:set var="context" value="${pageContext.request.contextPath}" />
					<a href="${context}/categoryBookList/${category}">
						<h4>${category}</h4>
					</a>
				</c:forEach>
			</div>
			<div class="col-lg-9">
				<div class="container-fluid ">

					<div class="row">
						<div class="col-lg-12">
							
							<c:set var="context" value="${pageContext.request.contextPath}" />
							<div class="main-container container-fluid">

								<section class="book-details row">
									<div class="book-details-wrapper col-lg-10">
										<div class="book-content">
											<img src="${context}${productList.book_img}" alt="not available"
												height="222" width="152" />
											<div class="text">
												
												<div class="title">
													<h2>${productList.title }</h2>
													
												</div>
												<div class="author">
													<h4>${productList.author }</h4>
												</div>
												<div class="author">
													<h4> <i class="fa">&#xf156;</i>${productList.price }</h4>
												</div>
												<div class="rating" id="rating"></div>
												<div class="publisher">
													<h4>${productList.publisher }</h4>
												</div>


											</div>

										</div>
										<hr>
										<div class="title">
											<h3>
												Description
												</h3>
										</div>
										<div class="description">${productList.long_desc }</div>
										<br> <br> <br> <br>
										<hr>
										<div class="title">
											<h3>User's Comments</h3>
										</div>
										<c:forTokens var="token" items="${bookCommentsList}"
											delims="[],">
											<c:out value="${token}" />
											</br>
										</c:forTokens>



										<%-- <div class="commentList">${bookCommentsList}</div> --%>

									</div>
								</section>
							</div>
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
		<script>
								
		(() => {
           const ratingNumber = Math.floor(${rating});
           const unfilledRating = 5 - ratingNumber;
           const productDetailsElement = document.getElementById("wrapper");
           const filledStars = Array(ratingNumber).fill("<span class='fa fa-star checked'></span>");
           const unfilledStars = Array(unfilledRating).fill('<span class="fa fa-star"></span>');
           const ratingTemplate = filledStars.concat(unfilledStars);
           console.log(ratingTemplate)
           $('#rating').append(ratingTemplate);
		})();
   </script>
</body>
</html>