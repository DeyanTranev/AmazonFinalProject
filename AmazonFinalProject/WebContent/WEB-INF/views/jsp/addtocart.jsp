<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>eBooks</title>

<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<div class="header-area">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="user-menu">
						<ul>

							<li><a href="addtocart"><i class="fa fa-user"></i> My Cart</a></li>
							<%
								if (((String) request.getSession().getAttribute("name")) == null) {
							%>
							<li><a href="login"><i class="fa fa-user"></i><span
									id="loginName"> Login</span></a></li>
							<%
								} else {
							%>
							<li><a href="login"><i class="fa fa-user"></i> <%=request.getSession().getAttribute("name")%></a></li>
							<li><a href="logout"><i class="fa fa-user"></i>
									Logout </a></li>
							<%
								}
							%>

						</ul>
					</div>
				</div>

				<div class="col-md-4">
					<div class="header-right">
						<ul class="list-unstyled list-inline">
							
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End header area -->

	<div class="site-branding-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo">
						<h1>
							<a href="index">e<span>Books</span></a>
						</h1>
					</div>
				</div>
				<div class="col-sm-6">

					<div class="shopping-item">
						<c:set var="total" value="${total}" />
						<a href="addtocart">Cart - <span class="cart-amunt"><fmt:formatNumber
															type="number" maxIntegerDigits="2" value="${total}" /></span>
							<i class="fa fa-shopping-cart"></i> <span class="product-count">${cart.size()}</span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->

	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="index">Home</a></li>
						<li><a href="shop">Shop page</a></li>
						<li class="active"><a href="addtocart">Cart</a></li>
						
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->

	<div class="product-big-title-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-bit-title text-center">
						<h2>Shopping Cart</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Page title area -->


	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-4">

				<c:choose>
					<c:when test="${!cart.isEmpty()}">
						<c:forEach items="${cart}" var="book">
							<div class="single-sidebar">
								<h2 class="sidebar-title">Products</h2>
								
								<div class="thubmnail-recent">
									<img src="img/${book.img}.jpg" class="recent-thumb" alt="">
									<h2>
										<a href="single-product-${book.id}">${book.title}</a>
									</h2>
									
									
									<div class="product-sidebar-price">
										<ins>${book.price}</ins>
									</div>
									<div >
										<a href="remove-${book.id}" class="tfbutton_remove">Remove</a>
									</div>
									
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p>Cart is empty.</p>
					</c:otherwise>
					</c:choose>
					<c:if test="${error != null }">
						<p style="color: red">${error}</p>
					</c:if>

				</div>

				<div class="col-md-8">
					<div class="product-content-right">
						<div class="woocommerce">
							<!-- <form method="post" action="#">
								
							</form> -->

							<div class="cart-collaterals">





								<div class="cart_totals ">
									<h2>Cart Totals</h2>

									<table cellspacing="0">
										<tbody>
											<tr class="cart-subtotal">
												<th>Cart Subtotal</th>
												<c:set var="total" value="${total}" />
												<td><span class="amount"><fmt:formatNumber
															type="number" maxIntegerDigits="2" value="${total}" /></span></td>
											</tr>

											<tr class="shipping">
												<th>Shipping and Handling</th>
												<td>Free Shipping</td>
											</tr>

											<tr class="order-total">
												<th>Order Total</th>
												<c:set var="total" value="${total}" />
												<td><strong><span class="amount"><fmt:formatNumber
																type="number" maxIntegerDigits="2" value="${total}" /></span></strong></td>
											</tr>
										</tbody>
									</table>
									<form:form commandName="orderForm" method="GET" class="form submit" action="order">
										<button type="submit" value="Login" class="button">Submit Order </button>
									</form:form>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="footer-bottom-area">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="copyright">
						<p>&copy; 2015 eBooks. All Rights Reserved. Coded by Us</p>
					</div>
				</div>

				<div class="col-md-4">
					<div class="footer-card-icon">
						<i class="fa fa-cc-discover"></i> <i class="fa fa-cc-mastercard"></i>
						<i class="fa fa-cc-paypal"></i> <i class="fa fa-cc-visa"></i>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End footer bottom area -->

	<!-- Latest jQuery form server -->
	<script src="https://code.jquery.com/jquery.min.js"></script>

	<!-- Bootstrap JS form CDN -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<!-- jQuery sticky menu -->
	
	

	<!-- jQuery easing -->
	
	<!--Alt -->
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/jquery.easing.1.3.min.js"></script>

	<!-- Main Script -->
	<script src="js/main.js"></script>
</body>
</html>