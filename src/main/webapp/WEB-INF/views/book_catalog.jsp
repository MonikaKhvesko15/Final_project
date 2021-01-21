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
                            <p><b><fmt:message key="local.book.title"/></b>${book.title}</p>
                            <p><b><fmt:message key="local.book.author"/></b>${book.author}</p>
                            <p><b><fmt:message key="local.book.pages"/></b>${book.pages}</p>
                            <p><b><fmt:message key="local.book.publisher.name"/></b>${book.publisher.name}</p>
                            <p><b><fmt:message key="local.book.publisher.year"/></b>${book.publisher.establishyear}</p>
                        </div>
                        <div class="element-amount">
                            <p><b><fmt:message key="local.book.amount"/></b>${book.amount}</p>
                        </div>
                        <c:if test="${sessionScope.user.role=='READER'}">
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
                        <c:if test="${sessionScope.user.role=='ADMIN'}">
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
                        <p><b><fmt:message key="local.book.title"/></b>${requestScope.foundBook.title}</p>
                        <p><b><fmt:message key="local.book.author"/></b>${requestScope.foundBook.author}</p>
                        <p><b><fmt:message key="local.book.pages"/></b>${requestScope.foundBook.pages}</p>
                        <p><b><fmt:message key="local.book.publisher.name"/></b>${requestScope.foundBook.publisher.name}
                        </p>
                        <p><b><fmt:message
                                key="local.book.publisher.year"/></b>${requestScope.foundBook.publisher.establishyear}
                        </p>
                    </div>
                    <div class="element-amount">
                        <p><b><fmt:message key="local.book.amount"/></b>${requestScope.foundBook.amount}</p>
                    </div>
                    <c:if test="${sessionScope.user.role=='READER'}">
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
                    <c:if test="${sessionScope.user.role=='ADMIN'}">
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

    <%--    PAGINATION   --%>
    <c:if test="${requestScope.foundBook==null}">
        <div class="center">
            <div class="pagination" align="center">
                <c:choose>
                    <c:when test="${(requestScope.currentPage - 1) == 0}">
                        <a align="center" href="" type="submit">&laquo;</a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=book_catalog&currentPage=${requestScope.currentPage-1}"
                           type="submit">&laquo;</a>
                    </c:otherwise>
                </c:choose>
                <a href="" class="active">${requestScope.currentPage}</a>
                <c:choose>
                    <c:when test="${requestScope.bookList.size() != 5}">
                        <a align="center" href="" type="submit">&raquo;</a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=book_catalog&currentPage=${requestScope.currentPage+1}"
                           type="submit">&raquo;</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </c:if>
    <%--    PAGINATION   --%>
</main>


</body>
</html>


