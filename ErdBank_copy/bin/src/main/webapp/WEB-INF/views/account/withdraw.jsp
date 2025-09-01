<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>계좌출금</title>
	</head>
	<body>
		<h3>계좌출금</h3>
		
		<a href="/ErdBank_copy">처음으로</a>
		<a href="/ErdBank_copy/account/list.do">목록이동</a>
		<form action="/ErdBank_copy/account/withdraw.do" method="post">
			<table border="1">
				<tr>
					<td>계좌번호</td>
					<td><input type="text" name="t_a_no" value="${dto.a_no}" placeholder="계좌번호 입력"/></td>
				</tr>
				<tr>
					<td>입금주</td>
					<td><input type="text" name="c_name" value="${dto.c_name}" placeholder="입금주 입력"/></td>
				</tr>
				<tr>
					<td>입금액</td>
					<td><input type="number" name="t_amount" placeholder="입금액 입력"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="출금하기"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>