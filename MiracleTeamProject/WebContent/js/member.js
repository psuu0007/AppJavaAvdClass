/**
 * 
 */
var emailCheck = false;
var nickNameCheck = false;
var pwdCheck = false;
var pwdEqCheck = false;
var cnt = 0;

window.onload = function() {

	var inputObj = document.getElementsByClassName('input-contents');
	var placeObj = document.getElementsByClassName('member-input__label');
	var eqObj = document.getElementById('eqEmail');
	
	
	for (var i = 0; i < 4; i++) {	
		inputObj[i].addEventListener('focus', placeFlyFnc)
		inputObj[i].addEventListener('blur', placeDownFnc)
		inputObj[i].addEventListener('keyup', submitFnc)
	}

	inputObj[0].addEventListener('keyup', emailFnc);
	inputObj[1].addEventListener('keyup', nameFnc);
	inputObj[2].addEventListener('keyup', pwdFnc);
	inputObj[3].addEventListener('keyup', equalPwd);
}

function emailFnc() {
	inputEmailChk();
	var wrongDiv = document.getElementById('wrongBox');
	var cuteImg = document.getElementById('mainImg');
	var equalBtn = document.getElementById('eqEmail');
	var wrongColor = document.getElementsByClassName('input-box');
	var wrongFontCorlor = document.getElementsByClassName('member-input__label');
	
	var re2 = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; // 이메일이 적합한지 검사할 정규식

	if (!re2.test(this.value)) {
		wrongFontCorlor[0].style.color = 'red';
		wrongColor[0].style.borderBottom = '1px solid red';
		
		equalBtn.disabled = true; 
		equalBtn.style.color = 'skyblue';
		equalBtn.style.backgroundColor = 'white';
		equalBtn.style.cursor = '';
		
		wrongDiv.style.color = "red";
		wrongDiv.innerHTML = "유효한 이메일 주소를<br>입력해 주세요~!";	
		cuteImg.setAttribute('src', "../img/pika7.gif");
		emailCheck = false;
		
	} else if (re2.test(this.value)) {
		wrongFontCorlor[0].style.color = '#1ea1f7';
		wrongColor[0].style.borderBottom = '1px solid #1ea1f7';
		wrongDiv.innerHTML = "";	
		wrongDiv.style.color = "#1ea1f7";
		equalBtn.disabled = false; 
		equalBtn.style.color = 'white';
		equalBtn.style.backgroundColor = 'skyblue';
		equalBtn.style.cursor = 'pointer';
		
		cuteImg.setAttribute('src', "../img/pika3.gif");
		
		emailCheck = true;
	} 
	
	if (this.value.length == 0) {
		wrongFontCorlor[0].style.color = '#7b858e';
		wrongColor[0].style.borderBottom = '1px solid #7b858e';
		wrongDiv.innerHTML = "";	
		equalBtn.disabled = true; 
		equalBtn.style.color = 'skyblue';
		equalBtn.style.backgroundColor = 'white';
		equalBtn.style.cursor = '';
		
		cuteImg.setAttribute('src', "../img/pika2.gif");
		emailCheck = false;
	}
}

function nameFnc() {
	var wrongDiv = document.getElementById('wrongBox');
	var cuteImg = document.getElementById('mainImg');
	var wrongColor = document.getElementsByClassName('input-box');
	var wrongFontCorlor = document.getElementsByClassName('member-input__label');
	
	var re3 = /^[가-힣]{2,4}$/;
	
	if (!re3.test(this.value)) {
		wrongFontCorlor[1].style.color = 'red';
		wrongColor[1].style.borderBottom = '1px solid red';
		
		wrongDiv.style.color = "red";
		wrongDiv.innerHTML = "이름은 최소 2자 최대 4자 <br>한글로만 입력가능합니다.";	
		cuteImg.setAttribute('src', "../img/pika7.gif");
		nickNameCheck = false;
	} else if (re3.test(this.value)) {
		wrongFontCorlor[1].style.color = '#1ea1f7';
		wrongColor[1].style.borderBottom = '1px solid #1ea1f7';
		wrongDiv.innerHTML = "사용가능한 이름입니다.";	
		wrongDiv.style.color = "#1ea1f7";
		cuteImg.setAttribute('src', "../img/pika3.gif");
		nickNameCheck = true;
	}
	
	if (this.value.length == 0) {
		wrongFontCorlor[1].style.color = '#7b858e';
		wrongColor[1].style.borderBottom = '1px solid #7b858e';
		cuteImg.setAttribute('src', "../img/pika2.gif");
		wrongDiv.innerHTML = "";	
		nickNameCheck = false;
	}
}

function pwdFnc() {
	
	var wrongDiv = document.getElementById('wrongBox');
	var cuteImg = document.getElementById('mainImg');
	var wrongColor = document.getElementsByClassName('input-box');
	var wrongFontCorlor = document.getElementsByClassName('member-input__label');
	
	var re = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;

	if (!re.test(this.value)) {
		wrongFontCorlor[2].style.color = 'red';
		wrongColor[2].style.borderBottom = '1px solid red';
		wrongDiv.style.color = "red";
		wrongDiv.innerHTML = "패스워드는 숫자, 특문 각 1회 <br>이상, 영문은 2개 이상 사용하여 <br>8자리 이상 입력";
		cuteImg.setAttribute('src', "../img/pika7.gif");
		pwdCheck = false;
		
	} else if (re.test(this.value)) {
		wrongFontCorlor[2].style.color = '#1ea1f7';
		wrongColor[2].style.borderBottom = '1px solid #1ea1f7';
		wrongDiv.innerHTML = "사용가능한 비밀번호입니다.";
		cuteImg.setAttribute('src', "../img/pika3.gif");
		wrongDiv.style.color = "#1ea1f7";
		pwdCheck = true;
	}
	
	if (this.value.length == 0) {
		wrongFontCorlor[2].style.color = '#7b858e';
		wrongColor[2].style.borderBottom = '1px solid #7b858e';
		cuteImg.setAttribute('src', "../img/pika2.gif");
		wrongDiv.innerHTML = "";	
		pwdCheck = false;
	}	
}

