<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" isELIgnored="false" %>

<!Doctype html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h3>Add or Update User</h3>
<form action="adduser" method="post">
    Name: <input type="text" name="name">
    Username: <input type="text" name="username">
    Password: <input type="password" name="password">
    <input type="submit" value="Submit">
</form>
<hr/>
<h3>Find User By Username</h3>
<form action="getuser" method="post">
    Username: <input type="text" name="username">
    <input type="submit" value="Submit">
</form>
<hr/>
<h3>Find User By Name</h3>
<form action="getuserbyname" method="post">
    Name: <input type="text" name="name">
    <input type="submit" value="Submit">
</form>
<hr/>
<h3>Delete User By Username</h3>
<form action="deleteuser" method="post">
    Username: <input type="text" name="username">
    <input type="submit" value="Submit">
</form>
</body>
</html>