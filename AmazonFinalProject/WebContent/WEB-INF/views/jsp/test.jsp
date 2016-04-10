<%@
page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <c:forEach items="${books}"   var="book" >
  
  
  <div class='single-product'>
  <div class='product-f-image'>
  <img src='img/${book.img}.jpg' alt=''>
  <div class='product-hover'>
  <a href='#' class='add-to-cart-link'>  <i class='fa fa-shopping-cart'>  </i> Add to cart</a>
  <a href='single-product.html' class='view-details-link'><i class='fa fa-link'></i> See details</a>
  </div></div><h2><a href='single-product.html'> ${book.title}</a></h2>
  <div class='product-carousel-price'><ins>${book.price}<br></ins> ${book.genre}</div></div>


	</c:forEach>
</body>
</html>