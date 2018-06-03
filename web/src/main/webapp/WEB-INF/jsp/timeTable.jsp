<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/timeTableServlet" method="post">
    Станция отправления:<br>
    <select name="stationStart">
        <c:forEach var="stationStart" items="${requestScope.stations}">
            <option value="${stationStart.id}">${stationStart.name}</option>
        </c:forEach>
    </select>
    <br>
    Станция прибытия:<br>
    <select name="stationFinish">
        <c:forEach var="stationFinish" items="${requestScope.stations}">
            <option value="${stationFinish.id}">${stationFinish.id}</option>
        </c:forEach>
    </select>
    <br>
    Выберите Дату отправления поезда:<br>
    <input type="date" name="date">

    <input type="submit" value="Поиск">
</form>

<c:if test="${not empty requestScope.timeTables}">
    <div>
        <c:forEach var="timeTable" items="${requestScope.timeTables}">
            ${timeTable.train.name}
            ${timeTable.stationStart}
            ${timeTable.stationFinish}
            ${timeTable.timeStart}
            ${timeTable.timeFinish}
        </c:forEach>
    </div>
    <form name="limitOffset" action="${pageContext.request.contextPath}/timeTableServlet" method="post">
        Номер страницы <br>
        <input type="text" name="page">
        Количество рейсов на странице <br>
        <select name="size">
            <option>1</option>
            <option>2</option>
            <option>3</option>
        </select>
    </form>
</c:if>

</body>
</html>

