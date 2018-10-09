<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript"
	src="${context}/resources/js/pagination.js"></script>
<link rel="stylesheet" href="${context}/resources/css/home.css">
<link rel="stylesheet" href="${context}/resources/css/style.css">
<link href="${context}/resources/styles/registrationform.css"
	rel="stylesheet">
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
	background-color: #dfe5e6;
	font-family: "Sapient Centro Slab";
}

.footer-wrapper {
	padding: 0;
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

.account-details {
	display: block;
}
/* .side-nav>a{
 display: block;
} */

.side-nav, .main-wrapper {
	display: flex;
	flex: 1 1 100%;
	flex-direction: column;
	height: 100%;
}

.block {
	display: inline;
}

.nyaba{
    color: #1d1d1d;
    font-weight: regular;
    font-size: 14px;
    font-family: SapientSansRegular;
    text-decoration: none;
    height: auto;
    margin-top: 10px;
    margin-bottom: 10px;
	display: block;
    /* padding-left: 0; */ 
    
}

.book-list {
	padding-left: 0;
	margin: 0;
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
			<div class="col-lg-3 side-nav" style="background-color: white;padding-right:0;padding-left:0;">

				<nav>

					<h2>Book Categories</h2>
					<div>
						<c:if test="${bookCategoryList ne 'null' }">
							<c:forEach var="bookCategoryList" items="${bookCategoryList}">
								<ul class="book-list"><a class="nyaba" href="${context}/all-books-by-category/${bookCategoryList}" ><h4 id="categoryId">${bookCategoryList}</h4></a>
								</ul>
							</c:forEach>
						</c:if>
					</div>
				</nav>

			</div>

			<div class="col-lg-9 main-wrapper">

				<div id="test"></div>

				<div>
					<h2>Customer Registration</h2>
					<hr>
				</div>


				<div class="block">
					<h4 style="color: green;">${registerMessage.successMessage}</h4>
					<h4 style="color: red;">${registerMessage.failiureMessage}</h4>
					<%
						session.setAttribute("message", null);
					%>
				</div>
				<form id="regForm" action="register" method="post">


					<input type="hidden" id="stateval" value='${statesel}'
						readonly="readonly" />
					<div class="inputData">
						<label id="label2" style="margin-top: 50px;"> Name <span
							class="color-red">*</span></label>
						<div class="boxsize">
							<input type="text" id="inputName" placeholder="Enter name" width=80% name="name"
								style="margin-top: 50px;"  required pattern="[A-Za-z\s]{3,25}" title="no special character or number is allowed and length will be greater than 3 letters"><span id="username" class="text-danger font-weight-bold"></span>
						</div>
					</div>

					<br>

					<div class="inputData">
						<label id="label2">Login Password <span class="color-red">*</span>
						</label> <input type="password"
							placeholder="Enter Password" name="password" id="password1"
							required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,16}" title="password should have Minimum eight and maximum 16 characters, at least one uppercase letter, one lowercase letter, one number and one special character"><br>
					</div>

					<br>
					<div class="inputData">
						<label id="label2">Retype Login Password !!! <span class="color-red">*</span>
						</label> <input type="password"
							placeholder="Retype Password" name="password1" id="confirm_password" 
							required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,16}" title="password should have Minimum eight and maximum 16 characters, at least one uppercase letter, one lowercase letter, one number and one special character" onkeyup="validatePassword()"><br>
					</div>

					<br>
					<div class="inputData">
						<label id="label2">Email <span class="color-red">*</span></label>
						<input type="email" placeholder="Enter E-mail" name="email"
							id="email" required><br>
					</div>
					<br>
					<div class="inputData">
						<label id="label2">Gender<span class="color-red">*</span>
						</label>
						<div id="gender">
							<select name="gender">
								<option value="Male">Male</option>
								<option value="Female">Female</option>
							</select>
						</div>
					</div>
					<br>
					<div class="inputData">

						<label id="label2">Address Line1<span class="color-red">*</span></label>
						<input type="text" name="addressLine1"
							placeholder="Enter Address Line1" id="address1" required><br>
					</div>
					<br>
					<div class="inputData">

						<label id="label2">Address Line2</label> <input type="text"
							name="addressLine2" placeholder="Enter Address Line2"
							id="address2"><br>
					</div>
					<br>
					<!-- <div class="inputData">

						<label id="label2">City<span class="color-red">*</span></label> <input
							type="text" name="city" placeholder="Enter City" id="city"
							required><br>
					</div> 
					
					<br>-->

					<div class="inputData">
						<label id="label2">State<span class="color-red">*</span></label> <select
							style="width:165px" name="state">
							<option value="">Select State</option>
							<option value="Andaman and Nicobar Islands">Andaman and
								Nicobar Islands</option>
							<option value="Andhra Pradesh">Andhra Pradesh</option>
							<option value="Arunachal Pradesh">Arunachal Pradesh</option>
							<option value="Assam">Assam</option>
							<option value="Bihar">Bihar</option>
							<option value="Chandigarh">Chandigarh</option>
							<option value="Chhattisgarh">Chhattisgarh</option>
							<option value="Dadra and Nagar Haveli">Dadra and Nagar
								Haveli</option>
							<option value="Daman and Diu">Daman and Diu</option>
							<option value="Delhi">Delhi</option>
							<option value="Goa">Goa</option>
							<option value="Gujarat">Gujarat</option>
							<option value="Haryana">Haryana</option>
							<option value="Himachal Pradesh">Himachal Pradesh</option>
							<option value="Jammu and Kashmir">Jammu and Kashmir</option>
							<option value="Jharkhand">Jharkhand</option>
							<option value="Karnataka">Karnataka</option>
							<option value="Kerala">Kerala</option>
							<option value="Lakshadweep">Lakshadweep</option>
							<option value="Madhya Pradesh">Madhya Pradesh</option>
							<option value="Maharashtra">Maharashtra</option>
							<option value="Manipur">Manipur</option>
							<option value="Meghalaya">Meghalaya</option>
							<option value="Mizoram">Mizoram</option>
							<option value="Nagaland">Nagaland</option>
							<option value="Orissa">Orissa</option>
							<option value="Pondicherry">Pondicherry</option>
							<option value="Punjab">Punjab</option>
							<option value="Rajasthan">Rajasthan</option>
							<option value="Sikkim">Sikkim</option>
							<option value="Tamil Nadu">Tamil Nadu</option>
							<option value="Tripura">Tripura</option>
							<option value="Uttaranchal">Uttaranchal</option>
							<option value="Uttar Pradesh">Uttar Pradesh</option>
							<option value="West Bengal">West Bengal</option>
						</select>
					</div>
					<br>

					<div class="inputData">
						<label id="label2">City<span class="color-red">*</span></label> <select
							style="width:165px" name="city" value="" style="width: 230">
							<option selected="selected">-Select-</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#000000"><i>-Top Metropolitan Cities-</i></font></option>
							<option>Ahmedabad</option>
							<option>Bengaluru/Bangalore</option>
							<option>Chandigarh</option>
							<option>Chennai</option>
							<option>Delhi</option>
							<option>Gurgaon</option>
							<option>Hyderabad/Secunderabad</option>
							<option>Kolkatta</option>
							<option>Mumbai</option>
							<option>Noida</option>
							<option>Pune</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Andhra Pradesh-</i></font></option>
							<option>Anantapur</option>
							<option>Guntakal</option>
							<option>Guntur</option>
							<option>Hyderabad/Secunderabad</option>
							<option>kakinada</option>
							<option>kurnool</option>
							<option>Nellore</option>
							<option>Nizamabad</option>
							<option>Rajahmundry</option>
							<option>Tirupati</option>
							<option>Vijayawada</option>
							<option>Visakhapatnam</option>
							<option>Warangal</option>
							<option>Andra Pradesh-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Arunachal Pradesh-</i></font></option>
							<option>Itanagar</option>
							<option>Arunachal Pradesh-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Assam-</i></font></option>
							<option>Guwahati</option>
							<option>Silchar</option>
							<option>Assam-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><fontcolor="#FFFFFF"><i>-Bihar-</i></font></option>
							<option>Bhagalpur</option>
							<option>Patna</option>
							<option>Bihar-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Chhattisgarh-</i></font></option>
							<option>Bhillai</option>
							<option>Bilaspur</option>
							<option>Raipur</option>
							<option>Chhattisgarh-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Goa-</i></font></option>
							<option>Panjim/Panaji</option>
							<option>Vasco Da Gama</option>
							<option>Goa-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Gujarat-</i></font></option>
							<option>Ahmedabad</option>
							<option>Anand</option>
							<option>Ankleshwar</option>
							<option>Bharuch</option>
							<option>Bhavnagar</option>
							<option>Bhuj</option>
							<option>Gandhinagar</option>
							<option>Gir</option>
							<option>Jamnagar</option>
							<option>Kandla</option>
							<option>Porbandar</option>
							<option>Rajkot</option>
							<option>Surat</option>
							<option>Vadodara/Baroda</option>
							<option>Valsad</option>
							<option>Vapi</option>
							<option>Gujarat-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Haryana-</i></font></option>
							<option>Ambala</option>
							<option>Chandigarh</option>
							<option>Faridabad</option>
							<option>Gurgaon</option>
							<option>Hisar</option>
							<option>Karnal</option>
							<option>Kurukshetra</option>
							<option>Panipat</option>
							<option>Rohtak</option>
							<option>Haryana-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Himachal Pradesh-</i></font></option>
							<option>Dalhousie</option>
							<option>Dharmasala</option>
							<option>Kulu/Manali</option>
							<option>Shimla</option>
							<option>Himachal Pradesh-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Jammu and Kashmir-</i></font></option>
							<option>Jammu</option>
							<option>Srinagar</option>
							<option>Jammu and Kashmir-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Jharkhand-</i></font></option>
							<option>Bokaro</option>
							<option>Dhanbad</option>
							<option>Jamshedpur</option>
							<option>Ranchi</option>
							<option>Jharkhand-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Karnataka-</i></font></option>
							<option>Bengaluru/Bangalore</option>
							<option>Belgaum</option>
							<option>Bellary</option>
							<option>Bidar</option>
							<option>Dharwad</option>
							<option>Gulbarga</option>
							<option>Hubli</option>
							<option>Kolar</option>
							<option>Mangalore</option>
							<option>Mysoru/Mysore</option>
							<option>Karnataka-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Kerala-</i></font></option>
							<option>Calicut</option>
							<option>Cochin</option>
							<option>Ernakulam</option>
							<option>Kannur</option>
							<option>Kochi</option>
							<option>Kollam</option>
							<option>Kottayam</option>
							<option>Kozhikode</option>
							<option>Palakkad</option>
							<option>Palghat</option>
							<option>Thrissur</option>
							<option>Trivandrum</option>
							<option>Kerela-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Madhya Pradesh-</i></font></option>
							<option>Bhopal</option>
							<option>Gwalior</option>
							<option>Indore</option>
							<option>Jabalpur</option>
							<option>Ujjain</option>
							<option>Madhya Pradesh-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Maharashtra-</i></font></option>
							<option>Ahmednagar</option>
							<option>Aurangabad</option>
							<option>Jalgaon</option>
							<option>Kolhapur</option>
							<option>Mumbai</option>
							<option>Mumbai Suburbs</option>
							<option>Nagpur</option>
							<option>Nasik</option>
							<option>Navi Mumbai</option>
							<option>Pune</option>
							<option>Solapur</option>
							<option>Maharashtra-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Manipur-</i></font></option>
							<option>Imphal</option>
							<option>Manipur-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Meghalaya-</i></font></option>
							<option>Shillong</option>
							<option>Meghalaya-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Mizoram-</i></font></option>
							<option>Aizawal</option>
							<option>Mizoram-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Nagaland-</i></font></option>
							<option>Dimapur</option>
							<option>Nagaland-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Orissa-</i></font></option>
							<option>Bhubaneshwar</option>
							<option>Cuttak</option>
							<option>Paradeep</option>
							<option>Puri</option>
							<option>Rourkela</option>
							<option>Orissa-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Punjab-</i></font></option>
							<option>Amritsar</option>
							<option>Bathinda</option>
							<option>Chandigarh</option>
							<option>Jalandhar</option>
							<option>Ludhiana</option>
							<option>Mohali</option>
							<option>Pathankot</option>
							<option>Patiala</option>
							<option>Punjab-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Rajasthan-</i></font></option>
							<option>Ajmer</option>
							<option>Jaipur</option>
							<option>Jaisalmer</option>
							<option>Jodhpur</option>
							<option>Kota</option>
							<option>Udaipur</option>
							<option>Rajasthan-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Sikkim-</i></font></option>
							<option>Gangtok</option>
							<option>Sikkim-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Tamil Nadu-</i></font></option>
							<option>Chennai</option>
							<option>Coimbatore</option>
							<option>Cuddalore</option>
							<option>Erode</option>
							<option>Hosur</option>
							<option>Madurai</option>
							<option>Nagerkoil</option>
							<option>Ooty</option>
							<option>Salem</option>
							<option>Thanjavur</option>
							<option>Tirunalveli</option>
							<option>Trichy</option>
							<option>Tuticorin</option>
							<option>Vellore</option>
							<option>Tamil Nadu-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Tripura-</i></font></option>
							<option>Agartala</option>
							<option>Tripura-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Union Territories-</i></font></option>
							<option>Chandigarh</option>
							<option>Dadra & Nagar Haveli-Silvassa</option>
							<option>Daman & Diu</option>
							<option>Delhi</option>
							<option>Pondichery</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Uttar Pradesh-</i></font></option>
							<option>Agra</option>
							<option>Aligarh</option>
							<option>Allahabad</option>
							<option>Bareilly</option>
							<option>Faizabad</option>
							<option>Ghaziabad</option>
							<option>Gorakhpur</option>
							<option>Kanpur</option>
							<option>Lucknow</option>
							<option>Mathura</option>
							<option>Meerut</option>
							<option>Moradabad</option>
							<option>Noida</option>
							<option>Varanasi/Banaras</option>
							<option>Uttar Pradesh-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Uttaranchal-</i></font></option>
							<option>Dehradun</option>
							<option>Roorkee</option>
							<option>Uttaranchal-Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-West Bengal-</i></font></option>
							<option>Asansol</option>
							<option>Durgapur</option>
							<option>Haldia</option>
							<option>Kharagpur</option>
							<option>Kolkata</option>
							<option>Siliguri</option>
							<option>West Bengal - Other</option>
							<option disabled="disabled" style="background-color: #3E3E3E"><font color="#FFFFFF"><i>-Other-</i></font></option>
							<option>Other</option>
						</select>
					</div>
					<br>
					<!-- <div class="inputData">

						<label id="label2">State<span class="color-red">*</span></label> <input
							type="text" name="state" placeholder="Enter State" id="state"
							required><br>
					</div>
					<br> -->
					<div class="inputData">

						<label id="label2">Pincode<span class="color-red">*</span></label>
						<input type="text"  name="pin" placeholder="Enter Pincode" id="zip" required pattern="\d{6}" title="pincode should contain 6 digit number" maxlength="6" />
						<span id="numberpin" class="text-danger font-weight-bold"></span>
					</div>
					<br>

					<div class="inputData">

						<label id="label2">Mobile Number<span class="color-red">*</span></label>
						<input style="width:165px" type="text"  name="phoneNumber" placeholder="Enter Number"
							id="mobileNo"  required pattern="[7-9]{1}[0-9]{9}" title="please provide a proper phone number"><span id="mobilenumber" class="text-danger font-weight-bold"></span><br>
					</div>
					<br>
					<button style="margin: auto; display: inline; margin-left: 30%;" type="submit" 
					class="btn btn-info" id="btnSubmit">Create Profile</button>

				</form>

				<br> <br>
			</div>

		</div>
		<div class="row">
		<div class="col-lg-12 footer-wrapper">
			<%@ include file="footer.jsp"%>
		</div>
	</div>
	</div>
	<br>
	<br>
