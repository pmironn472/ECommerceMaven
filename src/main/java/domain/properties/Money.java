package domain.properties;

import domain.properties.curency.Currency;
import domain.properties.curency.CurrencyProvider;
import domain.repository.Data;

import java.io.Serializable;

public class Money implements Serializable {

    private static CurrencyProvider currencyProvider = CurrencyProvider.getInstance();


    private Currency currencyCode;
    private Float amount;
    private Integer id;


    public Money() {
    }

    public Money(Float amount) {
        this.amount = amount;
        this.currencyCode = Currency.baseCurrency;
    }


    public Money(Integer id, String currencyCode, Float amount) {
        this.id = id;
        this.currencyCode = currencyProvider.getCurrency(currencyCode);
        this.amount = amount;
    }

    public Money(String currencyCode, Float amount) {
        this.currencyCode = currencyProvider.getCurrency(currencyCode);
        this.amount = amount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currencyCode;
    }

    public void setCurrency(Currency currency) {
        this.currencyCode = currency;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }


    public Money toCurrency(String currency) {


        Currency currency1 = currencyProvider.getCurrency(currency);

        if (currencyCode.getCode().equals("EUR"))
            return new Money(currency1.getId(), currency1.getCode(), amount * (float) currency1.getRate());
        else
            return new Money(currency1.getId(), currency1.getCode(), amount * (float) currency1.getRate());


    }

    public Money getMoney(float amount) {

        return new Money(amount);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currencyCode.getCode());
    }

    private static class SingletonHolder {
        private final static Money INSTANCE = new Money();
    }

    public static Money getInstance() {
        return Money.SingletonHolder.INSTANCE;
    }

}
