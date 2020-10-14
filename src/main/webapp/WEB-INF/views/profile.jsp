<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fml" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<html lang="${cookie['lang'].value}">

<head>
    <title>
        <fmt:message key="application.title"/>
    </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="http://i.imgur.com/8pTfNU5.png">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
</head>

<body>

<nav class="navbar navbar-expand-sm navbar-light bg-light">

    <div class="navbar-brand">
        <fmt:message key="profile.title"/>
    </div>

    <div class="collapse navbar-collapse">

        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/products">
                    <fmt:message key="products.title"/>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/orders">
                    <fmt:message key="orders.title"/>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/profile">
                    <fmt:message key="products.title"/>
                </a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">
                    <span class="fas fa-sign-out-alt"
                          aria-hidden="true">
                    </span>
                    <fmt:message key="logout"/>
                </a>
            </li>
        </ul>

    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col">
            <div class="panel border-panel">

                <div class="panel-heading title-panel">
                    <h4 class="text-center">
                        {firstName} + '&nbsp' + {lastName}
                    </h4>
                </div>

                <div class="panel-body" style="margin-top: 30px;">

                    <div class="row indent">
                        <div class="col text-center title">Id:</div>
                        <div class="col text-center data">{id}</div>
                    </div>

                    <div class="row indent">
                        <div class="col text-center title">Username:</div>
                        <div class="col text-center data">{username}</div>
                    </div>

                    <div class="row indent">
                        <div class="col text-center title">First Name:</div>
                        <div class="col text-center data">{firstName}</div>
                    </div>

                    <div class="row indent">
                        <div class="col text-center title">Last Name:</div>
                        <div class="col text-center data">lastName</div>
                    </div>

                    <div class="row indent">
                        <div class="col text-center title">Balance:</div>
                        <div class="col text-center data">Balance</div>
                    </div>

                </div>

            </div>

        </div>
    </div>
</div>

</body>
</html>