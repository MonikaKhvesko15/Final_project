<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">

<head>
    <meta charset="UTF-8">
    <title>Hello, library</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>

<body>
<header>
    <div class="library">
        <fmt:message key="local.title"/>
    </div>


    <div class="buttons">
        <a href="${pageContext.request.contextPath}/controller?command=login_page">
            <fmt:message key="local.login"/>
        </a>

        <div class="language">

            <form>
                <select id="language" name="language" onchange="submit()">
                    <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message
                            key="local.button.en"/></option>
                    <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message
                            key="local.button.ru"/></option>
                    <option value="fr" ${language == 'fr' ? 'selected' : ''}><fmt:message
                            key="local.button.fr"/></option>
                </select>
            </form>

        </div>
    </div>

</header>

<div class="container">
    <nav class="menu">
    </nav>
    <main class="content">
        <p>
            <fmt:message key="local.welcome"/>
        </p>
    </main>
</div>

</body>
</html>