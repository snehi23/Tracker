<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Travelogue.com</title>
    <link rel="shortcut icon" type="image/x-icon" href="">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=IE8">
    <meta name="description" content="">
    <meta name="application-name" content="Travelogue">
    <meta name="msapplication-tooltip" content="Travelogue">

    <script type="text/javascript" async="" src="js/ga.js"></script><script type="text/javascript" src="js/klg7bbu.js"></script>
    <style type="text/css">.tk-proxima-nova{font-family:"proxima-nova-1","proxima-nova-2",sans-serif;}</style><link rel="stylesheet" href="http://use.typekit.net/c/5da804/proxima-nova-1:n3:n4:n6:n7:n8.Vmx:F:2,W0V:F:2,W0X:F:2,W0Y:F:2,Vn5:F:2/d?3bb2a6e53c9684ffdc9a9bf0135b2a625599d48bf0f321e90d6570bc8950e4fef26628673e68601b2874d8377de581c77ab2ddcf86f8e3b02cef54f6a6bad9f4f7c2b0179010403d379349cc25efb8b9f47320f01764b949353c771187edc4e59d6c60983e0247b7d61703b12c224a38bf5ddf3fc0e29bc2d786b93a05477746a2f28ad6dd5b784fe1859e12840ec31b88277bd4ac265025523eabea42f399b4c4dc51dedea712c8c1"><script type="text/javascript">try{Typekit.load();}catch(e){}</script>

    <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" media="screen" href="css/homepage.css">
