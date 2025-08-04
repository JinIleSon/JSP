<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>College/Course::list</title>
	</head>
	<body>
		<h3>College/Course 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/course/register.do">등록하기</a>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>강좌이름</td>
				<td>권수</td>
				<td>학과</td>
				<td>관리</td>
			</tr>
			<tr>
				<td>${dto.cs_id}</td>
				<td>${dto.cs_name}</td>
				<td>${dto.cs_credit}</td>
				<td>${dto.cs_dept}</td>
				<td>
					<a href="/ch10/college/course/modify.do?cs_id=${dto.cs_id}">수정</a>
					<a href="/ch10/college/course/delete.do?cs_id=${dto.cs_id}">삭제</a>
				</td>
			</tr>
		</table>
	</body>
</html>