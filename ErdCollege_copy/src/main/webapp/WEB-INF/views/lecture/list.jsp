<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>강좌목록</title>
	</head>
	<body>
		<h3>강좌목록</h3>
		
		<a href="/ErdCollege_copy">처음으로</a>
		<a href="/ErdCollege_copy/lecture/register.do">등록하기</a>
		<table border="1">
			<tr>
				<td>강좌번호</td>
				<td>강좌명</td>
				<td>학점</td>
				<td>시간</td>
				<td>강의실</td>
				<td>관리</td>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.lecNo}</td>
				<td>${dto.lecName}</td>
				<td>${dto.lecCredit}</td>
				<td>${dto.lecTime}</td>
				<td>${dto.lecClass}</td>
				<td>
					<a href="/ErdCollege_copy/register/register.do?lecNo=${dto.lecNo}">수강신청</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		
	</body>
</html>