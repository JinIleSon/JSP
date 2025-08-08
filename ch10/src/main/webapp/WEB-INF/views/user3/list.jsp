<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user3::list</title>
	</head>
	<body>
		<h3>MySQL User3 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user3/register.do">등록하기</a>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>생년월일</td>
				<td>휴대폰</td>
				<td>주소</td>
				<td>관리</td>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.uid}</td>
				<td>${dto.name}</td>
				<td>${dto.birth}</td>
				<td>${dto.hp}</td>
				<td>${dto.addr}</td>
				<td>
					<a href="/ch10/user3/modify.do?uid=${dto.uid}">수정</a>
					<a href="/ch10/user3/delete.do?uid=${dto.uid}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>