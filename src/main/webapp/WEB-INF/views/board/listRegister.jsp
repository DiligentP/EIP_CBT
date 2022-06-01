<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../styles/style.css" />
    <title>게시판</title>
  </head>
  <body>
    <jsp:include page="../header.jsp" />

    <wrapper>
      <div class="wrapper">
        <div class="wrapper__container">
          <div class="wrapper__container__Main">
            <div class="board__register">
              <h2>게시글 등록</h2>
            </div>
            <!-- form 태그  -->
            <form action="/board/listRegister" id="board__form" method="post">
              <div class="board__form__input">
                <input type="text" id="board_bno" placeholder="No." disabled />
                <input
                  type="text"
                  id="board_title"
                  name="title"
                  placeholder="작성하는 제목"
                />
                <textarea
                  type="text"
                  id="board_textArea"
                  name="content"
                  placeholder="작성하는 내용"
                  cols="40"
                  rows="10"
                ></textarea>
                <input
                  type="text"
                  id="board_writer"
                  name="writer"
                  placeholder="사용자"
                />
              </div>
              <div class="board__form__submit">
                <input type="submit" value="작성" id="boardRegister" />
              </div>
            </form>
          </div>
        </div>
      </div>
    </wrapper>
    <jsp:include page="../footer.jsp" />
    <script src="../js/list.js"></script>
  </body>
</html>
