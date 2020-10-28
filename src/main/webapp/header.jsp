<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<link href="css/header.css" rel="stylesheet">


<header class="nav dis-flex">
    <div class="container dis-flex">
        <div class="header-logo">
            <img src="">
            <a href="cabinet.jsp" class="logo-link">Store</a>
        </div>

        <nav class="header-menu">
            <a href="#" class="menu-link">some1</a>
            <a href="#" class="menu-link">Add product</a>
            <a href="#" class="menu-link">Bucket</a>

<%--    Some fany feetures        --%>


        </nav>
        <div>
            <c:if test="${not empty userEmail}">
                <input id="logout" type="button" value="Log out"/>
            </c:if>
            <c:if test="${empty userEmail}">
                <input id="toLogin" type="button" value="Log in"/>
            </c:if>
        </div>
    </div>
</header>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="js/header.js"></script>
