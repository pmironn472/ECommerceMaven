package domain.intefaces;

import Exeptions.ClassTypeNoMatches;

import java.sql.SQLException;

public interface JdbcDAO {


    Object findByID(Class<?> classType, Integer id) throws ClassTypeNoMatches;

    void create(Class<?> classType,Object object) throws SQLException, ClassTypeNoMatches;

    void delete(String table, Integer id) throws SQLException;

    void update(String table,String columnName,String name ,Integer id ) throws SQLException;


}
