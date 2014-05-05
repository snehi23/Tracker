<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.min.css">
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui-1.10.4.custom.min.js"></script>

<script>
$(function() {
	
    $("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' }).val();
    
  });
  
function validateForm() {
	
	
	var only_letters = /^[A-Za-z]{3,20}$/;
	var letters_num = /^[A-Za-z0-9]{3,20}$/;
	var only_caps = /^[A-Z]{1,4}$/;
	
	var a=document.forms["form"]["DOJ"].value;
	var x=document.forms["form"]["Train"].value;
	var y=document.forms["form"]["From"].value;
	var z=document.forms["form"]["To"].value;	
	var q=document.forms["form"]["comments"].value;

	var n = y.localeCompare(z);
	
	var radios = document.getElementsByName("classes");
	
	
    var formValid = true;
    var classValid = false;
	
	var pattern = new RegExp(/[~!#$%\^&*+=\-\[\]\\;,/{}|\\:<>\?]/);
	
	if (a==null || a=="")
  	{
  		document.getElementById("Date_error").innerHTML="Please enter Train Name";
  		formValid = false;
  		
  		
  	} else {
		
		document.getElementById("Date_error").innerHTML="";
		
	}
	
	if (x==null || x=="")
  	{
  		document.getElementById("Train_error").innerHTML="Please enter Train Name";
  		formValid = false;
  		
  		
  	} else {
		
		document.getElementById("Train_error").innerHTML="";
		
	}
	
	if(y==null || y=="")
  	{
		document.getElementById("From_error").innerHTML="Please enter From Station Code";
		formValid = false;
		
  	} else {
		
		document.getElementById("From_error").innerHTML="";
		
	}
	
	
	if(z==null || z=="")
  	{
		document.getElementById("To_error").innerHTML="Please enter To Station Code";
		formValid = false;
		
		
  	} else {
		
		document.getElementById("To_error").innerHTML="";
		
	}
	
	if(n==0) {
		
		document.getElementById("To_error").innerHTML="Dude same source and destination";
		formValid = false;
	} else {
		
		document.getElementById("To_error").innerHTML="";
		
	}
	
	
    var i = 0;
    while (!classValid && i < radios.length) {
        if (radios[i].checked) classValid = true;
        i++;        
    }

    if (!classValid) {
     document.getElementById("Class_error").innerHTML="Must check some option!";
     formValid = false;
    } else {
		
		document.getElementById("Class_error").innerHTML="";
		
	}
	
	if(q==null || q=="") {
		document.getElementById("Comments_error").innerHTML="Please enter Comments";
		formValid = false;
  	} else {
		
		document.getElementById("Comments_error").innerHTML="";
		
	}
	
	if (!only_letters.test(x)) {
		document.getElementById("Train_error").innerHTML="Train Name requires only letters";
		formValid = false;		
	} else {
		
		document.getElementById("Train_error").innerHTML="";
		
	}	
	
	if (!only_caps.test(y)) {
		document.getElementById("From_error").innerHTML="From Station code should in capital and of length 3-4 characters only";
		formValid = false;		
	} else {
		
		document.getElementById("From_error").innerHTML="";
		
	}
	
	if (!only_caps.test(z)) {
		document.getElementById("To_error").innerHTML="To Station code should in capital and of length 3-4 characters only";
		formValid = false;		
	} else {
		
		document.getElementById("To_error").innerHTML="";
		
	}
	
	if(pattern.test(q) || !letters_num.test(q)) {
		
		document.getElementById("Comments_error").innerHTML="Please only use standard alphanumerics";
		formValid = false;
	} else {
		
		document.getElementById("Comments_error").innerHTML="";
		
	}
	
	
	
	if(formValid) {	
		return true;
	} else {return false;}
	
}

  
</script>

</head>
<body>
 <marquee><font color="Green">Welcome ${sessionScope['user'].username}</font></marquee>
 
<H3>User Input</H3>



<form name="form" action="UserInputController" METHOD="post" onsubmit="return validateForm()">

<table class=".bordered">

<tr>
    	<td></td>
    	<td><div id="error" style="color:red"></div></td>
</tr>

<tr>
	<td>Date Of Journey :</td>
	<td><INPUT TYPE="TEXT" id='datepicker' NAME="DOJ" SIZE="20"></td>
	<td><div id="Date_error" style="color:red"></div></td>
	
</tr>

<tr>
	<td>Train  :</td>
	<td><INPUT TYPE="TEXT" NAME="Train" SIZE="20"></td>
	<td><div id="Train_error" style="color:red"></div></td>
	
</tr>

<tr>
	<td>From  :</td>
	<td><INPUT TYPE="TEXT" NAME="From" SIZE="20"></td>
	<td><div id="From_error" style="color:red"></div></td>
	
</tr>

<tr>
	<td>To  :</td>
	<td><INPUT TYPE="TEXT" NAME="To" SIZE="20"></td>
	<td><div id="To_error" style="color:red"></div></td>
	
</tr>


<tr> 
<td>Class :</td> 
<tr>

	<td><INPUT TYPE="RADIO" NAME="classes" VALUE="1-AC">1-AC </td>
	<td><INPUT TYPE="RADIO" NAME="classes" VALUE="2-AC">2-AC </td>
	<td><div id="Class_error" style="color:red"></div></td>
</tr>

<tr>
	
	<td><INPUT TYPE="RADIO" NAME="classes" VALUE="3-AC">3-AC </td>
	<td><INPUT TYPE="RADIO" NAME="classes" VALUE="SL">SL </td>
	<td><INPUT TYPE="RADIO" NAME="classes" VALUE="Gen">Gen </td>


<tr>

<td>Comments :</td>
<td><textarea NAME="comments" style="resize:none"></textarea> </td>
<td><div id="Comments_error" style="color:red"></div></td>
</tr>
<tr>

<td><INPUT TYPE="SUBMIT" VALUE="Submit"></td>
<td><INPUT TYPE="RESET" VALUE="Reset"></td>

</tr>

</table> 
</form>


<table>
<tr>
<td>
<form action='DisplayAllController' method='post'>

<input type="submit" value="Show My data">

</form>
</td>
<td>
<form action='RefreshLocationController' method='post'>

<input type="submit" value="Force Refresh">

</form>
</td>
<td>
<form action='DisplayLocationController' method='post'>

<input type="submit" value="Show Location">

</form>
</td>
<td>
<form action='DisplayStatisticsController' method='post'>

<input type="submit" value="Show Stats">

</form>
</td>
</tr>
</table>
</body>


</html>