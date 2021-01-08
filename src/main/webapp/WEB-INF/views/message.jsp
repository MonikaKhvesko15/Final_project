<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${requestScope.language}">
<head>
    <meta charset="UTF-8">
    <title>Message</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<div class="container">
    <jsp:include page="templates/leftMenu.jsp"/>

    <main class="content">

        <c:if test="${bookNotFound}">
            <p><fmt:message key="message.book.not.found"/></p>
        </c:if>

        <c:if test="${bookOrdered}">
            <p><fmt:message key="message.book.ordered"/></p>
        </c:if>

        <c:if test="${noOrders}">
            <p><fmt:message key="message.no.orders"/></p>
        </c:if>

        <c:if test="${bookDeleted}">
            <p><fmt:message key="message.book.deleted"/></p>
        </c:if>

        <c:if test="${bookEdited}">
            <p><fmt:message key="message.book.edited"/></p>
        </c:if>

        <c:if test="${bookAdded}">
            <p><fmt:message key="message.book.added"/></p>
        </c:if>

    </main>

</div>
</body>
</html>