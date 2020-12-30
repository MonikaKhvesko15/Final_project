<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset="utf-8">
    <title>Login page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/login.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>

<body>
<jsp:include page="templates/header.jsp"/>
<div class="container">
    <nav class="menu"></nav>
    <main class="content">
        <p><fmt:message key="local.welcome"/></p>
        <form class="login" action="${pageContext.request.contextPath}/controller?command=login" method="POST">
            <h2><fmt:message key="local.login"/></h2>
            <h3><fmt:message key="local.form.login.message"/></h3>
            <label><span><fmt:message key="local.form.login.username"/></span> <input type="text" name="login" required></label>
            <label><span><fmt:message key="local.form.login.password"/> </span> <input type="password" name="password"
                                                                                       required></label>
            <input class="btn-submit" type="submit" value=<fmt:message key="local.form.button.login"/>>
        </form>
        ${errorMessage}
    </main>
</div>
</body>
</html>