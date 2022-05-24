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
              <form action="./register_confirm" method="post" id="registerForm">
                <div class="register__form__input">
                  <input
                    type="text"
                    id="registerId"
                    name="member_id"
                    placeholder="아이디"
                    required oninput="checkId()"
                  />
                  <!-- hidden -->
                  <span class="id_ok" style="color:#6A82FB; display: none; padding-left: 10px;">사용 가능한 아이디입니다.</span>
                  <span class="id_already" style="color:#ff006e; display: none; padding-left: 10px;">누군가 이 아이디를 사용하고 있어요.</span>

                  <input
                    type="password"
                    id="registerPassword"
                    name="member_password"
                    placeholder="패스워드"
                  />
                  <input
                          type="text"
                          id="registerName"
                          name="member_name"
                          placeholder="이름"
                  />
                  <input
                    type="email"
                    id="registerEmail"
                    name="member_email"
                    placeholder="이메일"
                  />
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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

    <!-- Ajax -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
      function checkId(){
        var id = $('#registerId').val(); //id값이 "registerId"인 입력란의 값을 저장
        $.ajax({
          url:'/idCheck', //Controller에서 인식할 주소
          type:'post', //POST 방식으로 전달
          data:{id:id},
          success:function(result){
            //사용 가능한 아이디일때
            if(result != 1){
              $('.id_ok').css("display","inline-block");
              $('.id_already').css("display", "none")
            }else { // 이미 존재하는 아이디 일때
              $('.id_already').css("display","inline-block");
              $('.id_ok').css("display", "none");
            }
          },
          error:function(){
            alert("에러입니다");
          }
        });
      };
    </script>
  </body>
</html>
