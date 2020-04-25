package ru.itparkkazan.processors;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Account;
import ru.itparkkazan.exceptions.ReplenishException;

/**
 * Класс, содержащий операции над счетами
 */
@Slf4j
public class AccountProcessor {

    private static void validateReplenisSum(int replenishSum) throws ReplenishException {
        log.info("Валидация суммы пополнения счета");
        if (replenishSum <= 0) {
            log.error("Ошибка при пополнении - сумма пополнения меньше 0");
            throw new ReplenishException("Сумма пополнения счета меньше 0.");
        }
    }

    /**
     * Метод пополнения счета
     *
     * @param account      счет
     * @param replenishSum сумма пополнения
     * @return флаг пополнения счета
     */
    public static synchronized void replenishAccount(Account account, int replenishSum) throws ReplenishException {
        log.info(String.join(" ", "Пополнение счета", String.valueOf(account.getAccountNumber()), "на сумму", String.valueOf(replenishSum)));
        validateReplenisSum(replenishSum);
        account.setSum(account.getSum() + replenishSum);
        log.info(String.join(" ", "Пополнение счета", String.valueOf(account.getAccountNumber()), "прошло успешно. Текущая сумма на счете", String.valueOf(account.getSum())));
    }

    /**
     * Метоод списания со счета
     *
     * @param account     счет
     * @param writeOffSum сумма списания
     */
    //TODO релизовать метод списания со счета
    public static void withdrawalAccount(Account account, int writeOffSum) {
        /*
        Реализовать метод списания со счета.
        Во время списания выполнить проверку на достаточность средств.
        В случае, если средств недостаточно для списания (остаток должен быть не меньше 0),
        прокинуть исключение WriteOffException с соответствующим описанием.
        Написать тест.
         */
    }

    /**
     * Метод перевода со счета на счет
     *
     * @param fromAccount исходный счет
     * @param toAccount   целевой счет
     * @param sum         сумма
     */
    //TODO реализовать метод перевода с одного счета на другой
    public static void transferMoney(Account fromAccount, Account toAccount, int sum) {
        /*
        Реализовать метод перевода средств с одного счета на другой.
        Во время перевода выполнить проверку на достаточность средств на счету, откуда перевод.
        Если средств недостаточно, прокинуть исключение WriteOffException с соответствующим описанием.
        Если сумма перевода отрицательная, прокинуть исключение ReplenishException с соответствующим описанием.
         */
    }

}
