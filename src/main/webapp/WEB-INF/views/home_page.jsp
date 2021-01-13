<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">

<head>
    <meta charset="utf-8">
    <title>Home page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/home_page.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="templates/header.jsp"/>


<div class="container">
    <jsp:include page="templates/leftMenu.jsp"/>

    <main class="content">
        <div class="data">
            <img src="${pageContext.request.contextPath}/images/person.jpg">

            <table>
                <tr>
                    <th><fmt:message key="local.name"/></th>
                    <th><c:out value="${sessionScope.user.firstname}"/></th>
                </tr>
                <tr>
                    <th><fmt:message key="local.surname"/></th>
                    <th><c:out value="${sessionScope.user.surname}"/></th>
                </tr>

                <tr>
                    <th></th>
                </tr>

                <tr>
                    <th><fmt:message key="local.status"/></th>
                    <th>
                        <c:if test="${sessionScope.user.blocked == true}">
                            <fmt:message key="local.status.block"/>
                        </c:if>
                        <c:if test="${sessionScope.user.blocked == false}">
                            <fmt:message key="local.status.unblock"/>
                        </c:if>
                    </th>
                </tr>
            </table>
            <form action="${pageContext.request.contextPath}/controller?command=edit_user" method="POST">
                <div class="editField"><input type="text" name="firstname" required class = "enter"></div>
                <div class="editField"><input type="text" name="surname" required class = "enter"></div>
                <input class="edit" type="submit" value=<fmt:message key="local.edit"/>>
            </form>
            <c:if test="${invalidData}">
               <span style="color: orangered"><fmt:message key="invalid.data"/></span>
            </c:if>
        </div>
    </main>
</div>
</body>
</html>