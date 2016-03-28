<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/responsive.css">
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body background="img/slide-2.jpg">
	<form action="./RegisterServ" method = "post">
		first name:<br> 
		<input type="text" name="firstname"/> <br>
		last name: <br> 
		<input type="text" name="lastname"/> <br>
		e-mail:<br> 
		<input type="text" name="email"/> <br>
		password:<br> 
		<input type="password" name="psw"/> <br>
		repeat password:<br> 
		<input type="password" name="rpsw"/> <br> 
		street:<br> 
		<input type="text" name="street"/> <br>
		number: <br> 
		<input type="text" name="number"/> <br>
		city:<br> 
		<input type="text" name="city"/> <br>
		 <input	type="submit" value = "Submit" class="button" />
	</form>
</body>
</html>