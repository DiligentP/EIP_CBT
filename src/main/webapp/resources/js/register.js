const registerSubmit = document.querySelector("#registerSubmit");
const registerName = document.querySelector("#registerName");
const registerId = document.querySelector("#registerId");
const registerPassword = document.querySelector("#registerPassword");
const registerEmail = document.querySelector("#registerEmail");

// 유효성 검사 함수
const validate = () => {
  // 이름 정규화
  const regName = /^[가-힣a-zA-Z]+$/;
  // 아이디 6~20이하 대소문자 또는 숫자 포함
  const regId = /^[a-zA-Z0-9]{6,20}$/;
  // 비밀번호 8~32이하 대소문자, 숫자, 특수문자 포함
  const regPw =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,32}$/;

  if (
    registerName.value == "" &&
    registerPassword.value == "" &&
    registerEmail.value == "" &&
    registerId.value == ""
  ) {
    alert("빈칸을 모두 채워주세요.");
  } else if (registerId.value == "") {
    alert("아이디를 입력해주세요.");
  } else if (!regId.test(registerId.value)) {
    alert("아이디는 6~20이하 대소문자 또는 숫자 포함해야합니다.");
  } else if (registerPassword.value == "") {
    alert("패스워드를 입력해주세요.");
  } else if (!regPw.test(registerPassword.value)) {
    alert("비밀번호는 8~32이하 대소문자, 숫자, 특수문자 포함해야합니다.");
  } else if (registerName.value == "") {
    alert("이름을 입력해주세요.");
  } else if (!regName.test(registerName.value)) {
    alert("이름을 잘못 입력하였습니다.");
  } else if (registerEmail.value == "") {
    alert("이메일을 입력해주세요.");
  } else {
    alert("✨축하합니다! 로그인 해주세요.");
  }
};

const handleSubmit = () => {
  validate();
};

registerSubmit.addEventListener("click", handleSubmit);
