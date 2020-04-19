package ru.itparkkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.PayData;
import ru.itparkkazan.exceptions.DataSourceServiceException;
import ru.itparkkazan.services.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Класс доступа к данным БД для оплат
 */
@Slf4j
public class PayDataDAO implements DAO<PayData> {
    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();

    /**
     * Метод для вставки в БД информации об оплате
     * @param payData
     */
    @Override
    public void insert(PayData payData) {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(PayDataQuerier.INSERT_INTO_PAY_DATA_VALUES)){
            preparedStatement.setInt(1, payData.getClient().getId() );
            preparedStatement.setString(2, payData.getTargetAccount());
            preparedStatement.setInt(3, payData.getSum());
            preparedStatement.setTimestamp(4, new Timestamp(payData.getDate().getTime()));
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
            log.error("Ошибка подключения к БД при попытке вставки записи с данными оплаты", e);
        } catch (SQLException e) {
            log.error("Ошибка запроса при попытке вставки записи с данными оплаты " + PayDataQuerier.INSERT_INTO_PAY_DATA_VALUES, e);
        } finally {
            dataSourceService.closeConnection();
        }
    }
}
