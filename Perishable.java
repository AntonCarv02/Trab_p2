import java.util.Date;

public class Perishable extends Product implements Freshness {

    private Date limitDate;

    
    public Perishable(String name, double cost,Date limitDate) {
        super(name, cost);
        setLimitDate(limitDate);
    }
    

    public Date getLimitDate() {
        return limitDate;
    }


    public void setLimitDate(Date limitDate) {

        this.limitDate = limitDate;
    }


    @Override
    public boolean isOutDated() {
        
        Date today = new Date(System.currentTimeMillis());
        return this.limitDate.before(today);
        
    }

    @Override
    public boolean isFromToday() {
        Date today = new Date(System.currentTimeMillis());
        return this.limitDate.equals(today);
        
    }

    
    
}
