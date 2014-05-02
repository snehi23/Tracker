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
<script>
      function initialize() {
        var mapOptions = {
          center: new google.maps.LatLng(-33.897, 150.099),
          zoom: 8
        };
        var map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
        
        var rendererOptions = { map: map };
    	directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);
    	
    	var point1 = new google.maps.LatLng(-33.8975098545041,151.09962701797485);
    	var point2 = new google.maps.LatLng(-33.8584421519279,151.0693073272705);
    	var point3 = new google.maps.LatLng(-33.87312358690301,151.99952697753906);
    	var point4 = new google.maps.LatLng(-33.84525521656404,151.0421848297119);

    	var wps = [{ location: point1 }, {location: point4}];
    	
    	var org = new google.maps.LatLng ( -33.89192157947345,151.13604068756104);
    	var dest = new google.maps.LatLng ( -33.69727974097957,150.29047966003418);
    	
    	var request = {
    			origin: org,
    			destination: dest,
    			waypoints: wps,
    			travelMode: google.maps.DirectionsTravelMode.DRIVING
    			};

    	directionsService = new google.maps.DirectionsService();
    	directionsService.route(request, function(response, status) {
    				if (status == google.maps.DirectionsStatus.OK) {
    					directionsDisplay.setDirections(response);
    				}
    				else
    					alert ('failed to get directions');
    			});
        
      }
      
      
      google.maps.event.addDomListener(window, 'load', initialize);
    </script>

<title>Pi And Map View</title>
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
<td><div>
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
</table></div> </td>
<td>
<div  id="map-canvas" style="width: 900px; height: 500px;float: right"> </div> </td>
</tr>
</table>
</body>
</html>