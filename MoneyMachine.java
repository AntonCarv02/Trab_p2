
public class MoneyMachine extends ElementarMachine<Float> {
    
    
    private ElementarMachine<Float> listaMoney;

    
    public MoneyMachine() {
        setListaMoney(new ElementarMachine<Float>());
    }

    public ElementarMachine<Float> getListaMoney() {
        return listaMoney;
    }


    public void setListaMoney(ElementarMachine<Float> listaMoney) {
        this.listaMoney = listaMoney;
    }


    public float getTotalValue(){
        int amount=0;
        float res=0, coin=0;

        for (int i = 0; i < getListaElements().size(); i++) {
            amount = getListaElements().get(i).getCount();
            coin =  getListaElements().get(i).getThing();
            res += (amount*coin);
        }
        return res;        
    }


    public void addMoney(int n, float money){
        addThings(n, money);
    }


    

}
