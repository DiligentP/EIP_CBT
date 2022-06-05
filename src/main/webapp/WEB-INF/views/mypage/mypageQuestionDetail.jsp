<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../styles/style.css" />
    <title>문제 관리</title>
  </head>
  <body>
  <jsp:include page="../header.jsp" />

    <wrapper>
      <div class="wrapper">
        <div class="wrapper__container">
          <div class="wrapper__container__Main">
            <!-- input 태그  -->
            <div class="wrapper__container__input">
              <div class="board__form__input">
                <textarea
                  id="board_textArea"
                  name=""
                  placeholder="문제"
                  cols="40"
                  rows="8"
                  readonly="readonly"
                  style="border: none"
                >
<c:out value=""/></textarea
                >
                <textarea
                  id="board_textArea"
                  name=""
                  placeholder="해설"
                  cols="40"
                  rows="8"
                  readonly="readonly"
                  style="border: none"
                >
<c:out value=""/></textarea
                >
                <textarea
                  id="board_textArea"
                  name=""
                  placeholder="답"
                  cols="40"
                  rows="5"
                  readonly="readonly"
                  style="border: none"
                >
<c:out value=""/></textarea
                >
              </div>
              <div class="wrapper__container__btn">
                <a href="">수정하기</a>
                <a href="">돌아가기</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </wrapper>

  <jsp:include page="../footer.jsp" />
  </body>
</html>
