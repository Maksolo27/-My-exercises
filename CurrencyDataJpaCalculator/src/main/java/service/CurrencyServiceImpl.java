package service;

import currency.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CurrencyRepository;

import java.util.List;

/**
 * Created by maxim on 13.05.2021.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public Currency save(Currency currency) {
        return currencyRepository.saveAndFlush(currency);
    }

    @Override
    public Currency findById(Long id) {
        return currencyRepository.getOne(id);
    }

    @Override
    public Currency update(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public void deleteById(Long id) {
        currencyRepository.deleteById(id);
    }

    @Override
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }


}
