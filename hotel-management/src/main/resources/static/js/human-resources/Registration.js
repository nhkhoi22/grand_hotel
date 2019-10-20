function Arrange() {
    var depart = document.getElementById("departmentID");
    $("#departmentID").append($("#departmentID option").remove().sort(function (a, b) {
        var at = $(a).text(), bt = $(b).text();
        return (at > bt) ? 1 : ((at < bt) ? -1 : 0);
    }));

    var option = document.createElement("option");
    option.text = "Department";
    option.style.visibility = "hidden";
    option.selected = "selected";
    option.setAttribute("disabled", "");
    depart.add(option);
}
function PositionFilter() {
    var depart = document.getElementById("departmentID");
    var value = depart.options[depart.selectedIndex].value;
    var pos = document.getElementById("PosDepartment");
    for (var i = 1; i < pos.options.length; i++) {
        if (pos.options[i].id.toUpperCase().localeCompare(value.toUpperCase()) == 0) {
            pos.options[i].style.display = "";
        }
        else {
            pos.options[i].style.display = "none";
        }
    }
}
function PasswordValidation() {
    var pass1 = document.getElementById("password1");
    var pass2 = document.getElementById("password2");
    pass2.setCustomValidity(pass2.value != pass1.value ? "Passwords do not match." : "");
}