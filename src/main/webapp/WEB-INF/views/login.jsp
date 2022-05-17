<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./styles/style.css" />
    <title>Login</title>
  </head>
  <body>
    <div class="login__container">
      <div class="login__wrapper">
        <img src="./assets/icons.png" class="login__logo" />
        <div class="login__form">
          <form action="#" id="loginForm">
            <div class="login__form__question">
              <a href="#"><span>아이디, 비번 잊으셨나요?</span></a>
            </div>
            <div class="login__form__input">
              <!-- <span>아이디</span> -->
              <input
                type="text"
                id="loginId"
                name="loginId"
                placeholder="아이디를 적어주세요."
              />
              <!-- <span>패스워드</span> -->
              <input
                type="password"
                id="loginPassword"
                name="loginPassword"
                placeholder="패스워드를 적어주세요."
              />
            </div>
            <div class="login__form__submit">
              <input type="submit" value="로그인" id="loginSubmit" />
            </div>
          </form>
          <div class="login__form__register">
            <a href="#"><span>회원가입 입력 : ${user}</span></a>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
