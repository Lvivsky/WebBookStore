$('.message a').click(function () {
    $('form').animate({
        height: "toggle",
        opacity: "toggle"
    }, "slow");
});

$(document).ready(function () {
    $("input#register").click(function () {
        var firstName = $("form.register-form input.firstName").val();
        var lastName = $("form.register-form input.lastName").val();
        var email = $("form.register-form input.email").val();
        var password = $("form.register-form input.password").val();
        var confirmPassword = $("form.register-form input.confirmPassword").val();
        if (firstName == '' || lastName == '' || email == '' || password == '' || confirmPassword == '') {
            alert("Please fill all fields...!!!!!!");
        } else if ((password.length) < 8) {
            alert("Password should at least have 8 character...!!!!!!");
        } else if (password != confirmPassword) {
            alert("Your passwords don't match. Try again?");
        } else {
            var userRegistration = {
                firstName: firstName,
                lastName: lastName,
                email: email,
                password: password
            };
            $.post("registration", userRegistration, function (data) {
                if (data == 'Success') {
                    window.location.href = "cabinet.jsp";
                } else {
                    alert("Something wrong! Please, try again");
                }
                $("form")[0].reset();
            });
        }
    });
});

$(document).ready(function () {
    $("input#login").click(function () {
        var email = $("form.login-form input.email").val();
        var password = $("form.login-form input.password").val();


        if (email == '' || password == '') {
            alert("Please fill all fields...!!!!!!");
        } else {
            var user = {
                email: email,
                password: password
            };

            $.post("login", user, function (data) {
                if (data == "Success") {
                    window.location.href = "cabinet.jsp";
                } else {
                    alert(data);
                }
            });
        }
    });
});


$(document).ready(function () {
   $("input#logout").click(function () {
       $.post("logout", null, function (data) {
           if (data == 'Success') {
               window.location.href = "index.jsp";
           } else {
               alert(data);
           }
       });
   });
});

$(document).ready(function () {
    $("input#craete-product").click(function () {




    });
});



