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

    <myPage>
      <div class="wrapper">
        <div class="wrapper__container">
          <div class="wrapper__container__Main">
            <div class="board__register">
              <h2>문제 등록</h2>
            </div>
            <!-- form 태그  -->
            <form
              action="/mypage/QuestionCreate"
              id="board__form"
              method="post"
            >
              <div class="board__form__input">
                <input
                  type="text"
                  id="question_title"
                  name="title"
                  placeholder="문제"
                />

                <input
                  type="text"
                  id="content1"
                  name="content1"
                  placeholder="보기1"
                />
                <input
                  type="text"
                  id="content2"
                  name="content2"
                  placeholder="보기2"
                />
                <input
                  type="text"
                  id="content3"
                  name="content3"
                  placeholder="보기3"
                />
                <input
                  type="text"
                  id="content4"
                  name="content4"
                  placeholder="보기4"
                />

                <textarea
                  id="comment"
                  name="comment"
                  placeholder="해설"
                  cols="40"
                  rows="5"
                ></textarea>

                <input type="text" id="answer" name="answer" placeholder="답" />

                <input
                  type="hidden"
                  id="writer"
                  name="writer"
                  value='<c:out value="${login_info.member_id}"/>'
                  placeholder="작성자"
                  readonly="readonly"
                />

                <input
                  type="hidden"
                  name="${_csrf.parameterName}"
                  value="${_csrf.token}"
                />
              </div>
              <div class="board__form__submit">
                <input type="submit" value="작성" id="boardRegister" />
              </div>
            </form>
          </div>
        </div>
      </div>
    </myPage>
    <jsp:include page="../footer.jsp" />
    <script src="../js/list.js"></script>
  </body>
</html>
