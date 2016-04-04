	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
  <!-- Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
<title>Login</title>
</head>

	<body background="img/slide-3.jpg" style="background-size:cover">
	
	<form:form commandName="loginForm" method="POST" class="form">
		<!-- Handle errors -->
	<!--  	<form:errors path="*" cssClass="errorblock" element="div"/> -->
		
		<!-- Input for name of the product with css class for errors. -->
		<label for="textinput1">Enter email:</label><br>
		<form:input type="email" placeholder="E-mail" path="email" cssErrorClass="error"/><br>
		<form:errors path="email" cssClass="error" />
		<br>
		
	 	<label for="textinput2">Enter pass:</label><br>
		<form:input type="password" placeholder="Password" path="pass" cssErrorClass="error" /><br>
		<form:errors path="pass" cssClass="error" />
		 <br>
		<button type="submit" value="Login" class="button"> login </button><br>
		<!--   <input type="submit" value=Submit /> -->
		<p>Don't have a registration?
    <a href="register"> register</a></p>
	</form:form> 
	
	
	<!-- <form action="./LoginServ" method="post" class="form">
	E-mail:<br>
	<input type="text" name="email" placeholder="E-mail" required/><br>
	password:<br>
	<input type="password" name= "pass" placeholder="Password" required/><br>
	<button type="submit" value="Login" class="button"> login </button>
    <p>Don't have a registration?
    <a href="register"> register</a>
    </p>
	</form> --> 
	
</body>
	

</html>