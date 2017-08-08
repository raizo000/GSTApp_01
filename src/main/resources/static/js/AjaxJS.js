$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        var search = {}
        search["username"] = $("#username").val();
        $("#btn-search").prop("disabled", true);
        $('#example').DataTable({
            "ajax": {
                "url": "http://localhost:8080/home/admin/search",
                "contentType": "application/json",
                "type": "POST",
                data: JSON.parse('{"username": "admin@gmail.com"}'),
            }
            ,
            "columns":
                [
                    {"result": "id"},
                    {"result": "email"},
                    {"result": "password"},
                ]
        });

    });

})
;

function fire_ajax_submit() {

    var search = {}
    search["username"] = $("#username").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/home/admin/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";

            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);
        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}