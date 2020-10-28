$('.message a').click(function () {
    $('form').animate({
        height: "toggle",
        opacity: "toggle"
    }, "slow");
});

$(document).ready(function () {
    $("input#register").click(function () {
        let firstName = $("form.register-form input.firstName").val();
        let lastName = $("form.register-form input.lastName").val();
        let email = $("form.register-form input.email").val();
        let password = $("form.register-form input.password").val();
        let confirmPassword = $("form.register-form input.confirmPassword").val();
        if (firstName == '' || lastName == '' || email == '' || password == '' || confirmPassword == '') {
            alert("Please fill all fields...!!!!!!");
        } else if ((password.length) < 8) {
            alert("Password should at least have 8 character...!!!!!!");
        } else if (password != confirmPassword) {
            alert("Your passwords don't match. Try again?");
        } else {
            let userRegistration = {
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
        let email = $("form.login-form input.email").val();
        let password = $("form.login-form input.password").val();

        if (email == '' || password == '') {
            alert("Please fill all fields...!!!!!!");
        } else {
            let user = {
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
   $("input#craete-product").click(function () {
       window.location.href = "productcreating.jsp";
   });
});
