    <html>
        <head>
        <meta charset = "utf-8">
        <title>Library. Home page</title>
        <link rel = "stylesheet" href = "${pageContext.request.contextPath}/styles/home_page.css">
        <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        </head>
        <body>
        <header>
        <div class = "library">Library</div>
        <div class = "user">
        <img src = "${pageContext.request.contextPath}/images/person.jpg">
        <p>Username</p>
        </div>
        <div class = "buttons">
        <a href = "/Final_project_war/controller?command=logout" id = "logout">Log out</a>
        <div class = "language">
        <a href = "index_hello.html">RU</a>
        <a href = "index_hello.html">ENG</a>
        </div>
        </div>
        </header>
        <div class = "container">
        <nav class = "menu">
        <div class = "topnav">
        <ul>
        <p id = "menuHeader">Menu</p>
        <li><a href = "index_home_page.html">Home page</a></li>
        <li><a href = "index_hello.html">Landing books</a></li>
        </ul>
        </div>
        </nav>
        <main class = "content">
        <div class = "data">
        <img src = "${pageContext.request.contextPath}/images/person.jpg">
        <table>
        <tr>
        <th>Name:</th>
        <th></th>
        <th class = "edit"><a>Edit</a></th>
        </tr>
        <tr>
        <th>Surname:</th>
        <th></th>
        <th class = "edit"><a>Edit</a></th>
        </tr>
        </table>
        </div>
        </main>
        </div>
        </body>
        </html>