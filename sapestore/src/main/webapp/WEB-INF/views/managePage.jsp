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
<script
	src="https://cdn.ckeditor.com/ckeditor5/10.0.1/classic/ckeditor.js"></script>
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

* {
	box-sizing: border-box
}

/* Set height of body and the document to 100% */
body, html {
	height: 100%;
	margin: 0;
	font-family: Arial;
}

.tab {
	margin: 15px;
	margin-top: 20px
}
/* Style tab links */
.tablink {
	background-color: #555;
	color: white;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	font-size: 17px;
	width: 25%;
}

.tablink:hover {
	background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
	color: black;
	display: flex;
	padding: 50px 10px;
	height: 400px;
}

#add {
	align-items: left;
	justify-content: left;
	position: relative;
	right: 0;
	margin: 5px;
	margin-top: 7px padding: 17px 14px;
	font-size: 20px;
	width: 14%;
}

#edit {
	align-items: right;
	justify-content: right;
	position: fixed;
	right: 0;
	margin: 15px;
	padding: 10px 15px;
	font-size: 20px;
	width: 15%;
}

#Home {
	background-color: white;
}

#News {
	background-color: white;
}

#editor {
	height: 80%;
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
			<br> <br>
			<!-- <button type="button" class="button  btn-info" id="edit">Edit</button> -->
			

			<nav class="tab">

				<button class="tablink" onclick="openPage('Home', this, 'white')">
					<font color="black">Privacy Policy</font>
				</button>
				<button class="tablink" onclick="openPage('News', this, 'white')"
					id="defaultOpen">
					<font color="black">Contact Us</font>
				</button>

			</nav>
				<form action="privacyPolicyContact" method="post">
			<div class="col-lg-12">
				${dId}​
				<div id="Home" class="tabcontent">
					<textarea name="privacydetail" id="editor">${privacy_detail}</textarea>


				</div>
				<div id="News" class="tabcontent">
					<div>
						<textarea name="contactdetail" id="contactEditor">${contact_detail}</textarea>
					</div>
				</div>

<input type="hidden" name="detailId" value="1">


					<input type="submit" value="Update" class="button  btn-info"
						id="add"> </form>
					</td>
					<!-- <td> <input type="submit"  value="Cancel"></td> -->

					<a href="${context}/adminHome"><button type="button"
							class="button  btn-info" id="add">Cancel</button></a>
					<!-- <button type="button"
                        class="button  btn-info" id="add">Save</button></form>
                        
                        <a href="privacyPolicyContact"><button type="button"
                        class="button  btn-info" id="add">Cancel</button></a> -->
			</div>

		</div>
		<div class="row">
			<div class="col-lg-12 footer-wrapper">
				<%@ include file="footer.jsp"%>
			</div>
		</div>
	</div>
	<script>
function openPage(pageName,elmnt,color) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
    }
    document.getElementById(pageName).style.display = "block";
    elmnt.style.backgroundColor = color;

}
// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
	<script>
			ClassicEditor
				.create( document.querySelector( '#editor' ) )
				.then( editor => {
					console.log( editor );
				} )
				.catch( error => {
					console.error( error );
				} );
               
			ClassicEditor
			.create( document.querySelector( '#contactEditor' ) )
			.then( editor => {
				console.log( editor );
			} )
			.catch( error => {
				console.error( error );
			} );
               
		</script>
</body>
</html>
