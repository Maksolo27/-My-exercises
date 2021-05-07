package currency;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by maxim on 07.05.2021.
 */
@Getter
@Setter
@NoArgsConstructor
public class CurrencyTransaction implements Comparable<CurrencyTransaction> {

    private UUID id;
    @NonNull
    private int sumIn;
    @NonNull
    private int sumOut;
    private LocalDateTime createdOn;

    public CurrencyTransaction(int sumIn, int sumOut){
        this.sumIn = sumIn;
        this.sumOut = sumOut;
    }

    @Override
    public int compareTo(CurrencyTransaction o) {
        return o.createdOn.compareTo(this.createdOn);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getSumIn() {
        return sumIn;
    }

    public void setSumIn(int sumIn) {
        this.sumIn = sumIn;
    }

    public int getSumOut() {
        return sumOut;
    }

    public void setSumOut(int sumOut) {
        this.sumOut = sumOut;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }


}
