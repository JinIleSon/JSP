<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College/Student::list</title>
	</head>
	<body>
		<h3>College/Student 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/student/register.do">등록하기</a>
		<table border="1">
				<tr>
					<td>학번</td>
					<td>이름</td>
					<td>생년월일</td>
					<td>전공</td>
					<td>등록일</td>
					<td>관리</td>
				</tr>
				<c:forEach var="dto" items="${dtoList}">
				<tr>
					<td>${dto.stdno}</td>
					<td>${dto.name}</td>
					<td>${dto.birth}</td>
					<td>${dto.major}</td>
					<td>${dto.enr_date}</td>
					<td>
						<a href="/ch10/college/student/modify.do?stdno=${dto.stdno}">수정</a>
						<a href="/ch10/college/student/delete.do?stdno=${dto.stdno}">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>