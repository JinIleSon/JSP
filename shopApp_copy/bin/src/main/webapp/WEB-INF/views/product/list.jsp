<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품목록</title>
	</head>
	<body>
		<h3>상품목록</h3>
		
		<a href="/shopApp_copy">처음으로</a>
		<a href="/shopApp_copy/customer/register.do">등록하기</a>
		<c:if test="${empty sessUser}">
			<form action="/shopApp_copy/customer/login.do" method="GET">
				<input type="text" name="custid" style="width:100px;"/>
				<input type="submit" value="로그인"/>
			</form>
		</c:if>
		<c:if test="${not empty sessUser}">
			<p>
				${sessUser.name}(${sessUser.custid})님 반갑습니다.
			</p>
			<a href="/shopApp_copy/customer/logout.do">로그아웃</a>
		</c:if>
		<table border="1">
			<tr>
				<td>상품번호</td>			
				<td>상품명</td>			
				<td>재고량</td>			
				<td>가격</td>			
				<td>제조사</td>			
				<td>수량</td>			
				<td>주문</td>			
			</tr>
			<c:forEach var="dto" items="${dtoList}">
			<form action="/shopApp_copy/order/register.do" method="post">
				<tr>
					<td>${dto.prodNo}</td>			
					<td>${dto.prodName}</td>			
					<td>${dto.stock}</td>			
					<td>${dto.price}</td>			
					<td>${dto.company}</td>			
					<td>
						<input type="hidden" name="prodNo" value="${dto.prodNo}"/>
						<input type="number" name="prodCount" style="width:40px;"/>
					</td>			
					<td><input type="submit" value="주문하기"/></td>	
				</tr>
			</form>
			</c:forEach>
		</table>
	</body>
</html>