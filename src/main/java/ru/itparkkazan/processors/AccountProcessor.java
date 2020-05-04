package ru.itparkkazan.processors;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Account;
import ru.itparkkazan.exceptions.ReplenishException;
import ru.itparkkazan.exceptions.WithdrawalException;

/**
 * Класс, содержащий операции над счетами
 */
@Slf4j
public class AccountProcessor {

    private static void validateReplenisSum(int replenishSum) throws ReplenishException {
        log.info("Валидация суммы пополнения счета");
        if (replenishSum <= 0) {
            log.error("Ошибка при пополнении - сумма пополнения меньше 0");
            throw new ReplenishException("Сумма пополнения счета меньше 0");
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

    private static boolean validateWithdrawalSum(int accountSum, int withdrawalSum) throws WithdrawalException {
        log.info("Валидация суммы списания счета");
        if (withdrawalSum <= 0) {
            log.error("Ошибка при списании - сумма списания меньше 0");
            throw new WithdrawalException("Сумма списания счета меньше 0");
        } else if (accountSum < withdrawalSum) {
            log.error("Ошибка при списании - сумма списания больше суммы на счете");
            throw new WithdrawalException("Сумма списания больше суммы счете");
        }
        return true;
    }

    /**
     * Метод списания со счета
     * @param account
     * @param withdrawaslSum
     * @throws WithdrawalException
     */
    public static void withdrawalAccount(Account account, int withdrawaslSum) throws WithdrawalException {
        log.info(String.join(" ", "Списание счета", String.valueOf(account.getAccountNumber()), "на сумму", String.valueOf(withdrawaslSum)));
        validateWithdrawalSum(account.getSum(), withdrawaslSum);
        account.setSum(account.getSum() - withdrawaslSum);
        log.info(String.join(" ", "Списание счета", String.valueOf(account.getAccountNumber()), "прошло успешно. Текущая сумма на счете", String.valueOf(account.getSum())));
    }

    /**
     * Метод перевода средств
     * @param fromAccount
     * @param toAccount
     * @param transferSum
     * @throws WithdrawalException
     * @throws ReplenishException
     */
    public static void transferMoney(Account fromAccount, Account toAccount, int transferSum) throws WithdrawalException, ReplenishException {
        log.info(String.join(" ",
                "Перевод средств со счета",
                String.valueOf(fromAccount.getAccountNumber()),
                "на счет",
                String.valueOf(toAccount.getAccountNumber()),
                "на сумму",
                String.valueOf(transferSum)));
        withdrawalAccount(fromAccount, transferSum);
        replenishAccount(toAccount, transferSum);
        log.info(String.join(" ",
                "Перевод средств со счета",
                String.valueOf(fromAccount.getAccountNumber()),
                "на счет",
                String.valueOf(toAccount.getAccountNumber()),
                "на сумму",
                String.valueOf(transferSum)),
                "прошел успешно");
    }
}
