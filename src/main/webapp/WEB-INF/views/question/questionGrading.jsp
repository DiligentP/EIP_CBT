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
            <c:choose>
              <c:when test="${result eq true}">
                <span style="color: blue"><c:out value="${vo.title}" /></span>
              </c:when>
              <c:when test="${result eq false}">
                <span style="color: red"><c:out value="${vo.title}" /></span>
              </c:when>
              <c:otherwise>
                <span><c:out value="${vo.title}" /></span>
              </c:otherwise>
            </c:choose>
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
          <div class="test__content">
            <span>해설</span>
            <label for="content4"><c:out value="${vo.comment}" /></label>
          </div>
          <div class="answer__container">
            <button class="answer__btn" onclick="btnClick()">다음문제</button>
            <button
              class="answer__btn"
              onclick="location.href = '/question/exam/result'"
            >
              그만풀기
            </button>
          </div>
        </div>
      </div>
    </test>

    <jsp:include page="../footer.jsp" />
  </body>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script>
    // URL 파라미터 값 가져오기
    const searchParams = new URLSearchParams(window.location.search);
    const ans = searchParams.get("ans");
    const qno = searchParams.get("qno");
    const div = searchParams.get("div");

    // 세션에서 qJson 파싱
    let qJson = JSON.parse(sessionStorage.getItem("qJson"));

    // 문제 푼결과 추가
    const voAns = '<c:out value="${vo.answer}" />';
    if (ans == voAns) {
      qJson.push({ [qno]: "true" });
    } else {
      qJson.push({ [qno]: "false" });
    }

    // 다시 세션에 넣기
    sessionStorage.setItem("qJson", JSON.stringify(qJson));
  </script>
  <script>
    /////////////// 다음문제 생성 ///////////////
    // 세션에서 qJson 파싱
    let re_qJson = JSON.parse(sessionStorage.getItem("qJson"));
    let count = sessionStorage.getItem("count");

    // key 값만 추출
    let qList = []; //jsonObj key 담을 배열
    for (let i = 0; i < re_qJson.length; i++) {
      qList.push(Object.keys(re_qJson[i])[0]); //key를 담음
    }

    console.log(qList);

    // 중복을 판단 : 중복되는 값이 하나도 없으면 true
    function notSame(n) {
      return qList.every((e) => n != e);
    }

    // 랜덤으로 문제를 받아옴
    function random() {
      if (qList.length == count) {
        return -1;
      }
      let n;
      do {
        n = Math.floor(Math.random() * count) + 1;
      } while (!notSame(n));
      {
      }

      return n;
    }
    console.log(qList.length);
  </script>

  <script>
    const btnClick = () => {
      let qno = random();
      if (qno == -1) {
        alert("문제가 더 이상 없습니다.");
        location.href = "/question/exam/result";
      } else {
        if (div == "w") {
          location.href = "/question/written/get?div=" + div + "&&qno=" + qno;
        } else if (div == "p") {
          location.href = "/question/practical/get?div=" + div + "&&qno=" + qno;
        } else {
          alert("문제 유형의 값이 정상적이지 않습니다.");
        }
      }
    };

    function record() {
      // 문제 푼사람
      let member_id = '<c:out value="${login_info.member_id}"/>';

      let Json = JSON.parse(sessionStorage.getItem("qJson"));
      let count = sessionStorage.getItem("count");
      let answerCount = 0;

      // key 값만 추출
      let qList = []; //jsonObj key 담을 배열
      for (let i = 0; i < Json.length; i++) {
        qList.push(Object.keys(Json[i])[0]); //key를 담음
      }

      // 로그인 되어 있으면,
      if (member_id) {
        for (let i = 0; i < qList.length; i++) {
          if (Json[i][qList[i]] == "true") {
            answerCount++;
          }
        }
        console.log("푼 사람 : " + member_id);
        console.log("푼 문제 : " + qList.length);
        console.log("맞춘 문제 : " + answerCount);
        location.href =
          "/question/exam/createResult?member_id=" +
          member_id +
          "&&answer=" +
          answerCount +
          "&&count=" +
          qList.length;
      }
      location.href = "/question/exam/result";
    }
  </script>
</html>
