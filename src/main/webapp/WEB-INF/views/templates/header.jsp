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

    <div class = "search">
    <c:choose>
        <c:when test="${requestScope.isBookPage}">
            <form action="${pageContext.request.contextPath}/controller?command=book_search"
                  method="POST">
                <input class = "enter" type="text" name="title">
                <input class = "edit" type="submit" value="search">
            </form>
        </c:when>
    </c:choose>
    </div>

    <c:choose>
        <c:when test="${sessionScope.user.role == 'READER'}">
            <div class="user">
                <img src="${pageContext.request.contextPath}/images/person.jpg">
                <p><c:out value="${sessionScope.user.firstname}"/></p>
            </div>
        </c:when>
        <c:when test="${sessionScope.user.role == 'LIBRARIAN'}">
            <div class="user">
                <img src="${pageContext.request.contextPath}/images/person.jpg">
                <p><c:out value="${sessionScope.user.firstname}"/></p>
            </div>
        </c:when>
        <c:when test="${sessionScope.user.role == 'ADMIN'}">
            <div class="user">
                <img src="${pageContext.request.contextPath}/images/person.jpg">
                <p><c:out value="${sessionScope.user.firstname}"/></p>
            </div>
        </c:when>
    </c:choose>

    <div class="buttons">

        <c:choose>
            <c:when test="${sessionScope.login == null}">
                <a href="${pageContext.request.contextPath}/controller?command=login_page">
                    <fmt:message key="local.login"/></a>
            </c:when>
            <c:when test="${sessionScope.login != null}">
                <a href="${pageContext.request.contextPath}/controller?command=logout">
                    <fmt:message key="local.logout"/></a>
            </c:when>
        </c:choose>

        <form class="language" method="post"
              action="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}">
            <select id="language" name="language" onchange="submit()">
                <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message
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