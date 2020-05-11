package ru.itparkkazan.servlets;

import ru.itparkkazan.beans.Client;
import ru.itparkkazan.dao.ClientDAO;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.utils.ServletUtil;
import ru.itparkkazan.utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "initProfile", urlPatterns = "/initProfile")
public class InitProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            ClientDAO clientDAO = new ClientDAO();
            Client currentClient = clientDAO.getById((Integer) httpServletRequest.getSession().getAttribute(ClientCredential.ID.getClientCredential()));
            SessionUtil.fillSession(httpServletRequest.getSession(), currentClient);
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.PROFILE_PAGE.getPage());
        } catch (Exception e) {
            ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.ERROR_PAGE.getPage());
        }

    }
}
