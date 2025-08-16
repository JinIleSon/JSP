<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생목록</title>
	</head>
	<body>
		<h3>학생목록</h3>
		
		<a href="/ErdCollege_copy">처음으로</a>
		<a href="/ErdCollege_copy/student/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>휴대폰</td>
				<td>학년</td>
				<td>주소</td>
				<td>관리</td>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.stdNo}</td>
				<td>${dto.stdName}</td>
				<td>${dto.stdHp}</td>
				<td>${dto.stdYear}</td>
				<td>${dto.stdAddress}</td>
				<td>
					<a href="#">수정</a>
					<a href="#">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>