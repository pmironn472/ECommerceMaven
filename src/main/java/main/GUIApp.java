package main;


import com.github.javafaker.Faker;
import domain.Product;
import domain.ProductFactory;
import domain.properties.Category;
import domain.properties.Money;
import domain.repository.Data;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;


public class GUIApp extends Application {
    public static void main(String[] args) {

        Product product = ProductFactory.getProduct("Women T-shirt", new Money("USD", 100f), 2, new Faker().number().numberBetween(1, 12), new Faker().number().numberBetween(1, 30), "Moldova", new Category("Boks"), "/resources/iamges/product1.png");

        Product fakeProduct = ProductFactory.getFakeProduct();
//        product.setPrice(product.getPrice().toCurrency("MDL"));
//        Cart.getInstance().add(product);
//        Cart.getInstance().add(fakeProduct);
//        Cart.getInstance().findById(2).setPrice(new Money("USD",276f));
//        Cart.getInstance().update(1,3);
//        Cart.getInstance().findAll().forEach(System.out::println);
//        System.out.println(Cart.getInstance().getTotal());

        Data.getInstance().save(product);
        product = Data.getInstance().load(Product.class);
        System.out.println(product);

        Money money = Money.getInstance().getMoney(1000);
        Data.getInstance().save(money);
        money = Data.getInstance().load(Money.class);
        System.out.println(money);

        launch();


//        mvn clean javafx:run


    }


    @Override
    public void start(Stage stage) throws Exception {

        VBox box = FXMLLoader.load(getClass().getResource("/product-full.fxml"));
        stage.setScene(new Scene(box));
        stage.show();
    }
}
