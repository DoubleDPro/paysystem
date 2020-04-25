package ru.itparkkazan.beans;

/**
 * Класс для описания клиента
 */
public class Client implements Person {

    //TODO переписать класс с использоваением аннотаций lombok

    /**
     * Конструктор
     * @param id идентификатор
     * @param login логин
     * @param psswd пароль
     * @param firstname имя
     * @param secondname отчество
     * @param surname фамилия
     * @param account счет
     */
    public Client(int id, String login, String psswd, String firstname, String secondname, String surname, Account account) {
        this.id = id;
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
        this.account = account;
    }
    /**
     * Конструктор
     *
     * @param login      логин
     * @param psswd      пароль
     * @param firstname  имя
     * @param secondname отчество
     * @param surname    фамилия
     */
    public Client(String login, String psswd, String firstname, String secondname, String surname) {
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
    }

    /**
     * Конструктор
     * @param id идентификатор
     * @param login логин
     * @param psswd пароль
     * @param firstname имя
     * @param secondname отчество
     * @param surname фамилия
     */
    public Client(int id, String login, String psswd, String firstname, String secondname, String surname) {
        this.id = id;
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
    }

    /**
     * Конструктор
     * @param login логин
     * @param psswd пароль
     * @param firstname имя
     * @param secondname отчество
     * @param surname фамилия
     * @param account аккаунт
     */
    public Client(String login, String psswd, String firstname, String secondname, String surname, Account account) {
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
        this.account = account;
    }

    /**
     * Конструктор
     * @param id идентификатор
     * @param firstname имя
     * @param secondname отчество
     * @param surname фамилия
     */
    public Client(int id, String firstname, String secondname, String surname, Account account) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
        this.account = account;
    }

    /**
     * Конструктор по-умолчанию
     */
    public Client() {}

    /**
     * Идентификатор
     */
    private int id;
    /**
     * Логин
     */
    private String login;
    /**
     * Пароль
     */
    private String psswd;
    /**
     * Имя
     */
    private String firstname;
    /**
     * Отчество
     */
    private String secondname;
    /**
     * Фамилия
     */
    private String surname;
    /**
     * Счет
     */
    private Account account;

    /**
     * Геттер идентификатора
     * @return идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Сеттер идентификаторов
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Геттер логина
     *
     * @return логин
     */
    public String getLogin() {
        return login;
    }

    /**
     * Сеттер логина
     *
     * @param login логин
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Геттер пароля
     *
     * @return пароль
     */
    public String getPsswd() {
        return psswd;
    }

    /**
     * Сеттер пароля
     *
     * @param psswd пароль
     */
    public void setPsswd(String psswd) {
        this.psswd = psswd;
    }

    /**
     * Геттер имени
     *
     * @return имя
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Сеттер имени
     *
     * @param firstname имя
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Геттер отсчества
     *
     * @return отчество
     */
    public String getSecondname() {
        return secondname;
    }

    /**
     * Сеттер отчества
     *
     * @param secondname отчество
     */
    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    /**
     * Геттер фамилии
     *
     * @return фамилия
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Сеттер фамилии
     *
     * @param surname фамилия
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Геттер списка счетов
     *
     * @return список счетов
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Сеттер списка счетов
     *
     * @param account список счетов
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Геттер полного имени
     *
     * @return полное имя
     */
    public String getFullName() {
        return String.join(" ", surname, firstname, secondname);
    }
}
