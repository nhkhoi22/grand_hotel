function AddToTable() {
    var product = document.getElementById("product").value;
    var quanity = document.getElementById("quanity").value;
    var table = document.getElementById("requestTable");
    var row = table.insertRow(0);
    row.classList.add("row");
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    cell1.classList.add("col-sm-5");
    cell2.classList.add("col-sm-5");
    cell3.classList.add("col-sm-2");
    cell1.setAttribute("value", product);
    cell1.setAttribute("value", quanity);
    cell1.innerHTML = product;
    cell2.innerHTML = quanity;
    cell3.innerHTML = '<input class="btn btn-block btn-danger" type="button" value="Delete" onclick="deleteRow(this)"/>';
    document.getElementById("quanity").value = "";
}
function deleteRow(btn) {
    var row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}