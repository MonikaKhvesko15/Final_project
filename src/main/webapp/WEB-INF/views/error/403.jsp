<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset="UTF-8">
    <title>Error 403</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/error.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>

<body>
<jsp:include page="../templates/header.jsp"/>
<div class="container">
    <nav class="menu"></nav>
    <main class="content">
        <p><fmt:message key="error.403"/></p>
    </main>
</div>
</body>
</html>