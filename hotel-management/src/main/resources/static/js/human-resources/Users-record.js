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
    var value = input.options[input.selectedIndex].id;
    var pos = document.getElementById("PositionSearch");

    //Display all
    if (filter.localeCompare("ALL") == 0) {
        for (i = 0; i < tr.length; i++) {
            tr[i].style.display = "";
        }
        for (i = 1; i < pos.options.length; i++) {
            pos.options[i].style.display = "";
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
        //Filter Position base on Department
        for (i = 2; i < pos.options.length; i++) {
            if (pos.options[i].id.toUpperCase().localeCompare(value.toUpperCase()) == 0) {
                pos.options[i].style.display = "";
            }
            else {
                pos.options[i].style.display = "none";
            }
        }
    }
}

function FilterPosition() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("PositionSearch");
    filter = input.value.toUpperCase();
    table = document.getElementById("UserTable");
    tr = table.getElementsByTagName("tr");

    //Display all
    if (filter.localeCompare("ALL") == 0) {
        for (i = 0; i < tr.length; i++) {
            tr[i].style.display = "";
        }
        FilterDepartment();
    }
    else {
        //Filter by Position
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[2];

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
    $.post('/admin/lock/' + staffCode, function (response) {
        // Log the response to the console
        console.log("Response: " + response);
    });
}

function searchProduct() {
	var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("SearchInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("ProductTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
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