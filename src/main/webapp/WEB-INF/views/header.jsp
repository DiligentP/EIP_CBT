<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
                                           prefix="c"%>
<header>
    <nav>
        <ul>
            <li>
                <a href="/"
                ><img src="/assets/icons.png" class="header__logo"
                /></a>
            </li>
            <li class="header__title">
                <a href="/">정보처리기사 CBT</a>
            </li>
        </ul>
        <ul class="header__nav">
            <li><a href="/">홈</a></li>
            <li><a href="/board/list">게시판</a></li>
            <!-- 로그인 세션이 존재하는 경우 -->
            <c:if test="${not empty login_info}">
                <li id="header_mypage"><a href="/mypage">마이페이지</a></li>
                <li>[${login_info.member_name}]님 반갑습니다</li>
                <li><a href="/logout">로그아웃</a></li>
            </c:if>

            <c:if test="${empty login_info}">
                <li>
                    <a href="/login"><span class="header__login">로그인</span></a>
                </li>
            </c:if>
        </ul>
    </nav>
</header>
