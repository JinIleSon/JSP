<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>college/course::register</title>
	</head>
	<body>
		<h3>college/course 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/college/course/list.do">목록이동</a>
		<form action="/ch10/college/course/register.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="cs_id" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>강좌명</td>
					<td><input type="text" name="cs_name" placeholder="강좌명 입력"/></td>
				</tr>
				<tr>
					<td>학점</td>
					<td><input type="text" name="cs_credit" placeholder="학점 입력"/></td>
				</tr>
				<tr>
					<td>학과</td>
					<td><input type="text" name="cs_dept" placeholder="학과 입력"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="등록하기"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>