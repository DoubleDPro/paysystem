<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<div align="center" style="width: 100%; height: 160px; background-color: #5a5a5a">
    <form style="width: 100%; height: 100%" id="replenishForm" action="${pageContext.servletContext.contextPath}/replenish" method="post">
        <table style="height: 100%">
            <tr>
                <td><label>Сумма</label></td>
                <td><input type="number" min="1" max="1000" name="replenish_sum"></td>
            </tr>
            <tr>
                <td colspan="2"><input style="width: 100%" type="submit" value="Пополнить"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>