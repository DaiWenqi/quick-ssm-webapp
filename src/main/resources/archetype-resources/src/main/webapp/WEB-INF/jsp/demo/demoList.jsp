<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xuzhuo
  Date: 2017/9/7
  Time: 下午12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${demoList}" var="demo" varStatus="i">
        <tr>
            <td><c:out value="${demo.id}"/></td>
            <td><c:out value="${demo.name}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
