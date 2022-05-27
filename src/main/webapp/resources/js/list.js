const boardRegister = document.querySelector("#boardRegister");
const board_title = document.querySelector("#board_title");

let Check = false;

const validate = () => {
  if (board_title.value === "") {
    alert("제목을 작성해주세요.");
    return (Check = false);
  }
  return (Check = true);
};

const handleSubmit = (e) => {
  validate();
  if (!Check) {
    e.preventDefault();
  }
};

boardRegister.addEventListener("click", handleSubmit);
