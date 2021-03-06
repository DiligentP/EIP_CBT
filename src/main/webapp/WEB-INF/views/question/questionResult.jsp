<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/styles/style.css" />
    <title>필기 시험 결과</title>
  </head>
  <body>
    <jsp:include page="../header.jsp" />

    <wrapper>
      <div class="wrapper">
        <div class="wrapper__container">
          <div class="test__result">
            <span>시험 결과</span>
          </div>
          <table class="table">
            <thead class="table__header">
              <tr class="table__header__row">
                <th>번호.</th>
                <!-- <th>제목.</th> -->
                <th>정답</th>
              </tr>
            </thead>

            <tbody class="table__body">
              <tr class="table__body__row"></tr>
            </tbody>
          </table>
          <button onclick="record()" class="saveBtn">저장하기</button>
        </div>
      </div>
    </wrapper>

    <jsp:include page="../footer.jsp" />
  </body>

  <script>
    // 세션에서 qJson 파싱
    let Json = JSON.parse(sessionStorage.getItem("qJson"));
    let count = sessionStorage.getItem("count");
    let answerCount = 0;

    // key 값만 추출
    let qList = []; //jsonObj key 담을 배열
    for (let i = 0; i < Json.length; i++) {
      qList.push(Object.keys(Json[i])[0]); //key를 담음
    }

    const body = document.querySelector(".table__body");
    const row = document.querySelector(".table__body__row");

    console.log(Json);
    console.log(typeof Json[0][qList[0]]);
    // console.log(Json[1][qList[1]]);

    for (let i = 0; i < Json.length; i++) {
      const rowNew = document.createElement("tr");
      rowNew.classList.add("table__body__row");

      const dataNum = document.createElement("td");
      const dataFlag = document.createElement("td");

      dataNum.innerText = qList[i];
      if (Json[i][qList[i]] == "false") {
        dataFlag.innerText = "❌";
      } else {
        dataFlag.innerText = "⭕";
        answerCount++;
      }
      // dataFlag.innerText = `${Json[i][qList[i]] == "false" ? "틀림" : "맞음"}`;

      rowNew.appendChild(dataNum);
      rowNew.appendChild(dataFlag);
      body.appendChild(rowNew);
    }

    function record() {
      // 문제 푼사람
      let member_id = '<c:out value="${login_info.member_id}"/>';

      // 로그인 되어 있으면,
      if (member_id) {
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
      location.href = "/";
    }
  </script>
</html>
