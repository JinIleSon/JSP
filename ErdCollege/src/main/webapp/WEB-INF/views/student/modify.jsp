<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생수정</title>
	</head>
	<body>
		<h3>학생수정</h3>
		
		<a href="/ErdCollege">처음으로</a>
		<a href="/ErdCollege/student/list.do">목록으로</a>
		<form action="/ErdCollege/student/modify.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="stdNo" value="${dto.stdNo}" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="stdName" value="${dto.stdName}"  placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="stdHp" value="${dto.stdHp}" placeholder="전화번호(- 포함) 입력"/></td>
				</tr>
				<tr>
					<td>학년</td>
					<td><input type="number" name="stdYear" value="${dto.stdYear}" placeholder="학년 입력"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="stdAddress" value="${dto.stdAddress}" placeholder="주소 입력"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>