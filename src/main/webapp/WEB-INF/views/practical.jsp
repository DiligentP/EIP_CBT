<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./styles/style.css" />
    <title>실기 시험</title>
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
          <li class="header__timer">00:00:00</li>
        </ul>
      </nav>
    </header>

    <test>
      <div class="test">
        <div class="test__container">
          <div class="test__titleNum">
            <span>Question Num</span>
          </div>
          <div class="test__question">
            <span>질문</span>
          </div>
          <div class="test__practical__answer">
            <input
              type="text"
              id="pracitcalAnswer"
              placeholder="정답을 입력하세요."
            />
          </div>
        </div>
        <div class="answer__container">
          <button id="answer__btn">정답</button>
        </div>
      </div>
    </test>

    <script src="./js/timer.js"></script>
  </body>
</html>
