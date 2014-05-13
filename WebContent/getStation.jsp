<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tracker.dao.*"%>
    <%@page import="java.util.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Station List</title>
</head>
<body>
<%

String stationCode = request.getParameter("q");
List<String> stations = new StationDao().getStation(stationCode);
/* Iterator<String> iterator = trains.iterator();
			
            while(iterator.hasNext()) {
                        String train= (String)iterator.next();
                                               
                        System.out.println(train);
                        System.out.println("<BR>");
                        
            } */
          
            
            pageContext.setAttribute("stations", stations);            
%>


<c:forEach items="${stations}" var="d1" > 

    <c:out value="${d1}"></c:out>
  
</c:forEach>
</body>
</html>