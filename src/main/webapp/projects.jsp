<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rphur
  Date: 4/24/2019
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <div class="addProject">
            <button id="addProjectBtn">Add Project</button>
            <div id="projectModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <form action="" method="post" id="Project">
                        Project Title:<br>
                        <label for="ptitle" class="textLabel"></label>
                        <input type="text" name="ptitle" id="ptitle" required/>
                        <br>

                        <input type="submit" name="submit" id="submit" value="Submit"/>
                        <br>
                    </form>
                </div>

            </div>
        </div>
        <div class="logo">
            <img src="img/logo.png" alt="logo">
        </div>
    </header>

    <div class="projectsList">
        <h1>Available Projects</h1>
        <ul>
            <% for(int i = 0; i < projectList.size(); i+=1) { %>
                System.out.println("");
            <% } %>
<%--            <c:forEach var="project" items="${ProjectList}">--%>
<%--                <li><a href="/projects/milestones?project= <c:out value="${project.getName()}""> <c:out value="${project.getName()}" /> </a></li>--%>
<%--            </c:forEach>--%>
        </ul>
    </div>


</div>

<script src="JS/projectsModal.js"></script>
</body>
</html>

