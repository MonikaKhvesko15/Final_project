<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset="utf-8">
    <title>My orders</title>
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

                <c:forEach var="order" items="${requestScope.orderList}" varStatus="index">
                    <tr>
                        <td>${(10)*(requestScope.currentPage - 1) + index.count}</td>
                        <td>${order.userName}</td>
                        <td>${order.userSurname}</td>
                        <td>${order.bookTitle}</td>
                        <td>${order.bookAuthor}</td>
                        <td>${order.type}</td>

                        <div class="buttons">
                            <c:choose>
                                <c:when test="${order.status=='UNDER_CONSIDERATION'}">
                                    <form class="issue"
                                          action="${pageContext.request.contextPath}/controller?command=issue_book"
                                          method="POST">
                                        <th class="issue">
                                            <a>
                                                <input type="hidden" name="orderId" value=${order.id}>
                                                <input class="btn-submit" type="submit" value=<fmt:message
                                                        key="local.issue"/>>
                                            </a>
                                        </th>
                                    </form>
                                </c:when>
                                <c:when test="${order.status=='ACCEPTED'}">
                                    <form class="return"
                                          action="${pageContext.request.contextPath}/controller?command=return_book"
                                          method="POST">
                                        <th class="return">
                                            <a>
                                                <input type="hidden" name="orderId" value=${order.id}>
                                                <input class="btn-submit" type="submit" value=<fmt:message
                                                        key="local.return"/>>
                                            </a>
                                        </th>
                                    </form>
                                </c:when>
                            </c:choose>
                        </div>
                    </tr>
                </c:forEach>
                <c:choose>
                    <c:when test="${(requestScope.currentPage - 1) == 0}">
                        <a align="center" href="" type="submit" class="pagination"><fmt:message
                                key="orders.previous"/></a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=my_orders&currentPage=${requestScope.currentPage-1}"
                           type="submit" class="pagination"><fmt:message key="orders.previous"/></a>
                    </c:otherwise>
                </c:choose>
                <div class="pagination">${requestScope.currentPage}</div>
                <c:choose>
                    <c:when test="${requestScope.orderList.size() != 10}">
                        <a align="center" href="" type="submit" class="pagination"><fmt:message key="orders.next"/></a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=my_orders&currentPage=${requestScope.currentPage+1}"
                           type="submit" class="pagination"><fmt:message key="orders.next"/></a>
                    </c:otherwise>
                </c:choose>
            </table>


        </div>

    </main>
</div>
</body>
</html>


