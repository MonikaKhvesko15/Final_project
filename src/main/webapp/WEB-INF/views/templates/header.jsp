<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${requestScope.language}">
<header>
    <div class="library">
        <fmt:message key="local.title"/>
    </div>

    <div class="search">
        <c:choose>
            <c:when test="${requestScope.isBookPage}">
                <form action="${pageContext.request.contextPath}/controller"
                      method="GET">
                    <input type="hidden" name="command" value="book_search">
                    <input class="enter" type="text" name="title">
                    <input class="edit" type="submit" value="<fmt:message key="local.search"/>">
                </form>
            </c:when>
        </c:choose>
    </div>

    <c:choose>
        <c:when test="${sessionScope.user.role == 'READER'}">
            <div class="user">
                <a href="${pageContext.request.contextPath}/controller?command=home_page">
                    <img src="${pageContext.request.contextPath}/images/person.jpg" alt="Home page">
                </a>
                <a href="${pageContext.request.contextPath}/controller?command=home_page">
                    <p><c:out value="${sessionScope.user.firstname}"/></p>
                </a>
            </div>
        </c:when>
        <c:when test="${sessionScope.user.role == 'LIBRARIAN'}">
            <div class="user">
                <a href="${pageContext.request.contextPath}/controller?command=home_page">
                    <img src="${pageContext.request.contextPath}/images/person.jpg" alt="Home page">
                </a>
                <a href="${pageContext.request.contextPath}/controller?command=home_page">
                    <p><c:out value="${sessionScope.user.firstname}"/></p>
                </a>
            </div>
        </c:when>
        <c:when test="${sessionScope.user.role == 'ADMIN'}">
            <div class="user">
                <a href="${pageContext.request.contextPath}/controller?command=home_page">
                    <img src="${pageContext.request.contextPath}/images/person.jpg" alt="Home page">
                </a>
                <a href="${pageContext.request.contextPath}/controller?command=home_page">
                    <p><c:out value="${sessionScope.user.firstname}"/></p>
                </a>
            </div>
        </c:when>
    </c:choose>

    <div class="buttons">

        <c:choose>
            <c:when test="${sessionScope.user == null}">
                <a href="${pageContext.request.contextPath}/controller?command=login_page">
                    <fmt:message key="local.login"/></a>
                <a href="${pageContext.request.contextPath}/controller?command=registration_page">
                    <fmt:message key="local.registration"/></a>
            </c:when>
            <c:when test="${sessionScope.user != null}">
                <a href="${pageContext.request.contextPath}/controller?command=logout">
                    <fmt:message key="local.logout"/></a>
            </c:when>
        </c:choose>

        <form class="language" method="post"
              action="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}">
            <select id="language" name="language" onchange="submit()">
                <option value="ru" ${language == 'ru' ? 'selected' : ''} selected><fmt:message
                        key="local.button.ru"/></option>

                <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message
                        key="local.button.en"/></option>

                <option value="fr" ${language == 'fr' ? 'selected' : ''}><fmt:message
                        key="local.button.fr"/></option>
            </select>
        </form>
    </div>

</header>
</html>