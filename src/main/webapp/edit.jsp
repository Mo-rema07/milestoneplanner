<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Milestone Planner</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="style.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
</head>
<body>
<!-- Main Container -->
<div class="container">
    <!-- Header -->
    <header>
        <img src="img/logo.png" alt="logo">
    </header>
    <form method="post">
        Milestone name :<input type="text" name="name" value="${m.getName()}"><br>
        Due Date: <input type="date" name="dueDate" value="${dueDate}"><br>
        Completion Date: <input type="date"  name="completionDate" value="${completionDate}"><br><br>
        <c:choose>
            <c:when test="${m.hasStarted()}">
                Started: <br><input type="radio" name="started" value="true" checked> True<br>
                <input type="radio" name="started" value="false"> False<br>
            </c:when>
            <c:otherwise>
                Started: <br><input type="radio" name="started" value="true" checked> True<br>
                <input type="radio" name="started" value="false" checked> False<br>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${m.isComplete()}">
                Completed: <br><input type="radio" name="complete" value="true" checked> True<br>
                <input type="radio" name="complete" value="false"> False<br>
            </c:when>
            <c:otherwise>
                Completed: <br><input type="radio" name="complete" value="true"> True<br>
                <input type="radio" name="complete" value="false" checked> False<br>
            </c:otherwise>
        </c:choose>


        <input type="submit" name="submit" id="submit" value="Submit"/>
    </form>

    <script src="JS/script.js"></script>
    <script src="JS/dragNDrop.js"></script>
    <script src="JS/actions.js"></script>
</div>
</body>
</html>