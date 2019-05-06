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
    <p id="m-name"  > Milestone name : ${m.getName()}</p>
    <p id="m-date" > Due Date: ${dueDate} </p>
    <p id="c-date" > Completion Date: ${completionDate} </p>
    <br>
    <c:choose>
        <c:when test="${m.hasStarted()}">
            <p id="m-started"> Started: True </p>
        </c:when>
        <c:otherwise>
            <p id="m-started"> Started: False </p>

        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${m.isComplete()}">
            <p id="m-completed"> Completed: True </p>

        </c:when>
        <c:otherwise>
            <p id="m-completed"> Completed: False </p>

        </c:otherwise>
    </c:choose>

    <script src="JS/script.js"></script>
    <script src="JS/dragNDrop.js"></script>
    <script src="JS/actions.js"></script>
</div>
</body>
</html>
