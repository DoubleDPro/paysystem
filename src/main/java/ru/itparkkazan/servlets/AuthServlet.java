package ru.itparkkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.dao.ClientDAO;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.exceptions.UnregistredAccountException;
import ru.itparkkazan.exceptions.UnregistredClientException;
import ru.itparkkazan.utils.ServletUtil;
import ru.itparkkazan.utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Сервлет для аутентификации пользователя
 */
@Slf4j
@WebServlet(name="auth", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     * @throws IOException ошибка перенаправления на другую страницу
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String clientLogin = httpServletRequest.getParameter(ClientCredential.LOGIN.getClientCredential());
        String clientPsswd = httpServletRequest.getParameter(ClientCredential.PSSWD.getClientCredential());
        ClientDAO clientDAO = new ClientDAO();
        Client client = null;
        try {
            client = clientDAO.get(clientLogin, clientPsswd);
            if (client == null) {
                //TODO Вывести на GUI предупреждение "Проблемы с БД, обратитесь к администратору"
            }
        } catch (UnregistredClientException | UnregistredAccountException e) {
            //TODO Вывести на GUI предупреждение с незарегистрирвоным клиентом
            log.error(e.getMessage());
        }
        HttpSession httpSession = httpServletRequest.getSession();
        SessionUtil.fillSession(httpSession, client);
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_AUTH_PAGE.getPage());
    }
}
