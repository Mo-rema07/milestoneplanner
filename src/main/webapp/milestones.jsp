
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

    <!-- Milestones Section -->
    <div class="milestones-left">

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
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Do Laundry</h4>
                <p class="tag"><i class="material-icons md-18">watch_later</i> Due: 25/04/2019</p>
              <form action="" method="post" class="milestoneStatus">
                <label class="checkbox-container">Started
                  <input type="checkbox" checked="checked">
                  <span class="checkmark"></span>
                </label>
              </form>
            </div>
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Do Laundry</h4>
                <p class="tag"><i class="material-icons md-18">watch_later</i> Due: 25/04/2019</p>
              <form action="" method="post" class="milestoneStatus">
                <label class="checkbox-container">Started
                  <input type="checkbox" checked="checked">
                  <span class="checkmark"></span>
                </label>
              </form>
            </div>
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Do Laundry</h4>
                <p class="tag"><i class="material-icons md-18">watch_later</i> Due: 25/04/2019</p>
              <form action="" method="post" class="milestoneStatus">
                <label class="checkbox-container">Started
                  <input type="checkbox" checked="checked">
                  <span class="checkmark"></span>
                </label>
              </form>
            </div>
            <div class="thumbnail" >
                <div id="drag1" ondrop="drop(event)" ondragover="allowDrop(event)" draggable="true" ondragstart="drag(event)" id="drag1">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Do Laundry</h4>
                <p class="tag"><i class="material-icons md-18">watch_later</i> Due: 25/04/2019</p>
                  <form action="" method="post" class="milestoneStatus">
                    <label class="checkbox-container">Started
                      <input type="checkbox" checked="checked">
                      <span class="checkmark"></span>
                    </label>
                  </form>
                </div>
            </div>
        </div>
    </div>

    <div class="milestones">
        <div class="gallery">
            <h2 class="gallery-heading1">In Progress</h2>
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Web Dev Assignment</h4>
                <p class="tag">Due: 24/04/2019</p>
              <form action="" method="post" class="milestoneStatus">
                <label class="checkbox-container">Completed
                  <input type="checkbox" checked="checked">
                  <span class="checkmark"></span>
                </label>
              </form>
            </div>
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Web Dev Assignment</h4>
                <p class="tag">Due: 24/04/2019</p>
              <form action="" method="post" class="milestoneStatus">
                <label class="checkbox-container">Completed
                  <input type="checkbox" checked="checked">
                  <span class="checkmark"></span>
                </label>
              </form>
            </div>
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Web Dev Assignment</h4>
                <p class="tag">Due: 24/04/2019</p>
              <form action="" method="post" class="milestoneStatus">
                <label class="checkbox-container">Completed
                  <input type="checkbox" checked="checked">
                  <span class="checkmark"></span>
              </form>
            </div>
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Web Dev Assignment</h4>
                <p class="tag">Due: 24/04/2019</p>
              <form action="" method="post" class="milestoneStatus">
                <label class="checkbox-container">Completed
                  <input type="checkbox" checked="checked">
                  <span class="checkmark"></span>
              </form>
            </div>
        </div>
    </div>

    <div class="milestones">
        <div class="gallery">
            <h2 class="gallery-heading1">Completed</h2>
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Read Stoker's Script</h4>
                <p class="tag">Completed: 08/04/2019</p>
            </div>
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Read Stoker's Script</h4>
                <p class="tag">Completed: 08/04/2019</p>
            </div>
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Read Stoker's Script</h4>
                <p class="tag">Completed: 08/04/2019</p>
            </div>
            <div class="thumbnail">
                <div class="icons">
                    <i class="material-icons md-18">create</i><i class="material-icons md-18">share</i><i class="material-icons md-18">delete_outline</i>
                </div>
                <h4>Read Stoker's Script</h4>
                <p class="tag">Completed: 08/04/2019</p>
            </div>
        </div>
    </div>

        </div>
    </div>
    <!-- Footer Section -->
    <!--  <footer id="contact">
       <p class="hero_header">Milestone Planner 2019</p>
     </footer> -->

    <!-- Main Container Ends -->

    <script src="JS/script.js"></script>
    <script src="JS/dragNDrop.js"></script>

</div>
</body>
</html>

