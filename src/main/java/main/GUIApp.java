package main;


import DAO.PriceRepository;
import DAO.ProductRepository;
import Exeptions.ClassTypeNoMatches;
import domain.Product;
import domain.ProductFactory;
import domain.properties.Category;
import domain.properties.Money;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jdbc_dao.JDBCDAORepository;


import java.sql.*;


public class GUIApp extends Application {


    public static VBox showProduct;
    private static VBox addProduct;

    private static Stage primaryStage;

    public static void main(String[] args) throws SQLException, ClassTypeNoMatches {

        //        launch();

        Product product = ProductFactory.getProduct(3, "OLOLO", new Money("EUR", 25f).toCurrency("RUB"), 5, "MD", new Category(2));

        JDBCDAORepository jdbcdaoRepository = JDBCDAORepository.getInstance();
        ProductRepository pr = new ProductRepository();
        PriceRepository price =new PriceRepository();


        System.out.println(pr.findByID(Money.class,1));
        System.out.println(pr.findByCategory(1));
        System.out.println(pr.findAllByCategory(1));


    }


    @Override
    public void start(Stage stage) throws Exception {

        GUIApp.primaryStage = stage;

        addProduct = FXMLLoader.load(getClass().getResource("/product-add.fxml"));
        showProduct = FXMLLoader.load(getClass().getResource("/product-full.fxml"));
        switchScene(addProduct);
        stage.show();
    }

    public static void switchScene(VBox tempalte) {
        Scene scene = new Scene(tempalte);
        primaryStage.setScene(scene);

    }
}
