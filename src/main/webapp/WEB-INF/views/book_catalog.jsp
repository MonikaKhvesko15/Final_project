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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/book_catalog_1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/footer.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>

<body>
<jsp:include page="templates/header.jsp"/>
<jsp:include page="templates/leftMenu.jsp"/>
<main class="content">

    <section class="content__container">
        <c:choose>
            <c:when test="${requestScope.foundBook == null}">
                <c:forEach var="book" items="${requestScope.bookList}" varStatus="index">
                    <div class="container-element">

                        <img src="images/book_example.jpg">
                        <div class="element-description">
                            <p><b>Book title:</b>${book.title}</p>
                            <p><b>Author:</b>${book.author}</p>
                            <p><b>Pages:</b>${book.pages}</p>
                            <p><b>Publishing:</b>${book.publisher.name}</p>
                            <p><b>Establich year:</b>${book.publisher.establishyear}</p>
                        </div>
                        <div class="element-amount">
                            <p><b>Amount:</b>${book.amount}</p>
                        </div>
                        <c:if test="${sessionScope.role=='READER'}">
                            <c:choose>
                                <c:when test="${book.amount > 0}">
                                    <div class="buttons">
                                        <form class="order"
                                              action="${pageContext.request.contextPath}/controller?command=order_book"
                                              method="POST">
                                            <input type="hidden" name="bookId" value=${book.id}>
                                            <select id="#type" name="issue_type">
                                                <option value="reader_room" ${type == 'reader_room' ? 'selected' : ''}>
                                                    <fmt:message key="local.form.button.reader_room"/></option>
                                                <option value="subscription" ${type == 'subscription' ? 'selected' : ''}>
                                                    <fmt:message key="local.form.button.subscription"/></option>
                                            </select>
                                            <p><input class="edit" type="submit" value=<fmt:message
                                                    key="local.form.button.order"/>></p>
                                        </form>
                                    </div>
                                </c:when>
                                <c:when test="${book.amount == 0}">
                                    <div class="not_available"><fmt:message key="book.order.not.possible"/></div>
                                </c:when>
                            </c:choose>
                        </c:if>
                        <c:if test="${sessionScope.role=='ADMIN'}">
                            <form class="delete"
                                  action="${pageContext.request.contextPath}/controller?command=delete_book"
                                  method="post">
                                <th class="delete"><a>
                                    <input type="hidden" name="bookId" value="${book.id}">
                                    <input class="edit" type="submit" value=<fmt:message
                                            key="local.delete"/>>
                                </a></th>
                            </form>
                            <form class="delete"
                                  action="${pageContext.request.contextPath}/controller?command=edit_book_page"
                                  method="post">
                                <th class="delete"><a>
                                    <input type="hidden" name="bookId" value="${book.id}">
                                    <input class="edit" type="submit" value=<fmt:message
                                            key="local.edit"/>>
                                </a></th>
                            </form>
                        </c:if>
                    </div>
                </c:forEach>
            </c:when>


        <c:otherwise>
            <div class="container-element">
                <img src="images/book_example.jpg">
                <div class="element-description">
                    <p><b>Book title:</b>${requestScope.foundBook.title}</p>
                    <p><b>Author:</b>${requestScope.foundBook.author}</p>
                    <p><b>Pages:</b>${requestScope.foundBook.pages}</p>
                    <p><b>Publishing:</b>${requestScope.foundBook.publisher.name}</p>
                    <p><b>Establich year:</b>${requestScope.foundBook.publisher.establishyear}</p>
                </div>
                <div class="element-amount">
                    <p><b>Amount:</b>${requestScope.foundBook.amount}</p>
                </div>
                <c:if test="${sessionScope.role=='READER'}">
                    <c:choose>
                        <c:when test="${requestScope.foundBook.amount > 0}">
                            <div class="buttons">
                                <form class="order"
                                      action="${pageContext.request.contextPath}/controller?command=order_book"
                                      method="POST">
                                    <input type="hidden" name="bookId" value=${requestScope.foundBook.id}>
                                    <select id="#type1" name="issue_type">
                                        <option value="reader_room" ${type == 'reader_room' ? 'selected' : ''}>
                                            <fmt:message key="local.form.button.reader_room"/></option>
                                        <option value="subscription" ${type == 'subscription' ? 'selected' : ''}>
                                            <fmt:message key="local.form.button.subscription"/></option>
                                    </select>
                                    <p><input class="edit" type="submit" value=<fmt:message
                                            key="local.form.button.order"/>></p>
                                </form>
                            </div>
                        </c:when>
                        <c:when test="${requestScope.foundBook.amount == 0}">
                            <div class="not_available"><fmt:message key="book.order.not.possible"/></div>
                        </c:when>
                    </c:choose>
                </c:if>
                <c:if test="${sessionScope.role=='ADMIN'}">
                    <form class="delete"
                          action="${pageContext.request.contextPath}/controller?command=delete_book"
                          method="post">
                        <th class="delete"><a>
                            <input type="hidden" name="bookId" value="${requestScope.foundBook.id}">
                            <input class="edit" type="submit" value=<fmt:message
                                    key="local.delete"/>>
                        </a></th>
                    </form>
                    <form class="delete"
                          action="${pageContext.request.contextPath}/controller?command=edit_book_page"
                          method="post">
                        <th class="delete"><a>
                            <input type="hidden" name="bookId" value="${requestScope.foundBook.id}">
                            <input class="edit" type="submit" value=<fmt:message
                                    key="local.edit"/>>
                        </a></th>
                    </form>
                </c:if>
            </div>

        </c:otherwise>

        </c:choose>
    </section>
    <jsp:include page="templates/footer.jsp"/>
</main>


</body>
</html>


