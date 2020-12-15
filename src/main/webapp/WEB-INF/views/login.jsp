    <%@ page contentType="text/html;charset=UTF-8" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <c:set var="language"
           value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
           scope="session"/>
        <fmt:setLocale value="${sessionScope.language}"/>
        <fmt:setBundle basename="property.local"/>

    <html lang="${sessionScope.language}">

        <head>
        <meta charset="utf-8">
        <title>Login page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/login.css">
        <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        </head>

        <body>
        <header>
        <div class="library">
                <fmt:message key="local.title"/>
        </div>
        <div class="buttons">
                <a href="main.jsp">
                        <fmt:message key="local.login"/>
                </a>
        <div class = "language">
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
        <nav class="menu"></nav>
        <main class="content">
        <p><fmt:message key="local.welcome"/></p>
        <form action="${pageContext.request.contextPath}/controller?command=login" method="POST" >
        <h2><fmt:message key="local.login"/></h2>
        <h3><fmt:message key="local.form.login.message" /></h3>
        <label><span><fmt:message key="local.form.login.username"/></span> <input type="text" name="login" required></label>
        <label><span><fmt:message key="local.form.login.password"/> </span> <input type="password" name="password" required></label>
        <input class="btn-submit" type="submit" value="Login">
        </form>
        ${errorMessage}
        </main>
        </div>
        </body>

        </html>