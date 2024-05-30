<%--@elvariable id="msg" type="jakarta"--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
${msg}
<c:out value="${msg}"/>

<sql:setDataSource var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost:5432/postgres" user="postgres" password="19209449"/>
<sql:query var="rs" dataSource="${db}">select * from cars;</sql:query>

<c:forEach items="${rs.rows}" var="car">
    <c:out value="${car.brand}"/>
    <c:out value="${car.model}"/>
    <c:out value="${car.year}"/><br/>
</c:forEach>
</body>
</html>