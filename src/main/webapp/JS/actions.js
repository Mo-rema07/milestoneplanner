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
    // console.log(mileId);
    // console.log(this.id);
    if(this.checked){
        newState = "true";
    }
    else {
        newState = "false";
    }
    window.location.href = "/hasStarted?to="+newState+"&id="+mileId;
});
