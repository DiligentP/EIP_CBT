<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../styles/style.css" />
    <title>EIP</title>
  </head>
  <body>
    <jsp:include page="../header.jsp" />

    <main>
      <div class="main__container">
        <a href="#" onclick="exam('w')">
          <div class="main__written">
            <span class="main__title">필기</span>
          </div>
        </a>
        <a href="#" onclick="exam('p')">
          <div class="main_practical">
            <span class="main__title">실기</span>
          </div>
        </a>
      </div>
    </main>

    <jsp:include page="../footer.jsp" />
    <script src="../js/index.js"></script>
  </body>

  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script>
    let qArray = new Array();
    function exam(type){
      let count = 0;
      let title = new Array();
      $.ajax({
        url: `/question/count`, //Controller에서 인식할 주소
        type: "get", //get 방식으로 전달
        data: { exam: type },
        dataType: "json",
        success: function (result){
          count = result;

          if(count == -1){
            alert("문제가 없습니다!")
            location.href="/question/#";
          }else{
            // 랜덤 문제 생성
            let n = Math.floor(Math.random() * count) + 1;

            // 세션 생성
            sessionStorage.setItem('qJson', JSON.stringify(qArray));
            sessionStorage.setItem('count',count);

            if(type == "w"){
              location.href="/question/written/get?div="+type+"&&qno="+n;
            }
            else if(type == "p"){
              location.href="/question/practical/get?div="+type+"&&qno="+n;
            }
            else{
              alert("페이지 이동 에러 (컨트롤러가 응답하지 않습니다)")
            }
          }
        },
        error: function (error){
          alert("에러");
        }
      });
    };
  </script>
</html>
