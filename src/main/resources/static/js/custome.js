 $(document).ready(function () {
     //create arrays to store option and values
     var khoi10 = [{
             display: "10A1",
             value: "10A1"
         },
         {
             display: "10A2",
             value: "10A2"
         },
         {
             display: "10A3",
             value: "10A3"
         },

     ];

     var khoi11 = [{
             display: "11A1",
             value: "11A1"
         },
         {
             display: "11A2",
             value: "11A2"
         },
         {
             display: "11A3",
             value: "11A3"
         },
     ];

     //If parent option is changed
     $("#parent_selection").change(function () {
         var parent = $(this).val(); //get option value from parent       
         switch (parent) { //using switch compare selected option and populate child
             case 'khoi10':
                 $('#child_selection').attr('disabled', false);
                 list(khoi10);
                 break;
             case 'khoi11':
                 $('#child_selection').attr('disabled', false);
                 list(khoi11);
                 break;
             default: //default child option is blank
                 $("#child_selection").html('');
                 $('#child_selection').attr("disabled", true);
                 break;
         }
     });

     //function to populate child select box
     function list(array_list) {
         $("#child_selection").html(""); //reset child options
         $(array_list).each(function (i) { //populate child options
             $("#child_selection").append("<option value=" + array_list[i].value + ">" +
                 array_list[i].display + "</option>");
         });
     }
 });


 $('#datepicker').daterangepicker({
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


 var password = document.getElementById("password")
     , confirm_password = document.getElementById("confirmPassword");

 function validatePassword(){
     if(password.value != confirmPassword.value) {
         confirm_password.setCustomValidity("mật khẩu không trùng khớp");
     } else {
         confirm_password.setCustomValidity('');
     }
 }

 password.onchange = validatePassword;
 confirm_password.onkeyup = validatePassword;