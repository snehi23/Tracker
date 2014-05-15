<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="pragma"        content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-store" />
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/signin.css" rel="stylesheet">
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
	
	
<title>Registration Form</title>

</head>
<body>

<%-- <marquee><font color="Red">${sessionScope['userid uniqeness']}</font></marquee> --%>

	 <form class="form-signin" role="form" name="loginform" action="RegistrationController" method="post" >
		<h2>Create account</h2>
		<div id="error" style="color:red"></div>
		<input id="name" type="text" name="name" maxlength="30" class="form-control" placeholder="Name" required autofocus>
		<input id="username" type="text" name="username" maxlength="30" class="form-control" placeholder="Username" required> <font color="Red">${sessionScope['userid uniqueness']}</font>
		<input id="email" type="text" name="email" maxlength="30" class="form-control" placeholder="Email" required>
		<input id="password" type="password" name="password" maxlength="30" class="form-control" placeholder="Password" required>
		<input id="password2" type="password" name="password2" maxlength="30" class="form-control" placeholder="Repeat password" required>
		<label class="checkbox">
			<input type="checkbox" value="remember-me"> By clicking "Create account" below, you agree to the Terms of Service.
		</label>
		<button class="btn btn-lg btn-primary btn-block" type="submit" name="submit" value="Create account">Create Account</button>
	</form>
</body>
</html>