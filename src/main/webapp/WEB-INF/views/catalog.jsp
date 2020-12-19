<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.local"/>

<html lang="${sessionScope.language}">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book catalog</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/st_catalog.css">
    <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
</head>


<body>
<jsp:include page="templates/header.jsp"/>


<div class="container">
    <jsp:include page="templates/leftMenu.jsp"/>

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
