<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./styles/style.css" />
    <title>마이 페이지</title>
  </head>
  <body>
    <header>
      <nav>
        <ul>
          <li>
            <a href="/"
              ><img src="./assets/icons.png" class="header__logo"
            /></a>
          </li>
          <li class="header__title">
            <a href="/">정보처리기사 CBT</a>
          </li>
        </ul>
        <ul class="header__nav">
          <li><a href="./board/list">게시판</a></li>
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

    <main>
      <div class="main__container">
        <a href="./mypageQuestion">
          <div class="main__written">
            <span class="main__title">문제 관리</span>
          </div>
        </a>
        <a href="./mypageModify">
          <div class="main_practical">
            <span class="main__title">정보 수정</span>
          </div>
        </a>
      </div>
    </main>

    <script src="./js/mypage.js"></script>
  </body>
</html>
