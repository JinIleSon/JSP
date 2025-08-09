<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bank/Account::list</title>
	</head>
	<body>
		<h3>Bank/Account 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/bank/account/register.do">등록하기</a>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>타입</td>
				<td>이름</td>
				<td>계좌번호</td>
				<td>잔액</td>
				<td>날짜</td>
				<td>관리</td>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.acc_no}</td>
				<td>${dto.acc_type}</td>
				<td>${dto.acc_name}</td>
				<td>${dto.acc_cid}</td>
				<td>${dto.acc_balance}</td>
				<td>${dto.acc_date}</td>
				<td>
					<a href="/ch10/bank/account/modify.do?acc_no=${dto.acc_no}">수정</a>
					<a href="/ch10/bank/account/delete.do?acc_no=${dto.acc_no}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>