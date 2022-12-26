
public class MoneyMachine extends ElementarMachine<Float>{
    
    
    ElementarMachine<Float> listaMoney;

    
    public MoneyMachine(ElementarMachine<Float> listaMoney) {
        this.listaMoney = listaMoney;
    }

    public ElementarMachine<Float> getListaMoney() {
        return listaMoney;
    }


    public void setListaMoney(ElementarMachine<Float> listaMoney) {
        this.listaMoney = listaMoney;
    }


    public float getTotalValue(){
        
        return 0;        
    }


    public void addMoney(int n, float money){
        addThings(n, money);
    }


    

}
