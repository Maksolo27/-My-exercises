package repository;

import currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by maxim on 13.05.2021.
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long>, CrudRepository<Currency, Long> {

    List<Currency>
}
