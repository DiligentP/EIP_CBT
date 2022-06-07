<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/styles/style.css" />
    <title>실기 시험</title>
  </head>
  <body>
    <jsp:include page="../header.jsp" />

    <test>
      <div class="test">
        <div class="test__container">
          <div class="test__titleNum">
            <span><c:out value="${vo.title}" /></span>
          </div>
          <div class="test__question">
            <%-- 건웅이형 질문 삭제 해주세요  --%>
            <span>질문</span>
          </div>
          <div class="test__practical__answer">
            <input
              type="text"
              id="pracitcalAnswer"
              name="answer"
              placeholder="정답을 입력하세요."
            />
          </div>
        </div>
        <div class="answer__container">
          <button id="answer__btn" onclick="btnClick()">정답확인</button>
        </div>
      </div>
    </test>
    <jsp:include page="../footer.jsp" />
  </body>

  <script>
    let ans;

    //// 사용자가 입력한 정답을 ans 변수에 담음
    const ansCheck = () => {
      ans = document.getElementById("pracitcalAnswer").value;
    }

    const btnClick = () => {
      ansCheck()

      if(ans == undefined) {
        alert("답을 입력하세요.");
      }else{
        const qno = '<c:out value="${vo.qno}"/>';
        const div = '<c:out value="${vo.division}"/>'
        window.location.href = '/question/exam/grading?div='+div+'&&qno='+qno+'&&ans='+ans;
      }
    };
  </script>
</html>
