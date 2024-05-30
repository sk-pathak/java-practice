<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="add.jsp" method="post">
    <input type="text" name="num1">
    <input type="text" name="num2">
    <input type="submit" name="submit" value="Submit">
</form>
<br/>
</body>
</html>