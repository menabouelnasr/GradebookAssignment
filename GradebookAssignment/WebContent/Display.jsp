<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <style> 
  body {text: white; background-color: white;  text-align: center; }
   p {background-color: white;}
   h1{text:white; text-aligh-left;}
   </style>
<title>Ms. Mackleberry's Gradebook</title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="jumbotron"> 
<div class="container">
  <h1>Welcome to Ms. Mackleberry's Gradebook!</h1>
</div>
<form action="GradeEnter" method="post">
<input  type=submit name=submit value="Enter Gradebook"> </input>
</form>
</div>
</nav>
<form action="InputName" method="post">
<p>
Please enter the assignment name and grade and submit each time.<br>
To check your input history or class average, you may enter the gradebook by clicking above.</br></p>
<br>
Assignment Name:<br>
<input type="edit" name="Assignment"><br>
<br>
Grade:<br>
<input type="edit" name="grade"><br>
<br>
<input type=submit name=submit value="Submit"> </input>
</form>


    
</body>
</html>