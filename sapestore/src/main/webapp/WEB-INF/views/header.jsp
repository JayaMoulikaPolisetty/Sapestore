<c:set var="context" value="${pageContext.request.contextPath}" />

<header>
	<div class="row header-row">
		<div class="col-sm-3">
			<img src="${context}/images/sapient.jpg">
		</div>
		<div class="col-sm-2">
			<span class="glyphicon glyphicon-user"> Welcome <c:choose>
					<c:when test="${customer != null && !customer.admin}">
				${customer.name}
				</c:when>
					<c:when test="${customer != null && customer.admin}">
				 	Admin
				 </c:when>
				</c:choose>

			</span>
		</div>
		<div class="col-sm-7 header-col">
			<div align=right class="row topLinks">
				<div class="col-sm-12">
					<span style="display: none;"> <c:out
							value="${customer.name}" />
					</span>
					<c:choose>
						<c:when test="${customer == null}">
							<a href="${context}/">HOME</a>

							<a id="login">LOGIN</a>
							<a href="${context}/searchBook" style="background-color: #fff;">
								<img src="${context}/resources/images/search.svg" height="20"
								width="20" />
							</a>

						</c:when>
						<c:when test="${customer!= null && (!customer.admin)}">
							<a href="${context}/">HOME</a>
							<!-- Team B and D  -->
							<!-- integration team b and team d -->
							<a href="${context}/viewprofilepage">Account</a>
							<a href="${context}/wishlist">Wishlist</a>
							<button type="button" class="btn btn-info btn-lg" id="#myModal"
								data-toggle="modal" data-target="#myModal"
								style="background-color: black; color: #46b8da; font-size: 16px; padding: 8px 8px; border-color: black">CART</button>
							<span class="glyphicon glyphicon-shopping-cart"></span>
							<span class="badge badge-sape" id="cart_list">${cart.quantity }</span>
							<a href="${context}/logout">Logout</a>
							<a href="${context}/searchBook" style="background-color: #fff;">
								<img src="${context}/resources/images/search.svg" height="20"
								width="20" />
							</a>
							<!-- Modal -->
							<div class="modal fade" class="al" id="myModal" role="dialog">
								<div class="modal-dialog modal-dialog-center">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title modal-title-cart">Your Cart</h4>
										</div>
										<div class="modal-body">
											<c:choose>
												<c:when test="${cart.quantity eq 0}">
													<h3 class='card-details' style="text-align: center">Cart
														is Empty</h3>
												</c:when>
												<c:otherwise>
													<table id="carte" class="table">
														<thead>
															<tr>
																<th>BOOK</th>
																<th style="width: 60px;">QTY</th>
																<!--  <th style="width:30%" class="text-center">TRANSACTION TYPE</th> -->
																<th>BOOK PRICE</th>
																<th>SUBTOTAL</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach var="cartItem" items="${cartList}">
																<tr>
																	<form action="updateCart/${cartItem.id}">
																		<td data-th="Items">
																			<div class="row" style="background-color: white">
																				<div class="col-sm-2 hidden-xs">
																					<img src="${context }${cartItem.bookImg}" alt="..."
																						class="img-responsive" />
																				</div>
																				<div class="col-sm-5">
																					<h4 class="nomargin">${cartItem.bookName}</h4>

																				</div>
																			</div>

																		</td>
																		<td data-th="Qty">
																			<%-- <input type="number"
                                                      class="form-control text-center"
                                                      value="${cartItem.quantity }" name ="quantity"> --%>
																			<select name="quantity">
																				<option value="${cartItem.quantity }" selected>${cartItem.quantity }</option>
																				<option value="1">1</option>
																				<option value="2">2</option>
																				<option value="3">3</option>
																				<option value="4">4</option>
																				<option value="5">5</option>
																		</td>

																		<td data-th="Price">&#8377 ${cartItem.bookPrice}</td>
																		<td data-th="Subtotal" class="text-center">&#8377
																			${cartItem.subtotal}</td>
																		<td class="actions" data-th="">
																			<button type="submit" class="btn btn-info btn-sm">
																				Update</a>
																			</button>
																		</td>
																	</form>
																	<td>
																		<%-- <button formaction="deleteCart/${cartItem.cartItemId}" type="submit" class="btn btn-danger btn-sm">Delete</button>        --%>
																		<a
																		href="deleteCart/${cartItem.id}/${cartItem.quantity}/${cartItem.subtotal}"><button
																				type="submit" class="btn btn-danger">Remove</button></a>
																	</td>
																</tr>
															</c:forEach>
														</tbody>
														<tfoot>
															<tr class="visible-xs">
																<td class="text-center"><strong>Total &#8377
																		${cart.cartPrice }</strong></td>
															</tr>
															<tr>
																<td><a href="${context}/" class="btn btn-info">
																		Continue Shopping</a></td>
																<td colspan="2" class="hidden-xs"></td>
																<td class="hidden-xs text-center"><strong></strong></td>
																<td></td>
																<td><a href="shipping" class="btn btn-info">Checkout
																		<i class="fa fa-angle-right"></i>
																</a></td>
															</tr>
														</tfoot>
													</table>
												</c:otherwise>
											</c:choose>
										</div>
									</div>
								</div>
							</div>
				</div>
				<!--    <script>
               function updateDetails(cartItem)
               {
               	fetch('/updateCart', {
               		  method: 'post',
               		  headers: {
               		    'Accept': 'application/json, text/plain, */*',
               		    'Content-Type': 'application/json'
               		  },
               		  body: cartItem
               		}).then(res=> res.json())
               		  .then(res => console.log(res));
               }
            </script> -->
				<!-- Team B and D  -->
				</c:when>
				<c:when test="${customer != null && customer.admin}">
					<a href="${context}/adminHome">Home</a>
					<a href="${context}/viewprofilepage">Account</a>
					<a href="${context}/orderList">Manage Orders</a>
					<a href="${context}/trackOrder">Track Order</a>

					<a href="${context}/reportDisplay">Manage Reports</a>
					<a href="${context}/manageDetailPage">Manage Pages</a>
					<a href="${context}/logout">Logout</a>
				</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</header>


