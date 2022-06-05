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
    <jsp:include page="../header.jsp" />

    <test>
      <div class="test">
        <div class="test__container">
          <div class="test__question">
            <span><c:out value="${vo.title}" /></span>
          </div>
          <div class="test__written__answer">
            <ul class="answer__radiolist">
              <li>
                <input
                  type="radio"
                  name="answer"
                  id="content1"
                  value="1"
                  onclick="hadleClick()"
                />
                <label for="content1"><c:out value="${vo.content1}" /></label>
              </li>
              <li>
                <input
                  type="radio"
                  name="answer"
                  id="content2"
                  value="2"
                  onclick="hadleClick()"
                />
                <label for="content2"> <c:out value="${vo.content2}" /></label>
              </li>
              <li>
                <input
                  type="radio"
                  name="answer"
                  id="content3"
                  value="3"
                  onclick="hadleClick()"
                />
                <label for="content3"><c:out value="${vo.content3}" /></label>
              </li>
              <li>
                <input
                  type="radio"
                  name="answer"
                  id="content4"
                  value="4"
                  onclick="hadleClick()"
                />
                <label for="content4"><c:out value="${vo.content4}" /></label>
              </li>
            </ul>
          </div>
          <div class="answer__container">
            <button id="answer__btn" onclick="btnClick()">정답확인</button>
          </div>
        </div>
      </div>
    </test>

    <jsp:include page="../footer.jsp" />
  </body>

  <script
    src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
    crossorigin="anonymous"
  ></script>
  <script>
    // let listVar = $("input[name='answer']:checked").val();

    const hadleClick = () => {
      let listVar = $("input[name='answer']:checked").val();
      // alert(listVar);
      console.log(listVar);
    };

    const btnClick = () => {
      // window.location.href =
    };

    // let count = 0;
    // console.log(count);
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
