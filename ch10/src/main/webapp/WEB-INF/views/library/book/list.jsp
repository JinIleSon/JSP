<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>library/book::list</title>
	</head>
	<body>
		<h3>Library/Book 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/library/book/register.do">등록하기</a>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>제목</td>
				<td>작가</td>
				<td>출판사</td>
				<td>대출가능</td>
				<td>등록일</td>
				<td>관리</td>
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<tr>
				<td>${dto.book_id}</td>
				<td>${dto.title}</td>
				<td>${dto.author}</td>
				<td>${dto.publisher}</td>
				<td>${dto.available}</td>
				<td>${dto.reg_date}</td>
				<td>
					<a href="/ch10/library/book/modify.do?book_id=${dto.book_id}">수정</a>
					<a href="/ch10/library/book/delete.do?book_id=${dto.book_id}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>