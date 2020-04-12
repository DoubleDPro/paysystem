package ru.itparkkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Account;
import ru.itparkkazan.enums.AccountInfo;
import ru.itparkkazan.exceptions.DataSourceServiceException;
import ru.itparkkazan.exceptions.UnregistredClientException;
import ru.itparkkazan.services.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class AccountDAO implements DAO<Account> {
    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();

    @Override
    public void insert(Account account) {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(AccountQuerier.INSERT_ACCOUNT_INFO)) {
            preparedStatement.setInt(1, account.getAccountNumber());
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
            log.error("Ошибка подключения к БД при попытке вставки записи с данными счета", e);
        } catch (SQLException e) {
            log.error("Ошибка запроса при попытке вставки записи с данными счета " + AccountQuerier.INSERT_ACCOUNT_INFO, e);
        } finally {
            dataSourceService.closeConnection();
        }
    }

    @Override
    public Account get(String firstParam) throws Exception {
        int accountNumber = Integer.valueOf(firstParam);
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(AccountQuerier.SELECT_ACCOUNT_BY_ACCOUNT_NUMBER)) {
            preparedStatement.setInt(1, accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(AccountInfo.ID.getAccountInfo());
                int sum = resultSet.getInt(AccountInfo.SUM.getAccountInfo());
                return new Account(id, accountNumber, sum);
            } else {
                throw new UnregistredClientException("Счет с номером " + accountNumber + " отсутсвует.");
            }
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении данных о счете с номером " + accountNumber, e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса " + AccountQuerier.SELECT_ACCOUNT_BY_ACCOUNT_NUMBER, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }

    @Override
    public Account get(String firstParam, String secondParam) throws Exception {
        return null;
    }

    @Override
    public List<Account> getAll() {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(AccountQuerier.SELECT__ALL_ACCOUNT_NUMBERS)) {
            List<Account> allAccountNumbers = new LinkedList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int accountNumber = resultSet.getInt(AccountInfo.ACCOUNT_NUMBER.getAccountInfo());
                allAccountNumbers.add(new Account(accountNumber));
            }
            return allAccountNumbers;
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении списка всех номеров счетов", e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса " + AccountQuerier.SELECT__ALL_ACCOUNT_NUMBERS, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }
}
