<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB_Tg3D8gm1S4YoqAH65i_HENA75UePGUk&sensor=false"> </script>
<title>USER LOCATION STATISTICS</title>
<style>
table, td, th
{
border:1px solid green;
}
th
{
background-color:green;
color:white;
}
</style>

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

<style>

.bordered thead {
color: #0E58A0;
font-family: Arial, Helvetica, sans-serif;
font-size: 12px;

}

.bordered tbody
{

border-width: 0px 0px 1px 0px;
font-family: Arial, Helvetica, sans-serif;
color: #2B4EB7;
font-size: 11px;
border-color: #2B4EB7;

}

.bordered {
    border: solid #ccc 1px;
    background-color:#FFF; 
    box-shadow: 0 1px 1px #ccc;
    border-left: 1px solid #ccc;
    border-top: 1px solid #ccc;
    padding: 5px;
    text-align: left;          
}

</style>
    
</head>
<body>
<a href="success.jsp" title="Home"><img src="img/home.png" width="20" height="20" border="0"/></a><BR>
<table>
<tr>
<td rowspan="2" style="text-align:left;vertical-align:top;padding:0">
<font color="Green"> Displaying <c:out value="${fn:length(station_loc_list)}"/> results </font>
<table id="myTable" class="bordered">
<thead id="Thead">
	<tr>               
        <th>Station Code</th>
        <th>Station Name</th>
		<th>Latitude</th>
		<th>Longitude</th>
				
    </tr>
</thead>
<tbody id="Tbody">
<c:forEach items="${station_loc_list}" var="d1" > 
  <tr> 
    <td><c:out value="${d1.station_code}"></c:out></td>
     <td><c:out value="${d1.station_name}"></c:out></td> 
    <td><c:out value="${d1.latitude}"></c:out></td>
    <td><c:out value="${d1.longitude}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</td>
<td rowspan="2" style="text-align:left;vertical-align:top;padding:0">
<div  id="map-canvas" style="width: 900px; height: 900px;float: right"> </div>
</td>
</tr>
</table>

<table>
<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_train_list)}"/> results </font>
<table id="myTable1" class="bordered">
<thead id="Thead">
	<tr>
        <th>Train</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody id="Tbody">
<c:forEach items="${group_by_train_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div> </td>
<td>
<div id="piechart1" style="width: 900px; height: 500px;"></div>
</td>
</tr>
<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_from_station_list)}"/> results </font>
<table id="myTable2" class="bordered">
<thead>
	<tr>
        <th>From Station</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_from_station_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="piechart2" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>
<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_to_station_list)}"/> results </font>
<table id="myTable3" class="bordered">
<thead>
	<tr>
        <th>To Station</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_to_station_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="piechart3" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>

<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_class_list)}"/> results </font>
<table id="myTable4" class="bordered">
<thead>
	<tr>
        <th>Class</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_class_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="piechart4" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>

<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_year_list)}"/> results </font>
<table id="myTable5" class="bordered">
<thead>
	<tr>
        <th>Year</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_year_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="bargraph1" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>

<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_month_list)}"/> results </font>
<table id="myTable6" class="bordered">
<thead>
	<tr>
        <th>Month</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_month_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="bargraph2" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>

<tr>
<td>
<div>
<font color="Green"> Displaying <c:out value="${fn:length(group_by_day_list)}"/> results </font>
<table id="myTable7" class="bordered">
<thead>
	<tr>
        <th>Day Of Week</th>        
        <th>Journey Count</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${group_by_day_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.key}"></c:out></td>
    <td><c:out value="${d1.value}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</div>
</td>
<td>
<div id="bargraph3" style="width: 900px; height: 500px;float: right"></div>
</td>
</tr>
</table>
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
  	zoom: 5,
  	center: new google.maps.LatLng(12.971730,77.590427),
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