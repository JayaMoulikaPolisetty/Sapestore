<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            
            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                padding-top: 100px; /* Location of the box */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            }
            
            /* Modal Content */
            .modal-content {
                background-color: #fefefe;
                margin: auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
            }
            
            /* The Close Button */
            .close {
                color: #aaaaaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }
            
            .close:hover,
            .close:focus {
                color: #000;
                text-decoration: none;
                cursor: pointer;
            }

            p{
                font-family:Sapient Centro Slab;
    font-weight:Medium;
    font-size: 22px;
    color:#000000;
            }

            div{
                flex:1;
            }

            label { width: 200px; float: left; margin: 0 20px 0 0; }
span { display: block; margin: 0 0 3px; font-size: 1.2em; font-weight: bold; }
            </style>
            </head>
   
   
     <body>
            
            <h2>Comment</h2>
            
            <!-- Trigger/Open The Modal -->
            <button id="myBtn">Write Review</button>
            
            <!-- The Modal -->
            <div id="myModal" class="modal">
            
              <!-- Modal content -->
              <div class="modal-content">
                <span class="close">&times;</span>
                <p>Write a Review</p>
                
               <form action= "add-comment" method="post" >
                <div class="row">
                
									<div class="col-sm-2 hidden-xs"><img src="${pageContext.request.contextPath}/resources/images/${book.book_img}" alt="..." class="img-responsive"/></div>
									<div class="col-sm-5">
										<h4 class="nomargin">${book.title}</h4>
									  	 <span><textarea class="form-control" rows="3" cols="40" name="book_comment"></textarea></span>
									</div>
								</div>
							
                          <input type="submit" class="btn btn-primary" >POST COMMENT</button>
                          </form>
  
           <!--      <div class="col-sm-4">
                        <a target="_blank" href="img_forest.jpg">
                                <img src="D:\BookStore\sapestore-2018-mar\sapestore\src\main\webapp\images\speak.jpg" alt="Forest" style="width:150px">
                              </a>
                        <p>A Possible Life</p>
                        </div>

                        <textarea class="form-control" rows="3" cols="40"></textarea>

                        <button type="button" class="btn btn-primary">POST COMMENT</button>

                         -->
                   
                         <!-- <div class="container right"> 
                                <div class="col-sm-4">
                                <textarea rows="4" cols="50">
                                      write your comment
                                        </textarea>
                              </div>
              </div>
              -->
            <script>
            // Get the modal
            var modal = document.getElementById('myModal');
            
            // Get the button that opens the modal
            var btn = document.getElementById("myBtn");
            
            // Get the <span> element that closes the modal
            var span = document.getElementsByClassName("close")[0];
            
            // When the user clicks the button, open the modal 
            btn.onclick = function() {
                modal.style.display = "block";
            }
            
            // When the user clicks on <span> (x), close the modal
            span.onclick = function() {
                modal.style.display = "none";
            }
            
            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
            </script>
         

</body>
</html> 