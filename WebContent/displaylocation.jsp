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
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/traveldataentry.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script> 
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB_Tg3D8gm1S4YoqAH65i_HENA75UePGUk&sensor=false"> </script>


<title>Journey Map View</title>
</head>
<body>
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
                <li><a href="DisplayAllController">Records</a></li>
                <li class="active"><a href="DisplayStatisticsController">Statistics</a></li>
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
	</div>
 		  
 		  
          <div class="inner cover">
          	<h5 class="masthead-brand">Total distance for this journey is <b style="color: #336699;"><c:out value="${total_distance}"/></b> KM  Keep Traveling!!!</h5>
			<div class="row">
				<div  id="map-canvas" style="width: 80%; height: 500px;"> </div>
			</div>
            
          <div class="mastfoot">
            <div class="inner">
              <p></p>
            </div>
          </div>

        </div>

      </div>

    </div>
<script>

	var locations_plot=[
	
	<c:forEach items="${station_loc_list}" var="d1"> 	
	new google.maps.LatLng(<c:out value="${d1.latitude}"></c:out>,<c:out value="${d1.longitude}"></c:out>),
	</c:forEach>
	
	];

	var map = new google.maps.Map(document.getElementById("map-canvas"), {
		zoom: 4,
	  	scrollwheel:true,
	  	center: new google.maps.LatLng(24.730852, 79.278573),
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