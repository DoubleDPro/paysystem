package ru.itparkkazan.servlets;

import ru.itparkkazan.beans.Client;
import ru.itparkkazan.dao.ClientDAO;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервлет для инициализации элемента select
 */
@WebServlet(name = "initClientsTransfer", urlPatterns = "/initClientsTransfer")
public class InitClientsTransferServlet extends HttpServlet {

    /**
     * Метод обработки GET-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     */
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        ClientDAO clientDAO = new ClientDAO();
        List<Client> allClients = clientDAO.getAll();
        List<Client> clientsWithoutCurrent = allClients.stream()
                .filter(x -> x.getId() != (int) httpServletRequest.getSession().getAttribute(ClientCredential.ID.getClientCredential()))
                .collect(Collectors.toList());
        httpServletRequest.setAttribute("allClients", clientsWithoutCurrent);
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("views/transfer.jsp");
        try {
            dispatcher.forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        } catch (IOException e) {
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }
    }
}
