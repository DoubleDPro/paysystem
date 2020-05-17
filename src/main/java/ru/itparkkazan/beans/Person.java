package ru.itparkkazan.beans;

/**
 * Интерфейс персона
 */
public interface Person {
    /**
     * Метод для получения полного имени
     * @return
     */
    String getFullName();

    /**
     * Сеттер счетов
     * @param account
     */
    void setAccount(Account account);
}
