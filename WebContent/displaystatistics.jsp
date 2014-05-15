<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="pragma"        content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-store" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/traveldataentry.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB_Tg3D8gm1S4YoqAH65i_HENA75UePGUk&sensor=false"> </script>
<title>USER LOCATION STATISTICS</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script>
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart1);
      google.setOnLoadCallback(drawChart2);
      google.setOnLoadCallback(drawChart3);
      google.setOnLoadCallback(drawChart4);
      google.setOnLoadCallback(drawChart5);
      google.setOnLoadCallback(drawChart6);
      google.setOnLoadCallback(drawChart7);
      
      function drawChart1() {
        
    	var data = new google.visualization.DataTable();
        data.addColumn('string','Train');
        data.addColumn('number','Count');
        <c:forEach items="${group_by_train_list}" var="d1" > 
        
          data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
          
      	</c:forEach>
        
        
        var options = {
          title: 'My Train Preferences'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart1'));
        chart.draw(data, options);
      }
      
      function drawChart2() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','From');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_from_station_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My From Station Preferences'
          };

          var chart = new google.visualization.PieChart(document.getElementById('piechart2'));
          chart.draw(data, options);
        }
      
      function drawChart3() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','To');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_to_station_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My To Station Preferences'
          };

          var chart = new google.visualization.PieChart(document.getElementById('piechart3'));
          chart.draw(data, options);
        }
      
      function drawChart4() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','Class');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_class_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My Class Preferences'
          };

          var chart = new google.visualization.PieChart(document.getElementById('piechart4'));
          chart.draw(data, options);
        }
      
      function drawChart5() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','Year');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_year_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My Yearly Stats'
          };

          var chart = new google.visualization.BarChart(document.getElementById('bargraph1'));
          chart.draw(data, options);
        }
      
      function drawChart6() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','Month');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_month_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My Monthly Stats'
          };

          var chart = new google.visualization.BarChart(document.getElementById('bargraph2'));
          chart.draw(data, options);
        }
      
      function drawChart7() {
          var data = new google.visualization.DataTable();
          data.addColumn('string','Day');
          data.addColumn('number','Count');
          <c:forEach items="${group_by_day_list}" var="d1" > 
          
            data.addRow(['<c:out value="${d1.key}"></c:out>',<c:out value="${d1.value}"></c:out>]);
            
        	</c:forEach>
          
          
          var options = {
            title: 'My Daily Stats'
          };

          var chart = new google.visualization.BarChart(document.getElementById('bargraph3'));
          chart.draw(data, options);
        }
      
      $(document).ready(function() 
    		    { 
    		        $("#myTable1").tablesorter();
    		        $("#myTable2").tablesorter();
    		        $("#myTable3").tablesorter();
    		        $("#myTable4").tablesorter();
    		        $("#myTable5").tablesorter();
    		        $("#myTable6").tablesorter();
    		        $("#myTable7").tablesorter();
    		        
    		    } 
    		);
    </script>   
</head>
<body>
	<div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Hello ${sessionScope['userid']} !</h3>
              <ul class="nav masthead-nav">
                <li><a href="#">Home</a></li>
                <li><a href="success.jsp">Add a Journey</a></li>
                <li><a href="DisplayAllController">Records</a></li>
                <li class="active"><a href="DisplayStatisticsController">Statistics</a></li>
                <!-- <li><a href="DisplayLocationController">Locations</a></li> -->
                <li><a href="LogoutController">LogOut</a></li>
                <li><a href="#"><form action='RefreshLocationController' method='post'>
					<input  style="background-image: url(img/refresh.png); background-color: transparent;
						background-repeat: no-repeat;
						background-position: 0px 0px;
						border: none;
						cursor: pointer;
						height: 35px;
						width: 30px;
						padding-left: 16px;
						vertical-align: middle;" title="Force Refresh" type="submit" value="">
					</form></a>
				</li>
              </ul>
            </div>
          </div>

          <div class="inner cover">
			<div class="row">
				<div  id="map-canvas" style="width: 100%; height: 500px;"> </div>
			</div>
            <div class="row">
				<div id="inner-left" class="col-lg-6">
					<div id="piechart1" style="width: 100%; height: 500px;"></div>
				</div>
				<div id="inner-right" class="col-lg-6">
					<div id="piechart2" style="width: 100%; height: 500px;"></div>
				</div>
			</div>
			<div class="row">
				<div id="inner-left" class="col-lg-6">
					<div id="piechart3" style="width: 100%; height: 500px;"></div>
				</div>
				<div id="inner-right" class="col-lg-6">
					<div id="piechart4" style="width: 100%; height: 500px;"></div>
				</div>
			</div>
			<div class="row">
				<div id="bargraph1" style="width: 100%; height: 500px"></div>	
			</div>
			<div class="row">
				<div id="bargraph2" style="width: 100%; height: 500px"></div>
			</div>
			<div class="row">
				<div id="bargraph3" style="width: 100%; height: 500px"></div> 
			</div>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p></p>
            </div>
          </div>

        </div>

      </div>

    </div>
<script>

	var locations=[
	<c:forEach items="${station_loc_list}" var="d1" varStatus="theCount">
		['<c:out value="${d1.station_name}"></c:out>',<c:out value="${d1.latitude}"></c:out>,<c:out value="${d1.longitude}"></c:out>,<c:out value="${d1.station_lat_long_id}"></c:out>],
	</c:forEach>	
	];
	
	var locations_plot=[
	
	<c:forEach items="${station_loc_plot}" var="d1"> 	
	[new google.maps.LatLng(<c:out value="${d1.from_latitude}"></c:out>,<c:out value="${d1.from_longitude}"></c:out>),new google.maps.LatLng(<c:out value="${d1.to_latitude}"></c:out>,<c:out value="${d1.to_longitude}"></c:out>)],
	</c:forEach>	                    	                    
	];

	var map = new google.maps.Map(document.getElementById("map-canvas"), {
  	zoom: 4,
  	center: new google.maps.LatLng(24.730852, 79.278573),
  	mapTypeId: google.maps.MapTypeId.ROADMAP
	});
	
	for (var i = 0; i < locations_plot.length; i++) {
    	var flightPath = new google.maps.Polyline({
        path: locations_plot[i],
        geodesic: true,
        strokeColor: '#FF0000',
        strokeOpacity: 1.0,
        strokeWeight: 2
      });
    	  flightPath.setMap(map);
    	}

	var infowindow = new google.maps.InfoWindow();
	var marker;
	for (var i = 0; i < locations.length; i++) {  
        marker = new google.maps.Marker({
          position: new google.maps.LatLng(locations[i][1], locations[i][2]),
          map: map
        });

        google.maps.event.addListener(marker, 'click', (function(marker, i) {
          return function() {
            infowindow.setContent(locations[i][0]);
            infowindow.open(map, marker);
          }
        })(marker, i));
        
                             
	}
	
	$(document).ready(function() 
		    { 
		        $("#myTable").tablesorter();
		        
		    } 
		);
</script>
</body>
</html>