function lockUser(staffCode) {
	$.post('/admin/lock/' + staffCode, function(response) {
	    // Log the response to the console
	    console.log("Response: "+response);
	});
}