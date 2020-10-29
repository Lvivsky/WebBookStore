$(document).ready(function () {
    $("input#createProduct").click(function () {
        var name = $("form.register-product-form input.name").val();
        var price = $("form.register-product-form input.price").val();
        var description = $("form.register-product-form input.description").val();

        if (name == '' || price == 0 || price == null || description == '') {
            alert("Please fill all fields...!!!!!!");
        } else {
            var product = {
                name: name,
                price: price,
                description: description
            };

            $.post("create-product", product, function (data) {
                if (data == "Success") {
                    window.location.href = "cabinet.jsp";
                } else {
                    alert(data);
                }
            });
        }
    });
});