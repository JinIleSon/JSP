<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::list</title>
		
		<script>
			document.addEventListener('DOMContentLoaded', function () {
				
				const table = documen.getElementsByTagName('table')[0];
				
				// 목록 데이터 요청
				fetch('/ch10/js/user1/getUser1All.do')
					.then(res => res.json())
					.then(data => {
						console.log(data);
						
						for(const user of data){
						
							const tr = `<tr>
										<td>\${user.user_id}</td>
										<td>\${user.name}</td>
										<td>\${user.hp}</td>
										<td>\${user.age}</td>
										<td>
											<a href='#' class='modify'>수정</a>
											<a href='#' class='remove'>삭제</a>
										</td>
								   </tr>`;
								   
						
							table.insertAdjacentHTML('beforeEnd', tr);
						}
					})
					.catch(err => {
						console.log(err);
					});
			});
		</script>
	</head>
	<body>
		<h3>MySQL User1 목록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user1/register.do">등록하기</a>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>나이</th>
				<th>관리</th>
			</tr>
			<c:forEach var="dto" items="${requestScope.dtoList}">
			<tr>
				<td>${dto.uid}</td>
				<td>${dto.name}</td>
				<td>${dto.hp}</td><!-- 표현언어에서 getter 호출 안 하고 직접 속성 참조해서 출력 가능 -->
				<td>${dto.age}</td>
				<td>
					<a href="/ch10/user1/modify.do?uid=${dto.uid }">수정</a>
					<a href="/ch10/user1/delete.do?uid=${dto.uid }">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>		
	</body>
</html>