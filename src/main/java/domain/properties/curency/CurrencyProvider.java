package domain.properties.curency;


import java.util.HashMap;
import java.util.Map;

public class CurrencyProvider {


    private Map<String, Currency> currencies = new HashMap<>() {{
        put("EUR", Currency.baseCurrency);
        put("USD", new Currency(1,"USD", 16.97));
        put("MDL", new Currency(2,"MDL", 19.63));
        put("RUB", new Currency(3,"RUB", 81.96));
        put("RON", new Currency(4,"RON", 4.84));
    }};

    public CurrencyProvider() {
    }


    public Currency getCurrency(String code) {
        return currencies.get(code);
    }


    private static class SingletonHolder {
        private static final CurrencyProvider INSTANCE = new CurrencyProvider();
    }

    public static CurrencyProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
