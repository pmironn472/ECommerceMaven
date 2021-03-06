package DAO;

import Exeptions.ClassTypeNoMatches;
import domain.properties.Money;
import domain.properties.curency.Currency;
import domain.properties.curency.CurrencyProvider;
import jdbc_dao.JDBCDAORepository;

import java.sql.*;

public class CurrencyRepository extends JDBCDAORepository {

    public CurrencyRepository() throws SQLException {
    }

    @Override
    public Object findByID(Class<?> classType, Integer id) throws ClassTypeNoMatches {
        if (classType == Currency.class) {
            return super.findByID(classType, id);
        } else
            throw new ClassTypeNoMatches("The class type doesn't matches ");
    }

    @Override
    public void create(Class<?> classType, Object object) throws SQLException, ClassTypeNoMatches {
        if (classType == Currency.class) {
            super.create(classType, object);
        }else
            throw new ClassTypeNoMatches("The class type doesn't matches");
    }


    @Override
    public void delete(String table, Integer id) throws SQLException {
        super.delete(table, id);
    }

    @Override
    public void update(String table, String columnName, String name, Integer id) throws SQLException {
        super.update(table, columnName, name, id);
    }
}
