<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/styles/style.css" />
    <title>필기 시험</title>
  </head>
  <body>
    <jsp:include page="header.jsp" />

    <test>
      <div class="test">
        <div class="test__container">
          <div class="test__question">
            <span><c:out value="${vo.title}" /></span>
          </div>
          <div class="test__written__answer">
            <ul>
              <input type="radio" name="" id="" />
            </ul>
            <span>1️⃣ <c:out value="${vo.content1}" /></span>
            <span>2️⃣ <c:out value="${vo.content2}" /></span>
            <span>3️⃣ <c:out value="${vo.content3}" /></span>
            <span>4️⃣ <c:out value="${vo.content4}" /></span>
          </div>
          <div class="answer__container">
            <button id="answer__btn">정답확인</button>
          </div>
        </div>
      </div>
    </test>

    <jsp:include page="footer.jsp" />
  </body>

  <script>
    let count = 0;
    console.log(count);
    // 푼 문제를 담는 리스트
    let qList = [];

    // 중복을 판단 : 중복되는 값이 하나도 없으면 true
    function notSame(n) {
      return qList.every((e) => n !== e);
    }

    // 랜덤으로 문제를 받아옴
    function random() {
      let n;
      do {
        n = Math.floor(Math.random() * count) + 1;
      } while (!notSame(n));

      return n;
    }
  </script>
</html>
