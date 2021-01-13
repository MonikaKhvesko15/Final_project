<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset="utf-8">
    <title>All orders</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/orders.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/footer.css">
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
                <tr>
                    <td><b></b></td>
                    <td><b><fmt:message key="local.order.user.name"/></b></td>
                    <td><b><fmt:message key="local.order.user.surname"/></b></td>
                    <td><b><fmt:message key="local.book.title"/></b></td>
                    <td><b><fmt:message key="local.book.author"/></b></td>
                    <td><b><fmt:message key="local.order.type"/></b></td>
                    <td><b></b></td>
                </tr>
                <c:forEach var="order" items="${requestScope.orderList}" varStatus="index">
                    <tr>
                        <td>${(20)*(requestScope.currentPage - 1) + index.count}</td>
                        <td>${order.userName}</td>
                        <td>${order.userSurname}</td>
                        <td>${order.bookTitle}</td>
                        <td>${order.bookAuthor}</td>
                        <td>
                            <c:if test="${order.type =='SUBSCRIPTION'}">
                                <fmt:message key="local.order.type.subscription"/>
                            </c:if>
                            <c:if test="${order.type == 'READER_ROOM'}">
                                <fmt:message key="local.order.type.reader_room"/>
                            </c:if>
                        </td>

                        <div class="buttons">
                            <c:choose>
                                <c:when test="${order.status=='UNDER_CONSIDERATION'}">
                                    <form action="${pageContext.request.contextPath}/controller?command=issue_book"
                                          method="POST">
                                        <th><a>
                                            <input type="hidden" name="orderId" value=${order.id}>
                                            <input class="edit" type="submit" value="<fmt:message
                                                        key="local.giveout"/>">
                                        </a>
                                        </th>
                                    </form>
                                </c:when>
                                <c:when test="${order.status=='ACCEPTED'}">
                                    <form action="${pageContext.request.contextPath}/controller?command=return_book"
                                          method="POST">
                                        <th><a>
                                            <input type="hidden" name="orderId" value=${order.id}>
                                            <input type="hidden" name="bookTitle" value="${order.bookTitle}">
                                            <input class="edit" type="submit" value=<fmt:message
                                                    key="local.return"/>>
                                        </a>
                                        </th>
                                    </form>
                                </c:when>
                            </c:choose>
                        </div>
                    </tr>
                </c:forEach>
            </table>
        </div>


        <%--    pagination--%>
        <div class="center">
            <div class="pagination" align="center">
                <c:choose>
                    <c:when test="${(requestScope.currentPage - 1) == 0}">
                        <a align="center" href="" type="submit">&laquo;</a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=view_orders&currentPage=${requestScope.currentPage-1}"
                           type="submit">&laquo;</a>
                    </c:otherwise>
                </c:choose>
                <a href="" class="active">${requestScope.currentPage}</a>
                <c:choose>
                    <c:when test="${requestScope.bookList.size() != 20}">
                        <a align="center" href="" type="submit">&raquo;</a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=view_orders&currentPage=${requestScope.currentPage+1}"
                           type="submit">&raquo;</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <%--    pagination--%>
    </main>
</div>
</body>
</html>


