package pl.projectE.loaders;

import pl.projectE.model.Currency;

import java.util.SortedMap;
import java.util.TreeMap;

import static pl.projectE.loaders.FileVars.*;
import static pl.projectE.loaders.LoadersUtil.loadInt;
import static pl.projectE.loaders.LoadersUtil.loadLong;

public class CurrencyLoader {
    public static SortedMap<String, Currency> loadCurrencies(String[][] rawData) {
        SortedMap<String, Currency> currencies = new TreeMap<>();
        for (int x = 1; x < rawData[Currencies].length; x++) {
            Currency currency = loadCurrency(rawData, x);
            currencies.put(currency.name, currency);
        }
        return currencies;
    }

    private static Currency loadCurrency(String[][] rawData, int column) {
        Currency currency = new Currency();
        currency.name = rawData[Currencies][column];
        currency.symbol = rawData[CurrenciesSymbol][column];
        currency.cost = loadInt(rawData[CurrenciesCost][column]);
        currency.m0 = loadLong(rawData[CurrenciesM0][column]);
        currency.controller = rawData[CurrenciesController][column];
        return currency;
    }
}
