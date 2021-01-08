<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${requestScope.language}">

<div class = "center">
<div class="pagination" align = "center">
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
    <a href = "" class = "active">${requestScope.currentPage}</a>
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
</html>