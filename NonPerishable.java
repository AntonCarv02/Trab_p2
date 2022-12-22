public class NonPerishable extends Product{
    
    private double volume;

    public NonPerishable(String name, double cost,double volume) {
        
        super(name, cost);
        setVolume(volume);
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    

}