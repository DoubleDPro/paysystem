package ru.itparkkazan.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.itparkkazan.beans.Client;

import java.util.List;

@Ignore
public class ClientDAOTest {

    ClientDAO clientDAO;

    @Before
    public void init() {
        clientDAO = new ClientDAO();
    }

    @Test
    public void doGetAllTest() {
        List<Client> testClients = clientDAO.getAll();
        Assert.assertFalse(testClients.isEmpty());
    }
}