<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/simplePagination.css">
<link href="css/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.min.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.pager.js"></script>


<title>User Details</title>


<script>

	$(document).ready(function() 
	    { 
	        $("#myTable").tablesorter();  
	    } 
	);
	
	$(document).ready(function() 
		    { 
				$( "#accordion" ).accordion({event: "click hoverintent"}); 
		    } 
	);
	
	$.event.special.hoverintent = {
		    setup: function() {
		      $( this ).bind( "mouseover", jQuery.event.special.hoverintent.handler );
		    },
		    teardown: function() {
		      $( this ).unbind( "mouseover", jQuery.event.special.hoverintent.handler );
		    },
		    handler: function( event ) {
		      var currentX, currentY, timeout,
		        args = arguments,
		        target = $( event.target ),
		        previousX = event.pageX,
		        previousY = event.pageY;
		 
		      function track( event ) {
		        currentX = event.pageX;
		        currentY = event.pageY;
		      };
		 
		      function clear() {
		        target
		          .unbind( "mousemove", track )
		          .unbind( "mouseout", clear );
		        clearTimeout( timeout );
		      }
		 
		      function handler() {
		        var prop,
		          orig = event;
		 
		        if ( ( Math.abs( previousX - currentX ) +
		            Math.abs( previousY - currentY ) ) < 7 ) {
		          clear();
		 
		          event = $.Event( "hoverintent" );
		          for ( prop in orig ) {
		            if ( !( prop in event ) ) {
		              event[ prop ] = orig[ prop ];
		            }
		          }
		          // Prevent accessing the original event since the new event
		          // is fired asynchronously and the old event is no longer
		          // usable (#6028)
		          delete event.originalEvent;
		 
		          target.trigger( event );
		        } else {
		          previousX = currentX;
		          previousY = currentY;
		          timeout = setTimeout( handler, 100 );
		        }
		      }
		 
		      timeout = setTimeout( handler, 100 );
		      target.bind({
		        mousemove: track,
		        mouseout: clear
		      });
		    }
		  };
	

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

  #accordion-resizer {
    padding: 10px;
    width: 350px;
    height: 220px;
  }


</style>

</head>
<body>
<a href="success.jsp" title="Home"><img src="img/home.png" width="20" height="20" border="0"/></a><BR>
<font color="Green"> Displaying <c:out value="${fn:length(details_list)}"/> results </font>
<%-- <table id="myTable" class="bordered">
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
</table> --%>

<!-- <form class="form-signin" role="form" name="filterform" action="FilterController" method="post" >

<input id="datepicker" type="text" name="DOJ" SIZE="20" class="form-control" placeholder="Date Of Journey" required>

<input id="autocomplete1" type="text" name="Train" SIZE="20" class="form-control" placeholder="Train Name" required>

<INPUT TYPE="SUBMIT" VALUE="Submit" class="btn btn-lg btn-success">

</form> -->


<div id="accordion" >
 
<c:forEach items="${details_list}" var="d1" varStatus="status"> 
 <h2>Journey on <c:out value="${d1.DOJ}"/> by <c:out value="${d1.train}"/> </h2>
   <div><p> <c:out value="${d1.comments}"></c:out> </p></div>
 
</c:forEach>

</div>


</body>
</html>