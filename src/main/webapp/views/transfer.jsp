<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div align="center" style="width: 100%; height: 160px; background-color: #5a5a5a">
    <form style="width: 100%; height: 100%" id="transferForm" action="${pageContext.servletContext.contextPath}/transfer" method="post">
        <table style="height: 100%">
            <tr>
                <td><label>Кому</label></td>
                <td><select name="toClient" style="width: 100%">
                    <option selected disabled>Выберите клиента</option>
                    <c:forEach items="${allClients}" var="client">
                        <option value="${client.account.id}">${client.firstname}</option>
                    </c:forEach>
                </select>
                </td>
            </tr>
            <tr>
                <td><label>Сумма</label></td>
                <td><input type="number" name="transferSum"/></td>
            </tr>
            <tr>
                <td colspan="2"><input style="width: 100%" type="submit" value="Отправить"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>