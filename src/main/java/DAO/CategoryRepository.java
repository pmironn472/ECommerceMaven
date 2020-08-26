package DAO;

import Exeptions.ClassTypeNoMatches;
import domain.Product;
import domain.ProductFactory;
import domain.properties.Category;
import domain.properties.curency.Currency;
import jdbc_dao.JDBCDAORepository;

import java.sql.*;

public class CategoryRepository extends JDBCDAORepository {

    public CategoryRepository() throws SQLException {
    }

    @Override
    public Object findByID(Class<?> classType, Integer id) throws ClassTypeNoMatches {
        if (classType == Category.class) {
            return super.findByID(classType, id);
        } else
            throw new ClassTypeNoMatches("The class type doesn't matches ");
    }

    @Override
    public void create(Class<?> classType, Object object) throws SQLException, ClassTypeNoMatches {
        if (classType == Category.class) {
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
