const boardRegister = document.querySelector("#boardRegister");
const board_title = document.querySelector("#board_title");
const board_textArea = document.querySelector("#board_textArea");

let Check = false;

const validate = () => {
  if (board_title.value === "") {
    alert("제목을 작성해주세요.");
    return (Check = false);
  } else if (board_textArea.value === "") {
    alert("내용을 작성해주세요.");
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
