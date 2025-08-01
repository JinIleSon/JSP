<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>shop/product::modify</title>
	</head>
	<body>
		<h3>shop/product 수정</h3>
		<a href="/ch10/">처음으로</a>
		<a href="/ch10/shop/product/list.do">목록이동</a>
		
		<form action="/ch10/shop/product/modify.do" method="post">
			<table border="1">
				<tr>
					<td>번호</td>
					<td><input type="text" name="pname" value="${}" placeholder="번호 입력"/></td>
				</tr>
				<tr>
					<td>제품이름</td>
					<td><input type="text" name="pname" value="${}" placeholder="번호 입력"/></td>
				</tr>
				<tr>
					<td>재고량</td>
					<td><input type="text" name="pname" value="${}" placeholder="번호 입력"/></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="pname" value="${}" placeholder="번호 입력"/></td>
				</tr>
				<tr>
					<td>회사</td>
					<td><input type="text" name="pname" value="${}" placeholder="번호 입력"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>