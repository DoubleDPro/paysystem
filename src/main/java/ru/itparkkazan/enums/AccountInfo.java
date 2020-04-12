package ru.itparkkazan.enums;

public enum AccountInfo {
    /**
     * Идентификатор
     */
    ID("id"),
    /**
     * Имя
     */
    ACCOUNT_NUMBER("firstname"),
    /**
     * Отчество
     */
    SUM("secondname");

    /**
     * Аутентификационные данные
     */
    private String accountInfo;

    /**
     * Конструктор с полем аутентификационных данных
     * @param accountInfo аутентификационные данные
     */
    AccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    /**
     * Геттер аутентификационных данных
     * @return аутентификационные данные
     */
    public String getAccountInfo() {
        return accountInfo;
    }
}
