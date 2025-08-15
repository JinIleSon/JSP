<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>거래목록</title>
	</head>
	<body>
		<h3>거래목록</h3>
		
		<a href="/ErdBank">처음으로</a>
		
		<table border="1">
			<tr>
				<th>일련번호</th>
				<th>계좌번호</th>
				<th>고객구분</th>
				<th>총액</th>
				<th>시간</th>
				<th>관리</th>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
				<tr>  <!--  손보기 -->
					<td>${dto.t_no}</td>
					<td>${dto.t_a_no}</td>
					<td>${dto.t_dist}</td>
					<td>${dto.t_amount}</td>
					<td>${dto.t_datetime}</td>
					<td>
						<a href="#">수강신청</a>
					</td>
				</tr>
			</c:forEach>
		</table>		
	</body>
</html>