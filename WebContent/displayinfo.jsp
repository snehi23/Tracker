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
<title>Journey Details</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/traveldataentry.css" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="css/simplePagination.css">
<link href="css/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.4.custom.min.js"></script> 

<script>

	$(document).ready(function() 
		    { 
				$( "#accordion" ).accordion({collapsible:true, heightStyle:"content"}); 
		    } 
	);
	

</script>
</head>
<body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Hello ${sessionScope['userid']} !</h3>
              <ul class="nav masthead-nav">
                <!-- <li><a href="#">Home</a></li> -->
                <li><a href="success.jsp">Add a Journey</a></li>
                <li class="active"><a href="DisplayAllController">Records</a></li>
                <li><a href="DisplayStatisticsController">Statistics</a></li>
                <!-- <li><a href="DisplayLocationController">Locations</a></li> -->
                <li><a href="LogoutController">LogOut</a></li>
                <li><a href="#"><form action='RefreshLocationController' method='post'>
					<input  style="background-image: url(img/refresh.png); background-color: transparent;
						background-repeat: no-repeat;
						background-position: 0px 0px;
						border: none;
						cursor: pointer;
						height: 35px;
						width: 30px;
						padding-left: 16px;
						vertical-align: middle;" title="Force Refresh" type="submit" value="">
					</form></a>
				</li>
              </ul>
            </div>
          </div>

          <div class="inner cover" id="records">
            <h1 class="cover-heading">Displaying <c:out value="${fn:length(details_list)}"/> results</h1>
				<div id="add-another-entry"><h5>${requestScope['Record_Confirmation']}</h5></div>
			<div id="accordion" > <!-- TODO: 1. Retaining formatting of text in comments 2. Adding link to delete the record -->
				<c:forEach items="${details_list}" var="d1" varStatus="status">
				<ul class="record_heading">
					<li><h3>Journey on <c:out value="${d1.DOJ}"/></h3></li>
					<li><h3><c:out value="${d1.train}"/></h3></li>
					
					
				</ul>
				<div class="comments"><p> <c:out value="${d1.comments}"></c:out> </p>
				
				<a href="DeleteRecordController?recordid=<c:out value="${d1.train_journey_id}"/>" onclick="return confirm('Are you sure you want to delete this journey?');">Delete Journey</a>
				
				<a href="UserInputEditController?recordid=<c:out value="${d1.train_journey_id}"/>">Edit Journey</a>
				
				<a href="ShowMapController?Train_Number=<c:out value="${d1.train_Number}"/>&From_Station=<c:out value="${d1.from_Station}"/>&To_Station=<c:out value="${d1.to_Station}"/>">Show on Map</a>
				
				</div>					 
				</c:forEach>
			</div>
			
			
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p></p>
            </div>
          </div>

        </div>

      </div>

    </div>
</body>
</html>