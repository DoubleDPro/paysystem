package ru.itparkkazan.servlets;

import ru.itparkkazan.beans.Account;
import ru.itparkkazan.dao.AccountDAO;
import ru.itparkkazan.enums.ClientCredential;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет для обработки перевода
 */
@WebServlet(name = "transfer", urlPatterns = "/transfer")
public class TransferServlet  extends HttpServlet {
    //TODO Переписать все относительные пути в jsp на contextPath

    /**
     *  Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        int fromClientAccountId = (Integer) httpServletRequest.getSession().getAttribute(ClientCredential.ACCOUNT_ID.getClientCredential());
        int toClientAccountId = Integer.parseInt(httpServletRequest.getParameter("toClient"));
        int sum = Integer.parseInt(httpServletRequest.getParameter("transferSum"));
        AccountDAO accountDAO = new AccountDAO();
        Account fromClientAccount = null;
        Account toClientAccount = null;
        try {
            fromClientAccount = accountDAO.getById(fromClientAccountId);
            toClientAccount = accountDAO.getById(toClientAccountId);
        } catch (Exception e) {
            //TODO Обработать исключения
        }
        //TODO Добавить проверку на достаточность средств на счете
        fromClientAccount.setSum(fromClientAccount.getSum() - sum);
        toClientAccount.setSum(toClientAccount.getSum() + sum);
        accountDAO.update(fromClientAccount);
        accountDAO.update(toClientAccount);
    }
}
