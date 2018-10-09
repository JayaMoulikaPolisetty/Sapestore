<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Detail</title>
<script type="text/javascript"></script>

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
<style>
.main-container {
	display: flex;
	background-color: #cacfc0;
}

.book-categories {
	width: 200px;
	background-color: white;
	padding: 10px 0px 10px 10px;
}

.book-categories ul {
	list-style-type: none;
}

.book-categories .active {
	background-color: #cacfc0;
}

.book-details {
	flex: 1;
	margin: 20px 10px 10px;
	background-color: #cacfc0;
}

.book-content {
	display: flex;
}

.book-content>img {
	margin-right: 20px;
}

.text {
	flex: 1
}

.title {
	font-size: 1.75em;
	color: #000;
}

.description {
	font-size: 1em;
	color: #000;
}

.action-items {
	
}

.book-image {
	width: 100px
}
/* .book-list {   
        display:inline-flex;
flex-direction: column; 
    padding-left:80px;
    paddin-right:80px} */
.setImg {
	width: 222px;
	height: 152px
}

.shadow-textarea textarea.form-control::placeholder {
	font-weight: 300;
}

.shadow-textarea textarea.form-control {
	padding-left: 0.8rem;
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
	background-color: #cacfc0;
	font-family: "Sapient Centro Slab";
}

.footer-wrapper {
	padding: 0px;
	position: relative;
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

.comments-wrapper {
	display: flex;
	flex-direction: column;
}

.active {
	background-color: #cacfc0;
	display: block;
	padding: 2px 1px 1px 16px;
}

header .row {
	background-color: #000;
	display: flex;
	align-items: center;
}

.data-list {
	pointer-events: none;
}

#screen {
	width: 100%;
}

.quicklinks dd {
	color: #1d1d1d;
	font-weight: regular;
	font-size: 14px;
	font-family: SapientSansRegular;
	text-decoration: none;
	height: auto;
	padding: 5px;
	width: 350px;
}

.book-author {
	font-family: SapientSansRegular;
	font-weight: regular;
	font-size: 18px;
	color: #000000;
}

.book-publisher {
	font-family: SapientSansRegular;
	font-weight: regular;
	font-size: 14px;
	color: #000000;
}

.book-title {
	font-family: SapientCentroSlab;
	font-weight: medium;
	font-size: 28px;
	color: #000000;
}

.comment {
	padding-right: 10px;
}

.comment-para {
	text-align: start;
}

