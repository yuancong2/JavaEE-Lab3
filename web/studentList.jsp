<%-- 
    Document   : studentList
    Created on : 2024-11-20, 15:14:27
    Author     : 12906
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="GBK">
    <title>学员列表</title>
</head>
<body>
<h2>学员列表</h2>
<table border="1">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>电话</th>
        <th>报名日期</th>
        <th>状态</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.phone}</td>
            <td>${student.registrationDate}</td>
            <td>${student.status}</td>
        </tr>
    </c:forEach>
    <c:if test="${empty students}">
        <tr>
            <td colspan="5">没有学员信息</td>
        </tr>
    </c:if>
</table>
<a href="addStudent.jsp">添加新学员</a>
</body>
</html>



