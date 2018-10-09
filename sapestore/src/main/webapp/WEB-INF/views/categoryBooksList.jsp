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
       background-color: #cacfc0;
       
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

</style>

<body>
	<div class="container-fluid book-store-wrapper">
	  <div class="row">
	    <div class="col-lg-12">
	       <%@ include file="header.jsp"%>
	    </div>
	  </div>
	  <div class="row details-wrapper-container">
	    <div  class="col-lg-3 col-sm-3 quicklinks"  style="background-color: white;padding-right:0 ;padding-left:0 ;">
	    <h2>Book Categories</h2>
			<c:forEach var="category" items="${categoryList}">
				<%-- <h3 data-toggle="modal" data-target="#myModal">${category}</h3> --%>
				<c:choose>
					<c:when test="${category == selectedCategory}"><a href="${context}/categoryBookList/${category}" class="account-details active"><h4>${category}</h4></a></c:when>
					<c:otherwise><a href="${context}/categoryBookList/${category}" class="account-details">${category}</a></c:otherwise>
				</c:choose>				
			</c:forEach>
	    </div>
	    
	    <div class="col-lg-9">
	  
<div id="heading" class="main">
<%--  <%
             if(session.getAttribute("loginSuccessful") != null && session.getAttribute("loginSuccessful") == "false") {
          %>
 --%>


	
		<div class="add-button-update">
			<h2 class="update-text" align="center">Books In store</h2>
			<!-- <div id="add">

				<a href="addBookform"><button type="button"
						class="button  btn-success">Add Book To Store</button></a>
			</div> -->
		</div>
	
		<hr>
		 
		<div class="container-fluid">
			<div class="row book-category" >
				<c:forEach var="book" items="${categoryBooks}">

					<div class="col-sm-6 col-md-3 col-lg-2 book-card" >
						<div id="thumbnail" >
							<img src="${context}${book.book_img}"
								alt="Generic placeholder thumbnail" width="150px" height="200px">
						</div> 

						<div class="caption">
							<a onclick="getbookPageDetails('${book.iSBN}')">
								<h3><a href="${context}/productdescription/${book.iSBN}">${book.title }</a></h3>
							</a>
							<h4><b>Author:</b> ${book.author}</h4>
							<h4><b>ISBN:</b>${book.iSBN}</h4>
							  <h4>
                                  <i class="fa">&#xf156;</i>${book.price}
                              </h4>
							<p style="text-align: left;" class="text-details">${book.short_desc}</p>

							<p style="text-align: left;">
								<a href="${context}/editBookForm/${book.iSBN}" class="btn btn-primary"
									role="button"> update </a> <input type="text" value="${book.active}" disabled></input>
									<%-- <a  href="deleteBook/${book.iSBN}"
									class="btn btn-default" role="button"> delete </a> --%>
							</p>

						</div>
					</div>

				</c:forEach>

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
</html>