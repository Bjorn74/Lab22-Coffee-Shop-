<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Coffee Man Can</title>
</head>
<body>
	<br>
	<div style="text-align:center">
		<table border=1>
<c:forEach var="myVar" items="${iList}">
<tr>
<td>${myVar.itemName}</td>
<td>${myVar.itemDesc}</td>
<td>${myVar.itemPrice}</td>
</tr>
</c:forEach>
	</table>
	</div>
</body>
</html>