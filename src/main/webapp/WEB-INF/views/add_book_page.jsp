<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">

<head>
    <meta charset="utf-8">
    <title>Add book page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/book_page.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="templates/header.jsp"/>


<div class="container">
    <jsp:include page="templates/leftMenu.jsp"/>

    <main class="content">
        <div class="data">
            <img src="${pageContext.request.contextPath}/images/book_example.jpg" alt="">
            <table>
                <form action="${pageContext.request.contextPath}/controller?command=add_book" method="POST">
                    <input type="hidden" name="bookId" value="${null}">
                    <tr>
                        <th><fmt:message key="local.book.title"/></th>
                        <th class="input"><input type="text" name="title" minlength="2" maxlength="50" required></th>
                    </tr>
                    <tr>
                        <th><fmt:message key="local.book.author"/></th>
                        <th class="input"><input type="text" name="author" minlength="2" maxlength="50"
                                                 pattern="([^0-9!*$?]+)" required></th>
                    </tr>
                    <tr>
                        <th><fmt:message key="local.book.pages"/></th>
                        <th class="input"><input type="number" name="pages" min="1" max="3000" required></th>
                    </tr>
                    <tr>
                        <th><fmt:message key="local.book.amount"/></th>
                        <th class="input"><input type="number" name="amount" min="0" max="1000" required></th>
                    </tr>
                    <tr>
                        <th><fmt:message key="local.book.publisher.name"/></th>
                        <th class="input">
                            <select name="publisherName">
                                <option value="Penguin Random House">Penguin Random House</option>

                                <option value="Hachette Livre">Hachette Livre</option>

                                <option value="HarperCollins">HarperCollins</option>

                                <option value="Macmillan Publishers">Macmillan Publishers</option>

                                <option value="Simon & Schuster">Simon & Schuster</option>
                            </select>
                        </th>
                    </tr>
                    <tr>
                        <th class="input"><input class="edit" type="submit" value=<fmt:message key="local.add"/>></th>
                    </tr>
                </form>
                <c:if test="${invalidData}">
                    <span style="color: orangered"><fmt:message key="invalid.data"/></span>
                </c:if>
            </table>
        </div>
    </main>
</div>
</body>
</html>