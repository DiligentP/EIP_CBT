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

    <myPage>
      <div class="wrapper">
        <div class="wrapper__container">
          <div class="wrapper__container__Main">
            <form
              id="QuestionModifyForm"
              action="/mypage/questionModify"
              method="post"
            >
              <div class="wrapper__container__input">
                <div class="mypage__input">
                  <span>문제</span>
                  <input id="title" name="title" placeholder="문제"
                  value="<c:out value="${vo.title}" />">

                  <span>객관식 1</span>
                  <input id="content1" name="content1" placeholder="선택1"
                  value="<c:out value="${vo.content1}" />">
                  <span>객관식 2</span>
                  <input id="content2" name="content2" placeholder="선택2"
                  value="<c:out value="${vo.content2}" />">
                  <span>객관식 3</span>
                  <input id="content3" name="content3" placeholder="선택3"
                  value="<c:out value="${vo.content3}" />">
                  <span>객관식 4</span>
                  <input id="content4" name="content4" placeholder="선택4"
                  value="<c:out value="${vo.content4}" />">

                  <span>해설</span>
                  <textarea
                    id="comment"
                    name="comment"
                    placeholder="해설"
                    cols="40"
                    rows="5"
                  >
<c:out value="${vo.comment}"/></textarea
                  >

                  <span>답</span>
                  <input id="answer" name="answer" placeholder="답"
                  value="<c:out value="${vo.answer}" />">

                  <input type="hidden" name="qno" value="${vo.qno}" />
                  <input
                    type="hidden"
                    name="sessionId"
                    value="${login_info.member_id}"
                  />
                  <input
                    type="hidden"
                    name="${_csrf.parameterName}"
                    value="${_csrf.token}"
                  />
                </div>
                <div class="wrapper__container__btn">
                  <input
                    type="submit"
                    value="수정하기"
                    class="mypage__inputBtn"
                  />

                  <a href="/mypage/mypageQuestion?id=${login_info.member_id}"
                    >돌아가기</a
                  >
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </myPage>

    <jsp:include page="../footer.jsp" />
  </body>
</html>
