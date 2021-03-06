<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/styles/style.css" />
    <title>νκΈ° μν</title>
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
            <span>ν΄μ€</span>
            <label for="content4"><c:out value="${vo.comment}" /></label>
          </div>
          <div class="answer__container">
            <button class="answer__btn" onclick="btnClick()">λ€μλ¬Έμ </button>
            <button
              class="answer__btn"
              onclick="location.href = '/question/exam/result'"
            >
              κ·Έλ§νκΈ°
            </button>
          </div>
        </div>
      </div>
    </test>

    <jsp:include page="../footer.jsp" />
  </body>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script>
    // URL νλΌλ―Έν° κ° κ°μ Έμ€κΈ°
    const searchParams = new URLSearchParams(window.location.search);
    const ans = searchParams.get("ans");
    const qno = searchParams.get("qno");
    const div = searchParams.get("div");

    // μΈμμμ qJson νμ±
    let qJson = JSON.parse(sessionStorage.getItem("qJson"));

    // λ¬Έμ  νΌκ²°κ³Ό μΆκ°
    const voAns = '<c:out value="${vo.answer}" />';
    if (ans == voAns) {
      qJson.push({ [qno]: "true" });
    } else {
      qJson.push({ [qno]: "false" });
    }

    // λ€μ μΈμμ λ£κΈ°
    sessionStorage.setItem("qJson", JSON.stringify(qJson));
  </script>
  <script>
    /////////////// λ€μλ¬Έμ  μμ± ///////////////
    // μΈμμμ qJson νμ±
    let re_qJson = JSON.parse(sessionStorage.getItem("qJson"));
    let count = sessionStorage.getItem("count");

    // key κ°λ§ μΆμΆ
    let qList = []; //jsonObj key λ΄μ λ°°μ΄
    for (let i = 0; i < re_qJson.length; i++) {
      qList.push(Object.keys(re_qJson[i])[0]); //keyλ₯Ό λ΄μ
    }

    console.log(qList);

    // μ€λ³΅μ νλ¨ : μ€λ³΅λλ κ°μ΄ νλλ μμΌλ©΄ true
    function notSame(n) {
      return qList.every((e) => n != e);
    }

    // λλ€μΌλ‘ λ¬Έμ λ₯Ό λ°μμ΄
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
        alert("λ¬Έμ κ° λ μ΄μ μμ΅λλ€.");
        location.href = "/question/exam/result";
      } else {
        if (div == "w") {
          location.href = "/question/written/get?div=" + div + "&&qno=" + qno;
        } else if (div == "p") {
          location.href = "/question/practical/get?div=" + div + "&&qno=" + qno;
        } else {
          alert("λ¬Έμ  μ νμ κ°μ΄ μ μμ μ΄μ§ μμ΅λλ€.");
        }
      }
    };

    function record() {
      // λ¬Έμ  νΌμ¬λ
      let member_id = '<c:out value="${login_info.member_id}"/>';

      let Json = JSON.parse(sessionStorage.getItem("qJson"));
      let count = sessionStorage.getItem("count");
      let answerCount = 0;

      // key κ°λ§ μΆμΆ
      let qList = []; //jsonObj key λ΄μ λ°°μ΄
      for (let i = 0; i < Json.length; i++) {
        qList.push(Object.keys(Json[i])[0]); //keyλ₯Ό λ΄μ
      }

      // λ‘κ·ΈμΈ λμ΄ μμΌλ©΄,
      if (member_id) {
        for (let i = 0; i < qList.length; i++) {
          if (Json[i][qList[i]] == "true") {
            answerCount++;
          }
        }
        console.log("νΌ μ¬λ : " + member_id);
        console.log("νΌ λ¬Έμ  : " + qList.length);
        console.log("λ§μΆ λ¬Έμ  : " + answerCount);
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
