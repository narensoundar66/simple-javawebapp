<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Vladimir Kostin">

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <title>
        <fmt:bundle basename="application">
            <fmt:message key="app.title" />
        </fmt:bundle>
    </title>

    <!-- Bootstrap core CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-bare/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
        body {
            padding-top: 54px;
        }
        @media (min-width: 992px) {
            body {
                padding-top: 56px;
            }
        }

    </style>

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/">
            <fmt:bundle basename="application">
                <fmt:message key="app.title" />
            </fmt:bundle>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" target="_blank" href="https://github.com/vlavik007/SimpleJavaWebApp">
                        Github
                    </a>
                </li>
                <li class="nav-item" style="margin-left: 1em;">
                    <a class="nav-link" href="#">
                        <fmt:bundle basename="application">
                            <fmt:message key="count.total-page-views" />
                        </fmt:bundle>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">${hits}</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-12 text-center">
            <h1 class="mt-5">
                <fmt:bundle basename="application">
                    <fmt:message key="app.title" />
                </fmt:bundle>
            </h1>
            <p class="lead">
                <fmt:bundle basename="application">
                    <fmt:message key="app.desc" />
                </fmt:bundle>
            </p>
            <br><br><hr><br><br>

            <c:forEach items="${requestScope.collection}" var="emp">
                ${emp},
            </c:forEach>

            <br>

            <fmt:bundle basename="application">
                <fmt:message key="count.total-collection-size" />
            </fmt:bundle>
            <strong>${listSize}</strong>

            <br><br><hr><br>

            <div class="btn-group" style="margin:5px 0 10px 0;">
                <input type="button" onclick="sendGet()" class="btn btn-primary" value="GET"/>
                <input type="button" onclick="sendPost()" class="btn btn-success" value="POST"/>
                <input type="button" onclick="sendPut()" class="btn btn-info" value="PUT"/>
                <input type="button" onclick="sendDelete()" class="btn btn-danger" value="DELETE"
                       title="Push harder! Several times may not work :("/>
            </div>

            <br>
            <p><i>Delete button works. But sometimes it needs to be pressed several times to make it work.</i></p>

        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript -->
<script src="https://blackrockdigital.github.io/startbootstrap-bare/vendor/jquery/jquery.min.js"></script>
<script src="https://blackrockdigital.github.io/startbootstrap-bare/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="http://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>
<script src="js/send-functions.js" type="text/javascript"></script>

</body>

</html>