.checked {
	color: orange;
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

.screen {
	width: 100%;
}

.click {
	color: red;
}
</style>

</head>
<body style="background-color: #cacfc0">
	<div class="container-fluid book-store-wrapper screen">
		<div class="row">
			<div class="col-lg-12">
				<%@ include file="header.jsp"%>
			</div>
		</div>
		<div class="row details-wrapper-container">
			<div class="main-container">


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
				<section class="book-details">
					<div class="book-content"
						style="font-size: 22px; font-family: SapientCentroSlab; font-weight: medium; padding-bottom: 0px;">

						<div class="action-items">
						<c:choose>
							<c:when test="${customer ne null }">
								<a href="${context}/add-to-wishlist/${book.iSBN}"
									style="float: right;" class="click">&nbsp;&nbsp; Add to
									wishlist </a>&nbsp; 
								
								<a type="button" id="#myReviewModal" href="modal"
									data-toggle="modal" data-target="#myReviewModal"
									style="float: right;" class="click">Write a review &nbsp; |</a>
							</c:when>
							<c:otherwise>
								<button type="button" onclick="myfunction()"
									class="btn btn-info" style="width: 120px;"
									value="Add to Woishlist">Add to Wishlist</button>
								<button type="button" onclick="myfunction()"
									class="btn btn-info" style="width: 120px;"
									value="Add to Woishlist">Write a review</button>
							</c:otherwise>
							</c:choose>
							<br> <br>


							<table>
								<tr>
									<c:url value="${book.book_img}" var="imageUrl"></c:url>
									<td><img src="${imageUrl}" height="222px" width="152px"></td>
									<td>
										<div id="101" class="book-title">&nbsp;&nbsp;${book.title}</div>


										<div id="102" class="book-author">&nbsp;&nbsp;&nbsp;${book.author}</div>

										<div class="rating" style="padding-left: 10px"
											id="averageRating"></div>

										<div id="103" class="book-publisher">&nbsp;&nbsp;&nbsp;&nbsp;Publisher:
											${book.publisher}</div> <c:choose>
											<c:when test="${customer ne null}">
												<div style="padding-left: 10px;" data-toggle="tooltip"
													title="Add to cart">
													<a href="${context}/addToCart/${book.iSBN}"
														class="btn btn-info" style="width: 120px;"> <span
														class="btn btn-info"> &#8377 ${book.price} <span
															class="glyphicon glyphicon-shopping-cart"></span></a></span>
												</div>
											</c:when>

											<c:otherwise>
												<div style="padding-left: 10px;" data-toggle="tooltip"
													title="Add to cart">
													<button id="login" onclick="myfunction()"
														class="btn btn-info" style="width: 120px;">
														<span class="btn btn-info"> &#8377 ${book.price} <span
															class="glyphicon glyphicon-shopping-cart"></span>
													</button>
													</span>
												</div>
											</c:otherwise>

										</c:choose>
									</td>
								</tr>

							</table>
							<br> <b>Description</b> <br> ${book.long_desc}






							<c:if test="${book.quantity==0 }">
Out of Stock
</c:if>
							<c:if test="${book.quantity!=0 }">
								<c:url value="${context }/cart/addtocart/${book.iSBN }"
									var="url"></c:url>
								<form action="${url }"></form>
							</c:if>


							<div class="modal fade" class="al" id="myReviewModal"
								role="dialog">
								<div class="modal-dialog">

									<!-- Modal content-->
									<div class="modal-content" style="width: initial">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Write a review</h4>
										</div>
										<div>
											<div>
												<form action="add-comment" method="post">
													<div class="row">

														<div class="col-sm-5">
															<img
																src="${pageContext.request.contextPath}${book.book_img}"
																alt="..." height="222px" width="152px" /><br>
															<h2 class="nomargin">${book.title}</h2>
														</div>


														<div class="form-group shadow-textarea col-sm-7">
															<label for="exampleFormControlTextarea6">Your
																comment</label>
															<textarea class="form-control z-depth-1"
																id="exampleFormControlTextarea6" cols="20" rows="4"
																placeholder="Write something here..." name="comment"
																required="required"></textarea>
															<br> <input type="number" name="rating"
																placeholder="Your rating" min="0" max="5"
																required="required"> <input type="submit"
																value="POST COMMENT" class="btn btn-primary"> <input
																type="submit" value="CANCEL POST" class="btn btn-danger">

														</div>

													</div>


												</form>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</div>

								</div>
							</div>

						</div>
						<hr>


					</div>
					<div id="detailsWrapper" class="details-wrapper row"></div>

					<!-- Pagination -->
					<div class="right">

						<div class="pagination" id="pagination1"></div>
					</div>

					<div class="comment-section-wrapper">
						<h3>
							<b>Customer Reviews</b>
						</h3>
						<hr>
					</div>

					<c:forEach var="comment" items="${comments}">
						<div class="comment-section">

							<div>
								<div id="commentRating" style="visibility: hidden">${comment.book_rating}</div>

								<span class="comment"><b>${comment.userName}</b></span>
								<!-- <span class="rating" style="padding-left:10px" id="averageCommentRating"></span> -->

								<span class="rating" style="padding-left: 10px"> <c:forEach
										var="i" begin="1" end="5">
										<c:choose>
											<c:when test="${comment.book_rating >= i}">
												<span class="fa fa-star checked"></span>
											</c:when>
											<c:otherwise>
												<span class="fa fa-star"></span>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</span> <span class="comment">&nbsp;${comment.book_comment_date}</span>
								<br>
								<p class="comment-para">
									<h5>${book.title}:&nbsp;${comment.book_comment}</h5>

							</div>
						</div>
						<hr>

					</c:forEach>

				</section>
			</div>
		</div>

		<div></div>
		<div class="row">
			<div class="col-lg-12 footer-wrapper">
				<%@ include file="footer.jsp"%>
			</div>
		</div>

	</div>
</body>

<script type="text/javascript">

var ctx = "${pageContext.request.contextPath}" ;

(() => {
    const ratingNumber = Math.floor(document.getElementById("commentRating").innerHTML);
    const unfilledRating = 5 - ratingNumber;
    const productDetailsElement = document.getElementById("wrapper");
    const filledStars = Array(ratingNumber).fill("<span class='fa fa-star checked'></span>");
    const unfilledStars = Array(unfilledRating).fill('<span class="fa fa-star"></span>');
    const ratingTemplate = filledStars.concat(unfilledStars);
    console.log(ratingTemplate)
    $('#averageCommentRating').append(ratingTemplate);
       })();

(() => {
    const ratingNumber = Math.floor(${averageRating});
    const unfilledRating = 5 - ratingNumber;
    const productDetailsElement = document.getElementById("wrapper");
    const filledStars = Array(ratingNumber).fill("<span class='fa fa-star checked'></span>");
    const unfilledStars = Array(unfilledRating).fill('<span class="fa fa-star"></span>');
    const ratingTemplate = filledStars.concat(unfilledStars);
    console.log(ratingTemplate)
    $('#averageRating').append(ratingTemplate);
       })();

function fetchAllBookData(title) {
          return new Promise((resolve, reject) => {
                 fetch(ctx+ '/all-books-by-category/' + title).then(res => {
                           res.json().then(data => {
                                  console.log(data);
                                  $("#detailsWrapper").empty();
                                  const dataToPush = [];
                                  data.forEach(item => {

                                         
                                         const htmlElement = '<div class="book-list" style="padding:12px;"><img src= ' + ctx + item.book_img + ' class="book-image">' + '<span><a href="one-book/'+item.iSBN +'">'+ item.title + '</span></a>' + '<span>' + item.author + '</span>'  + '<span class="btn btn-info" > &#x20b9 ' + item.price +   '<a href="${context}/addToCart/'+item.iSBN+'" class="btn btn-info"  style="width:50px;"> <span class="glyphicon glyphicon-shopping-cart"/></a></span>' +'</div>';
                                         dataToPush.push(htmlElement);
                                  });
                                  resolve(dataToPush);
                       })
                 })
          });
}
       
          
let currentBookData = [];
       (() => {
              const dataToFetch = $('.data-list')[0].innerHTML;
              const id = $('.data-list')[0].id;
              $("#" + id).addClass("active").siblings().removeClass("active");
              fetchAllBookData(dataToFetch).then(allBook => {
                     currentBookData = allBook;
                     const paginatedData = getPaginationData(allBook, 1);
                     paginatedData.forEach(item => {
                           $("#detailsWrapper").append(item);
                     });
                     const numberOfPagination = Math.floor(allBook.length / 10);
                     if((numberOfPagination * 10) === allBook.length) {
                           var points = new Array(numberOfPagination + 1);
                           $("#pagination").append(`<a id="prev">&laquo;</a>`);
                           $("#pagination1").append(`<a id="prev">&laquo;</a>`);
                      for (var i = 0; i < numberOfPagination + 1; i++) {
                          points[i] = i + 1;
                          $("#pagination").append("<a id='paginationNum'>"+ (i + 1) + '</a>');
                          $("#pagination1").append("<a id='paginationNum'>"+ (i + 1) + '</a>');
                      }
                      $("#pagination").append(`<a id="next" >&raquo;</a>`);
                      $("#pagination1").append(`<a id="next" >&raquo;</a>`);
                     } else {
                           var points = new Array(numberOfPagination);
                           $("#pagination").append(`<a id="prev">&laquo;</a>`);
                           $("#pagination1").append(`<a id="prev">&laquo;</a>`);
                      for (var i = 0; i < numberOfPagination; i++) {
                          points[i] = i + 1;
                          $("#pagination").append(`<a id='paginationNum' onclick="onClickPaginationNum(this)">`+ (i + 1) + '</a>');
                          $("#pagination1").append(`<a id='paginationNum' onclick="onClickPaginationNum(this)">`+ (i + 1) + '</a>');
                      }
                      $("#pagination").append(`<a id="next" >&raquo;</a>`);
                      $("#pagination1").append(`<a id="next" >&raquo;</a>`);
                     }
              });
       })();

       function onClickPaginationNum(e) {
              console.log( e.innerHTML );
              $("#detailsWrapper").empty(); 
              const paginatedData = getPaginationData(currentBookData, e.innerHTML);
              paginatedData.forEach(item => {
                     $("#detailsWrapper").append(item);
              })
       }
       function getPaginationData(dataToPush, num) {
              return dataToPush.slice((num - 1) * 10, num * 10);
       }
        function fetchData(e) {
              const title = e.innerHTML;
              fetchAllBookData(title).then(allBook => {
                     currentBookData = allBook;
                     const paginatedData = getPaginationData(allBook, 1);
                     paginatedData.forEach(item => {
                           $("#detailsWrapper").append(item);
                     });
                     
                     $("#" + e.id).addClass("active").siblings().removeClass("active");
              

                     

       });
       };

       var active=document.getElementsByClassName("active");
       active.style.background="red";

       
       var active=document.getElementsByClassName("active");
       active.style.background="red";

    var modal = document.getElementById('myModal');
    
    var btn = document.getElementById("myBtn");
    
    var span = document.getElementsByClassName("close")[0];
    
    btn.onclick = function() {
        modal.style.display = "block";
    }
    
    span.onclick = function() {
        modal.style.display = "none";
    }
    
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
  

function myfunction(){

$('#loginModel').show();
}


</script></
								html>
