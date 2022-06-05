<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
        uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/styles/style.css" />
    <title>필기 시험</title>
</head>
<body>
<jsp:include page="header.jsp" />

<test>
    <div class="test">
        <div class="test__container">
            <div class="test__titleNum">
                <span>CBT 문제 설정</span>
            </div>
            <form>
            <div class="test__question">
                <span>문제 유형</span>
                <input type="radio" id="written"
                       name="contact" value="written">
                <label for="written">
                    <div class="main__written">
                        <span class="main__title">필기</span>
                    </div>
                </label>
                <input type="radio" id="practical"
                       name="contact" value="practical">
                <label for="practical">
                    <div class="main_practical">
                        <span class="main__title">실기</span>
                    </div>
                </label>
            </div>
                <button type="submit" id="answer__btn">시험 시작</button>
            </form>
            <div class="test__written__answer">
                <span>...</span>
            </div>
        </div>
        <div class="answer__container">
<%--            <button type="submit" id="answer__btn">시험 시작</button>--%>
        </div>
    </div>
</test>
<jsp:include page="footer.jsp" />
</body>
</html>