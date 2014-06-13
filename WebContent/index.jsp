<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HOME</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/homepage.css" rel="stylesheet">
<link href="css/footer.css" rel="stylesheet">
<link rel="stylesheet" href="css/mainSlideShow.css">

	<link rel="stylesheet" type="text/css" href="css/jcarousel.basic.css">
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
<script src="js/bootstrap-carousel.js"></script>


    <script type="text/javascript">

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['Rajdhani', 2],
          ['Expree/Mail', 2],
          ['Garibrath', 1],
          ['Intercity', 1],
        ]);

        // Set chart options
        var options = {'title':'My Train Preferences',
					   'backgroundColor': '#E4E4E4',
					   'height':'300',};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
      
      $(function() {
    	    $('.jcarousel').jcarousel({
    	        // Configuration goes here
    	    });
    	});
 </script>
</head>

  <body>
	
    <div class="site-wrapper" id="site-intro-cover">
      <div class="site-wrapper-inner">

        <div class="cover-container">
          <div class="inner cover">
            <h1 class="cover-heading">Journey Tracker</h1>
            <p class="lead">
				Traveling is like an hobby for people and so is record keeping. 
				Join us if you want to record all your travels, track it, share it and relive those moments again.
			</p>
            <p class="lead">
              <a href="#about-us" class="btn btn-lg btn-default">About Us</a>
              <a href="SessionController" class="btn btn-lg btn-default">Sign In</a>
              <a href="register.jsp" class="btn btn-lg btn-default">Sign Up</a>
            </p>
          </div>
        </div>
      </div>
    </div>
	
	<div class="col-lg-12" id="about-us">
		<div class="row">
			<div class="inner-left col-lg-6">
				<p><img src="img/profile.png"></p>
			</div>
			<div class="inner-right col-lg-6">
				<h2>
					Manage your personal profile. Add flights, train and bus journeys. 
				</h2>
			</div>
		</div>
		<div class="row">
			<div class="inner-left col-lg-6">
				<h2>
					Never forget those moments. You can add all your memories to this. Where and when of your tours are taken care by us.
				</h2>
			</div>
			<div class="inner-right col-lg-6">
				<p><img src="img/diary.png"></p>
			</div>
		</div>
		<div class="row">
			<div class="inner-left col-lg-6">
				<div id="chart_div"></div>	
			</div>
			<div class="inner-right col-lg-6">
				<h2>
					Analyse data, follow statistics. See your top destinations, top routes, top trains etc. Check which day, which month you travel most on. 
					Which year did you travel the most? All your statistics at one place.
				</h2>
			</div>
		</div>
		<div class="row">
			<div class="inner-left col-lg-6">
				<h2>Travelling is like an hobby for people and so is record keeping. 
				Join us if you want to record all your travels, track it, share it and relive those moments again.o is record keeping. 
				Join us if you want to record all your travels, track it, share it and relive those moments again.</h2>
			</div>
			<div class="inner-right col-lg-6">
				<p><img src="img/diary.png"></p>
			</div>
		</div>
	</div>
	
	<div id="carousel-example-generic" class="carousel slide">
		<ol class="carousel-indicators">
		  <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		  <li data-target="#carousel-example-generic" data-slide-to="1" class=""></li>
		  <li data-target="#carousel-example-generic" data-slide-to="2" class=""></li>
		  <li data-target="#carousel-example-generic" data-slide-to="3" class=""></li>
		  <li data-target="#carousel-example-generic" data-slide-to="4" class=""></li>
		</ol>
		<div class="carousel-inner">
		  <div class="item active">
			<div class="slide1">
				<div class="container">
				  <h1 class="home-intro text-left">Professional Training For Students</h1>
				  <p class="home-lead">
					Giving Industry Insights in College
					<i></i>
				  </p>
				  <a href="training/" class="learn-more">Learn more <span class="link-arrow">→</span></a>
				</div>    
			</div>
		  </div>
		  <div class="item">
			<div class="slide2">
				<div class="container">
				  <h1 class="home-intro text-left">Bridging The Gap For Rural Students</h1>
				  <p class="home-lead">
					To Make Them Compete With Urban Students 
					<i></i>
				  </p>
				  <a href="schools/" class="learn-more">Learn more <span class="link-arrow">→</span></a>
				</div>    
			</div>
		  </div>
		  <div class="item">
			<div class="slide3">
				<div class="container">
				  <h1 class="home-intro text-left">Creating Jobs for Rural People</h1>
				  <p class="home-lead">
					By Outsourcing Jobs requiring Low Skills
					<i></i>
				  </p>
				  <a href="jobs/" class="learn-more">Learn more <span class="link-arrow">→</span></a>
				</div>    
			</div>
		  </div>
		  <div class="item">
			<div class="slide4">
				<div class="container">
				  <h1 class="home-intro text-left">Monitoring Health Of School Students</h1>
				  <p class="home-lead">
					By Quarterly Check-up And Diagnosis
					<i></i>
				  </p>
				  <a href="health/" class="learn-more">Learn more <span class="link-arrow">→</span></a>
				</div>    
			</div>
		  </div>
		  <div class="item">
			<div class="slide5">
				<div class="container">
				  <h1 class="home-intro text-left">Enterprises for Creating Rural Employment</h1>
				  <p class="home-lead">
					Expanding Food-Processing, Food Packaging Industries 
					<i></i>
				  </p>
				  <a href="FarMark/" class="learn-more">Learn more <span class="link-arrow">→</span></a>
				</div>    
			</div>
		  </div>
		</div>
		<a class="left carousel-control hidden-phone" href="" data-slide="prev">
		  <span></span>
		</a>
		<a class="right carousel-control hidden-phone" href="" data-slide="next">
		  <span></span>
		</a>
	</div>	
	<div id="feedback">
	<!-- <iframe name="hidden_iframe" id="hidden_iframe" style="display:none;" onload="if(submitted) {window.location='success.jsp';}"></iframe> -->		
				 <h1>Feedback</h1>

				<p>Please help us improve with your valuable feedback.</p>
				<iframe name="hidden_iframe" id="hidden_iframe" style="display:none;" onload="if(submitted) { feedback = document.getElementById("feedback");feedback.innerHTML = "Invalid Email-ID";}"></iframe>
				<form action="https://docs.google.com/forms/d/1X-KbSlFmjh_9xFUHdiGTmh5Y35m6AsjCyQORU8htgdU/formResponse" method="POST" id="ss-form" target="_self" onsubmit=""><ol role="list" class="ss-question-list" style="padding-left: 0">
					<input type="text" name="entry.690358858" value="" class="ss-q-short form-control" id="entry_690358858" dir="auto" aria-label="Username  " title="" placeholder="Username" required>

					<input type="text" name="entry.2129960556" value="" class="ss-q-short form-control" id="entry_2129960556" dir="auto" aria-label="Email ID  " title="" placeholder="Email ID" required>
					<div class="error-message"></div>

					<textarea name="entry.694356638" rows="8" cols="0" class="ss-q-long form-control" id="entry_694356638" dir="auto" aria-label="Feedback  " placeholder="Feedback" required></textarea>
					<div class="error-message"></div>

					<input class="btn btn-lg btn-success" type="submit" name="submit" value="Submit" id="ss-submit">
				</form>				
	</div>
	<div id="footer" class="col-lg-12">
		<ul id="footer-list">
			<li><a href="#">Contact Us</a></li>
			<li><a href="#">Blogs</a></li>
			<li><a href="#">Features</a></li>
			<li><a href="#">Feedback</a></li>
			<li><a href="register.jsp">Sign Up</a></li>	
		</ul>
	</div>
  </body>
</html>