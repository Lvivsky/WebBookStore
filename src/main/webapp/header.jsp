<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<link href="css/head.css" rel="stylesheet">


<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
        <div class="container">
            <a class="logo-brand" href="cabinet.jsp">Store</a>
            <div class="ml-auto">

                <c:if test="${not empty userEmail}">
                <div class="dropdown">
                    <a class="btn dropdown-toggle"
                            type="button" id="dropdownMenu2"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false">
                        <span class="btn-account">${userEmail}</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                        <a class="dropdown-item" type="button">Account</a>
                        <a class="dropdown-item" type="button">My bucket</a>
                        <a class="dropdown-item" type="button">My product</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" type="button" id="toProductAdd">Add product</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" type="button" id="logout">Log out</a>
                    </div>
                </div>
                </c:if>
                <c:if test="${empty userEmail}">
                    <a class="btn" type="button" id="toLogin">
                        <span class="btn-account">Log in</span>
                    </a>
                </c:if>


            </div>
        </div>
    </nav>
    <div style="display:block;height: 70px"></div>
</header>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="js/header.js"></script>



