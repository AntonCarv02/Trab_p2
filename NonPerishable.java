public class NonPerishable extends Product{
    
    private int volume;

    public NonPerishable(String name, double cost,int volume) {
        
        super(name, cost);
        setVolume(volume);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    

}