<!-- Team B The Modal -->
<c:choose>
	<c:when test="${customer eq null }">
		<!-- The Modal -->
		<div id="loginModel" class="modal">

			<!-- Modal content -->
			<div class="modal1-content">
				<span id="loginModelClose"><img
					src="${context}/resources/images/btnclose.png" id="btnclose1"></span>
				<br>
				<form action="${context}/login" method="post" id="loginForm">

					<label class="text"><strong>Email</strong> </label><label
						style="color: red;">*</label><br> <input type="text"
						name="email" class="input" id="email" required><br> <br>
					<label class="text"><strong>Password</strong> </label> <label
						style="color: red;">*</label> <a href="javascript:void(0)"
						style="float: right; font-size: 14px; font-family: SapientSansRegular"
						id="forgotPassword">Forgot Password?</a><br> <input
						type="password" name="password" id="password" class="input"
						required><br>

					<c:if test="${message.failiureMessage ne null}">
						<span style="color: red;">${message.failiureMessage}</span>
						<br>
						<br>
						<% session.invalidate();%>
					</c:if>
					<!-- <input type="submit" value="Log In" id="loginbtn"><br> -->
					<Button type="submit" class="btn btn-info" id="loginbtn">Log
						In</Button>
					<hr>
					<label id="label3">Don't have an account yet?</label><br>

				</form>
				<form action="${context}/registrationForm" class="register-process">
					<input type="submit" value="Register" class="input" id="regbtn"><br>

				</form>

			</div>

		</div>

		<script type="text/javascript" src="${context}/resources/js/login.js"></script>



		<!-- The Modal failiureMessage -->
		<div id="forgotModel" class="modal">

			<!-- Modal content -->
			<div class="modal1-content">


				<span id="forgotModelClose"><img
					src="${context}/resources/images/btnclose.png" id="btnclose1"></span>
				<form action="${context}/forgot" method="get">

					<label class="text"><strong> Enter your Email ID</strong> </label><label
						style="color: red;">*</label><br> <input type="email"
						name="email" placeholder="Email ID" class="input" required><br>
					<br> <input type="submit" style="margin-left: 15px;"
						class="btn btn-primary" value="Submit" id="submitbtn"><br>
					<c:if test="${errorMessage!=null}">
						<span style="color: red;">${errorMessage}</span>
						<%session.setAttribute("errorMessage", null); %>
					</c:if>
					<c:if test="${successMessage!=null}">
						<span style="color: green;">${successMessage}</span>
						<%session.setAttribute("successMessage", null); %>
					</c:if>

				</form>
			</div>

		</div>
		<script type="text/javascript" src="${context}/resources/js/fpj.js"></script>

	</c:when>


</c:choose>