<script type="text/javascript">
var password = document.getElementById("password1"), confirm_password = document.getElementById("confirm_password");

function validatePassword() {
	if (password.value != confirm_password.value) {
		console.log(password.value);
		confirm_password.setCustomValidity("password dont match");
	} else {
		confirm_password.setCustomValidity('');
	}
}
</script>
<!--  name input not allowing Special character  -->
<!-- <script>
$(document).ready(function(){
$('#inputName').on('keypress', function (event) {
    var regex = new RegExp("^[a-zA-Z\s]+");
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
       event.preventDefault();
       const errorIsAvialable = $('#nameError').html();
       console.log(errorIsAvialable);
       if(!errorIsAvialable) {
	       $('#inputName').after('<span id="nameError">No Special Charecters or numbers are allowed</span>');
       }
       return false;
    }
    $('#nameError').empty();
});
});
</script> -->
<!-- <script type="text/javascript">
function onlyAlphabets() {

	  var regex = /^[a-zA-Z]*$/;
	  if (regex.test(document.f.nm.value)) {

	      //document.getElementById("notification").innerHTML = "Watching.. Everything is Alphabet now";
	      return true;
	  } else {
	      document.getElementById("notification").innerHTML = "Alphabets Only";
	      return false;
	  }


	}
</script> -->

</body>
</html>