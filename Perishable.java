import java.util.Date;

public class Perishable extends Product implements Freshness {

    private Date limitDate;

    public Perishable(int limitDate) {
        setLimitDate(limitDate);
    }
    
    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(int limitDate) {
        Date lDate = new ();
        this.limitDate = lDate;
    }


    @Override
    public boolean isOutDated() {

        return false;
    }

    @Override
    public boolean isFromToday() {

        return false;
    }

    
    
}
