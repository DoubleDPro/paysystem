package ru.itparkkazan.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет для обработки перевода
 */
@WebServlet(name = "transfer", urlPatterns = "/transfer")
public class TransferServlet  extends HttpServlet {

    /**
     *  Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //TODO реализовать логику перевода средств
    }
}
