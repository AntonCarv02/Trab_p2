public class VendingMachine {
    ProductMachine pm;
    MoneyMachine mm;

    /*
     * Construtor
     */
    public VendingMachine(ProductMachine pm, MoneyMachine mm) {
        this.pm = pm;
        this.mm = mm;
    }


    /*
     * getters e setters
     */
    public ProductMachine getProductMachine() {
        return pm;
    }


    public void setProductMachine(ProductMachine pm) {
        this.pm = pm;
    }


    public MoneyMachine getMoneyMachine() {
        return mm;
    }


    public void setMoneyMachine(MoneyMachine mm) {
        this.mm = mm;
    }


    /*
     * Métodos de Classe
     * 
     * 
     */
    public static void saveMachine(VendingMachine vm, String ficheiro) {


    }



    public static VendingMachine restoreMachine(String ficheiro) {

        return null;

    }
}
