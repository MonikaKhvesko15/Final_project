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
                    <td class="border-br"><b></b></td>
                    <td class="border-br"><b><fmt:message key="local.order.user.name"/></b></td>
                    <td class="border-br"><b><fmt:message key="local.order.user.surname"/></b></td>
                    <td class="border-br"><b><fmt:message key="local.book.title"/></b></td>
                    <td class="border-br"><b><fmt:message key="local.book.author"/></b></td>
                    <td class="border-br"><b><fmt:message key="local.order.type"/></b></td>
                    <td class="border-bottom"><b><fmt:message key="local.order.status"/></b></td>
                </tr>
                <c:forEach var="order" items="${requestScope.orderList}" varStatus="index">
                    <tr>
                        <td class="border-br">${(20)*(requestScope.currentPage - 1) + index.count}</td>
                        <td class="border-br">${order.userName}</td>
                        <td class="border-br">${order.userSurname}</td>
                        <td class="border-br">${order.bookTitle}</td>
                        <td class="border-br">${order.bookAuthor}</td>
                        <td class="border-br">
                            <c:if test="${order.type =='SUBSCRIPTION'}">
                                <fmt:message key="local.order.type.subscription"/>
                            </c:if>
                            <c:if test="${order.type == 'READER_ROOM'}">
                                <fmt:message key="local.order.type.reader_room"/>
                            </c:if>
                        </td>
                        <td class="border-bottom">
                            <c:choose>
                                <c:when test="${order.status=='UNDER_CONSIDERATION'}">
                                   <span style="color: goldenrod"><fmt:message
                                           key="local.order.status.under_consideration"/></span>
                                </c:when>
                                <c:when test="${order.status=='ACCEPTED'}">
                                      <span style="color: limegreen"> <fmt:message
                                              key="local.order.status.accepted"/></span>
                                </c:when>
                                <c:when test="${order.status=='COMPLETED'}">
                                      <span style="color: blueviolet"> <fmt:message
                                              key="local.order.status.completed"/></span>
                                </c:when>
                                <c:when test="${order.status=='REJECTED'}">
                                      <span style="color: orangered"> <fmt:message
                                              key="local.order.status.rejected"/></span>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <%--    PAGINATION   --%>
        <div class="center">
            <div class="pagination" align="center">
                <c:choose>
                    <c:when test="${(requestScope.currentPage - 1) == 0}">
                        <a align="center" href="" type="submit">&laquo;</a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=orders_history&currentPage=${requestScope.currentPage-1}"
                           type="submit">&laquo;</a>
                    </c:otherwise>
                </c:choose>
                <a href="" class="active">${requestScope.currentPage}</a>
                <c:choose>
                    <c:when test="${requestScope.orderList.size() != 20}">
                        <a align="center" href="" type="submit">&raquo;</a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=orders_history&currentPage=${requestScope.currentPage+1}"
                           type="submit">&raquo;</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <%--    PAGINATION   --%>
    </main>
</div>
</body>
</html>