function equalPwd() {
	var inputObj = document.getElementsByClassName('input-contents');
	var wrongDiv = document.getElementById('wrongBox');
	var cuteImg = document.getElementById('mainImg');
	var wrongColor = document.getElementsByClassName('input-box');
	var wrongFontCorlor = document.getElementsByClassName('member-input__label');
	
	if (this.value.length >= inputObj[2].value.length || this.value.length <= inputObj[2].value.length
			&& this.value != inputObj[2].value ) {
		wrongFontCorlor[3].style.color = 'red';
		wrongColor[3].style.borderBottom = '1px solid red';
		wrongDiv.style.color = "red";
		this.focus();
		wrongDiv.innerHTML = "입력하신 비밀번호와 <br>일치하지 않습니다.";
		cuteImg.setAttribute('src', "../img/pika7.gif");
		pwdEqCheck = false;
	}
	
	if (this.value == inputObj[2].value) {
		wrongFontCorlor[3].style.color = '#1ea1f7';
		wrongColor[3].style.borderBottom = '1px solid #1ea1f7';
		wrongDiv.style.color = "#1ea1f7";
		wrongDiv.innerHTML = "입력하신 비밀번호와 일치합니다.";
		cuteImg.setAttribute('src', "../img/pika3.gif");
		pwdEqCheck = true;
	}
	
	if (this.value.length == 0) {
		wrongFontCorlor[3].style.color = '#7b858e';
		wrongColor[3].style.borderBottom = '1px solid #7b858e';
		wrongDiv.innerHTML = "";
		cuteImg.setAttribute('src', "../img/pika2.gif");
		pwdEqCheck = false;
	}

	
}

function check(re, what, message) {

	if (re.test(what.value)) {
		return true;
	}
	what.focus();
	
	return false;
}

function placeFlyFnc() {
	this.parentNode.children[0].style.transform = 'scale(.75) translateY(-39px)';
//	this.parentNode.style.borderBottom = '1px solid #1ea1f7';
//	this.parentNode.children[0].style.color = '#1ea1f7';
}

function placeDownFnc() {
	var inputObj = document.getElementsByClassName('input-contents');

	if (this.value.length == 0) {
		this.parentNode.style.borderBottom = '1px solid #dddfe4';
		this.parentNode.children[0].style.color = '#7b858e';
		this.parentNode.children[0].style.transform = '';

	} else if (this.value.length > 0) {
//		this.parentNode.style.borderBottom = '1px solid #dddfe4';
//		this.parentNode.children[0].style.color = '#7b858e';
		this.parentNode.children[0].style.transform = 'scale(.75) translateY(-39px)';
	}
}

function validate() {
	var equalResult = document.userInfo.emailEqual.value;
	var inputObj = document.getElementsByClassName('input-contents');
	var formObj = document.getElementById('formFirst');
	var wrongDiv = document.getElementById('wrongBox');
	var cuteImg = document.getElementById('mainImg');
	var wrongColor = document.getElementsByClassName('input-box');
	var wrongFontCorlor = document.getElementsByClassName('member-input__label');
	
	if (equalResult == "emailUncheck") {
		alert("이메일 중복체크를 해주세요!")
		inputObj[0].focus();
		return false;
	}
	
	if (nickNameCheck == false) {
		alert("이름을 확인해주세요!")
		inputObj[1].focus();
		wrongDiv.style.color = "red";
		wrongDiv.innerHTML = "이름은 최소 2자 최대 4자 <br>한글로만 입력가능합니다.";
		cuteImg.setAttribute('src', "../img/pika7.gif");
		return false;
	}
	
	if (emailCheck == true && nickNameCheck == true && pwdCheck == true && pwdEqCheck == true) {
		formObj.setAttribute('action', './add');
		return true;
	} 
	return false;
}

function submitFnc() {
	var submitBnt = document.getElementById('target');
	var inputObj = document.getElementsByClassName('input-contents');

	if (inputObj[0].value.length > 0 && inputObj[1].value.length > 0
			&& inputObj[2].value.length > 0 && inputObj[3].value.length > 0
			&& inputObj[2].value == inputObj[3].value) {
		submitBnt.style.backgroundColor = 'skyblue';
		submitBnt.style.cursor = 'pointer';
		submitBnt.disabled = false;
	} else if (inputObj[0].value.length == 0 || inputObj[1].value.length == 0
			|| inputObj[2].value.length == 0 || inputObj[3].value.length == 0 || inputObj[2].value != inputObj[3].value) {
		submitBnt.style.backgroundColor = '#dddfe4';
		submitBnt.style.cursor = 'default';
		submitBnt.disabled = true;
	}
}

function openEmailChk(){
    window.name = "parentForm";
    window.open("emailCheckForm.jsp",
            "chkForm", "width=500, height=320, resizable = no, scrollbars = no");    
}

function inputEmailChk() {
	document.userInfo.emailEqual.value = "emailUncheck";	
}



