<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>bank/account::modify</title>
	</head>
	<body>
		<h3>bank/account 수정</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/bank/account/list.do">목록이동</a>
		<form action="/ch10/bank/account/modify.do" method="post">
			<table border="1">
				<tr>
					<td>번호</td>
					<td><input type="text" name="acc_no" value="${dto.acc_no}" placeholder="번호(- 포함) 입력"/></td>
				</tr>
				<tr>
					<td>타입</td>
					<td><input type="text" name="acc_type" value="${dto.acc_type}" placeholder="타입 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="acc_name" value="${dto.acc_name}" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>계좌번호</td>
					<td><input type="text" name="acc_cid" value="${dto.acc_cid}" placeholder="계좌번호 입력"/></td>
				</tr>
				<tr>
					<td>잔액</td>
					<td><input type="text" name="acc_balance" value="${dto.acc_balance}" placeholder="잔액 입력"/></td>
				</tr>
				<tr>
					<td>생성일</td>
					<td><input type="date" name="acc_date" value="${dto.acc_date}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="수정하기"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>