<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>수강목록</title>
	</head>
	<body>
		<h3>수강목록</h3>
		
		<a href="/ErdCollege_copy">처음으로</a>
		<table border="1">
			<tr>
				<td>학번</td>
				<td>수강번호</td>
				<td>중간고사 점수</td>
				<td>기말고사 점수</td>
				<td>총점</td>
				<td>학점</td>
				<td>관리</td>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.regStdNo}</td>
				<td>${dto.regLecNo}</td>
				<td>${dto.regMidScore}</td>
				<td>${dto.regFinalScore}</td>
				<td>${dto.regTotalScore}</td>
				<td>${dto.regGrade}</td>
				<td>
					<a href="#">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>	
	</body>
</html>