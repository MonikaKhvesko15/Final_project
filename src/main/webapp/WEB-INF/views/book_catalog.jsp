<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset="utf-8">
    <title>Book catalog</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/book_catalog.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>

<body>
<jsp:include page="templates/header.jsp"/>

<div class="container">
    <jsp:include page="templates/leftMenu.jsp"/>

    <main class="content">
        <div class="data">
            <table>

                <c:choose>
                    <c:when test="${requestScope.foundBook == null}">

                        <c:forEach var="book" items="${requestScope.bookList}" varStatus="index">
                            <tr>
                                <td><img src="images/book_example.jpg"></td>
                                <td>${(5)*(requestScope.currentPage - 1) + index.count}</td>
                                <td>${book.title}</td>
                                <td>${book.author}</td>
                                <td>${book.pages}</td>
                                <td>${book.amount}</td>
                                <td>${book.publisher.name}</td>
                                <td>${book.publisher.establishyear}</td>

                                <div class="buttons">
                                    <c:choose>
                                        <c:when test="${book.amount > 0}">
                                            <form class="order"
                                                  action="${pageContext.request.contextPath}/controller?command=order_book"
                                                  method="POST">
                                                <th class="order"><a>
                                                    <select id="type" name="issue_type">
                                                        <option value="reader_room" ${type == 'reader_room' ? 'selected' : ''}>
                                                            <fmt:message
                                                                    key="local.form.button.reader_room"/></option>

                                                        <option value="subscription" ${type == 'subscription' ? 'selected' : ''}>
                                                            <fmt:message
                                                                    key="local.form.button.subscription"/></option>
                                                    </select>
                                                    <input type="" name="bookId" value=${book.id}>
                                                    <input class="btn-submit" type="submit" value=<fmt:message
                                                            key="local.form.button.order"/>>
                                                </a></th>
                                            </form>
                                        </c:when>
                                        <c:when test="${book.amount == 0}">
                                            <fmt:message key="book.order.not.possible"/>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </tr>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${(requestScope.currentPage - 1) == 0}">
                                <a align="center" href="" type="submit" class="pagination"><fmt:message
                                        key="books.previous"/></a>
                            </c:when>
                            <c:otherwise>
                                <a align="center"
                                   href="${pageContext.request.contextPath}/controller?command=book_catalog&currentPage=${requestScope.currentPage-1}"
                                   type="submit" class="pagination"><fmt:message key="books.previous"/></a>
                            </c:otherwise>
                        </c:choose>
                        <div class="pagination">${requestScope.currentPage}</div>
                        <c:choose>
                            <c:when test="${requestScope.bookList.size() != 5}">
                                <a align="center" href="" type="submit" class="pagination"><fmt:message
                                        key="books.next"/></a>
                            </c:when>
                            <c:otherwise>
                                <a align="center"
                                   href="${pageContext.request.contextPath}/controller?command=book_catalog&currentPage=${requestScope.currentPage+1}"
                                   type="submit" class="pagination"><fmt:message key="books.next"/></a>
                            </c:otherwise>
                        </c:choose>
                    </c:when>

                    <c:otherwise>
                        <tr>
                            <td><img src="images/book_example.jpg"></td>
                            <td>${requestScope.foundBook.title}</td>
                            <td>${requestScope.foundBook.author}</td>
                            <td>${requestScope.foundBook.pages}</td>
                            <td>${requestScope.foundBook.amount}</td>
                            <td>${requestScope.foundBook.publisher.name}</td>
                            <td>${requestScope.foundBook.publisher.establishyear}</td>

                            <div class="buttons">
                                <c:choose>
                                    <c:when test="${requestScope.foundBook.amount > 0}">
                                        <form class="order"
                                              action="${pageContext.request.contextPath}/controller?command=order_book"
                                              method="POST">
                                            <th class="order"><a>
                                                <select id="type" name="issue_type">
                                                    <option value="reader_room" ${type == 'reader_room' ? 'selected' : ''}>
                                                        <fmt:message
                                                                key="local.form.button.reader_room"/></option>

                                                    <option value="subscription" ${type == 'subscription' ? 'selected' : ''}>
                                                        <fmt:message
                                                                key="local.form.button.subscription"/></option>
                                                </select>
                                                <input type="" name="bookId" value=${requestScope.foundBook.id}>
                                                <input class="btn-submit" type="submit" value=<fmt:message
                                                        key="local.form.button.order"/>>
                                            </a></th>
                                        </form>
                                    </c:when>
                                    <c:when test="${book.amount == 0}">
                                        <fmt:message key="book.order.not.possible"/>
                                    </c:when>
                                </c:choose>
                            </div>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>


        </div>

    </main>
</div>
</body>
</html>


