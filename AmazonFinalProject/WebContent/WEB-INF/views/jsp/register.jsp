<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<title>Registration</title>
</head>
<body background="img/slide-2.jpg" style="background-size:cover">

<form:form action="register" method = "post" class="form" commandName="userWrap">
		first name:<br> 
		<form:input type="text" placeholder="First Name" path="user.firstName"/> <br>
		last name: <br> 
		<form:input type="text" placeholder="Last Name" path="user.lastName"/> <br>
		e-mail:<br> 
		<form:input type="email" placeholder="Email" path="user.eMail"/> <br>
		password:<br> 
		<form:input type="password" placeholder="Password" path="user.password"/> <br>
		repeat password:<br> 
		<form:input type="password" placeholder="Re-Password" path="user.rePassword"/> <br> 
		street:<br> 
		<form:input type="text" placeholder="Street" path="adress.street"/> <br>
		number: <br> 
		<form:input type="text" placeholder="number" path="adress.number"/> <br>
		city:<br> 
		<form:input type="text" placeholder="City" path="adress.city"/> <br>
		<div>
		<button type="submit" value="Login" class="button"> Register</button>
		<a href="index" >back</a>
		</div>
	</form:form>



<!-- 	<form action="./RegisterServ" method = "post" class="form">
		first name:<br> 
		<input type="text" placeholder="First Name" name="firstname"/> <br>
		last name: <br> 
		<input type="text" placeholder="Last Name" name="lastname"/> <br>
		e-mail:<br> 
		<input type="text" placeholder="Emai" name="email"/> <br>
		password:<br> 
		<input type="password" placeholder="Password" name="psw"/> <br>
		repeat password:<br> 
		<input type="password" placeholder="Re-Password" name="rpsw"/> <br> 
		street:<br> 
		<input type="text" placeholder="Street" name="street"/> <br>
		number: <br> 
		<input type="text" placeholder="Number" name="number"/> <br>
		city:<br> 
		<input type="text" placeholder="City" name="city"/> <br>
		 <input	type="submit" value = "Submit" class="button"/>
	</form> -->
	
	
</body>
</html>