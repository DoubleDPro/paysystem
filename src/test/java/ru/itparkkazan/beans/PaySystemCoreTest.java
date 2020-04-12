package ru.itparkkazan.beans;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PaySystemCoreTest {

    private static final String IVANOV_LOGIN = "Ivan";
    private static final String IVANOV_PASSWD = "Ivan";
    private static final String IVANOV_FIRSTNAME = "Иван";
    private static final String IVANOV_SECONDNAME = "Иванович";
    private static final String IVANOV_SURNAME = "Иванов";

    private static final String PETROV_LOGIN = "Petrov";
    private static final String PETROC_PASSWD = "Petrov";
    private static final String PETROV_FIRSTNAME = "Петр";
    private static final String PETROV_SECONDNAME = "Петрович";
    private static final String PETROV_SURNAME = "Петров";

    private PaySystemCore paySystemCore;

    /**
     * Инициализация данных платежной системы
     */
    /*@Before
    public void initPaySystemCore() {
        paySystemCore = PaySystemCore.builder().build();

        Person ivanovClient = new Client(IVANOV_LOGIN, IVANOV_PASSWD, IVANOV_FIRSTNAME, IVANOV_SECONDNAME, IVANOV_SURNAME);

        List<Account> ivanovAccounts = new ArrayList<>();

        ivanovAccounts.add(Account.builder().accountNumber(1111).sum(500).client(ivanovClient).build());
        ivanovAccounts.add(Account.builder().accountNumber(2222).sum(1000).client(ivanovClient).build());
        ivanovClient.setAccounts(ivanovAccounts);

        Person petrovClient = new Client(PETROV_LOGIN, PETROC_PASSWD, PETROV_FIRSTNAME, PETROV_SECONDNAME, PETROV_SURNAME);

        List<Account> petrovAccounts = new ArrayList<>();

        petrovAccounts.add(Account.builder().accountNumber(3333).sum(2000).client(petrovClient).build());
        petrovAccounts.add(Account.builder().accountNumber(4444).sum(3000).client(petrovClient).build());
        petrovAccounts.add(Account.builder().accountNumber(5555).sum(4000).client(petrovClient).build());
        petrovClient.setAccounts(petrovAccounts);

        List<Account> allAccounts = new ArrayList<>(petrovAccounts);
        allAccounts.addAll(ivanovAccounts);

        List<Person> allClients = new ArrayList<>();
        allClients.add(ivanovClient);
        allClients.add(petrovClient);

        paySystemCore.setPaySystemAccounts(allAccounts);
        paySystemCore.setPaySystemClients(allClients);

    }*/

    /**
     * Метод проверки отображения всех счетов платежной системы
     */
    @Test
    public void showAllAccountsTest() {
        paySystemCore.showAllAccounts();
    }

    /**
     * Метод проверки отображения всех клиентов платежной системы
     */
    @Test
    public void showAllClientsTest() {
        paySystemCore.showAllClients();
    }

    /**
     * Метод проверки отображения полной информации клиент-счета платежной системы
     */
    @Test
    public void showAllClientAccountsTest() {
        //TODO определить причину отрицательного результата теста
        //paySystemCore.showAllClientAccounts();
    }
}