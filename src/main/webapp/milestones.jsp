<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <!-- Not Started -->
    <div class="milestones">

        <div class="projectsList">
            <h1> Not Started</h1>
        </div>

        <div class="gallery">
            <h2 class="gallery-heading">Milestones</h2>
            <div class="add">
                <button id="milestoneBtn" ><i class="material-icons md-24">add</i></button>
                <div id="milestoneModal" class="modal">
                    <div class="modal-content">
                        <span class="close">&times;</span>
                        <form action="" method="post" id="addMilestone">
                            Milestone Name:<br>
                            <label for="title" class="textLabel"></label>
                            <input type="text" name="title" id="title" required/>
                            <br>
                            Due <br>
                            <label for="dueDate" class="textLabel"></label>
                            <input type="date" name="dueDate" id="dueDate" required/>
                            <br>
                            <input type="submit" name="submit" id="submit" value="Submit"/>
                            <br>
                        </form>
                    </div>

                </div>
            </div>
            <c:forEach items="${notStarted}" var="milestone">
                <div class="thumbnail">
                    <div class="icons">
                        <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                    </div>
                    <h4><c:out value="${milestone.getName()}"/> </h4>
                    <p class="tag"><i class="material-icons md-18">watch_later</i> Due: <c:out value="${milestone.getDueDate()}"/></p>
                </div>
            </c:forEach>
        </div>
    </div>

    <%-- In Progress--%>
    <div class="milestones">
        <div class="gallery">
            <h2 class="gallery-heading">In Progress</h2>
            <div class="add">
                <button onclick=""><i class="material-icons md-24">add</i></button>
            </div>
            <c:forEach items="${inProgress}" var="milestone">
                <div class="thumbnail">
                    <div class="icons">
                        <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                    </div>
                    <h4><c:out value="${milestone.getName()}"/></h4>
                    <p class="tag"><i class="material-icons md-18">watch_later</i> Due: <c:out value="${milestone.getDueDate()}"/> </p>
                </div>
            </c:forEach>
        </div>
    </div>

    <%--Completed--%>
    <div class="milestones-right">
        <div class="gallery">
            <h2 class="gallery-heading">Completed</h2>
            <div class="add">
                <button onclick=""><i class="material-icons md-24">add</i></button>
            </div>
            <c:forEach items="${completed}" var="milestone">
                <div class="thumbnail">
                    <div class="icons">
                        <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                    </div>
                    <h4><c:out value="${milestone.getName()}"/></h4>
                    <p class="tag"><i class="material-icons md-18">watch_later</i> Due: <c:out value="${milestone.getDueDate()}"/></p>
                </div>
            </c:forEach>
        </div>
    </div>


    <!-- Main Container Ends -->
</div>
<script src="JS/script.js"></script>
<script src="JS/dragNDrop.js"></script>
</body>
</html>

