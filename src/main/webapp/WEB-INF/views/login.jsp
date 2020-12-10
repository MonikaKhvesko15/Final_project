    <html>

        <head>
        <meta charset="utf-8">
        <title>Hello, library</title>
        <link rel="stylesheet" href="./login.css">
        <link href="https://fonts.googleapis.com/css2?family=Belgrano&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
        </head>

        <body>
        <header>
        <div class="library">Library</div>
        <div class="buttons"><a href="main.jsp">Login</a>
        <a href="main.jsp">Language</a></div>
        </header>
        <div class="container">
        <nav class="menu"></nav>
        <main class="content">
        <p>Welcome to the Library!</p>
        <form action="/registration-test/controller?command=login" method="POST" >
        <h2>Login</h2>
        <h3>Sign in to your account</h3>
        <label><span>Username</span> <input type="text" required></label>
        <label><span>Password</span> <input type="password" required></label>
        <input class="btn-submit" type="submit" value="Login">
        </form>
        ${errorMessage}
        </main>
        </div>
        </body>

        </html>