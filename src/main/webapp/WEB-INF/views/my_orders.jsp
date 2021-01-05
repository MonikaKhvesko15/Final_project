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
                    <c:if test="${order.userName==sessionScope.user.firstname}">
                        <tr>
                            <td>${order.bookTitle}</td>
                            <td>${order.bookAuthor}</td>
                            <td>${order.issueDate}</td>
                            <td>${order.returnDate}
<%--                                <c:when test="${requestScope.currentData.isAfter(order.returnDate)}">--%>
<%--                                <span--%>
<%--                                        style="color:orangered">${order.returnDate}</span>--%>
<%--                            </c:when>--%>
<%--                                <c:otherwise>${order.returnDate}</c:otherwise>--%>
                            </td>
                            <td>${order.type}</td>
                            <td>${order.status}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                <c:choose>
                    <c:when test="${(requestScope.currentPage - 1) == 0}">
                        <a align="center" href="" type="submit" class="pagination"><fmt:message
                                key="orders.previous"/></a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=view_orders&currentPage=${requestScope.currentPage-1}"
                           type="submit" class="pagination"><fmt:message key="orders.previous"/></a>
                    </c:otherwise>
                </c:choose>
                <div class="pagination">${requestScope.currentPage}</div>
                <c:choose>
                    <c:when test="${requestScope.orderList.size() != 15}">
                        <a align="center" href="" type="submit" class="pagination"><fmt:message key="orders.next"/></a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=view_orders&currentPage=${requestScope.currentPage+1}"
                           type="submit" class="pagination"><fmt:message key="orders.next"/></a>
                    </c:otherwise>
                </c:choose>
            </table>


        </div>

    </main>
</div>
</body>
</html>


