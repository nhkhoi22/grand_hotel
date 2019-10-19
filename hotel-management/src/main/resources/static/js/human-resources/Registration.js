function PositionFilter() {
    var depart = document.getElementById("departmentID");
    var value = depart.options[depart.selectedIndex].value;
    var pos = document.getElementById("PosDepartment");
    for(var i = 1; i < pos.options.length; i++)
    {
        console.log(pos.options[i].id);
        
        if(pos.options[i].id.toUpperCase().localeCompare(value.toUpperCase()) == 0)
        {
            pos.options[i].style.display = "";
        }
        else
        {
            pos.options[i].style.display = "none";
        }
    }
}
function PasswordValidation(){
    var pass1 = document.getElementById("password1");
    var pass2 = document.getElementById("password2");
    pass2.setCustomValidity(pass2.value != pass1.value ? "Passwords do not match." : "");
}