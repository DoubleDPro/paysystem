<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Система</title>
    <style>
        .topnav {
            overflow: hidden;
            background-color: #333;
            line-height: 10%;
        }

        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<jsp:include page="headers/system_header.jsp"/>
<div style="width: 100%; line-height: 600px; vertical-align: bottom">
    <div align="center" style="background-color: gray">
        <div class="topnav">
            <a href="pay.jsp" target="payOperationFrame">Оплата</a>
            <a href="../initClientsTransfer" target="payOperationFrame">Перевод</a>
            <a href="withdrawal.jsp" target="payOperationFrame">Вывод</a>
            <a href="replenish.jsp" target="payOperationFrame">Пополнение</a>
        </div>
        <iframe frameborder="0" name="payOperationFrame" width="100%" height="200px"/>
    </div>
</div>
</body>
</html>