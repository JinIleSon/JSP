<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>조회</title>
	</head>
	<body>
		<h3>조회</h3>
		
		<a href="/ErdBank_copy">처음으로</a>
		<a href="/ErdBank_copy/account/list.do">목록이동</a>
		<table border="1">
			<tr>
				<td>일련번호</td>
				<td>계좌번호</td>
				<td>고객구분</td>
				<td>총액</td>
				<td>시간</td>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.t_no}</td>
				<td>${dto.t_a_no}</td>
				<td>${dto.t_dist}</td>
				<td>${dto.t_amount}</td>
				<td>${dto.t_datetime}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>