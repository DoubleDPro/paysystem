package ru.itparkkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.beans.PayData;
import ru.itparkkazan.dao.PayDataDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Сервлет для обратотки оплаты
 */
@Slf4j
@WebServlet(name="pay", urlPatterns = "/pay")
public class PayServlet extends HttpServlet {

    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String payTargetCount = httpServletRequest.getParameter("payTargetCount");
        String paySum = httpServletRequest.getParameter("paySum");
        PayDataDAO payDataDAO = new PayDataDAO();
        //TODO Добавить создание объекта клиента и SessionUtil из данных по сессии
        Client client = new Client();
        client.setId(1);
        PayData payData = new PayData(client, payTargetCount, Integer.parseInt(paySum), new Date());
        payDataDAO.insert(payData);
    }
}
