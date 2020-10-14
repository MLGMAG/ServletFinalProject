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


<div class="container">
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            <div class="panel" style="margin-top: 80px;">
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath}/sign-in" method="post">
                        <fieldset>

                            <legend>
                                <fmt:message key="signIn.title"/>
                            </legend>

                            <%--                            <div th:if="${logout}">--%>
                            <%--                                <div class="alert alert-info fade show" role="alert">--%>
                            <%--                                    You've has been logged out successfully--%>
                            <%--                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">--%>
                            <%--                                        <span aria-hidden="true">&times;</span>--%>
                            <%--                                    </button>--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>

                            <c:if test="${regSuccess}">
                                <div class="alert alert-success fade show" role="alert">
                                    <fml:message key="signIn.regSuccess"/>
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                            </c:if>

                            <c:if test="${loginException}">
                                <div class="alert alert-danger fade show" role="alert">
                                    <fml:message key="signIn.error"/>
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                            </c:if>

                            <div class="form-group">
                                <label>
                                    <fmt:message key="signIn.username"/>
                                </label>
                                <input class="form-control" type="text" name="username"
                                       placeholder="<fmt:message key="signIn.username"/>" required>
                            </div>

                            <div class="form-group">
                                <label>
                                    <fmt:message key="signIn.password"/>
                                </label>
                                <input class="form-control" type="password" name="password"
                                       placeholder="<fmt:message key="signIn.password"/>" required>
                            </div>

                            <input class="btn btn-success btn-block" type="submit"
                                   value="<fmt:message key="signIn.button"/>">

                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

</body>
</html>
