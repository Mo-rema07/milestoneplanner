$(".complete").change(function () {
    let newState;
    let mileId = this.id.substring(3);
    if(this.checked){
       newState = "true";
    }
    else {
        newState = "false";
    }
    window.location.href = "/isComplete?to="+newState+"&id="+mileId;
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
    window.location.href = "/hasStarted?to="+newState+"&id="+mileId;
});


$(".edit").click(function () {
    let mileId = this.id.substring(3);
    window.location.href = "/edit?id="+mileId;
});
$(".share").click(function () {
    let mileId = this.id.substring(3);
    window.location.href = "/share?id="+mileId;
});

$(".delete").click(function () {
    let mileId = this.id.substring(3);
    window.location.href = "/delete?id="+mileId;
});

$(".project-view").click(function () {
    let projectId = this.id.substring(3);
    window.location.href = "/milestones?id="+projectId;
});


