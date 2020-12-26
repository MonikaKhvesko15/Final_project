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
            <p id="menuHeader"><fmt:message key="local.menu"/></p>

            <c:choose>
                <c:when test="${sessionScope.user.role == 'READER'}">
                    <li><a href="${pageContext.request.contextPath}/controller?command=home_page"><fmt:message
                            key="local.menu.home"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=book_catalog"><fmt:message
                            key="local.menu.book.catalog"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=view_orders"><fmt:message
                            key="local.menu.reader.orders"/></a></li>
                </c:when>
                <c:when test="${sessionScope.user.role == 'LIBRARIAN'}">
                    <li><a href="${pageContext.request.contextPath}/controller?command=home_page"><fmt:message
                            key="local.menu.home"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=view_orders"><fmt:message
                            key="local.menu.all.orders"/></a></li>
                </c:when>
                <c:when test="${sessionScope.user.role == 'ADMIN'}">
                    <li><a href="${pageContext.request.contextPath}/controller?command=home_page"><fmt:message
                            key="local.menu.home"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=book_catalog"><fmt:message
                            key="local.menu.book.catalog"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=add_book"><fmt:message
                            key="local.menu.librarian.add.book"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=reader_list"><fmt:message
                            key="local.menu.reader.list"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/controller?command=librarian_list"><fmt:message
                            key="local.menu.librarian.list"/></a></li>
                </c:when>
            </c:choose>
        </ul>
    </div>
</nav>
</html>