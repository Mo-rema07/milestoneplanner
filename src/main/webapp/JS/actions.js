$(".complete").change(function () {
    let newState;
    let mileId = this.id.substring(3);
    if(this.checked){
       newState = "true";
    }
    else {
        newState = "false";
    }
    window.location.href = "/isComplete?to="+newState+"&milestone_id="+mileId;
});

$(".start").change(function () {
    let newState;
    let mileId = this.id.substring(3);
    if(this.checked){
        newState = "true";
    }
    else {
        newState = "false";
    }
    window.location.href = "/hasStarted?to="+newState+"&milestone_id="+mileId;
});


$(".edit").click(function () {
    let mileId = this.id.substring(3);
    window.location.href = "/edit?milestone_id="+mileId;
});
$(".share").click(function () {
    let mileId = this.id.substring(3);
    window.location.href = "/share?milestone_id="+mileId;
});

$(".delete").click(function () {
    let mileId = this.id.substring(3);
    window.location.href = "/delete?milestone_id="+mileId;
});

$(".project-view").click(function () {
    let projectId = this.id.substring(3);
    window.location.href = "/milestones?project_id="+projectId;
});


