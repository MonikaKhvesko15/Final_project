<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<nav class="menu">
    <div class="topnav">
        <ul>
            <c:choose>
                <c:when test="${sessionScope.role == 'GUEST'}">
                    <p id="menuHeader"><fmt:message key="local.menu"/></p>
                    <li><a href="${pageContext.request.contextPath}/controller?command=book_catalog"><fmt:message
                            key="local.menu.book.catalog"/></a></li>
                </c:when>
                <c:when test="${sessionScope.user.role == 'READER'}">
                    <p id="menuHeader"><fmt:message key="local.menu"/></p>
                    <li><a href="${pageContext.request.contextPath}/controller?command=book_catalog"><fmt:message
                            key="local.menu.book.catalog"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=reader_orders"><fmt:message
                            key="local.menu.reader.orders"/></a></li>
                </c:when>
                <c:when test="${sessionScope.user.role == 'LIBRARIAN'}">
                    <p id="menuHeader"><fmt:message key="local.menu"/></p>
                    <li><a href="${pageContext.request.contextPath}/controller?command=view_orders"><fmt:message
                            key="local.menu.all.orders"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=orders_history"><fmt:message
                            key="local.menu.orders.history"/></a></li>
                </c:when>
                <c:when test="${sessionScope.user.role == 'ADMIN'}">
                    <p id="menuHeader"><fmt:message key="local.menu"/></p>
                    <li><a href="${pageContext.request.contextPath}/controller?command=book_catalog"><fmt:message
                            key="local.menu.book.catalog"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=add_book_page"><fmt:message
                            key="local.menu.librarian.add.book"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=view_readers"><fmt:message
                            key="local.menu.reader.list"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=view_librarians"><fmt:message
                            key="local.menu.librarian.list"/></a></li>
                </c:when>
            </c:choose>
        </ul>
    </div>
</nav>
</html>