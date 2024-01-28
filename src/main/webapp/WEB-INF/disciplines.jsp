
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">
    <script type="application/javascript" src="../resources/js/functions.js"></script>
    <title>disciplines</title>
</head>
<body>
<aside class="navigation">
    <a href="/" class="navigation-item">на главную</a>

</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
    <h2 class="heading-secondary">список дисциплин</h2>

    <div class="container">
        <table class="discipline-table" border="1">
            <tr>
                <th>&nbsp</th>
                <th> название дисциплин</th>
            </tr>
            <c:forEach items="${disciplines}" var="dc">
                <tr>
                    <td> <input type="checkbox" name="idDiscipline" value="${dc.id}"></td>
                    <td> ${dc.discipline} </td>
                </tr>
            </c:forEach>


        </table>
        <div class="discipline-btns">

            <form action="/discipline-create" method="get">
                <input type="submit" class="discipline-btn" value="создать дисциплину"/>
            </form>

            <input type="submit" onclick="modifyDisciplines()" class="discipline-btn" value="модифицировать выбранную дисциплину"/>
            <input type="submit" onclick="deleteDisciplines()" class="discipline-btn" value="удалить выбранную дисциплину"/>
        </div>
    </div>

</main>
<aside class="logout">
    <c:choose>
        <c:when test="${isLogin eq 1}">
            <a href="/logout" class="logout-btn">Logout, ${login}</a>
        </c:when>
        <c:otherwise>
            <a href="/login" class="logout-btn">Login</a>
        </c:otherwise>
    </c:choose>
</aside>

<form action="/discipline-delete" method="post" id="deleteDisciplineForm">
    <input type="hidden" value="" id="deleteDisciplineHidden" name="idsToDelete">
</form>

<form action="/discipline-modify" method="get" id="modifyDisciplineForm">
    <input type="hidden" value="" id="modifyDisciplineHidden" name="idsToModify">
</form>

</body>
</html>
