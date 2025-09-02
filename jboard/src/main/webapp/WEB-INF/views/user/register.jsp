<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_head.jsp" %>
<script>
	document.addEventListener('DOMContentLoaded', function(){
		
		const btnCheckUid = document.getElementById('btnCheckUid');
		const btnCheckNick = document.getElementById('btnCheckNick');
		const btnCheckEmail = document.getElementById('btnCheckEmail');

		const uidResult = document.getElementsByClassName('uidResult')[0];
		const nickResult = document.getElementsByClassName('nickResult')[0];
		const emailResult = document.getElementsByClassName('emailResult')[0];
		const hpResult = document.getElementsByClassName('hpResult')[0];
		
		const form = document.getElementsByTagName('form')[0];
		
		// 아이디 중복체크 요청
		btnCheckUid.addEventListener('click', function(e){
			
			
			const uid = form.uid.value;
			
			console.log('uid : ' + uid);
			
			fetch('/jboard/user/check.do?col=uid&value='+uid)
				.then(res => res.json())
				.then(data => {
					console.log(data);
					if(data.count > 0){
						uidResult.innerText = '이미 사용 중인 아이디 입니다.';
						uidResult.style.color = 'red';
					}else{
						uidResult.innerText = '사용 가능한 아이디 입니다.';
						uidResult.style.color = 'green';
					}
				})
				.catch(err => {
					console.log(err);
				});
		});
		
		// 별명 중복체크 요청
		btnCheckNick.addEventListener('click', function(e){
						
			const value = form.nick.value;
			
			console.log('value : ' + value);
			
			fetch('/jboard/user/check.do?col=nick&value='+value)
				.then(res => res.json())
				.then(data => {
					console.log(data);
					if(data.count > 0){
						nickResult.innerText = '이미 사용 중인 별명 입니다.';
						nickResult.style.color = 'red';
					}else{
						nickResult.innerText = '사용 가능한 별명 입니다.';
						nickResult.style.color = 'green';
					}
				})
				.catch(err => {
					console.log(err);
				});
		});
		
		
		// 이메일 중복체크 요청
		btnCheckEmail.addEventListener('click', function(e){
			
			
			const value = form.email.value;
			
			console.log('value : ' + value);
			
			fetch('/jboard/user/check.do?col=email&value='+value)
				.then(res => res.json())
				.then(data => {
					console.log(data);
					if(data.count > 0){
						emailResult.innerText = '이미 사용 중인 이메일 입니다.';
						emailResult.style.color = 'red';
					}else{
						emailResult.innerText = '사용 가능한 이메일 입니다.';
						emailResult.style.color = 'green';
					}
				})
				.catch(err => {
					console.log(err);
				});
		});
		
		// 휴대폰 중복 체크 
		form.hp.addEventListener('focusout', function(e){
			const value = form.hp.value;
			
			console.log('value : ' + value);
			
			fetch('/jboard/user/check.do?col=hp&value='+value)
				.then(res => res.json())
				.then(data => {
					console.log(data);
					if(data.count > 0){
						hpResult.innerText = '이미 사용 중인 휴대폰 입니다.';
						hpResult.style.color = 'red';
					}else{
						hpResult.innerText = '사용 가능한 휴대폰 입니다.';
						hpResult.style.color = 'green';
					}
				})
				.catch(err => {
					console.log(err);
				});
		});
	});
</script>

<main id="user">
    <section class="register">
        <form action="/jboard/user/register.do" method="post">
            <h2 class="tit">사이트 이용정보 입력</h2>
            <table border="1">                        
                <tr>
                    <td>아이디</td>
                    <td>
                        <input type="text" name="uid" placeholder="아이디 입력"/>
                        <button type="button" id="btnCheckUid"><img src="../images/chk_id.gif" alt="중복확인"/></button>
                        <span class="uidResult"></span>
                    </td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="pass1" placeholder="비밀번호 입력"/></td>
                </tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td><input type="password" name="pass2" placeholder="비밀번호 입력 확인"/></td>
                </tr>
            </table>

            <h2 class="tit">개인정보 입력</h2>
            <table border="1">                        
                <tr>
                    <td>이름</td>
                    <td>
                        <input type="text" name="name" placeholder="이름 입력"/>                        
                    </td>
                </tr>
                <tr>
                    <td>별명</td>
                    <td>
                        <p class="nickInfo">공백없는 한글, 영문, 숫자 입력</p>
                        <input type="text" name="nick" placeholder="별명 입력"/>
                        <button type="button" id="btnCheckNick"><img src="../images/chk_id.gif" alt="중복확인"/></button>
                        <span class="nickResult"></span>
                    </td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td>
                        <input type="email" name="email" placeholder="이메일 입력"/>
                        <button type="button" id="btnCheckEmail"><img src="../images/chk_auth.gif" alt="인증번호 받기"/></button>
                        <span class="emailResult"></span>
                        <div class="auth">
                            <input type="text" name="auth" placeholder="인증번호 입력"/>
                            <button type="button"><img src="../images/chk_confirm.gif" alt="확인"/></button>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>휴대폰</td>
                    <td>
                    	<input type="text" name="hp" placeholder="휴대폰 입력"/>
                    	<span class="hpResult"></span>
                    </td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td>
                        <input type="text" name="zip" placeholder="우편번호"/>
                        <button type="button"><img src="../images/chk_post.gif" alt="우편번호찾기"/></button>
                        <input type="text" name="addr1" placeholder="주소 검색"/>
                        <input type="text" name="addr2" placeholder="상세주소 입력"/>
                    </td>
                </tr>
            </table>

            <div>
                <a href="/jboard/user/login.do" class="btn btnCancel">취소</a>
                <input type="submit" value="회원가입" class="btn btnRegister"/>
            </div>

        </form>

    </section>
</main>
<%@ include file="./_tail.jsp" %>