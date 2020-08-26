package DAO;


import Exeptions.ClassTypeNoMatches;
import domain.Product;
import domain.ProductFactory;
import domain.properties.Category;
import domain.properties.Money;
import domain.properties.curency.Currency;
import jdbc_dao.JDBCDAORepository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository extends JDBCDAORepository {


    public ProductRepository() throws SQLException {
        super();

    }


    @Override
    public Object findByID(Class<?> classType, Integer id) throws ClassTypeNoMatches {
        if (classType == Product.class) {
            return super.findByID(classType, id);
        } else
            throw new ClassTypeNoMatches("The class type doesn't matches ");
    }

    @Override
    public void create(Class<?> classType, Object object) throws SQLException, ClassTypeNoMatches {
        if (classType == Product.class) {
            super.create(classType, object);
        } else
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

    public Product findByCategory(Integer id) {

        Product product = null;
        try {

            String select = "Select * from  products where category_id = " + id;
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(select);

            if (res.next()) {
                CategoryRepository cr = new CategoryRepository();
                Category cat = (Category) cr.findByID(Category.class, res.getInt("category_id"));
                PriceRepository pr = new PriceRepository();
                Money money = (Money) pr.findByID(Money.class, res.getInt("id"));
                product = ProductFactory.getProduct(res.getInt("id"), res.getString("name"), money, res.getInt("qty"), res.getString("manufactured"), cat);

            }
        } catch (SQLException | ClassTypeNoMatches e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> findAllByCategory(Integer id) {

        List<Product> product = new ArrayList<>();
        try {

            String select = "Select * from  products where category_id = " + id;
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(select);

            while (res.next()) {
                CategoryRepository cr = new CategoryRepository();
                Category cat = (Category) cr.findByID(Category.class, res.getInt("category_id"));
                PriceRepository pr = new PriceRepository();
                Money money = (Money) pr.findByID(Money.class, res.getInt("id"));
                product.add(ProductFactory.getProduct(res.getInt("id"), res.getString("name"), money, res.getInt("qty"), res.getString("manufactured"), cat));

            }
        } catch (SQLException | ClassTypeNoMatches e) {
            e.printStackTrace();
        }
        return product;
    }
}