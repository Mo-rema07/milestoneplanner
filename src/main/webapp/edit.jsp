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
    <form method="post" id="editMilestone">
        <label for="m-name" class="textLabel"><h4>Milestone name:</h4></label>
        <input  id="m-name" type="text" name="name" value="${m.getName()}">
          <label for="m-date" class="textLabel"><h4>Due date:</h4></label>
           <input id="m-date" type="date" name="dueDate" value="${dueDate}">
          <label for="c-date" class="textLabel"><h4>Completion date:</h4></label>
           <input id="c-date" type="date"  name="completionDate" value="${completionDate}">
             <br>
        <c:choose>
            <c:when test="${m.hasStarted()}">
              <label for="m-started" class="textLabel"><h4>Started:</h4></label>
              <input type="radio" name="started" value="true" checked id="m-started"> True
                <input type="radio" name="started" value="false" id="m-started-f"> False<br>
            </c:when>
            <c:otherwise>
                <label for="m-started" class="textLabel"><h4>Started:</h4></label>
                <input type="radio" name="started" value="true"  id="m-started"> True
                <input type="radio" name="started" value="false" checked id="m-started-f"> False<br>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${m.isComplete()}">
                <label for="m-completed" class="textLabel"><h4>Completed:</h4></label>
                <input type="radio" name="complete" value="true" checked id="m-completed"> True
                <input type="radio" name="complete" value="false" id="m-completed-f"> False<br>
            </c:when>
            <c:otherwise>
                <label for="m-completed" class="textLabel"><h4>Completed:</h4></label>
                <input type="radio" name="complete" value="true" id="m-completed" > True
                <input type="radio" name="complete" value="false" checked id="m-completed-f"> False<br>
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
