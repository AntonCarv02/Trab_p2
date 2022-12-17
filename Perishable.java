public class Perishable extends Product implements Freshness {

    private int limitDate;

    @Override
    public boolean isOutDated() {

        return false;
    }

    @Override
    public boolean isFromToday() {

        return false;
    }
    
}
