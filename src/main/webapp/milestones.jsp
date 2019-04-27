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
    <link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
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

        <div class="gallery">
            <h2 class="gallery-heading">Milestones</h2>
            <div class="add">
                <button id="milestoneBtn" ><i class="material-icons md-24">add</i></button>
                <div id="milestoneModal" class="modal">
                    <div class="modal-content">
                        <span class="close">&times;</span>
                        <form action="" method="post" id="addMilestone">
                            Milestone Title:<br>
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
                        <i class="material-icons mdc-icon-button edit md-18"  id="edi<c:out value="${milestone.getName()}"/>">create</i>
                        <i class="material-icons mdc-icon-button share md-18"  id="sha<c:out value="${milestone.getName()}"/>">share</i>
                        <i class="material-icons mdc-icon-button delete md-18" id="del<c:out value="${milestone.getName()}"/>">delete_outline</i>
                    </div>
                    <h4><c:out value="${milestone.getName()}"/></h4>
                    <p class="tag"><i class="material-icons md-18">watch_later</i> Due:  <c:out value="${milestone.getDueDate()}"/></p>
                    <form action="" method="post" class="milestoneStatus">

                        <label class="checkbox-container">Started
                            <input id="str<c:out value="${milestone.getName()}"/>" type="checkbox" class="start" >
                            <span class="checkmark"></span>
                        </label>

                    </form>
                </div>
            </c:forEach>
        </div>
    </div>

    <%-- In Progress--%>
    <div class="milestones">
        <div class="gallery">
            <h2 class="gallery-heading1">In Progress</h2>
            <c:forEach items="${inProgress}" var="milestone">
                <div class="thumbnail">
                    <div class="icons">
                        <button class="material-icons mdc-icon-button edit md-18"  id="edi<c:out value="${milestone.getName()}"/>">create</button>
                        <button class="material-icons mdc-icon-button share md-18"  id="sha<c:out value="${milestone.getName()}"/>">share</button>
                        <button class="material-icons mdc-icon-button delete md-18" id="del<c:out value="${milestone.getName()}"/>">delete_outline</button>
                    </div>
                    <h4><c:out value="${milestone.getName()}"/></h4>
                    <p class="tag"><i class="material-icons md-18">watch_later</i> Due:  <c:out value="${milestone.getDueDate()}"/></p>
                    <form action="" method="post" class="milestoneStatus">

                        <label class="checkbox-container">Started
                            <input id="str<c:out value="${milestone.getName()}"/>" type="checkbox" checked  class="start">
                            <span class="checkmark"></span>
                        </label>

                        <label class="checkbox-container">Completed
                            <input id="com<c:out value="${milestone.getName()}"/>" type="checkbox" class="complete" >
                            <span class="checkmark"></span>
                        </label>


                    </form>
                </div>
            </c:forEach>
        </div>
    </div>

    <%--Completed--%>
    <div class="milestones">
        <div class="gallery">
            <h2 class="gallery-heading1">Completed</h2>
            <c:forEach items="${completed}" var="milestone">
                <div class="thumbnail">
                    <div class="icons">
                        <button class="material-icons mdc-icon-button edit md-18"  id="edi<c:out value="${milestone.getName()}"/>">create</button>
                        <button class="material-icons mdc-icon-button share md-18"  id="sha<c:out value="${milestone.getName()}"/>">share</button>
                        <button class="material-icons mdc-icon-button delete md-18" id="del<c:out value="${milestone.getName()}"/>">delete_outline</button>
                    </div>
                    <h4><c:out value="${milestone.getName()}"/></h4>
                    <p class="tag"><i class="material-icons md-18">watch_later</i> Due:  <c:out value="${milestone.getDueDate()}"/></p>
                    <p class="tag"><i class="material-icons md-18">check</i> Completed:  <c:out value="${milestone.getCompletionDate()}"/></p>
                    <form action="" method="post" class="milestoneStatus">

                        <label class="checkbox-container">Completed
                            <input id="com<c:out value="${milestone.getName()}"/>" type="checkbox" checked class="complete">
                            <span class="checkmark"></span>
                        </label>

                    </form>
                </div>
            </c:forEach>
        </div>
    </div>

    <script src="JS/script.js"></script>
    <script src="JS/dragNDrop.js"></script>
    <script src="JS/actions.js"></script>


</div>
</body>
</html>

<%--TODO: Add sharing capacity--%>
<%--TODO: Refactor DAO sql to use prepared statements correctly--%>
<%--TODO: Refactor session management code to use Session Filters--%>
<%--TODO: Refactor milestone_code to use milestone_id as a reference--%>
<%--TODO: Add validation for all forms--%>
<%--TODO: Add Navigation to take user back to Projects page--%>
<%--TODO: Add Logout functionality--%>
