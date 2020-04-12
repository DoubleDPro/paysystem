package ru.itparkkazan.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Класс для описания оплаты
 */
@AllArgsConstructor
@Data
public class PayData {
    /**
     * Клиент
     */
    private Client client;
    /**
     * Целевой счет
     */
    private String targetAccount;
    /**
     * Сумма
     */
    private int sum;
    /**
     * Дата/время
     */
    private Date date;

}
