window.onload = function() {
	var inputObj = document.getElementsByTagName('input');
	var placeObj = document.getElementsByClassName('member-input__label');
	var clickObj = document.getElementById("ex_chk");

	for (var i = 0; i < 2; i++) {
		inputObj[i].addEventListener('focus', placeFlyFnc)
		inputObj[i].addEventListener('blur', placeDownFnc)
		inputObj[i].addEventListener('keyup', submitFnc)
	}
	setInterval(metaFnc, 4000);
}

function metaFnc() {
	var imgArray = new Array(8);

	for (var i = 0; i < imgArray.length; i++) {
		imgArray[i] = "../img/pika" + i + ".gif";
	}
	var imgNum = Math.round(Math.random() * 7);
	var objImg = document.getElementById("mainImg");
	objImg.src = imgArray[imgNum];
}

function placeFlyFnc() {
	this.parentNode.style.borderBottom = '1px solid #1ea1f7';
	this.parentNode.children[0].style.transform = 'scale(.75) translateY(-39px)';
	this.parentNode.children[0].style.color = '#1ea1f7';
}

function placeDownFnc() {

	if (this.value.length == 0) {
		this.parentNode.style.borderBottom = '1px solid #dddfe4';
		this.parentNode.children[0].style.color = '#7b858e';
		this.parentNode.children[0].style.transform = '';

	} else if (this.value.length > 0) {
		this.parentNode.style.borderBottom = '1px solid #dddfe4';
		this.parentNode.children[0].style.color = '#7b858e';
		this.parentNode.children[0].style.transform = 'scale(.75) translateY(-39px)';
	}
}

function submitFnc() {
	var submitBnt = document.getElementById('target');
	var inputObj = document.getElementsByTagName('input');
	var wrongObj = document
			.getElementsByClassName('member-input-wrong-message');
	var sizeUp = document.getElementsByClassName('member-card');

	if (inputObj[0].value.length > 0 && inputObj[1].value.length > 0) {
		submitBnt.style.backgroundColor = 'skyblue';
		submitBnt.style.cursor = 'pointer';
		submitBnt.disabled = false;
	} else if (inputObj[0].value.length == 0 || inputObj[1].value.length == 0) {
		/* sizeUp[0].style.height = "726px"; */
		submitBnt.style.backgroundColor = '#dddfe4';
		wrongObj[0].innerHTML = "";
		submitBnt.style.cursor = 'default';
		submitBnt.disabled = true;
	}
}

function findPwd() {

	window.name = "parentForm";
	window.open("FindPwdForm.jsp", "chkForm",
			"width=500, height=320, resizable = no, scrollbars = no");
}
