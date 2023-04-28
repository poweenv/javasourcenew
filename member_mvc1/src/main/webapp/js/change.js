/**
 *  기존비밀번호, 새비밀번호.새비밀번호확인 내용 비어 있지 않도록 확인
 *  새비밀번호와 새비밀번호확인 동일한가?
 * 
 */

const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();

	const curPwd = document.querySelector("#floatingPassword1");
	const newPwd = document.querySelector("#floatingPassword2");
	const confirmPwd = document.querySelector("#floatingPassword3");

	if (curPwd.value === "") {
		alert("비밀번호를 입력해 주세요");
		curPwd.select();
		return;
	} else if (newPwd.value === "") {
		alert("변경할 비밀번호를 입력해주세요");
		newPwd.select();
		return;
	} else if (confirmPwd.value === "") {
		alert("변경할 비밀번호를 한번더 입력해 주세요")
		confirmPwd.select();
		return;
	}

	if (newPwd.value !== confirmPwd.value) {
		alert("변경할 비밀번호가 일치한지 확인해 주세요");
		confirmPwd.select();
		return;
	}
	form.submit();
})