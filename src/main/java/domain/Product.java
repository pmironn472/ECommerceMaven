package domain;

import domain.properties.Category;
import domain.properties.Money;

import java.io.Serializable;


public class Product implements Serializable {

    private Integer id; // unique for products
    private String name;
    private Money price;
    private Integer quantity;
    private Integer expritaionM;
    private Integer expritaionD;
    private String manufactured;
    private Category category;
    private String imagePath;


    Product() {


    }

    public Product(Integer id, String name, Money price, Integer quantity, String manufactured, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufactured = manufactured;
        this.category = category;
    }





    public Product(Integer id, String name) {

        this.id = id;
        this.name = name;
    }

    public Product(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getExpritaion() {
        return expritaionM;
    }

    public void setExpritaion(Integer expritaionM) {
        this.expritaionM = expritaionM;
    }

    public Integer getExpritaionD() {
        return expritaionD;
    }

    public void setExpritaionD(Integer expritaionD) {
        this.expritaionD = expritaionD;
    }

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String toString() {
        return String.format("Product [ Id = %d," +
                        "%n          Name = %s " +
                        "%n          Price = %s," +
                        "%n          Quantity = %d," +
                        "%n          Manufacturer = %s," +
                        "%n          Category = %s " +
                        " ]%n", id, name, price, quantity,
                  manufactured, category);
    }

    private static class SingletonHolder {
        private final static Product INSTANCE = new Product();
    }

    public static Product getInstance() {
        return Product.SingletonHolder.INSTANCE;
    }


}
