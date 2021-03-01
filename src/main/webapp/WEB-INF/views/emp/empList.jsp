<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>emp/empList.jsp</title>
</head>
<body>
<h3>사원목록</h3>
<c:forEach items="${list }" var="emp">
	${emp.first_name } ${emp.email} ${emp.manager_id}<br>
</c:forEach>
</body>
</html>