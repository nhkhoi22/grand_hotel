function getLastRecord() {
	$.post("/user/room_division/checkout_handle");
}

function checkTable() {
    console.log("hello")
    var rows = document.getElementById("ReservationTable").getElementsByTagName("tr").length;
    if (rows == 1) {
        document.getElementById("header0").style.display = "none";
        document.getElementById("header1").style.display = "none";
        document.getElementById("header2").style.display = "none";
        document.getElementById("header3").style.display = "none";
    }
    else
    {
        document.getElementById("header0").style.display = "";
        document.getElementById("header1").style.display = "";
        document.getElementById("header2").style.display = "";
        document.getElementById("header3").style.display = "";
    }
}

function warn() {
	if(confirm('If proceed, the time of latest check-out will change to now. Do you want to proceed?')) {
		$.post('/user/room_division/checkout_handle/' + document.getElementById("roomid"), function(response) {
			// Log the response to the console
			console.log("Response: " + response);
		});
	}
}