<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>library/book::register</title>
	</head>
	<body>
		<h3>library/book 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/library/book/list.do">목록이동</a>
		<form action="/ch10/library/book/register.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="book_id" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>책제목</td>
					<td><input type="text" name="title" placeholder="책제목 입력"/></td>
				</tr>
				<tr>
					<td>작가</td>
					<td><input type="text" name="author" placeholder="작가 입력"/></td>
				</tr>
				<tr>
					<td>출판사</td>
					<td><input type="text" name="publisher" placeholder="출판사 입력"/></td>
				</tr>
				<tr>
					<td>대출가능</td>
					<td><input type="text" name="available" placeholder="대출가능(Y,N) 입력"/></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="date" name="reg_date"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="등록하기"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>