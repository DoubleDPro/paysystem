package ru.itparkkazan.servlets;

import ru.itparkkazan.beans.Account;
import ru.itparkkazan.dao.AccountDAO;
import ru.itparkkazan.enums.AccountInfo;
import ru.itparkkazan.enums.ClientCredential;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Сервлет для обработки пополнения счета
 */
@WebServlet(name = "replenish", urlPatterns = "/replenish")
public class ReplenishServlet extends HttpServlet {

    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String sum = httpServletRequest.getParameter(AccountInfo.REPLENISH_SUM.getAccountInfo());
        //TODO Добавить валидацию суммы (положительные цифры)
        AccountDAO accountDAO = new AccountDAO();
        Account currentAccount = null;
        try {
            currentAccount = accountDAO.getById((Integer) httpServletRequest.getSession().getAttribute(ClientCredential.ACCOUNT_ID.getClientCredential()));
        } catch (Exception e) {
            //TODO Обработать исключения
        }
        currentAccount.setSum(currentAccount.getSum() + Integer.parseInt(sum));
        accountDAO.update(currentAccount);
    }
}
