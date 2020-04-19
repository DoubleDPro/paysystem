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
        //TODO Добавить валидацию суммы (положительные цифры)
        AccountDAO accountDAO = new AccountDAO();
        Account currentAccount = null;
        try {
            currentAccount = accountDAO.getById((Integer) httpServletRequest.getSession().getAttribute(ClientCredential.ACCOUNT_ID.getClientCredential()));
        } catch (Exception e) {
            //TODO Обработать исключения
        }
        //TODO Добавить проверку на достаточность средств на счете
        currentAccount.setSum(currentAccount.getSum() - Integer.parseInt(sum));
        accountDAO.update(currentAccount);
    }
}
