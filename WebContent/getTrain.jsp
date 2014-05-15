<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tracker.dao.*"%>
    <%@page import="com.tracker.model.*"%>
    <%@page import="java.util.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%

session = request.getSession(true);
String trainName = request.getParameter("q");
List<TrainDetails> trainDetails = new TrainDao().getTrain(trainName);
/* Iterator<String> iterator = trains.iterator();
			
            while(iterator.hasNext()) {
                        String train= (String)iterator.next();
                                               
                        System.out.println(train);
                        System.out.println("<BR>");
                        
            } */
          
            for(TrainDetails d : trainDetails) {
				System.out.println(d.getTrain_Name()+" "+d.getTrain_Number());
			}
            
           /*  pageContext.setAttribute("trainDetails", trainDetails); */       
            
            session.setAttribute("trainDetails", trainDetails);
%>


<c:forEach items="${trainDetails}" var="d1" > 

    <c:out value="${d1.Train_Name}"></c:out>
  
</c:forEach>
