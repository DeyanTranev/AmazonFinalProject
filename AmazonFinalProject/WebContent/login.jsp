<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Login</title>
</head>
<body>
	<body>
	<form action="./LoginServ" method="post">
	user name:<br>
	<input type="text" name="username"/><br>
	password:<br>
	<input type="password" name= "pass"/><br>
	<button type="submit" value="Login" class="button"> login </button>

	</form>
	<p>Don't have a registration?
	<a href="register.html"> register</a>
	</p>
</body>
	
</body>
</html>