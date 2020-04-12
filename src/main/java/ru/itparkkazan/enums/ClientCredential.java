package ru.itparkkazan.enums;

/**
 * Перечисление, содержащее аутентификационные данные для клиента
 */
public enum ClientCredential {
    /**
     * Идентификатор
     */
    ID("id"),
    /**
     * Имя
     */
    FIRST_NAME("firstname"),
    /**
     * Отчество
     */
    SECOND_NAME("secondname"),
    /**
     * Фамилия
     */
    SURNAME("surname"),
    /**
     * Логин
     */
    LOGIN("login"),
    /**
     * Пароль
     */
    PSSWD("psswd");

    /**
     * Аутентификационные данные
     */
    private String clientCredential;

    /**
     * Конструктор с полем аутентификационных данных
     * @param clientCredential аутентификационные данные
     */
    ClientCredential(String clientCredential) {
        this.clientCredential = clientCredential;
    }

    /**
     * Геттер аутентификационных данных
     * @return аутентификационные данные
     */
    public String getClientCredential() {
        return clientCredential;
    }

}