</head>
<body>	

	<div id="warning-message">
		You may need a newer browser for this site to function properly. Consider upgrading to the newest version of <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">Internet Explorer</a> or <a href="https://www.google.com/intl/en/chrome/browser/">Chrome</a>.
	</div>
		
	<!-- header -->
	<header class="full">
		<div class="row">
			<ul id="header-menu" class="list-reset">
				<li class="selected"><a href="#welcome">Home</a></li>
				<li><a href="#about">AboutUs</a></li>
				<li><a href="#contact">Feedback</a></li>
			</ul>		
			<a id="header-hello" href="login.jsp">Sign In</a>			
		</div>
	</header>

	<!-- welcome -->
	<section id="welcome" class="container">
		<div class="row">
			<h2 style="font-size: 84.57142857142857px;">My Travelogue</h2>
			<h3 style="bottom: 0px;text-align:left;">Keep logs of your train travel. Maintain records. Analyse statistics. Make your journeys Memorable. 
				<input class="btn btn-success" type="submit" name="submit" value="Sign Up" id="ss-submit" onclick="window.location.href='register.jsp'">
			</h3>
		</div>
	</section>
		
	<!-- about -->
	<section class="page-section-gray" id="about">
		<h2 class="small-section-title">About Us</h2>
		<div class="subsection-title row">
			<h2 id="faq-title" class="title">What is travelogue?</h2>
			<h3 id="faq-subtitle">
			Travelogue is an application where one can log h[is/er] train journeys, maintain details of each journey and see beautiful statistics of them with timely stats, map displays and total distance travelled.
			</h3>
		</div>
		<div class="subsection-title row">
			<h3 id="faq-title" class="title">FAQ</h3>
		</div>
		<div id="questions" class="questions-columns row">
			<div class="question-item">
				<h4 class="inline-header">How to use it?</h4>
				<p>You must sign up to use travelogue. You can fill the details of the journeys you have travelled. We have also provided functionality to fetch details of future journeys from pnr.</p>
			</div>
			<div class="question-item">
				<h4 class="inline-header">Is my data secure with travelogue?</h4>
				<p>The data is encrypted before storing. The data is not available to anybody else than you. We don't share your travel details with others and you can rely on us for that.</p>
			</div>
			<div class="question-item">
				<h4 class="inline-header">What is the cost for usage?</h4>
				<p>Travelogue is completely free of cost. Your satisfaction is ultimate profit for us. ;)</p>
			</div>
			<div class="question-item hasmore">
				<h4 class="inline-header">Is there any mobile application for the same?</h4>
				<p>Yes. The mobile application for Travelogue is coming soon. We'd like to hear your ideas.<!-- <span class="prompt">MORE</span><span class="more"></span> </p><p class="more"></p>
				<p>Yes. The mobile application for Travelogue is coming soon. We'd like to hear your ideas.<span class="prompt">MORE</span><span class="more"></span> </p><p class="more"></p> -->
			</div>
			<div class="question-item hasmore">
				<h4 class="inline-header">Why the application is train specific?</h4>
				<p>Because trains are the most preferred/affordable mode of travel in India.</p>
			</div>
		</div>
	</section>
	
	<!-- contact -->
	<section id="contact">
		<h2 class="small-section-title">Contact</h2>
		<div class="subsection-title row" id="feedback">
			<h3 class="title">Say Hello</h3>
			<div id="contact-sent"><div></div><h3>Thank you! We'll be in touch!</h3></div>
			<iframe name="hidden_iframe" id="hidden_iframe" style="display:none;" onload="if(submitted) { feedback = document.getElementById("contact");feedback.innerHTML = "Invalid Email-ID";}"></iframe>
				<form action="https://docs.google.com/forms/d/1X-KbSlFmjh_9xFUHdiGTmh5Y35m6AsjCyQORU8htgdU/formResponse" method="POST" id="ss-form" target="_self" onsubmit=""><ol role="list" class="ss-question-list" style="padding-left: 0">
					<input type="text" name="entry.690358858" value="" class="ss-q-short form-control" id="entry_690358858" dir="auto" aria-label="Username  " title="" placeholder="Username" required>

					<input type="text" name="entry.2129960556" value="" class="ss-q-short form-control" id="entry_2129960556" dir="auto" aria-label="Email ID  " title="" placeholder="Email ID" required>
					<div class="error-message"></div>

					<textarea name="entry.694356638" rows="8" cols="0" class="ss-q-long form-control" id="entry_694356638" dir="auto" aria-label="Feedback  " placeholder="Feedback" required></textarea>
					<div class="error-message"></div>

					<input class="btn btn-lg btn-success" type="submit" name="submit" value="Submit" id="ss-submit">
				</form>	
		</div>
	</section>

    <!-- footer -->
	<footer class="full">
	    <div class="container row">
	        <div class="col span-2">
	            <h3>Contact</h3>
	            <p>
	            <a href="mailto:hello@mytravelogue.in">hello@mytravelogue.in</a>
	            <br>
	            +91 942-085-5095
	            </p>
	            <p>
	            <div><h3>Built in Bangalore</h3></div>
	            </p>
	        </div>
	        <div class="col span-2">
	            <h3>Friends &amp; Family</h3>
	            <p>
	                The core travelogue members are
	                <a href="" target="_blank">Suraj</a> and
	                <a href="" target="_blank">Snehal</a>.
	            </p>
	            <p></p>
	            Also, a big thanks to <a href="">Sameer</a> and <a href="">Nikhil</a> for their valuable inputs.
	            <p></p>
	        </div>
	        <div class="col span-2">
	            <h3>Social</h3>
	            <p id="footer-elsewhere">
	            <a href=""><h3><img src="img/facebook.png" style="width:20px; height:20px;">/myTravelogue</h3></a>
	            </p>
	            <h3>Legal</h3>
	            <p>Copyright © 2014 Travelogue, All rights reserved.</p>
	        </div>
	    </div>
	</footer>

    <!-- analytics -->
   <script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-52676021-1', 'auto');
	  ga('send', 'pageview');
	</script>	    

    <!-- javascript -->
    <script src="js/jquery.js"></script>
    <script>window.jQuery || document.write('<script src="jquery-1.8.0.min.js"><\/script>')</script>
    <script src="js/libs-1362713605000.js"></script>
<script src="js/page-1362821514000.js"></script>



</body></html>
