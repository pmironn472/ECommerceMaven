package domain;


import com.github.javafaker.Faker;
import domain.properties.Category;
import domain.properties.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ProductFactory {
    static Faker faker = new Faker(new Locale("ru"));
    private static Integer productCount = 0;

    public ProductFactory() {
    }

    public static Product getProductCategory(int id, String name, Category category) {

        return new Product(id, name, category);
    }

    public static Product getProductt(int id, String name) {

        return new Product(id, name);
    }

    public static Product getProduct(Integer id, String name, Money price, int quantyty,String manufactured, Category category) {

        return new Product(id, name, price, quantyty, manufactured,category);
    }


    private static class SingletonHolder {
        private final static ProductFactory INSTANCE = new ProductFactory();
    }

    public static ProductFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

}



