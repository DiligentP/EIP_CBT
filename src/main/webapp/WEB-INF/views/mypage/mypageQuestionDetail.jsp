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
              <form action="#" method="post">
            <div class="wrapper__container__input">
              <div class="board__form__input">
                  <span>문제</span>
                  <input id="title" name="" placeholder="문제" style="border: none" value="<c:out value="${vo.title}"/>">

                  <br><br>
                  <span>객관식 1</span>
                  <input id="content1" name="" placeholder="선택1" style="border: none" value="<c:out value="${vo.content1}"/>">
                  <span>객관식 2</span>
                  <input id="content2" name="" placeholder="선택2" style="border: none" value="<c:out value="${vo.content2}"/>">
                  <span>객관식 3</span>
                  <input id="content3" name="" placeholder="선택3" style="border: none" value="<c:out value="${vo.content3}"/>">
                  <span>객관식 4</span>
                  <input id="content4" name="" placeholder="선택4" style="border: none" value="<c:out value="${vo.content4}"/>">
                  <br><br><br>

                  <span>해설</span>
                  <textarea id="comment" name="" placeholder="해설" cols="40" rows="5" style="border: none"><c:out value="${vo.comment}"/></textarea>

                  <span>답</span>
                  <input id="answer" name="" placeholder="답" style="border: none" value="<c:out value="${vo.answer}"/>">
              </div>

              <div class="wrapper__container__btn">
                <a href="">수정하기</a>
                <a href="/mypage/mypageQuestion?id=${login_info.member_id}">돌아가기</a>
              </div>
            </div>
              </form>
          </div>
        </div>
      </div>
    </wrapper>

    <jsp:include page="../footer.jsp" />
  </body>
</html>
