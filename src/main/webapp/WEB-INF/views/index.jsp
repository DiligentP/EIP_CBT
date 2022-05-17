<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./styles/style.css" />
    <title>EIP</title>
  </head>
  <body>
    <header>
      <nav>
        <ul>
          <li>
            <a href="index.html"
              ><img src="./assets/icons.png" class="header__logo"
            /></a>
          </li>
          <li class="header__title">
            <a href="index.jsp">정보처리기사 CBT</a>
          </li>
        </ul>
        <ul class="header__nav">
          <li><a href="#">게시판</a></li>
          <li id="header_mypage"><a href="#">마이페이지</a></li>
          <li>
            <a href="./login"><span class="header__login">로그인</span></a>
          </li>
        </ul>
      </nav>
    </header>

    <main>
      <div class="main__container">
        <a href="#">
          <div class="main__written">
            <span class="main__title">필기</span>
          </div>
        </a>
        <a href="#">
          <div class="main_practical">
            <span class="main__title">실기</span>
          </div>
        </a>
      </div>
    </main>

    <footer>
      <div class="footer__context">
        <span>정보구축시스템 Team B</span>

        <span
          >Copyright © 2022. ${test} All pictures cannot be copied without
          permission</span
        >
      </div>
    </footer>
    <script src="./js/index.js"></script>
  </body>
</html>
