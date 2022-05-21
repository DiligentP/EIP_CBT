<%-- Created by IntelliJ IDEA. User: qkrwj Date: 2022-05-17 Time: 오후 5:09 To
change this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./styles/style.css" />
    <title>Register</title>
  </head>
  <body>
    <div class="register__container">
      <div class="register__wrapper">
        <div class="register__wrapper__nav">
          <a href="/">Home</a>
        </div>
        <div class="register__wrapper__main">
          <div class="main__left">
            <span>Create new account</span>
          </div>
          <div class="main__right">
            <div class="main__right__question">
              <span>Already A Member?</span>
              <a href="./login">Log In</a>
            </div>
            <div class="main__right__form">
              <form action="#" id="registerForm">
                <div class="register__form__input">
                  <input
                    type="text"
                    id="registerName"
                    name="registerName"
                    placeholder="이름"
                  />
                  <input
                    type="text"
                    id="registerId"
                    name="registerId"
                    placeholder="아이디"
                  />
                  <input
                    type="password"
                    id="registerPassword"
                    name="registerPassword"
                    placeholder="패스워드"
                  />

                  <input
                    type="email"
                    id="registerEmail"
                    name="registerEmail"
                    placeholder="이메일"
                  />
                </div>
                <div class="register__form__submit">
                  <input type="submit" value="생성" id="registerSubmit" />
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script src="./js/register.js"></script>
  </body>
</html>
