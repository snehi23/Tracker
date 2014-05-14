<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tracker.dao.*"%>
    <%@page import="java.util.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%

String trainName = request.getParameter("q");
List<String> trains = new TrainDao().getTrain(trainName);
/* Iterator<String> iterator = trains.iterator();
			
            while(iterator.hasNext()) {
                        String train= (String)iterator.next();
                                               
                        System.out.println(train);
                        System.out.println("<BR>");
                        
            } */
          
            
            pageContext.setAttribute("trains", trains);            
%>


<c:forEach items="${trains}" var="d1" > 

    <c:out value="${d1}"></c:out>
  
</c:forEach>
