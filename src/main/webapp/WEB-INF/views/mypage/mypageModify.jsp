<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/styles/style.css" />
    <title>마이 페이지</title>
  </head>
  <body>
    <jsp:include page="header.jsp" />

    <wrapper>
      <div class="wrapper">
        <div class="wrapper__container">
          <div class="wrapper__container__Main">
            <div class="board__register">
              <h2>정보 수정</h2>
            </div>
            <!-- input 태그  -->
            <form action="#" id="board__form">
              <div class="board__form__input">
                <input placeholder="id" name="member_id" readonly="readonly" />
                <input
                  type="password"
                  id="registerPassword"
                  placeholder="password"
                  name="member_password"
                />
                <input
                  type="text"
                  id="registerName"
                  placeholder="name"
                  name="member_name"
                />

                <input
                  type="email"
                  id="registerEmail"
                  placeholder="email"
                  name="member_email"
                />
              </div>
              <div class="board__form__submit">
                <div class="">
                  <input type="submit" value="수정" id="boardRegister" />
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </wrapper>
    <jsp:include page="footer.jsp" />
  </body>
</html>
