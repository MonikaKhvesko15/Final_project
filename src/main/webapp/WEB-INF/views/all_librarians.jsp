<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset="utf-8">
    <title>Librarians</title>
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

                <c:forEach var="librarian" items="${requestScope.librarianList}" varStatus="index">
                    <tr>
                        <td>${(15)*(requestScope.currentPage - 1) + index.count}</td>
                        <td>${librarian.firstname}</td>
                        <td>${librarian.surname}</td>
                        <td>${librarian.blocked}</td>

                        <div class="buttons">
                            <c:choose>
                                <c:when test="${!librarian.blocked}">
                                    <form class="block"
                                          action="${pageContext.request.contextPath}/controller?command=block_user"
                                          method="POST">
                                        <th class="block">
                                            <a>
                                                <input type="hidden" name="userId" value=${librarian.id}>
                                                <input type="hidden" name = "userRole" value=${librarian.role}>
                                                <input class="btn-submit" type="submit" value=<fmt:message
                                                        key="local.block"/>>
                                            </a>
                                        </th>
                                    </form>
                                </c:when>
                                <c:when test="${librarian.blocked}">
                                    <form class="unblock"
                                          action="${pageContext.request.contextPath}/controller?command=unblock_user"
                                          method="POST">
                                        <th class="unblock">
                                            <a>
                                                <input type="hidden" name="userId" value=${librarian.id}>
                                                <input type="hidden" name = "userRole" value=${librarian.role}>
                                                <input class="btn-submit" type="submit" value=<fmt:message
                                                        key="local.unblock"/>>
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
                           href="${pageContext.request.contextPath}/controller?command=view_librarians&currentPage=${requestScope.currentPage-1}"
                           type="submit" class="pagination"><fmt:message key="orders.previous"/></a>
                    </c:otherwise>
                </c:choose>
                <div class="pagination">${requestScope.currentPage}</div>
                <c:choose>
                    <c:when test="${requestScope.readerList.size() != 15}">
                        <a align="center" href="" type="submit" class="pagination"><fmt:message key="orders.next"/></a>
                    </c:when>
                    <c:otherwise>
                        <a align="center"
                           href="${pageContext.request.contextPath}/controller?command=view_librarians&currentPage=${requestScope.currentPage+1}"
                           type="submit" class="pagination"><fmt:message key="orders.next"/></a>
                    </c:otherwise>
                </c:choose>
            </table>


        </div>

    </main>
</div>
</body>
</html>


