<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int i= Integer.parseInt(request.getParameter("num1"));
    int j= Integer.parseInt(request.getParameter("num2"));
    int result=i+j;
%>
<%= result%>
</body>
</html>
