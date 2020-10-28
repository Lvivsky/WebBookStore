$(document).ready(function () {
    $("input#logout").click(function () {
        $.post("logout", null, function (data) {
            if (data == 'Success') {
                window.location.href = "cabinet.jsp";
            } else {
                alert(data);
            }
        });
    });
});

$(document).ready(function () {
   $("input#toLogin").click(function () {
       window.location.href = 'index.jsp';
   });
});