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
      <div class="main__container">
        <a href="./question/setting">
          <div class="main__written">
            <span class="main__title">필기</span>
          </div>
        </a>
        <a href="./practical">
          <div class="main_practical">
            <span class="main__title">실기</span>
          </div>
        </a>
      </div>
    </main>

    <jsp:include page="footer.jsp" />
    <script src="./js/index.js"></script>
  </body>
</html>
