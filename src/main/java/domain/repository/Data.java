package domain.repository;

import domain.Product;
import domain.intefaces.DataRepository;
import domain.properties.Money;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;



public class Data implements DataRepository {

    private Data() {}

    private String nameFileType(Class<?> classType) {

        String fileName = null;

        if (classType == Product.class)
            fileName = "product";

        else if (classType == Money.class)
            fileName = "money";

        return "C:\\games\\EcommerceMaven\\src\\main\\resources\\" + fileName +".bin" ;

    }

    @Override
    public <T> void save(T entity) {

        try {

            File file = new File(nameFileType(entity.getClass()));
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

            out.writeObject(entity);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T load(Class<?> classType) {

        T entity = null;

        try {
            File file = new File(nameFileType(classType));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

            entity = (T)in.readObject();
            in.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    private static class SingletonHolder {
        private final static Data INSTANCE = new Data();
    }

    public static Data getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
