package ru.itparkkazan.dao;

public class ClientQuerier {
    /**
     * SQL-запрос для вставки в БД информации о клиенте
     */
    protected static final String INSERT_INTO_CLIENT_VALUES = "INSERT INTO PAYSYSTEM.PAYSYSTEM.CLIENT (LOGIN, PSWD, FIRSTNAME, SECONDNAME, SURNAME, ACCOUNT_ID) VALUES (?,?,?,?,?,?)";
    /**
     * SQL-запрос для получения из БД информации о клиенте по логину и паролю
     */
    protected static final String SELECT_CLIENT_BY_LGN_AND_PSSWD = "SELECT * FROM PAYSYSTEM.PAYSYSTEM.CLIENT WHERE LOGIN = ? AND PSWD = ?";
    /**
     * SQL-запрос для получения из БД информацию со списком всех клиентов
     */
    protected static final String SELECT__ALL_CLIENTS = "SELECT * FROM PAYSYSTEM.PAYSYSTEM.CLIENT";
}
