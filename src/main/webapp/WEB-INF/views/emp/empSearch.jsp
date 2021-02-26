<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$(".btnSelect").on("click", function() {
			//var empid = $(this).parent().find("span").first().text(); // val값을 안넣어서 text로 했다.
			//var empid = $(this).closest(".div"); // row가오든 div가오든 상관없다
			var empid = $(this).closest("div").find("span").eq(0).html();// html 값을지정.
			var firstname = $(this).closest("div").find("span").eq(1).html();
			//console.log(empid)
			opener.document.frm.manager_id.value = empid;
			opener.document.frm.manager_name.value = firstname;
			$(opener.document).find('[name=manager_id]').val(empid);
			$(opener.document).find('[name=manager_name]').val(firstname);
			window.close();
		});
	});
</script>

</head>
<body>
<h3>사원검색</h3>
	<c:forEach items="${empList }" var="emp">
	<div class="row">
		사번 : <span>${emp.employee_id } </span> 
		/ 이름 : <span>${emp.first_name } </span> 
		/ 부서 : <span>${emp.job_id } </span>
	<button type="button" class="btnSelect">선택</button>
	<br>
	</div>	
	</c:forEach>
	
</body>
</html>