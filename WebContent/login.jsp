<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="pragma"        content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-store" />
<title>Login Page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">

<script>
function validateLogin()
{
	var x=document.forms["loginform"]["user"].value;
	var y=document.forms["loginform"]["pass"].value;
	
	if (x==null || x=="")
  	{
  		document.getElementById("error").innerHTML="Please enter Username";
  		return false;
  	}
	
	if(y==null || y=="")
  	{
		document.getElementById("error").innerHTML="Please enter Password";
		return false;
  	}
	
	return true;
 
}
</script>
</head>
<body>

 <form class="form-signin" role="form" name="loginform" action="LoginController" method="post" >
	<h2 class="form-signin-heading"><a id="sign-up" href="register.jsp">Sign up,it's free</a></h2>
	<div id="error" style="color:red"></div></td>
	<input type="text" name="user" maxlength="30" class="form-control" placeholder="Username"  required autofocus>
	<input type="password" name="pass" maxlength="30" class="form-control" placeholder="Password" required>
	<label class="checkbox">
          <input type="checkbox" name="remember" value="true"> Remember me
    </label>
	<button class="btn btn-lg btn-primary btn-block" type="submit" name="submit" value="Login">Sign in</button>
</form>
</body>
</html>