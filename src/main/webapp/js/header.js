$(document).ready(function () {
    $("a#logout").click(function () {
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
   $("a#toLogin").click(function () {
       window.location.href = 'index.jsp';
   });
});

$(document).ready(function () {
    $("a#toProductAdd").click(function () {
        window.location.href = "productcreating.jsp";
    });
});