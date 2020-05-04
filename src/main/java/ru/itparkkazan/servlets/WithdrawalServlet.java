package ru.itparkkazan.servlets;

import ru.itparkkazan.beans.Account;
import ru.itparkkazan.dao.AccountDAO;
import ru.itparkkazan.enums.AccountInfo;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.processors.AccountProcessor;
import ru.itparkkazan.utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет для обработки снятия средств
 */
@WebServlet(name = "withdrawal", urlPatterns = "/withdrawal")
public class WithdrawalServlet extends HttpServlet {

    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String sum = httpServletRequest.getParameter(AccountInfo.WITHDRAWAL_SUM.getAccountInfo());
        AccountDAO accountDAO = new AccountDAO();
        try {
            Account currentAccount = accountDAO.getById((Integer) httpServletRequest.getSession().getAttribute(ClientCredential.ACCOUNT_ID.getClientCredential()));
            AccountProcessor.withdrawalAccount(currentAccount, Integer.parseInt(sum));
            accountDAO.update(currentAccount);
        } catch (Exception e) {
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
