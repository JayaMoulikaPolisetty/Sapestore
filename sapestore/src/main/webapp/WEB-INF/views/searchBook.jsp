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
   #thumbnail{
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
             position: absolute;
         right: 0;
      }
      
.data-list {
    cursor: pointer;
}

#screen{
    width: 100%;
}
  
.active { 
    background-color:#dfe5e6;
    display: block;
    padding: 2px 1px 1px 16px;
    width:"330px"
}
.but{
text-align: left;
}
.quicklinks{
   height: 100%;
   display: flex;
    flex-direction: column;
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
/*  width: 50px;
height:33px;
border-radius: 20px; */
width: 40px;
height:40px;
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

@-webkit-keyframes fadein {
    from {bottom: 0; opacity: 0;} 
    to {bottom: 30px; opacity: 1;}
}

@keyframes fadein {
    from {bottom: 0; opacity: 0;}
    to {bottom: 30px; opacity: 1;}
}

@-webkit-keyframes fadeout {
    from {bottom: 30px; opacity: 1;} 
    to {bottom: 0; opacity: 0;}
}

@keyframes fadeout {
    from {bottom: 30px; opacity: 1;}
    to {bottom: 0; opacity: 0;}
}

.header-wrapper {
       display: flex;
       align-items: center;
}
.header-dashboard {
       flex: 1;
}
.caption {
       flex: 1 1 100%;
       display: flex;
    flex-direction: column;
}
/* .book-card {
    display: flex;
    flex-direction: column;
    padding-top: 25px;
} */
.row.book-category {
    display: flex;
    flex-wrap: wrap;
}
.col-sm-6 col-md-3 col-lg-2 book-card{
  display: flex;
    flex-direction: column;
    padding-top: 25px;
}

.text-details {
       flex: 1 1 100%;
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
            
            <div class="col-lg-12">
             <div class="container-fluid ">
         <div class="row">
          <div class="col-lg-12">
                    <div class="header-wrapper">
                           
                 
                    
                    </div>       
               <div class="add-button-update">
                  <h2 class="update-text">Search Books</h2>
               </div>
               </div>
               </div>
             
              
                  <div class="row">
                  <div class="col-lg-12">
                     <form id="myForm">
                     
                        <div class="form-group col-xs-10 col-sm-6 col-md-6 col-lg-6">
                           <label>Book Title <span style="color: red;">*</span></label> <input
                              type="text" class="form-control" name="title" value="">
                        </div>
                        <div class="form-group col-xs-10 col-sm-6 col-md-6 col-lg-6">
                           <label>Author </label> <input
                              type="text" class="form-control" name="author" value="">
                        </div>
                        <!--  <div class="clearfix"></div>
                           -->
                        <div class="form-group col-xs-10 col-sm-6 col-md-6 col-lg-6">
                        <label>Books Category</label> 
                          <input type="text"
                              class="form-control" name="category" value=""> 
                        </div>
                        <div class="form-group col-xs-10 col-sm-6 col-md-6 col-lg-6">
                           <label>Publisher</label> <input type="text" class="form-control"
                              name="publisher" value="">
                        </div>
                     </form>
                     </div>
                     <div class="col-md-offset-4 col-md-4">
                        <button type="button" onclick="multiSearch()"
                           class="btn btn-info btn-lg btn-block">Search</button>
                     </div>
                  </div>
               <div class="row">
          <div class="col-lg-12">
          <div id="errorSnackbar">No results found</div>
          </div>
          </div>
         <!--  <input id="myInput" type="text" placeholder="Search..">
<div id="myDIV"> -->
         <div class="row">
          <div class="col-lg-12">
               <div id="searchResult" class="container-fluid">
               </div>
               <hr style="height: 1px; border: none; color: #333; background-color: #333;">
              
               </div>
             
           </div>  
               
               <BR />
             
               
             
              
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
         function multiSearch() {
             console.log('as-fdasfs=====================================================')
             var elements = document.getElementById("myForm").elements;
             var obj ={};
             for(var i = 0 ; i < elements.length ; i++){
                 var item = elements.item(i);
                 if(item.value) {
                   obj[item.name] = item.value;
                 } else {
                   obj[item.name] = '';
                 }
             }
             console.log(JSON.stringify(obj));
            /*  const url = "/searchresult/title='" + oobjbj.title + ' ";
             console.log(url);
             fetch('http://localhost:8050/sapestore/movies.json')
             .then((response) =>  {
                    response.json().then((data) => {
                    console.log(data);
             })});
             
             
           */
           console.log('calling my ajaxx');
           var ctx = "${pageContext.request.contextPath}" ;
           var url = ctx+'/userSearchResult?title=' + obj.title + '&category=' + obj.category + '&author=' + obj.author + '&publisher=' + obj.publisher ;
           console.log(url);
           fetch(url).then(res => { 
             res.json().then(data => {
                           
                           console.log(data);
                           const templates = [];
                           if (data.length) {
                                  data.forEach(item => {
                                         console.log(item)
                                         const { book_img, title, author, category, iSBN, price} = item;
                                         const searchTemplate = "<div class='col-sm-6 col-md-3'><br><div class='thumbnail'><img src=" + ctx + book_img + " alt='image missing'></div><div class='caption'><a href='one-book/" + iSBN + "'><h3>" + title + "</h3></a><h4>ISBN:" + iSBN + "</h4><h4><i class='fa'>&#xf156;</i>" + price + "</h4></div></div>";
                                         console.log(category);
                                         templates.push(searchTemplate);
                                  })
                                  document.getElementById("searchResult").innerHTML = templates;                            
                           } else {
                                  var x = document.getElementById("errorSnackbar");
                               x.className = "show";
                               setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
                           }
                    }) 
           })
           .catch(error => console.error('Error:', error));
         }
      </script>
   </body>
</html>
 