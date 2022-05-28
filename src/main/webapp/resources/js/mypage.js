const boardRegister = document.querySelector("#boardRegister");
const registerName = document.querySelector("#registerName");
const registerId = document.querySelector("#registerId");
const registerPassword = document.querySelector("#registerPassword");
const registerEmail = document.querySelector("#registerEmail");

// 유효성 검사 함수
const validate = () => {
  // 이름 정규화
  const regName = /^[가-힣a-zA-Z]+$/;

  if (registerName.value == "") {
    alert("이름을 입력해주세요.");
  } else if (!regName.test(registerName.value)) {
    alert("이름을 잘못 입력하였습니다.");
  } else if (registerPassword.value == "") {
    alert("패스워드를 입력해주세요.");
  } else if (registerEmail.value == "") {
    alert("이메일을 입력해주세요.");
  } else if (registerId.value == "") {
    alert("아이디를 입력해주세요.");
  }
};

const handleSubmit = () => {
  validate();
};

boardRegister.addEventListener("click", handleSubmit);
