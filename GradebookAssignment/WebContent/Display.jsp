<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ms. Mackleberry's Gradebook</title>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <style> 
  body {text: white; background-color: white;  text-align: center; }
   h1 {text: white;}
   h2{text:white;}
   </style>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="jumbotron"> 
<div class="container">
  <h1>Welcome to Ms. Mackleberry's Gradebook!</h1>
</div>
</div>

<form action="InputName" method="post">
<br></br>

Please enter the assignment name and grade and submit each time.<br>
Once complete, you may check the input history and class average.</br>
<br>
Assignment Name:<br>
<input type="edit" name="Assignment"><br>
<br>
Grade:<br>
<input type="edit" name="grade"><br>
<br>
<input href="InputName" type=submit name=submit value="Submit"> </input>
</form>
<form action="GradeEnter" method="post">
<br>
<input href="GradeEnter" type=submit name=submit value="Grade Average"> </input>
</form>
    
</body>
</html>