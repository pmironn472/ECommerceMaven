package domain.properties.curency;

import java.io.Serializable;

public class Currency implements Serializable {


    public static Currency baseCurrency = new Currency(
            0,
            "EUR",
            1.00
    );

    private String code;
    private double rate;
    private Integer id;

    public Currency() {
    }

    public Currency(Integer id, String code, double rate) {
        this.id = id;
        this.code = code;
        this.rate = rate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return code + " " + rate;
    }
}

