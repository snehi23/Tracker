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


<title>Map View</title>
<style>
table, td, th
{
border:1px solid orange;
}
th
{
background-color:orange;
color:white;
}
</style>
</head>
<body>
<table>
<tr>
<td>
Displaying <c:out value="${fn:length(station_loc_list)}"/> results
<table id="myTable">
<thead>
	<tr>
        <th>Station Location ID</th>        
        <th>Station Code</th>
        <th>Station Name</th>
		<th>Latitude</th>
		<th>Longitude</th>
				
    </tr>
</thead>
<tbody>
<c:forEach items="${station_loc_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.station_lat_long_id}"></c:out></td>
    <td><c:out value="${d1.station_code}"></c:out></td>
     <td><c:out value="${d1.station_name}"></c:out></td> 
    <td><c:out value="${d1.latitude}"></c:out></td>
    <td><c:out value="${d1.longitude}"></c:out></td>
  </tr>
</c:forEach>
</tbody>
</table>
</td>
<td>
<div  id="map-canvas" style="width: 900px; height: 500px;float: right"> </div>
</td>
</tr>
</table>


<script>


	var locations=[
	<c:forEach items="${station_loc_list}" var="d1" varStatus="theCount">
		['<c:out value="${d1.station_name}"></c:out>',<c:out value="${d1.latitude}"></c:out>,<c:out value="${d1.longitude}"></c:out>,<c:out value="${d1.station_lat_long_id}"></c:out>],
	</c:forEach>	
	];

	var map = new google.maps.Map(document.getElementById("map-canvas"), {
  	zoom: 10,
  	center: new google.maps.LatLng(12.971730,77.590427),
  	mapTypeId: google.maps.MapTypeId.ROADMAP
	});

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
	
	/* var locations = [
	                 ['Hospital A', 28.650825,77.2276, 4],
	                 ['Hospital B', 28.62009,77.119796, 5],
	                 ['Hospital C', 28.573668,77.228286, 3],
	                 ['Hospital D',28.618282,77.349823, 2],
	                 ['Hospital F', 28.646909,77.235893, 1]
	               ];

	               var map = new google.maps.Map(document.getElementById('map-canvas'), {
	                 zoom: 10,
	                 center: new google.maps.LatLng(28.650825,77.2276),
	                 mapTypeId: google.maps.MapTypeId.ROADMAP
	               });

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
	               } */

</script>
</body>
</html>