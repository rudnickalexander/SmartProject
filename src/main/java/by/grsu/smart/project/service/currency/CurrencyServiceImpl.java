package by.grsu.smart.project.service.currency;

import by.grsu.smart.project.entity.Currency;
import by.grsu.smart.project.parser.CurrencyDomParser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final static Logger logger = Logger.getLogger(CurrencyServiceImpl.class);
    private final static String URL = "http://www.nbrb.by/Services/XmlExRates.aspx?ondate=";

    @Autowired
    private CurrencyDomParser currencyDomParser;

    @Override
    public List<Currency> getCurrencyExchange() {
        logger.info("Start getting currency exchange");

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = sdf.format(new Date());

        return currencyDomParser.parse(URL + formattedDate);
    }

    @Override
    public Currency getUSDCurrencyExchange() {
        return getCustomCurrencyExchange("USD");
    }

    @Override
    public Currency getEURCurrencyExchange() {
        return getCustomCurrencyExchange("EUR");
    }

    @Override
    public Currency getRUBCurrencyExchange() {
        return getCustomCurrencyExchange("RUB");
    }

    private Currency getCustomCurrencyExchange(String code) {
        List<Currency> currencies = getCurrencyExchange();

        for (Currency currency : currencies) {
            if (currency.getCharCode().equals(code)) {
                return currency;
            }
        }

        return null;
    }
}
