taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form id="editMilestone">
      <label for="m-name" class="textLabel"><h4>Milestone name:</h4></label>

      <input type="text"  id="m-name">

      <label for="m-date" class="textLabel"><h4>Due date:</h4></label>

      <input type="date"  id="m-date">

      <label for="c-date" class="textLabel"><h4>Completion date:</h4></label>

      <input type="text" id="c-date">
      <br>
      <label for="m-started" class="textLabel"><h4>Started:</h4></label>

      <input type="radio" name="started" value="true" id="m-started"> True
      <input type="radio" name="started" value="false" id="m-started-f"> False
      <br>
      <label for="m-completed" class="textLabel"><h4>Completed:</h4></label>
      <input type="radio" name="complete" value="true" id="m-completed"> True
        <input type="radio" name="complete" value="false" id="m-completed-f"> False<br>
        <input type="submit" name="submit" id="submit" value="Submit"/>
    </form>


    <script src="JS/script.js"></script>
    <script src="JS/dragNDrop.js"></script>
    <script src="JS/actions.js"></script>
</div>
</body>
</html>
