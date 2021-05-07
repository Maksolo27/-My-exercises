package data;

import currency.CurrencyTransaction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by maxim on 07.05.2021.
 */
@Component
public class OldCalcs {

    private final Map<UUID, CurrencyTransaction> transactionMap = new HashMap<>();

    public List<CurrencyTransaction> getAll(){
        ArrayList<CurrencyTransaction> noteList = new ArrayList<>(transactionMap.values());
        noteList.sort(CurrencyTransaction::compareTo);
        return noteList;
    }

    public void add(CurrencyTransaction transaction) {
        transaction.setId(UUID.randomUUID());
        transaction.setCreatedOn(LocalDateTime.now());
        transactionMap.put(transaction.getId(), transaction);
    }

}
