package main;


import com.github.javafaker.Faker;
import domain.Product;
import domain.ProductFactory;
import domain.repository.Cart;
import domain.properties.Category;
import domain.properties.Money;
import domain.repository.Data;


public class Application {
    public static void main(String[] args) {

        Product product = ProductFactory.getProduct("Java SE 1",new Money("USD",100f),2,new Faker().number().numberBetween(1,12),new Faker().number().numberBetween(1,30),"Moldova",new Category("Boks"));

        Product fakeProduct = ProductFactory.getFakeProduct();





//        product.setPrice(product.getPrice().toCurrency("MDL"));
//        Cart.getInstance().add(product);
//        Cart.getInstance().add(fakeProduct);
//        Cart.getInstance().findById(2).setPrice(new Money("USD",276f));
//        Cart.getInstance().update(1,3);
//        Cart.getInstance().findAll().forEach(System.out::println);
//        System.out.println(Cart.getInstance().getTotal());

        Data.getInstance().save(product);
        product =  Data.getInstance().load(Product.class);
        System.out.println(product);

        Money money = Money.getInstance().getMoney(1000);
        Data.getInstance().save(money);
        money = Data.getInstance().load(Money.class);
        System.out.println(money);










    }


}
