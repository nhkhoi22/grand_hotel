function SearchUser() {
    // Declare variables
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("SearchInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("UserTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function FilterDepartment() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("DepartmentSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("UserTable");
    tr = table.getElementsByTagName("tr");

    //Display all
    if (filter.localeCompare("ALL") == 0) {
        for (i = 0; i < tr.length; i++) {
            tr[i].style.display = "";
        }
    }
    else {
        //Filter by Department
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[3];

            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
}

function lockUser(staffCode) {
	$.post('/admin/lock/' + staffCode, function(response) {
	    // Log the response to the console
	    console.log("Response: "+response);
	});
}