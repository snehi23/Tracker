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
<title>Pi And Map View</title>
</head>
<body>
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

</body>
</html>