<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <link rel="stylesheet" type="text/css" href="resources/css/text.css">
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
      
      .button{
      padding: 10px 30px;
      }
      #msg{
      color: green;
      }
      
      
      
      input[type=submit].disabled {
      	cursor: not-allowed;
	    filter: alpha(opacity=65);
	    -webkit-box-shadow: none;
	    box-shadow: none;
	    opacity: .65;
      }
      
      [data-parent-unfiltered="true"] {
      	display: none;
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
         
         <div id="msg" class="row">
         <h2> ${error}</h2>
		<h2>${sucess}</h2>         
                  </div>
                  
         <div class="row details-wrapper-container">
            <div class="pageheader">
               <h3 align="center" >Order List</h3>
            </div>
            <h5> Search Using Order Item ID</h5>
			
				<input type="text" name="orderId"  id="myInput" onkeyup="myFunction()" placeholder="Enter Order Item Id...."> 
				
			
			<br>
			<br>
            
          <form action="orderList" method="GET"> 
            <table  id="myTable" class="table">
               <thead>
                  <tr>
                    <th class="text-center">ORDER ITEM ID</th>
                     	<th class="text-center">ORDER ID</th>
                     		<th class="text-center">USER ID</th>
               
                     <th class="text-center">TOTAL PAYMENT</th>
                     <th class="text-center">TOTAL QUANTITY</th>
                     <th class="text-center">STATUS</th>
                     <th class="text-center">DISPATCH </th>
                     <th class="text-center">DELIVERED</th>
                  </tr>
               </thead>
                <c:forEach var="odr" items="${allorder}">
                  <tr>
                  	 <td>${odr.orderItemId}</td> 
                   		<td >${odr.orderInfo.orderId}</td>
                     		<td >${odr.orderInfo.userId}</td>
                	
                     <td > <i class="fa">&#xf156;</i> ${odr.orderInfo.totalPayment}</td>
                     <td >${odr.orderInfo.orderQuantity }</td>
                      <td id="orderStatus${odr.orderItemId}">${odr.status }</td>
                   
                     <c:choose>
  <c:when test="${odr.status=='Dispatched'}">
    <td ><input type="checkbox" disabled id="${odr.orderItemId}" name="dispatch" value="Dispatch" > </td>
                     <td><input type="checkbox" id="${odr.orderItemId}" name="delivery" value="Delivery"></td>
  </c:when>
  <c:when test="${odr.status=='Delivered'}">
   <td ><input type="checkbox" disabled id="${odr.orderItemId}" name="dispatch" value="Dispatch" > </td>
                     <td><input type="checkbox" disabled id="${odr.orderItemId}" name="delivery" value="Delivery"></td>
  </c:when>
  <c:otherwise>
   <td ><input type="checkbox"  id="${odr.orderItemId}"  name="dispatch" value="Dispatch" > </td>
                     <td><input type="checkbox"  id="${odr.orderItemId}" name="delivery" value="Delivery"></td>
  </c:otherwise>
</c:choose>
                  </tr>
               </c:forEach>
               
               
             
     
            </table>
          <div class="button">
            <input type="submit" class="button  btn-info" value="Dispatch Order" onclick="onDispatchClick()">
            <input type="submit" class="button  btn-info" value="Deliver Order" onclick="onDeliveryClick()">
            </div> 
            </form>
            
            </div>
         <div class="row">
         <div class="col-lg-12 footer-wrapper">
            <%@ include file="footer.jsp"%> 
         </div>
      </div>
      </div>
      
<script>

function myFunction() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
	
	
	
	

	
	
	function onDispatchClick() {
		console.log('Vijyaaaaa :p');
		var elements = document.querySelectorAll('input[name="dispatch"]:checked');
		for(var i=0; i<elements.length; i++) {
		    console.log(elements[i].id);
		    elements[i].value = 'Dispatched';
		    document.getElementById("orderStatus" + elements[i].id).innerHTML = 'Dispatched';
		   /*  document.getElementById("${odr.orderItemId}").disabled = false; */
		 /*    $("input[name='dispatch']").prop("disabled", true); */
		  /*   elements[i].value = 'Delivered'; */
		    fetch('${context}/dispatch/'+elements[i].id).then(res => {
		    	console.log(res);
		    
		    });
		   
		    }		 
	}
	
	
	function onDeliveryClick() {
		console.log('Vijyaaaaa :D');
		var elements = document.querySelectorAll('input[name="delivery"]:checked');
		for(var i=0; i<elements.length; i++) {
		    console.log(elements[i].id);
		    elements[i].value = 'Delivered';
		    document.getElementById("orderStatus" + elements[i].id).innerHTML = 'Delivered';
		 /*    document.getElementById("${odr.orderItemId}").disabled = true; */
		   /*  $("input[name='delivery']").prop("disabled", true); */
		  /*   elements[i].value = 'Delivered'; */
		    fetch('${context}/deliver/'+elements[i].id).then(res => {
		    	console.log(res);
		    
		    });
		   
		    }		 
	}
	

</script>
            
   </body>
</html>