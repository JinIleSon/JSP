<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>bank/customer::modify</title>
	</head>
	<body>
		<h3>bank/customer 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/bank/customer/list.do">목록이동</a>
		<form action="/ch10/bank/customer/modify.do" method="post">
			<table border="1">
				<tr>
					<td>계좌번호</td>
					<td><input type="text" name="c_id" value="${dto.c_id}" placeholder="계좌번호 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="c_name" value="${dto.c_name}" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>타입</td>
					<td><input type="text" name="c_type" value="${dto.c_type}" placeholder="타입 입력"/></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="c_hp" value="${dto.c_hp}" placeholder="전화번호(- 포함) 입력"/></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="c_addr" value="${dto.c_addr}" placeholder="주소 입력"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="수정하기"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>