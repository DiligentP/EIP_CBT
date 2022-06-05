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
    <title>마이 페이지</title>
  </head>
  <body>
    <jsp:include page="../header.jsp" />

    <main>
      <div class="main__container">
        <a href="/mypage/mypageResult">
          <div class="mypage_box">
            <span class="main__title">시험 결과</span>
          </div>
        </a>
        <a href="/mypage/questionList?id=${login_info.member_id}">
          <div class="mypage_box">
            <span class="main__title">문제 관리</span>
          </div>
        </a>
        <a href="/mypage/mypageModify">
          <div class="mypage_box">
            <span class="main__title">정보 수정</span>
          </div>
        </a>
      </div>
    </main>
    <jsp:include page="../footer.jsp" />
    <script src="../js/mypage.js"></script>
  </body>
</html>
