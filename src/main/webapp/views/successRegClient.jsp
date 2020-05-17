<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Успешная регистрация</title>
</head>
<body>
<jsp:include page="headers/index_header.jsp"/>

<div style="width: 100%; height: 600px;  display: flex; justify-content: center; align-items: center; background-color: gray">
    <div align="center" style="width: 100%; height: 160px; background-color: #5a5a5a">
        <form id="clientSuccessRegistrationForm" style="height: 100%" action="${pageContext.servletContext.contextPath}/enterSystem.jsp" method="post">
            <table style="height: 100%">
                <tr>
                    <td>
                        <label>Пользователь </label>
                        <output>"${sessionScope.firstname}"</output>
                        <label> успешно зарегистрирован!</label>
                        <br>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <input type="submit" name="enterSystem" value="Перейти в систему"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>


</body>
</html>