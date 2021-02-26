<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>emp/empList.jsp</title>
</head>
<body>
<h3>직원목록</h3>
<c:forEach items="${list }" var="dept">
	${dept.department_id } ${dept.department_name} ${dept.salary}<br>
</c:forEach>
</body>
</html>