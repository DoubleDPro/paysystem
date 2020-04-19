package ru.itparkkazan.dao;

public class AccountQuerier {
    /**
     * SQL-запрос для получения из БД информации о счете по идентификатору
     */
    protected static final String SELECT_ACCOUNT_BY_ID = "SELECT * FROM PAYSYSTEM.PAYSYSTEM.ACCOUNT WHERE ID = ?";
    /**
     * SQL-запрос для получения из БД информации о всех счетах
     */
    protected static final String SELECT__ALL_ACCOUNT_NUMBERS = "SELECT * FROM PAYSYSTEM.PAYSYSTEM.ACCOUNT";
    /**
     * SQL-запрос для получения из БД информации о счете по его номеру
     */
    protected static final String SELECT_ACCOUNT_BY_ACCOUNT_NUMBER = "SELECT * FROM PAYSYSTEM.PAYSYSTEM.ACCOUNT WHERE ACCOUNT_NUMBER = ?";
    /**
     * SQL-запрос для вставки в БД информации о счете
     */
    protected static final String INSERT_ACCOUNT_INFO = "INSERT INTO PAYSYSTEM.PAYSYSTEM.ACCOUNT (ACCOUNT_NUMBER) VALUES (?)";
    /**
     * SQL-запрос для обновления в БД информации о сумме на счете по идентификатору
     */
    protected static final String UPDATE_ACCOUNT_SUM = "UPDATE PAYSYSTEM.PAYSYSTEM.ACCOUNT SET SUM = ? WHERE ID = ?";

}
