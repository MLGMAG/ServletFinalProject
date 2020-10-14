<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<nav class="navbar navbar-expand-sm navbar-light bg-light" style="margin-bottom: 30px;">

    <a href="${pageContext.request.contextPath}/">
        <div class="navbar-brand" style="margin-left: 16px;">
            <fmt:message key="application.title"/>
        </div>
    </a>

    <div class="collapse navbar-collapse">

        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/sign-up">
                    <span class="fas fa-user-plus" aria-hidden="true"></span>
                    <fmt:message key="signUp.title"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/sign-in">
                    <span class="fas fa-sign-in-alt" aria-hidden="true"></span>
                    <fmt:message key="signIn.title"/>
                </a>
            </li>
        </ul>

    </div>
</nav>

<div class="main-div" style="margin-left: 70px;margin-top: 60px;">
    <h1 style="margin-bottom: 50px;">
        <fmt:message key="index.title"/>
    </h1>

    <div class="content">

        <div class="language" style="margin-bottom: 16px;">
            <span>
                <fmt:message key="index.language.change"/>
            </span>
            <select id="locales">
                <option value=""></option>
                <option value="en"><fmt:message key="lang.en"/></option>
                <option value="ua"><fmt:message key="lang.ua"/></option>
            </select>
        </div>


        <p>
            <fmt:message key="index.product.possibilities"/>
        </p>
        <ul>
            <li>
                <fmt:message key="index.product.possibility1"/>
            </li>
            <li>
                <fmt:message key="index.product.possibility2"/>
            </li>
            <li>
                <fmt:message key="index.product.possibility3"/>
            </li>
            <li>
                <fmt:message key="index.product.possibility4"/>
            </li>
        </ul>
        <p>
            <fmt:message key="index.user.possibilities"/>
        </p>
        <ul>
            <li>
                <fmt:message key="index.user.possibility1"/>
            </li>
            <li>
                <fmt:message key="index.user.possibility2"/>
            </li>
            <li>
                <fmt:message key="index.user.possibility3"/>
            </li>
        </ul>
        <p>
            <fmt:message key="index.user.possibility4"/>
        </p>
        <p>
            <fmt:message key="index.admin.possibilities"/>
        </p>
        <ul>
            <li>
                <fmt:message key="index.admin.possibility1"/>
            </li>
            <li>
                <fmt:message key="index.admin.possibility2"/>
            </li>
            <li>
                <fmt:message key="index.admin.possibility3"/>
            </li>
        </ul>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#locales").change(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption !== '') {
                window.location.replace('${pageContext.request.contextPath}/?cookieLocale=' + selectedOption);
            }
        });
    });
</script>

</body>
</html>