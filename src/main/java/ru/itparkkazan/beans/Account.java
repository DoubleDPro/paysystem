package ru.itparkkazan.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс для описания объекта "Счет"
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    /**
     * Идентификатор
     */
    private int id;
    /**
     * Номер счета
     */
    private int accountNumber;
    /**
     * Сумма счета
     */
    private int sum;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.sum = sum;
    }
    @Override
    public boolean equals(Object object) {
        Account account = (Account) object;
        return this.accountNumber == account.getAccountNumber();
    }

    /**
     * Переопределенный метод вывода класса счета в строку
     *
     * @return номер счета и сумму на нём через разделитель
     */
    @Override
    public String toString() {
        return String.join(" | ", String.valueOf(accountNumber), String.valueOf(sum));
    }
}
