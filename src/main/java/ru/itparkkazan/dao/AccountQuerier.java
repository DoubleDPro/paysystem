package ru.itparkkazan.dao;

public class AccountQuerier {
    protected static final String SELECT__ALL_ACCOUNT_NUMBERS = "SELECT * FROM PAYSYSTEM.PAYSYSTEM.ACCOUNT";
    protected static final String SELECT_ACCOUNT_BY_ACCOUNT_NUMBER = "SELECT * FROM PAYSYSTEM.PAYSYSTEM.ACCOUNT WHERE ACCOUNT_NUMBER = ?";
    protected static final String INSERT_ACCOUNT_INFO = "INSERT INTO PAYSYSTEM.PAYSYSTEM.ACCOUNT (ACCOUNT_NUMBER) VALUES (?)";
}
