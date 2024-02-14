const reg_email =  /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+/;
const reg_password = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
const reg_name = /^[가-힣]{2,15}$/;

let mail = document.getElementById("mail");
let password = document.getElementById("password");
let password_check = document.getElementById("password_check");
let user_name = document.getElementById("name");
let checkbox = document.getElementById("checkbox");

let mail_msg = document.getElementById("mail_msg");
let password_msg = document.getElementById("password_msg");
let check_msg = document.getElementById("password_check_msg");
let name_msg = document.getElementById("name_msg");
let checkbox_msg = document.getElementById("check_msg");

mail.addEventListener("input", checkMail);
password.addEventListener("input", checkPassword);
password_check.addEventListener("input", duplicationPassword);
user_name.addEventListener("input", checkName);


function checkMail() {	
	if(!reg_email.test(mail.value)) {
		mail_msg.style.color = "#D83F31";
		mail_msg.textContent = "올바른 메일 형식을 입력해주세요 :(";
	} else {
		mail_msg.style.color = "#808080";
		mail_msg.textContent = "올바른 형식입니다:)";
	}
}

function checkPassword() {		
	if(!reg_password.test(password.value)) {
		password_msg.style.color = "#D83F31";
		password_msg.textContent = "영문, 숫자 조합하여 6~20자리로 입력해주세요 ";
		password_check.disabled = true;
	} else {
		password_msg.style.color = "#808080";
		password_msg.textContent = "올바른 형식입니다:)";
		password_check.disabled = false;
	}
}

function duplicationPassword() {
	if(password.value !== password_check.value) {
		check_msg.style.color = "#D83F31";
		check_msg.textContent = "패스워드가 일치하지 않습니다 :(";
	} else if(password.value === password_check.value){
		check_msg.style.color = "#808080";
		check_msg.textContent = "패스워드가 일치합니다:)";
	}
}

function checkName() {
	if(!reg_name.test(user_name.value)) {
		name_msg.style.color = "#D83F31";
		name_msg.textContent = "올바른 이름을 입력해주세요 :(";
	} else {
		name_msg.style.color = "#808080";
		name_msg.textContent = user_name.value + "님, 반갑습니다 :)";
	}
}

function signUp() {
	if(mail.value == "" || mail.value.length == 0) {
		mail_msg.textContent = "이메일을 입력해주세요 :)";
		mail.focus();
		return false;
	} else if (password.value == "") {
		password_msg.textContent = "패스워드를 입력해주세요 :)";
		password.focus();
		return false;
	} else if (password_check.value == "") {
		check_msg.textContent = "패스워드를 입력해주세요 :)";
		password_check.focus();
		return false;
	} else if (name.value == "") {
		name_msg.textContent = "이름을 입력해주세요 :)";
		name.focus();
		return false;
	} else if (!checkbox.checked) {
		checkbox.focus();
		return false;
	}
}
