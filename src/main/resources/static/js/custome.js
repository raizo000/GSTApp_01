

$('#birthday').daterangepicker({
    singleDatePicker: true,
    showDropdowns: true,
    minDate: "01/01/1950",
    maxDate: "01/01/2040",
});

$(document).ready(function () {
    $('#dataTables').DataTable({
        responsive: true
    });
});


var password = document.getElementById("password");
var confirm_password = document.getElementById("confirmPassword");

function validatePassword() {
    if (password.value != confirmPassword.value) {
        confirm_password.setCustomValidity("Mật khẩu không trùng khớp");
    } else {
        confirm_password.setCustomValidity('');
    }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

function resetFunction() {
    document.getElementById("form").reset();
}