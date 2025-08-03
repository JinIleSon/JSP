<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>college/student::register</title>
	</head>
	<body>
		<h3>college/student 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/student/list.do">목록이동</a>
		<form action="/ch10/college/student/register.do" method="post">
			<table border="1">
				<tr>
					<td>번호</td>
					<td>
						<input type="text" name="stdno" placeholder="학번 입력"/>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" placeholder="이름 입력"/>
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<input type="text" name="birth" placeholder="생년월일(- 포함) 입력"/>
					</td>
				</tr>
				<tr>
					<td>전공</td>
					<td>
						<input type="text" name="major" placeholder="전공 입력"/>
					</td>
				</tr>
				<tr>
					<td>등록일</td>
					<td>
						<input type="text" name="enr_date"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value = "등록하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>