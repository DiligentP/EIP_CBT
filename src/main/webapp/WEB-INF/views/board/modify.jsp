<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
          <h2>Title: <c:out value="${board.title}" /></h2>
        </div>
        <!-- input 태그  -->
        <form
                role="form"
                action="/board/modify"
                method="post"
                id="board__form"
        >
          <div class="board__form__input">
            <input
                    id="board_bno"
                    name="bno"
                    value='<c:out value="${board.bno}"/>'
                    readonly="readonly"
            />
            <input
                    id="board_title"
                    name="title"
                    value='<c:out value="${board.title}"/>'
                    placeholder="작성하는 제목"
            />
            <textarea
                    id="board_textArea"
                    name="content"
                    placeholder="작성하는 내용"
                    cols="40"
                    rows="10"
            ><c:out value="${board.content}"/></textarea>
            <input
                    id="board_writer"
                    name="writer"
                    value='<c:out value="${board.title}"/>'
                    placeholder="사용자"
                    readonly="readonly"
            />
          </div>
          <div class="wrapper__container__btn">
            <div class="">
              <input type="submit" value="수정" id="wrapperSubmitBtn" />
            </div>
            <div class="">
              <form role="form" action="/board/remove" method="post">
                <input
                        type="hidden"
                        name="bno"
                        value='<c:out value="${board.bno}"/>'
                        readonly="readonly"
                />
                <input type="submit" value="제거" id="wrapperSubmitBtn" />
              </form>
            </div>
            <div class="">
              <a href="/board/list">게시판</a>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</wrapper>
</body>
</html>

