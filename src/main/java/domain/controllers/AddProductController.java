package domain.controllers;

import domain.Product;
import domain.ProductFactory;
import domain.properties.Category;
import domain.properties.Money;
import domain.repository.Data;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.GUIApp;

import java.util.ArrayList;
import java.util.List;

public class AddProductController {

    Product product = Product.getInstance();
    List<Product> productList = new ArrayList<>();


    @FXML
    private TextField productName;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField productQty;

    @FXML
    private TextField expritaionM;

    @FXML
    private TextField expritaionD;

    @FXML
    private TextField manufactured;


    @FXML
    private TextField category;

    @FXML
    private TextField currency;


    public void addProduct() {

        product = ProductFactory.getProducts(productName.getText(), new Money(currency.getText(), Float.valueOf(productPrice.getText())), Integer.parseInt(productQty.getText()), Integer.valueOf(expritaionM.getText()), Integer.valueOf(expritaionD.getText()), manufactured.getText(), new Category(category.getText()));

        Data.getInstance().save(product);
        System.out.println("Product was added");

        GUIApp.switchScene(GUIApp.showProduct);
    }
}
