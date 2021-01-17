<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset="utf-8">
    <title>Readers</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/all_users.css">
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

                <c:forEach var="reader" items="${requestScope.readerList}" varStatus="index">
                    <tr>
                        <td>${(20)*(requestScope.currentPage - 1) + index.count}</td>
                        <td>${reader.firstname}</td>
                        <td>${reader.surname}</td>
                        <td>
                            <c:choose>
                            <c:when test="${reader.blocked}">
                                <img src="${pageContext.request.contextPath}/images/block.jpg" class = "lock">
                            </c:when>
                            <c:when test="${!reader.blocked}">
                                <img src="${pageContext.request.contextPath}/images/unblock.jpg" class = "lock">
                            </c:when>
                            </c:choose>
                        </td>

                        <div class="buttons">
                            <c:choose>
                                <c:when test="${!reader.blocked}">
                                    <form action="${pageContext.request.contextPath}/controller?command=block_user"
                                          method="POST">
                                        <th>
                                            <a class = "btn-block">
                                                <input type="hidden" name="userId" value=${reader.id}>
                                                <input type="hidden" name="userRole" value=${reader.role}>
                                                <input class="block" type="submit" value=<fmt:message
                                                        key="local.block"/>>
                                            </a>
                                        </th>
                                    </form>
                                </c:when>
                                <c:when test="${reader.blocked}">
                                    <form action="${pageContext.request.contextPath}/controller?command=unblock_user"
                                          method="POST">
                                        <th>
                                            <a class = "btn-block">
                                                <input type="hidden" name="userId" value=${reader.id}>
                                                <input type="hidden" name="userRole" value=${reader.role}>
                                                <input class="block" type="submit" value=<fmt:message
                                                        key="local.unblock"/>>
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
                           href="${pageContext.request.contextPath}/controller?command=view_readers&currentPage=${requestScope.currentPage-1}"
                           type="submit">&laquo;</a>
                    </c:otherwise>
                </c:choose>
                <a href="" class="active">${requestScope.currentPage}</a>
                <c:choose>
                    <c:when test="${requestScope.readerList.size() != 20}">
                        <a align="center" href="" type="submit">&raquo;</a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=view_readers&currentPage=${requestScope.currentPage+1}"
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


