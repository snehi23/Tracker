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
	<style type="text/css">
		#dis
		{
			text-align:center;
			height: 20px;
			background-color:#428BCA;
			color:#FFF;
			background-color : transparent;
		}

	</style>
	
	<script type="text/javascript">
		function pop(div) {
			document.getElementById(div).style.display = 'block';
		}
		function hide(div) {
			document.getElementById(div).style.display = 'none';
		}
		//To detect escape button
		document.onkeydown = function(evt) {
			evt = evt || window.event;
			if (evt.keyCode == 27) {
				hide('popDiv');
			}
		};
	</script>
<script type="text/javascript">

	$(document).ready(function(){
			$("#submit").click(function(){
					//var name=$("#name").val();
					//var username=$("#username").val();
					var email=$("#email").val();
					var password=$("#password").val();
					var password2=$("#password2").val();
					//var rule=$("#rule").val();

					if(password!=password2) {
							$("#dis").slideDown().html('<span id="error">Password mismatch</span>');
								return false;
					}

				var filter = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
			
				if(!filter.test(email)) {
						$("#dis").slideDown().html('<span id="error">Please type correct email</span>');
						return false;
				}
				
				if (jQuery("#rule").is(":checked")) {
					
					
				} else {
					
					$("#dis").slideDown().html('<span id="error">Please accept terms & conditions</span>');
					return false;
					
				}

			});
		});
	
</script>
<title>Registration Form</title>

</head>
<body>



	 <form class="form-signin" role="form" name="loginform" action="RegistrationController" method="post" >
		<h2 id="page-heading">Sign up</h2>
		<div id="dis"><p id="errors-text">${requestScope['userid uniqueness']}</p></div><br>
		<input id="name" type="text" name="name" maxlength="30" class="form-control" placeholder="Name" required autofocus value="${User_Details.user}">
		<input id="username" type="text" name="username" maxlength="30" class="form-control" placeholder="Username" required> <%-- <font color="Red">${sessionScope['userid uniqueness']}</font> --%>
		<input id="email" type="text" name="email" maxlength="30" class="form-control" placeholder="Email" required value="${User_Details.email}">
		<input id="password" type="password" name="password" maxlength="30" class="form-control" placeholder="Password" required>
		<input id="password2" type="password" name="password2" maxlength="30" class="form-control" placeholder="Repeat password" required>
		<label class="checkbox">
			<input type="checkbox" id="rule" value="remember-me"> By clicking "Sign up" below, you agree to the <a href="#" onClick="pop('popDiv')">Terms and Conditions</a>
		</label>
		<button class="btn btn-lg btn-primary btn-block" type="submit" name="submit" id="submit" value="Sign Up">Sign up</button>
	</form>
	<div id="popDiv" class="ontop">
			<div id="popup">
			<div id="terms-and-conditions">
				<h3>DESCRIPTION</h3>
				<p><i>journeytracker.in</i> is a service for traveling enthusiasts who want to keep a record of journey they have done.
				Members of <i>journeytracker.in</i> have their own profile where statistics of the members journey are shown, to keep the tracking as simple as possible.
				<i>journeytracker.in</i> is aimed to serve passengers who want to keep track of their journey.</p>

				<h3>PRIVACY POLICY</h3>
				<p><i>journeytracker.in</i> will keep your information accurate, secure and private and we will never transfer any information or data to any third party.
				<i>journeytracker.in</i> collects and saves this data at the time of registration for the use of our services:
				<ol>
					<li>Your name</li>
					<li>Your e-mail address</li>
				</ol>
				</p>
				
				<h3>RULES AND REGULATIONS</h3>
				<p>Once registered to <i>journeytracker.in</i> you will get access to your own personal journeys page. You can manage all of your journeys, delete and add a new journey. What information you add is up to yourself to decide.
				You may add as many journeys you want but you may not abuse the system such as adding unrealistic journeys and you must not add any hypothetical journey, the purpose of <i>journeytracker.in</i> is to track real journeys.
				</p>
				
				<h3>NOT FOLLOWING THE RULES</h3>
				<p>Not following the rules will have consequences. You will be warned, or ultimately banned. In more alarming situations your user account will be deleted and/or your Internet service provider may also be contacted.
				If you are being contacted by one of our staff, it is recommended that you obey their wishes and recommendations. We are here to keep a friendly environment, so please respect our wishes. If you have any comments about the work or decisions of the staff, please contact us via the contact form.
				</p>
				
				<h3>ADVERTISING POLICY</h3>
				<p>If you wish to receive more information about future advertisement possibilities at our WebSite, please contact us. For the moment, we are completely ad-free.</p>
					
				<h3>TERMINATION OF ACCOUNT</h3>
				<p>If a user wishes to delete his or her account, he or she may request this using our contact form. This can be done at any time.
				In the case of termination of an account, all information will be deleted, including all of your journeys.</p>
					
				<h3>COPYRIGHT</h3>
				<p>When register to <i>journeytracker.in</i> you agree not to copy, distribute, transfer or modify our work.</p>
					
				<h3>COSTS AND CONTRIBUTION</h3>
				<p><i>journeytracker.in</i> is completely free of charge.</p>
					
				<h3>DISCLAIMER</h3>
				<p><i>journeytracker.in</i> reserves itself for any changes or updates of these terms and conditions. In an event of a major update users will be contacted.</p>
				</br>
				<a href="#" onClick="hide('popDiv')">Close</a>
			</div>
			</div>
		</div>
</body>
</html>