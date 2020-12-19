<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset = "utf-8">
    <title>Book catalog</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link rel = "stylesheet" href = "${pageContext.request.contextPath}/styles/book_catalog.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>

<body>
<jsp:include page="templates/header.jsp"/>

<div class = "container">
    <jsp:include page="templates/leftMenu.jsp"/>
<%--
    <main class = "content">
        <div class = "data">
            <table>

                <tr>
                    <th><fmt:message key="local.books.info"/></th>
                    <th><fmt:message key="local.books.amount"/></th>
                </tr>


                <tr>
                    <th class = "book_img"><img src="images/2.jpg"></th>
                    <th class = "book_name"><p>Java. Методы программирования, И.Блинов, В.Романчик</p></th>
                    <th class = "amount"><p>1</p></th>
                    <th class = "edit"><a>Edit</a></th>
                </tr>
                <tr><th></th></tr>
                <tr>
                    <th class = "book_img"><img src="images/book.jpg"></th>
                    <th class = "book_name"><p>Java. Методы программирования, И.Блинов, В.Романчик</p></th>
                    <th class = "amount"><p>1</p></th>
                    <th class = "edit"><a>Edit</a></th>
                </tr>
                <tr><th></th></tr>
                <tr>
                    <th class = "book_img"><img src="images/2.jpg"></th>
                    <th class = "book_name"><p>Java. Методы программирования, И.Блинов, В.Романчик</p></th>
                    <th class = "amount"><p>1</p></th>
                    <th class = "edit"><a>Edit</a></th>
                </tr>
                <tr><th></th></tr>
                <tr>
                    <th class = "book_img"><img src="images/book.jpg"></th>
                    <th class = "book_name"><p>Java. Методы программирования, И.Блинов, В.Романчик</p></th>
                    <th class = "amount"><p>1</p></th>
                    <th class = "edit"><a>Edit</a></th>
                </tr>
                <tr><th></th></tr>
            </table>
        </div>
        <div class = "pagination">
            <span>1</span><a href="index_reader_book_catalog_2.html">&raquo;</a>
        </div>
    </main>--%>

    <main class="content">


        <section class="content__container">


            <div class="container-element">
                <img src="${pageContext.request.contextPath}/images/person.jpg" alt="book_cover">
                <div class="element-description">
                    <p><b>Book title:</b> Обложка книги</p>
                    <p><b>Author:</b> Неизвестно</p>
                    <p><b>Numb of pages:</b> 624стр.</p>
                    <p><b>Year of publishing:</b> 2002 год</p>
                </div>
                <div class="element-amount">
                    <p><b>Amount:</b> 1</p>
                </div>
                <button class="element-order">Order</button>
            </div>

        </section>


        <section class="pagination">
            <button>&lt;&lt;</button>
            <button class="numbers active">1</button>
            <button class="numbers">2</button>
            <button class="numbers">3</button>
            <button>&gt;&gt;</button>
        </section>
    </main>

</div>
</body>
</html>