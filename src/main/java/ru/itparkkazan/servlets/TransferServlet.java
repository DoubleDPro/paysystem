package ru.itparkkazan.servlets;

import ru.itparkkazan.beans.Account;
import ru.itparkkazan.dao.AccountDAO;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.processors.AccountProcessor;
import ru.itparkkazan.utils.ServletUtil;

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
        int transferSum = Integer.parseInt(httpServletRequest.getParameter("transferSum"));
        AccountDAO accountDAO = new AccountDAO();
        try {
            Account fromClientAccount = accountDAO.getById(fromClientAccountId);
            Account toClientAccount = accountDAO.getById(toClientAccountId);
            AccountProcessor.transferMoney(fromClientAccount, toClientAccount, transferSum);
            accountDAO.update(fromClientAccount);
            accountDAO.update(toClientAccount);
        } catch (Exception e) {
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
