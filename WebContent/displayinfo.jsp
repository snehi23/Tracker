<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/simplePagination.css">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.pager.js"></script>


<title>User Details</title>
<style>
table, td, th
{
border:1px solid blue;
}
th
{
background-color:blue;
color:white;
}
</style>
<script type="text/javascript">

	$(document).ready(function() 
	    { 
	        $("#myTable").tablesorter();  
	    } 
	);

</script>


</head>
<body>
Displaying <c:out value="${fn:length(details_list)}"/> results
<table id="myTable">
<thead>
<tr>
        <th>Train Journey ID</th>        
        <th>Date Of Journey</th>
        <th>Train</th>
		<th>From Station</th>
		<th>To Station</th>
		<th>Class</th>
		<th>Comment</th>		
    </tr>
</thead>
<tbody>
<c:forEach items="${details_list}" var="d1" > 
  <tr>
    <td><c:out value="${d1.train_journey_id}"></c:out></td>
    <td><c:out value="${d1.DOJ}"></c:out></td>
     <td><c:out value="${d1.train}"></c:out></td> 
    <td><c:out value="${d1.from_Station}"></c:out></td>
    <td><c:out value="${d1.to_Station}"></c:out></td>
    <td><c:out value="${d1.classes}"></c:out></td>
    <td><c:out value="${d1.comments}"></c:out></td>
     </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>