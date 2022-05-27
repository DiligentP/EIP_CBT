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
    <header>
      <nav>
        <ul>
          <li>
            <a href="/"
              ><img src="../assets/icons.png" class="header__logo"
            /></a>
          </li>
          <li class="header__title">
            <a href="/">정보처리기사 CBT</a>
          </li>
        </ul>
        <ul class="header__nav">
          <li><a href="/board/list">게시판</a></li>
          <!-- 로그인 세션이 존재하는 경우 -->
          <c:if test="${not empty login_info}">
            <li id="header_mypage"><a href="./mypage">마이페이지</a></li>
            <li>[${login_info.member_name}]님 반갑습니다</li>
            <li><a href="./logout">로그아웃</a></li>
          </c:if>

          <c:if test="${empty login_info}">
            <li>
              <a href="./login"><span class="header__login">로그인</span></a>
            </li>
          </c:if>
        </ul>
      </nav>
    </header>

    <wrapper>
      <div class="wrapper">
        <div class="wrapper__container">
          <div class="wrapper__container__Main">
            <div class="board__register">
              <h2>게시글 등록</h2>
            </div>
            <!-- form 태그  -->
            <form action="./list" id="board__form">
              <div class="board__form__input">
                <input
                  type="text"
                  id="board_bno"
                  name="board_bno"
                  placeholder="No."
                  disabled
                />
                <input
                  type="text"
                  id="board_title"
                  name="board_title"
                  placeholder="작성하는 제목"
                />
                <textarea
                  type="text"
                  id="board_textArea"
                  name="board_textArea"
                  placeholder="작성하는 내용"
                  cols="40"
                  rows="10"
                ></textarea>
                <input
                  type="text"
                  id="board_writer"
                  name="board_writer"
                  placeholder="사용자"
                  disabled
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
    <script src="../js/list.js"></script>
  </body>
</html>
