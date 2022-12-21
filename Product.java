public abstract class Product {

    protected String name;
    protected double cost;
        
    
    protected Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    

}

