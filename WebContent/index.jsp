<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HOME</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/homepage.css" rel="stylesheet">
<link href="css/footer.css" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="css/jcarousel.basic.css">
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
<script src="js/jquery.jcarousel.min.js"></script>
<script type="text/javascript" src="js/jcarousel.basic.js"></script>



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
	
	<div class="wrapper">
            <h1>Basic carousel</h1>

            <p>This example shows how to setup a basic carousel with prev/next controls and pagination.</p>

            <div class="jcarousel-wrapper">
                <div class="jcarousel">
                    <ul>
                        <li><img src="img/Arya.png" width="600" height="400" alt=""></li>
                        <li><img src="img/Arya-Stark.png" width="600" height="400" alt=""></li>
                        
                    </ul>
                </div>

                <a href="#" class="jcarousel-control-prev">&lsaquo;</a>
                <a href="#" class="jcarousel-control-next">&rsaquo;</a>
                
                <p class="jcarousel-pagination">
                    
                </p>
            </div>
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