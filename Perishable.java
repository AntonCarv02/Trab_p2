import java.time.*;

public class Perishable extends Product implements Freshness {

    private LocalDate limitDate;

    
    public Perishable(String name, double cost,int[] limitDate) {
        super(name, cost);
        setLimitDate(limitDate);
    }
    

    public LocalDate getLimitDate() {
        return limitDate;
    }


    public void setLimitDate(int [] limitDate) {

        LocalDate lDate = LocalDate.of(limitDate[2], limitDate[1], limitDate[0]);
        
        this.limitDate = lDate;
    }


    @Override
    public boolean isOutDated() {
        return this.limitDate.isBefore(LocalDate.now());
        
    }

    @Override
    public boolean isFromToday() {
        return this.limitDate.isEqual(LocalDate.now());
        
    }

    
    
}
