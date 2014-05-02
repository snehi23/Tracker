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

	var myCenter = new google.maps.LatLng(12.971730,77.590427);
      function initialize() {
        var mapOptions = {
          center: myCenter,
          zoom: 8,
          mapTypeId:google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map-canvas"),mapOptions);
        
        var locations = [];
        <c:forEach items="${station_loc_list}" var="d1"> 
    
        	locations.push(new google.maps.LatLng(<c:out value="${d1.latitude}"></c:out>,<c:out value="${d1.longitude}"></c:out>));
        	
      	</c:forEach>
      	
      	var image = {
      		  url: 'snehal.png',
      		  size: new google.maps.Size(71, 71),
      		  origin: new google.maps.Point(0, 0),
      		  anchor: new google.maps.Point(17, 34),
      		  scaledSize: new google.maps.Size(50, 50)
      		};
      	
      	var marker=new google.maps.Marker({
      	  position: myCenter,
      	  icon:image,
      	  animation:google.maps.Animation.BOUNCE
      	  });
      	
      	var JourneyPath=new google.maps.Polyline({
      	  path:locations,
      	  strokeColor:"#0000FF",
      	  strokeOpacity:0.8,
      	  strokeWeight:2
      	  });

      	
      	marker.setMap(map);
      	JourneyPath.setMap(map);
        
        
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