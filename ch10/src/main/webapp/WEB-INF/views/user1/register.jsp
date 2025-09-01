<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user1::register</title>
	</head>
	<script>
		document.addEventListener('DOMContentLoaded', function(){
			const form = document.formUser1;
			
			form.addEventListener('submit', function(e){
				e.preventDefault();
				
				// JSON 생성
				const jsonData = {
					"user_id" : this.user_id.value,
					"name" : this.name.value,
					"hp" : this.hp.value,
					"age" : this.age.value,
				};
				
				console.log(jsonData);
				
				// 서버전송
				fetch('/ch10/js/user1/register.do', {
					method: 'POST',
					headers: {"Content-Type": "application/json"}, // 반드시 설정
					body: JSON.stringify(jsonData)
				})
					.then(res => res.json())
					.then(data => {
						console.log(data);
					})
					.catch(err => {
						console.log(err);
					});
			})
		})
	</script>
	<body>
		<h3>User1 등록</h3>
		
		<a href="/ch10">처음으로</a>
		<a href="/ch10/user1/list.do">목록이동</a>
		
		<form action="/ch10/user1/register.do" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" placeholder="아이디 입력"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" placeholder="이름 입력"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" placeholder="휴대폰 입력(- 포함)"/></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" placeholder="숫자 입력"/></td>
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