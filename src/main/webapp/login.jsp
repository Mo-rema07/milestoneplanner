<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Milestone Planner</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

<!-- Main Container -->
<div class="container">
    <!-- Header -->
    <header>
        <img src="img/logo.png" alt="logo">
    </header>

</div>
<!-- Login section -->
<div class="login">
    <button onclick="loginFunction()">Login</button>
    <form action="" method="post" id="Login">
        Username:<br>
        <label for="user" class="textLabel"></label>
        <input type="text" name="user" id="user" required/>
        <br>

        Password <br>
        <label for="password" class="textLabel"></label>
        <input type="text" name="password" id="pass" required/>
        <br>
        <input type="submit" name="submit" id="Submit" value="Submit"/>
        <br>
    </form>
</div>
<!-- signup section -->
<div class="signup">
    <button onclick="signupFunction()">Sign Up</button>
    <form action="/projects" method="post" id="SignUp">
        Username:<br>
        <label for="user" class="textLabel"></label>
        <input type="text" name="user" id=User" required/>
        <br>


        Email adress:<br>
        <label for="email" class="textLabel"></label>
        <input type="text" name="email" id="email" required/>
        <br>

        Password <br>
        <label for="password" class="textLabel"></label>
        <input type="text" name="password" id="password" required/>
        <br>
        <input type="submit" name="submit" id="submit" value="Submit"/>
        <br>
    </form>
</div>

<script src="JS/script.js"></script>
</body>
</html>
