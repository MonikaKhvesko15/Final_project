<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset="utf-8">
    <title>My orders</title>
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
                    <td><b><fmt:message key="local.book.title"/></b></td>
                    <td><b><fmt:message key="local.book.author"/></b></td>
                    <td><b><fmt:message key="local.order.issue.date"/></b></td>
                    <td><b><fmt:message key="local.order.return.date"/></b></td>
                    <td><b><fmt:message key="local.order.type"/></b></td>
                    <td><b><fmt:message key="local.order.status"/></b></td>
                    <td><b></b></td>
                </tr>
                <c:forEach var="order" items="${requestScope.orderList}" varStatus="index">

                    <c:if test="${order.userName==sessionScope.user.firstname}">
                        <tr>
                            <td>${(20)*(requestScope.currentPage - 1) + index.count}</td>
                            <td>${order.bookTitle}</td>
                            <td>${order.bookAuthor}</td>
                            <td><ctg:dateFormatterTag>${order.issueDate}</ctg:dateFormatterTag></td>
                            <td>
                                <c:if test="${!order.returnDate.isAfter(requestScope.currentData)}">
                                    <span style="color: orangered"><ctg:dateFormatterTag>${order.returnDate}</ctg:dateFormatterTag></span>
                                </c:if>
                                <c:if test="${order.returnDate.isAfter(requestScope.currentData)}">
                                    <ctg:dateFormatterTag>${order.returnDate}</ctg:dateFormatterTag>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${order.type =='SUBSCRIPTION'}">
                                    <fmt:message key="local.order.type.subscription"/>
                                </c:if>
                                <c:if test="${order.type == 'READER_ROOM'}">
                                    <fmt:message key="local.order.type.reader_room"/>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${order.status =='UNDER_CONSIDERATION'}">
                                    <span style="color: goldenrod"><fmt:message
                                            key="local.order.status.under_consideration"/></span>
                                </c:if>
                                <c:if test="${order.status == 'ACCEPTED'}">
                                    <span style="color: limegreen"> <fmt:message
                                            key="local.order.status.accepted"/></span>
                                </c:if>
                            </td>
                        </tr>
                    </c:if>
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
                           href="${pageContext.request.contextPath}/controller?command=reader_orders&currentPage=${requestScope.currentPage-1}"
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
                           href="${pageContext.request.contextPath}/controller?command=reader_orders&currentPage=${requestScope.currentPage+1}"
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


