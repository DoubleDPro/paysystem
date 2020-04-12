package ru.itparkkazan.beans;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    private Account account;

    /**
     * Базовый метод тестирования создания счёта
     */
    @Test
    public void basicAccountTest() {
        Account account = new Account();
        account.setSum(1000);
        Assert.assertEquals(1000, account.getSum());
        System.out.println(account.getSum());
    }

    /**
     * Метод проверки корректности создания счета посредством lombok
     */
    @Test
    public void buildAccountTest() {
        account = Account.builder().sum(500).build();
        Assert.assertEquals(500, account.getSum());
        System.out.println(account.getSum());
    }

    /**
     * Метод проверки блокировки счета
     */
    @Test
    public void isAccountBlockedTest() {
//        account = Account.builder().isBlocked(new Boolean("true")).build();
    }

}