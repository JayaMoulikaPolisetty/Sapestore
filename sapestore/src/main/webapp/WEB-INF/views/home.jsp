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

<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.details-wrapper {
       display: flex;
       flex-wrap: wrap;
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
       padding: 0
}

.container-footer {
       background-color: #000;
}

.container-footer {
       display: flex;
    justify-content: center;
    height: 100%;
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
.quicklinks{
height: 100%;
}

.quicklinks a {
       display: block;
}

.active { 
    background-color:#cacfc0;
       display: block;
       padding: 2px 1px 1px 16px;

}
input[value="true"] {
    background-color: green;
width: 40px;
height:40px;
border-radius: 20px;
text-align: center;
color: white;
/*  value:Active; */
}
input[value*="false"] {
  
  background-color: red;
   width: 40px;
height:40px;
border-radius: 20px; 
 text-align: center;
  color: white;
  
}

.quicklinks{
   height: 100%;
   display: flex;
   flex-direction: column;
}

.row.book-category {
    display: flex;
    flex-wrap: wrap;
}

.book-card {
    display: flex;
    flex-direction: column;
    padding-top: 25px;
}

.caption {
       flex: 1 1 100%;
       display: flex;
    flex-direction: column;
}

.text-details {
       flex: 1 1 100%;
}
.nav{
       display: flex;
       flex-direction: column;
       width: 18%;
}

.checked {
       color: orange;
}
.caption-tbody {
    display: flex;
    flex-direction: column;
    flex: 1 1 100%;
}

</style>
<body  onload="lg()">
	<c:choose>
		<c:when test="${message!= null}">


			<script type="text/javascript">
				function lg() {
					$('#loginModel').show();

				}
			</script>
		</c:when>
		<c:when test="${errorMessage!= null}">
			<script type="text/javascript">
				function lg() {
					$('#forgotModel').show();

				}
			</script>
		</c:when>
		<c:when test="${successMessage !=null}">
			<script type="text/javascript">
				function lg() {
					$('#forgotModel').show();

				}
			</script>
		</c:when>
	</c:choose>


<div class="container-fluid book-store-wrapper">
  <div class="row">
    <div class="col-lg-12">
       <%@ include file="header.jsp"%>
    </div>
  </div>
  <div class="row details-wrapper-container">
    <div  class="col-lg-3 col-sm-3 quicklinks"  style="background-color: white;padding-right:0;padding-left:10px;">
    <h2>Book Categories</h2>
<c:forEach var="category" items="${categoriesList}">
<%-- <h3 data-toggle="modal" data-target="#myModal">${category}</h3> --%>
<c:choose>
<c:when test="${category == selectedCategory}"><a href="${context}/all-books-by-category/${category}" class="account-details active"><h4>${category}</h4></a></c:when>
<c:otherwise><a href="${context}/all-books-by-category/${category}" class="account-details"><h4 id="categoryId">${category}</h4></a></c:otherwise>
</c:choose> 
</c:forEach>
    </div>
    
    <div class="col-sm-9 col-md-9 col-lg-9 book-card" style="padding-bottom:0;">
<c:if test="${empty selectedCategory}">
    <h1>Top Rated</h1>
    
</c:if>
<h1>${selectedCategory}</h1>
<div class="row book-category" >

<c:forEach var ="top" items="${topRatedList}">  
  <div class="nav" style="padding: 12px; padding-left:20px;">
<table class="caption" >
<tbody class="caption-tbody">
<tr> <td colspan="2" style="text-align:center;"><span><img src="${context}${top.book_img}" width="78px" height="108px"></span><br></td></tr>
    <tr>    <td> <span><a href="${context}/one-book/${top.iSBN}"></span>${top.title}</a></td>  </tr>
  <tr><td>  ${top.author}</td></tr>
  <tr><td>
       <div class="rating" style="padding-left:10px">
         <c:forEach var = "i" begin = "1" end = "5">
         <c:choose>
             <c:when test="${top.avgRating >= i}"><span class="fa fa-star checked"></span></c:when>
             <c:otherwise><span class="fa fa-star"></span></c:otherwise>
         </c:choose>
      </c:forEach>
    </div>
</td></tr>
<!--   <tr><td><div class="rating" style="padding-left:10px" id="averageRating"></div></td></tr>
--> <tr><td>

<c:choose>
  <c:when test="${customer ne null}">
  <div  data-toogle="tooltip" title="Add to cart">
<a href="${context}/addToCart/${top.iSBN}" class="btn btn-info"  style="width:120px;">
  
 <span class="btn btn-info"> &#8377   ${top.price} <span class="glyphicon glyphicon-shopping-cart" ></span></a></span>
</div>    
  </c:when>
  
  <c:otherwise>
  <div  data-toogle="tooltip" title="Add to cart">
<button id="login" onclick="myfunction()" class="btn btn-info"  style="width:120px;">
  
 <span class="btn btn-info"> &#8377  ${top.price} <span class="glyphicon glyphicon-shopping-cart" ></span></button></span>
</div>    
  </c:otherwise>
  
</c:choose> 
  </td></tr>
</tbody>

</table>
</div>
</c:forEach>

<c:forEach var="book" items="${bookList}">

<div class="nav" style="padding: 12px">
<table class="caption" >
<tbody class="caption-tbody">

<div id="averageRating1"  style="visibility: hidden">${book.avgRating}</div>

<tr>
       <td colspan="2" style="text-align:center;"><span><img src="${context}${book.book_img}" width="100px" height="108px"></span><br></td></tr>

    <tr>    <td> <span><a href="${context}/one-book/${book.iSBN}"></span>${book.title}</a></td>  </tr>
  <tr>     <td>  ${book.author}</td></tr>
  <!-- <tr><td><div class="rating" style="padding-left:10px" id="averageRating"></div></td></tr>  -->
<tr><td>
       <div class="rating" style="padding-left:10px">
         <c:forEach var = "i" begin = "1" end = "5">
         <c:choose>
             <c:when test="${book.avgRating >= i}"><span class="fa fa-star checked"></span></c:when>
             <c:otherwise><span class="fa fa-star"></span></c:otherwise>
         </c:choose>
      </c:forEach>
    </div>
</td></tr>
  
 <tr><td>
<c:choose>
  <c:when test="${customer ne null}">
  <div  data-toogle="tooltip" title="Add to cart">
<a href="${context}/addToCart/${book.iSBN}" class="btn btn-info"  style="width:120px;">
  
 <span class="btn btn-info"> &#8377   ${book.price} <span class="glyphicon glyphicon-shopping-cart" ></span></a></span>
</div>    
  </c:when>
  
  <c:otherwise>
  <div  data-toogle="tooltip" title="Add to cart">
<a id="login" onclick="myfunction(this)" class="btn btn-info"  style="width:120px;">
  
 <span class="btn btn-info"> &#8377  ${book.price} <span class="glyphicon glyphicon-shopping-cart" ></span></a></span>
</div>    
  </c:otherwise>
  
</c:choose> 
 
 
 </td></tr>

 
  </tbody>
</table>
</div>
</c:forEach>
<div class="container">
<div class="row" >

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
</body>
<script>
(() => {
       
    const ratingNumber = Math.floor(document.getElementById("averageRating1").innerHTML);
    const unfilledRating = 5 - ratingNumber;
    const productDetailsElement = document.getElementById("wrapper");
    const filledStars = Array(ratingNumber).fill("<span class='fa fa-star checked'></span>");
    const unfilledStars = Array(unfilledRating).fill('<span class="fa fa-star"></span>');
    const ratingTemplate = filledStars.concat(unfilledStars);
    console.log(ratingTemplate)
    $('#averageRating').append(ratingTemplate);
       
       })();



</script>

<script>

function myfunction(evt){
	console.log(evt)
	$('#loginModel').show();
}

</script>
</html>


