const loginSubmit = document.querySelector("#loginSubmit");
const loginId = document.querySelector("#loginId");
const loginPassword = document.querySelector("#loginPassword");

const validate = () => {
  if (loginId.value == "" && loginPassword.value == "") {
    alert("아이디, 패스워드를 입력하세요.");
  } else if (loginId.value == "") {
    alert("아이디를 입력하세요.");
  } else if (loginPassword.value == "") {
    alert("패스워드를 입력하세요.");
  }
};

const handleLogin = () => {
  validate();
};

loginSubmit.addEventListener("click", handleLogin);
