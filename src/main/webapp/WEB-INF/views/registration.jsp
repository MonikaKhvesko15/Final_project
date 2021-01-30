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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/registration.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>

<body>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/leftMenu.jsp"/>
<div class="container">
    <main class="content">
        <form class="registration" action="${pageContext.request.contextPath}/controller?command=registration"
              method="POST">
            <h2><fmt:message key="local.registration"/></h2>
            <h3><fmt:message key="local.form.registration.message"/></h3>
            <label><span><fmt:message key="local.form.register.firstname"/></span> <input type="text" name="firstname"
                                                                                          pattern="([A-Z]{1}[a-z]+)|([А-Я]{1}[а-яёЁ]+)"
                                                                                          minlength="2" maxlength="20"
                                                                                          required></label>
            <label><span><fmt:message key="local.form.register.surname"/></span> <input type="text" name="surname"
                                                                                        pattern="([A-Z]{1}[a-z]+)|([А-Я]{1}[а-яёЁ]+)"
                                                                                        minlength="2" maxlength="20"
                                                                                        required></label>
            <label><span><fmt:message key="local.form.register.role"/></span>
                <div class="user-role">
                    <select class="select-role" name="role">
                        <option value="READER"><fmt:message key="local.user.role.reader"/></option>

                        <option value="LIBRARIAN"><fmt:message key="local.user.role.librarian"/></option>
                    </select>
                </div>
            </label>
            <label><span><fmt:message key="local.form.register.username"/></span> <input type="text" name="login"
                                                                                         pattern="([^!@#$%^&*()+=-]+)"
                                                                                         minlength="2" maxlength="20"
                                                                                         required></label>
            <label><span><fmt:message key="local.form.register.password"/> </span> <input type="password"
                                                                                          name="password" minlength="5"
                                                                                          maxlength="20"
                                                                                          required></label>
            <label><span><fmt:message key="local.form.repeat.password"/> </span> <input type="password"
                                                                                        name="repeat_password"
                                                                                        minlength="5" maxlength="20"
                                                                                        required></label>
            <input class="btn-submit" type="submit" value=<fmt:message key="local.form.register"/>>
        </form>
        <c:if test="${param.message=='invalidData'}">
            <h3><span style="color: orangered"><fmt:message key="registration.message.invalid.data"/></span></h3>
        </c:if>
        <c:if test="${param.message=='passwordMismatch'}">
            <h3><span style="color: orangered"><fmt:message key="registration.message.password.mismatch"/></span></h3>
        </c:if>
        <c:if test="${param.message=='suchUserExists'}">
            <h3><span style="color: orangered"><fmt:message key="registration.message.user.exists"/></span></h3>
        </c:if>
    </main>
</div>
</body>
</html>