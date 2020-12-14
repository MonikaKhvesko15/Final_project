           <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


        <fmt:setLocale value="${sessionScope.lang}"/>
        <fmt:setBundle basename="property.local"/>

        <html lang="${sessionScope.lang}">

        <head>
        <meta charset="UTF-8">
        <title>Hello, library</title>
        <link rel = "stylesheet" href = "${pageContext.request.contextPath}/styles/main.css">
        <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        </head>
        <body>
        <header>
        <div class = "library">
        <fmt:message key="local.title"/>
        </div>


        <div class = "buttons">
        <a href = "${pageContext.request.contextPath}/views/login.jsp">
        <fmt:message key="local.login"/>
        </a>

        <div class = "language">

        <form method="post"
        action="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}">
        <input type="hidden" name="lang" value="en"/>
        <button type="submit">
        <fmt:message key="local.button.english"/>
        </button>
        </form>

        <form method="post"
        action="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.queryString}">
        <input type="hidden" name="lang" value="ru"/>
        <button type="submit">
        <fmt:message key="local.button.russian"/>
        </button>
        </form>

        </div>
        </div>

        </header>

        <div class = "container">
        <nav class = "menu">
        </nav>
        <main class = "content">
        <p>
        <fmt:message key="local.welcome"/>
        </p>
        </main>
        </div>

        </body>
        </html>