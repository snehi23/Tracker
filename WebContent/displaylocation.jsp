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

<script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB_Tg3D8gm1S4YoqAH65i_HENA75UePGUk&sensor=false"> </script>


<title>Map View</title>
<style>

#Thead {
color: #0E58A0;
font-family: Arial, Helvetica, sans-serif;
font-size: 12px;

}

#Tbody
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


<script>

	var locations_plot=[
	
	<c:forEach items="${station_loc_list}" var="d1"> 	
	new google.maps.LatLng(<c:out value="${d1.latitude}"></c:out>,<c:out value="${d1.longitude}"></c:out>),
	</c:forEach>
	
	];

	var map = new google.maps.Map(document.getElementById("map-canvas"), {
  	zoom: 5,
  	center: new google.maps.LatLng(12.971730,77.590427),
  	mapTypeId: google.maps.MapTypeId.ROADMAP
	});
	
	
    	var flightPath = new google.maps.Polyline({
        path: locations_plot,
        geodesic: true,
        strokeColor: '#FF0000',
        strokeOpacity: 1.0,
        strokeWeight: 2
      });
    	  flightPath.setMap(map);

	google.maps.event.addDomListener(window, 'load', initialize);

	
</script>
</body>
</html>