package service;

import currency.Currency;
import repository.CurrencyRepository;

import java.util.List;

/**
 * Created by maxim on 13.05.2021.
 */
public interface CurrencyService{

    Currency save(Currency currency);

    Currency findById(Long id);

    Currency update(Currency currency);

    void deleteById(Long id);

    List<Currency> findAll();


}
