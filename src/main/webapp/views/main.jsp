<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${currentLocale}"/>
<fmt:setBundle basename="property/local"/>

    <html>
    <head>
    <meta charset = "utf-8">
    <title>Hello, library</title>
    <link rel = "stylesheet" href = "${pageContext.request.contextPath}/styles/main.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    </head>
    <body>
    <header>
    <div class = "library">Library</div>
    <div class = "buttons"><a href = "${pageContext.request.contextPath}/views/login.jsp">Login</a>
    <a href = "${pageContext.request.contextPath}/views/main.jsp">Language</a></div>
    </header>
    <div class = "container">
    <nav class = "menu"></nav>
    <main class = "content"><p>Welcome to the Library!</p></main>
    </div>
    </body>
    </html>