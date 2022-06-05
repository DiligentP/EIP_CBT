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
    <title>EIP</title>
  </head>
  <body>
    <jsp:include page="header.jsp" />

    <main>
      <div class="main__block">
        <div class="main__title2">
          <span>정보 처리 기사 CBT 문제 풀기</span>
        </div>
        <div class="main__subTitle">
          <span>정보처리기사 합격을 기원합니다.</span>
        </div>
        <div class="main__btn">
          <a href="/question/setting">
            <span>시작하기</span>
          </a>
        </div>
      </div>
    </main>

    <jsp:include page="footer.jsp" />
    <script src="./js/index.js"></script>
  </body>
</html>
