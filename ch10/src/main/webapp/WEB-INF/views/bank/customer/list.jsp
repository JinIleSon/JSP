<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bank/Customer::list</title>
	</head>
	<body>
		<h3>Bank/Customer 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/bank/customer/register.do">등록하기</a>
		<table border="1">
			<tr>
				<td>계좌번호</td>
				<td>이름</td>
				<td>타입</td>
				<td>전화번호</td>
				<td>주소</td>
				<td>관리</td>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.c_id}</td>
				<td>${dto.c_name}</td>
				<td>${dto.c_type}</td>
				<td>${dto.c_hp}</td>
				<td>${dto.c_addr}</td>
				<td>
					<a href="/ch10/bank/customer/modify.do?c_id=${dto.c_id}">수정</a>
					<a href="/ch10/bank/customer/delete.do?c_id=${dto.c_id}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>