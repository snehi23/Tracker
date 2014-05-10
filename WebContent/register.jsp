<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/screen.css" rel="stylesheet" type="text/css" />
  	<link href="css/redesign.css" rel="stylesheet" type="text/css" />
  	<link href="css/responsive.css" rel="stylesheet" type="text/css" />
  	<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.min.css"/>
  
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
	<!-- <script src="js/sign-up.js"></script> -->
	
<title>Registration Form</title>
</head>
<body>

<form action="RegistrationController" method="post" class="sign-up">
	<div class="content-container">
		<fieldset class="left" style="width: 550px">
			<legend>Create account</legend>
			
			<div style="padding-left: 20px;">
				<p class="no-margin">Name</p><div class="left"><span><input type="text" class="sign-up big-white" name="name" id="name" value="" maxlength="25" /></span></div><div class="sign-up-tooltip" id="name-tooltip"><div class="left"><img src="img/info_16.png" id="name-tooltip-img" /></div><div class="sign-up-tooltip-text" id="name-tooltip-text" rel="enter your full name">enter your full name</div></div><div class="clear" style="margin: 0 0 10px 0;"></div>
				<p class="no-margin">Username</p><div class="left"><span><input type="text" class="sign-up big-white" name="username" id="username" value="" maxlength="20" /></span></div><div class="sign-up-tooltip" id="username-tooltip"><div class="left"><img src="img/info_16.png" id="username-tooltip-img" /></div><div class="sign-up-tooltip-text" id="username-tooltip-text" rel="choose a username">choose a username</div></div><div class="clear" style="margin: 0 0 10px 0;"></div>
				<p class="no-margin">Email</p><div class="left"><span><input type="text" class="sign-up big-white" name="email" id="email" value="" maxlength="60" /></span></div><div class="sign-up-tooltip" id="email-tooltip"><div class="left"><img src="img/info_16.png" id="email-tooltip-img" /></div><div class="sign-up-tooltip-text" id="email-tooltip-text" rel="enter your email">enter your email</div></div><div class="clear" style="margin: 0 0 10px 0;"></div>
				<p class="no-margin">Password</p><div class="left"><span><input type="password" class="sign-up big-white" name="password" id="password" value="" maxlength="30" /></span></div><div class="sign-up-tooltip" id="password-tooltip"><div class="left"><img src="img/info_16.png" id="password-tooltip-img" /></div><div class="sign-up-tooltip-text" id="password-tooltip-text" rel="at least 6 characters">at least 6 characters</div></div><div class="clear" style="margin: 0 0 10px 0;"></div>
				<p class="no-margin">Repeat password</p><div class="left"><span><input type="password" class="sign-up big-white" name="password2" id="password2" value="" maxlength="30" /></span></div><div class="sign-up-tooltip" id="password2-tooltip"><div class="left"><img src="img/info_16.png" id="password2-tooltip-img" /></div><div class="sign-up-tooltip-text" id="password2-tooltip-text" rel="so you get it right">so you get it right</div></div><div class="clear" style="margin: 0 0 10px 0;"></div>
				<p style="margin: 10px 0 0 0;">By clicking "Create account" below, you agree to the Terms of Service.</p>
			</div>
		</fieldset>
				
		<br class="clear" />
	</div>
	<div class="button-container">
		<input type="hidden" name="f847t40b0" value="!" />
		<input type="submit" class="black-submit" value="Create account" />
	</div>
</form>

</body>
</html>