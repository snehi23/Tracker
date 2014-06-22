<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
<title>Success</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/traveldataentry.css" rel="stylesheet">
<link href="css/dataentry_form.css" rel="stylesheet">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.min.css">
<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
<link rel="stylesheet" type="text/css" href="css/chosen.css" />
	<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="js/jquery.autocomplete.js"></script>
	<script src="js/chosen.jquery.js"></script>


<script>
$(function() {
	
    $("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' }).val();
    
  });
  
$(document).ready(function(){
	
	$("#From").chosen();
	$("#To").chosen();

});


  
  $(document).ready(function() {
    $("#autocomplete1").autocomplete("getTrain.jsp");
    //$("#autocomplete2").autocomplete("getStation.jsp");
    //$("#autocomplete3").autocomplete("getStation.jsp");
});
    
function validateForm() {

	var formValid = true;
    
    	
	var a= document.getElementById("From");	
	var b= document.getElementById("To");
	
	var aa = a.options[a.selectedIndex].text;
	var bb = b.options[b.selectedIndex].text;
	
	
	var xx="";
	var yy="";

	if(aa=="Please Select From Station") {
		document.getElementById("From_error").innerHTML="Please choose From Station";
		formValid = false;
		
	} else {
		
		document.getElementById("From_error").innerHTML="";
	}
	
	if(bb=="Please Select To Station") {
		
		document.getElementById("To_error").innerHTML="Please choose To Station";
		formValid = false;
	} else {
		
		document.getElementById("To_error").innerHTML="";
	}
	
	// alert(aa); alert(bb);
	<c:forEach var="d" items="${station_code}" varStatus="status" > 

		var station = "<c:out value="${d.key}"/>";
			
		 	if(aa==station) {
			 		
			 	xx = "<c:out value="${d.value}"/>";
			 	//alert(xx);
			 
		 	}	
		 
		 	if(bb==station) {
		 		
			 	yy = "<c:out value="${d.value}"/>";
			 	//alert(yy);
			 
		 	}
		
		 
	</c:forEach>

	var cc = parseInt(xx);
	var dd = parseInt(yy);

	if(cc>=dd) {
		
		document.getElementById("Choice_error").innerHTML="Please choose wisely SRC -> DEST";
		formValid = false;
		
		
	} else {
		
		document.getElementById("Choice_error").innerHTML="";
		
	}
	
		if(formValid) {	
		return true;
	} else {return false;}
	
}

function nobacktrack() {
	
	history.forward();
}

  
</script>

</head>
<body onload="">
    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Hello ${sessionScope['userid']} !</h3>
              <ul class="nav masthead-nav">
                <!-- <li><a href="#">Home</a></li> -->
                <li class="active"><a href="#">Add a Journey</a></li>
                <li><a href="DisplayAllController">Records</a></li>
                <li><a href="DisplayStatisticsController">Statistics</a></li>
                <!-- <li><a href="DisplayLocationController">Locations</a></li> -->
                <li><a href="LogoutController">LogOut</a></li>
                <!-- <li><a href="#"><form action='RefreshLocationController' method='post'>
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
				</li> -->
              </ul>
            </div>
          </div>

          <div class="inner cover">
            <h1 class="cover-heading">Enter Your Journey Details</h1>
            <div id="add-another-entry"><h5>${requestScope['Record_Confirmation']}</h5></div>
			<div class="row">
			<form class="form-signin" name="form" action="UserInputController" METHOD="post" onsubmit="return validateForm()">
				<div id="inner-left" class="col-lg-6">
				<p class="lead">
					<input type="text" id="PNR" name="PNR" SIZE="20" class="form-control" placeholder="Enter Your PNR or Fill out following fields" required autofocus>
					<button id="fetch1" type="button" onclick="javascript: return getPNRValue();" class="btn btn-lg btn-success">fetch details</button>
					<div style="color:red"><h5>${requestScope['Invalid PNR']}</h5></div>
					<!--  <ul id="berth-input-list"> -->
					<div id="trains">
					<input id="autocomplete1" type="text" name="Train" SIZE="20" class="form-control" placeholder="Train Name" required value="${details.train}${details.train_Number}">
					<button id="fetch" type="button" onclick="javascript: return getInputValue();" class="btn btn-lg btn-success">fetch codes</button>
					</div>
					<!--  </ul> -->
					<div id="train_error" style="color:red"></div>
					<input id="datepicker" type="text" name="DOJ" SIZE="20" class="form-control" placeholder="Date Of Journey" required value="${details.DOJ}">
					<!-- <input id="autocomplete2" type="text" name="From" SIZE="20" class="form-control" placeholder="Station From" required> -->
					<div id="From_error" style="color:red"></div><div id="To_error" style="color:red"></div><div id="Choice_error" style="color:red"></div>
					<select name="From" id="From" required onchange=""> 
						<option value="" selected="selected" disabled="disabled">Please Select From Station</option>
						<option value="" selected="selected" value="${details.from_Station}">${details.from_Station}</option>
						<c:forEach var="d" items="${station_code}">  
							<option value="${d.key}">${d.key}</option>  	
							 
						</c:forEach>  
						
					</select>
					<select name="To" id="To" required onchange=""> 
					<option value="" selected="selected" disabled="disabled">Please Select To Station</option>
					<option value="" selected="selected" value="${details.to_Station}">${details.to_Station}</option>
					<c:forEach var="d" items="${station_code}">  
  						<option value="${d.key}">${d.key}</option>  	
      					 
   					</c:forEach>  
					
					</select>
					
					<!-- <input id="autocomplete3" type="text" name="To" SIZE="20" class="form-control" placeholder="Station To" required> -->
					
					<div id="class-input">
						<ul id="class-input-list">
							<li>Class :</li>
							<li><input class="radio-control" TYPE="RADIO" NAME="classes" VALUE="1-AC" ${details.classes == '1A' ? 'checked' : ''}>1-AC</li> 
							<li><input class="radio-control" TYPE="RADIO" NAME="classes" VALUE="2-AC" ${details.classes == '2A' ? 'checked' : ''}>2-AC</li>
							<li><input class="radio-control" TYPE="RADIO" NAME="classes" VALUE="3-AC" ${details.classes == '3A' ? 'checked' : ''}>3-AC</li>
							<li><input class="radio-control" TYPE="RADIO" NAME="classes" VALUE="SL" ${details.classes == 'SL' ? 'checked' : ''}>SL</li>
							<li><input class="radio-control" TYPE="RADIO" NAME="classes" VALUE="Gen" ${details.classes == 'GN' ? 'checked' : ''}>Gen</li>
						</ul>
						<div id="Class_error" style="color:red"></div>
					</div>
					<div id="berth-input">
						<ul id="berth-input-list">
							<li>Berth :</li>
							<li><input class="radio-control" TYPE="RADIO" NAME="berth" VALUE="LB" ${details.berth == 'LB' ? 'checked' : ''}>LB</li> 
							<li><input class="radio-control" TYPE="RADIO" NAME="berth" VALUE="MB" ${details.berth == 'MB' ? 'checked' : ''}>MB</li>
							<li><input class="radio-control" TYPE="RADIO" NAME="berth" VALUE="UB" ${details.berth == 'UB' ? 'checked' : ''}>UB</li>
							<li><input class="radio-control" TYPE="RADIO" NAME="berth" VALUE="SL" ${details.berth == 'SL' ? 'checked' : ''}>SL</li>
							<li><input class="radio-control" TYPE="RADIO" NAME="berth" VALUE="SU" ${details.berth == 'SU' ? 'checked' : ''}>SU</li>
						</ul>
						<div id="Berth_error" style="color:red"></div>
					</div>
				</p>
				</div>
				<div id="inner-right" class="col-lg-6">
				<p class="lead">
					<textarea id="memorable-moments" type="text" name="comments" class="form-control" placeholder="Memorable Moments" style="resize:none" value="NA"></textarea> 
					<div id="Comments_error" style="color:red"></div>
					<div id="buttons-control">
						<ul id="submit-buuton-input-list">
							<li><INPUT TYPE="SUBMIT" VALUE="Submit" class="btn btn-lg btn-success"></li>
							<li><INPUT TYPE="RESET" VALUE="Reset" class="btn btn-lg btn-success"></li>
						</ul>
					</div>
				</p>
				</div>
			</form>
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
<script> 
function getInputValue(){
    var inputValue = document.getElementById('autocomplete1').value;
	url = 'FetchStationCodeController?Train_Name=';  		
    if(inputValue != ""){
		  url += inputValue;			
		  window.location.href = url;
		  return url;
    } else {
		document.getElementById("train_error").innerHTML="Please select train";
		return false;
	}
}
function getPNRValue(){
    var inputValue = document.getElementById('PNR').value;
	url = 'FetchDetailsController?PNR=';  		
    if(inputValue != ""){
		  url += inputValue;			
		  window.location.href = url;
		  return url;
    } else {
		document.getElementById("train_error").innerHTML="Please Enter PNR";
		return false;
	}
}
</script>

</html>