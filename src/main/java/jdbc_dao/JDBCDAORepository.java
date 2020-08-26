package jdbc_dao;

import DAO.CategoryRepository;
import DAO.CurrencyRepository;
import DAO.PriceRepository;
import Exeptions.ClassTypeNoMatches;
import domain.Product;
import domain.ProductFactory;
import domain.intefaces.JdbcDAO;
import domain.properties.Category;
import domain.properties.Money;
import domain.properties.curency.Currency;

import java.sql.*;

public class JDBCDAORepository implements JdbcDAO {
    private final String url = "jdbc:postgresql://localhost/ecommerce?user=postgres&password=200633A&ssl=false";


    protected Connection conn;

    public JDBCDAORepository() throws SQLException {

        conn = DriverManager.getConnection(url);
    }


    @Override
    public Object findByID(Class<?> classType, Integer id) throws ClassTypeNoMatches {
        if (classType == Product.class) {
            Product product = null;
            try {

                String select = "Select * from  products where id = " + id;
                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(select);

                if (res.next()) {
                    CategoryRepository cr = new CategoryRepository();
                    Category cat = (Category)cr.findByID(Category.class,res.getInt("category_id"));
                    PriceRepository pr = new PriceRepository();
                    Money money = (Money) pr.findByID(Money.class,res.getInt("id"));
                    product = ProductFactory.getProduct(res.getInt("id"), res.getString("name"), money, res.getInt("qty"), res.getString("manufactured"), cat);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return product;

        } else if (classType == Category.class) {
            Category category = null;

            try {

                String select = "Select * from  categories where id = " + id;
                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(select);

                if (res.next()) {
                    category = new Category(res.getInt("id"), res.getString("name"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return category;

        } else if (classType == Money.class) {
            Money money = null;

            try {

                String select = "Select * from  prices where id = " + id;
                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(select);

                if (res.next()) {
                    CurrencyRepository cr = new CurrencyRepository();
                    Currency currency =(Currency) cr.findByID(Currency.class,res.getInt("id"));
                    money = new Money(res.getString("currency"), res.getFloat("price"));
                    money.setCurrency(currency);


                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return money;
        } else if (classType == Currency.class) {
            Currency currency = null;

            try {

                String select = "Select * from  currencies where id = " + id;
                Statement statement = conn.createStatement();
                ResultSet res = statement.executeQuery(select);

                if (res.next()) {
                    currency = new Currency(res.getInt("id"), res.getString("currency"), res.getInt("amount"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return currency;
        }else
        throw new ClassTypeNoMatches("The class Type doesn't matches");


    }


    @Override
    public void create(Class<?> classType, Object object) throws SQLException, ClassTypeNoMatches {
        String insert = null;
        if (classType == Product.class) {
            Product product = (Product) object;
            insert = "Insert into products (id , name , price,qty,manufactured,category_id ) Values ( " + product.getId() + " , '" + product.getName() + "' , '" + product.getPrice() + "'," + product.getQuantity() + ",'" + product.getManufactured() + "', " + product.getCategory().getId() + " )";
        } else if (classType == Category.class) {
            Category category = (Category) object;
            insert = "Insert into categories (id , name ) Values ( " + category.getId() + " , '" + category.getName() + "' )";
        } else if (classType == Money.class) {
            Money money = (Money) object;
            insert = "Insert into prices (id , currency, price ) Values ( " + money.getId() + " , '" + money.getCurrency() + "' , " + money.getAmount() + " )";
        } else if (classType == Currency.class) {
            Currency currency = (Currency) object;
            insert = "Insert into currencies (id , currency, amount ) Values ( " + currency.getId() + " , '" + currency.getCode() + "' , " + currency.getRate() + " )";
        } else {
            throw new ClassTypeNoMatches("The class Type doesn't matches");
        }

        Statement statement = conn.createStatement();
        statement.executeUpdate(insert);
    }

    @Override
    public void delete(String table, Integer id) throws SQLException {
        String delete = "Delete from " + table + " Where id =  " + id;
        Statement statement = conn.createStatement();
        statement.executeUpdate(delete);
    }

    @Override
    public void update(String table, String columnName, String name, Integer id) throws SQLException {
        String insert = "Update "+ table + " set " + columnName + "  = '" + name + "' where id = " + id;
        Statement statement = conn.createStatement();
        statement.executeUpdate(insert);
    }


    private static class SingletonHolder {
        private static JDBCDAORepository INSTANCE = null;

        static {
            try {
                INSTANCE = new JDBCDAORepository();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static JDBCDAORepository getInstance() {
        return JDBCDAORepository.SingletonHolder.INSTANCE;
    }
}
