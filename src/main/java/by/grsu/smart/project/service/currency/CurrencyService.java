package by.grsu.smart.project.service.currency;

import by.grsu.smart.project.entity.Currency;

import java.util.List;

public interface CurrencyService {

    List<Currency> getCurrencyExchange();

    Currency getUSDCurrencyExchange();

    Currency getEURCurrencyExchange();

    Currency getRUBCurrencyExchange();
}
