
public class MoneyMachine extends ElementarMachine<Float> {
    
    private ElementarMachine<Float> listaMoney; // Variável listaMoney : Guarda os tipos das moeda (0.20, 0.50 etc).

    
    public MoneyMachine() {
        setListaMoney(new ElementarMachine<Float>());
    }

    public ElementarMachine<Float> getListaMoney() {
        return listaMoney;
    }


    public void setListaMoney(ElementarMachine<Float> listaMoney) {
        this.listaMoney = listaMoney;
    }

    // Este método retorna o total do valor presente na máquina.
    public float getTotalValue(){
        int amount=0; 
        float res=0, coin=0;

        // Percorre a lista retornada pelo método getListaElements().
        for (int i = 0; i < getListaElements().size(); i++) {
            amount = getListaElements().get(i).getCount(); // Quantidade das moedas que estão na máquina.
            coin =  getListaElements().get(i).getThing(); // O respetivo tipo da moeda.
            res += (amount*coin); // Multiplica as moedas pelo valor da moeda.
        }
        return res; // total do valor presente na máquina.
    }

    // Este método retorna o total do valor presente na máquina.
    public void addMoney(int n, float money){
        addThings(n, money);
    }
}
