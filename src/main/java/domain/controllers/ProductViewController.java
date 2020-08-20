package domain.controllers;


import domain.Product;

import domain.repository.Data;
import javafx.fxml.FXML;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


import java.io.File;

public class ProductViewController {

    Product product;

    @FXML
    private Text productName;

    @FXML
    private ImageView productIamge;


    public void showProduct() {
        product= Data.getInstance().load(Product.class);
        productName.setText(product.getName());
        File image = new File("src/main/resources/iamges/product1.png");
        productIamge.setImage(new Image(image.toURI().toString()));


    }
}


