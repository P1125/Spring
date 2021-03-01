<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>emp/deptList.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<form action="deptList" method="post" name="frm">
		<h3>직원목록</h3>
		<c:forEach items="${dlist }" var="dept">
	${dept.department_id } ${dept.department_name} ${dept.manager_id}<br>
		</c:forEach>
		<input name="department_id" value="${dept.department_id }">:
		부서 id<br> <input name="department_name"
			value="${dept.department_name }">: 부서 name<br> <input
			name="manager_id" value="${dept.manager_id }">: 부서 manager<br>
		<button type="submit">부서 등록</button>

	</form>
</body>
</html>