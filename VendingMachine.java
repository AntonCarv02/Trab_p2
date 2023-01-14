import java.io.*;
import java.util.*;

public class VendingMachine implements Serializable {
    ProductMachine pm;
    MoneyMachine mm;

    /*
     * Construtor da classe VendingMachine.
     * Ojetivo: Criar uma máquina ProductMachine e uma MoneyMachine.
     */
    public VendingMachine(ProductMachine pm, MoneyMachine mm) {
        setProductMachine(pm);
        setMoneyMachine(mm);
    }

    public ProductMachine getProductMachine() { // Este método retorna a productMachine
        return pm;
    }

    public void setProductMachine(ProductMachine pm) { // Este método insere na variável pm, a productMachine dada pelo
                                                       // utilizador.
        this.pm = pm;
    }

    public MoneyMachine getMoneyMachine() { // Este método retorna a MoneyMachine
        return mm;
    }

    public void setMoneyMachine(MoneyMachine mm) { // Este método insere na variável pm, a MoneyMachine dada pelo
                                                   // utilizador.
        this.mm = mm;
    }

    /*
     * Método saveMachine
     * Este método permite guardar uma VendingMachine num ficheiro pretendido.
     */
    public static void saveMachine(VendingMachine vm, String ficheiro) throws IOException {

        FileOutputStream foutStream = new FileOutputStream(ficheiro); // permite escrever dados binarios para um ficheiro.
        ObjectOutputStream outputStream = new ObjectOutputStream(foutStream); // Permite escrever no ficheiro um arraylist

        try {
            outputStream.writeObject(vm.getProductMachine().getListaElements());
            outputStream.writeObject(vm.getMoneyMachine().getListaElements());
            outputStream.close();
            foutStream.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    public static VendingMachine restoreMachine(String ficheiro) throws IOException, ClassNotFoundException {

        File f = new File(ficheiro);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream objStream = new ObjectInputStream(fis);

        ProductMachine prod = new ProductMachine();
        MoneyMachine mon = new MoneyMachine();


        prod.setListaElements((ArrayList<Element<Product>>) objStream.readObject());
        mon.setListaElements((ArrayList<Element<Float>>) objStream.readObject());

        VendingMachine vm = new VendingMachine(prod, mon);

        fis.close();
        objStream.close();
        return vm;

    }



    public static float buy(VendingMachine vm, String prod, float totalvalue) throws Exception{

        float totalCarteira = totalvalue;
        double custo = 0;
        float troco=0;

        

        for (int i = 0; i < vm.getProductMachine().getListaElements().size(); i++) {
            if (vm.getProductMachine().getListaElements().get(i).getThing().getName().equalsIgnoreCase(prod)) {
                
                custo = vm.getProductMachine().getListaElements().get(i).getThing().getCost();
                
                if (custo > totalCarteira) {
                    
                    throw new Exception("valor insuficiente");
                } else {

                    troco = (float) (totalCarteira-custo);
                    vm.getProductMachine().removeOneThing(vm.getProductMachine().getListaElements().get(i).getThing());
                    return troco;
                }
            }
        }
        throw new Exception("Produto não existe");
    }



    public MoneyMachine calcTroco(float troco) {

        final float Limite = 0.000001f;
        MoneyMachine carteiraTroco = new MoneyMachine();

        int i = 0;
        
        this.getMoneyMachine().getListaElements().sort((element1, element2) -> Double.compare(element1.getThing() ,(element2.getThing())));


        while ( i < this.getMoneyMachine().getListaElements().size()) {
            
            
            if (Math.abs(troco - this.getMoneyMachine().getListaElements().get(i).getThing())< Limite){

                carteiraTroco.addMoney(1, this.getMoneyMachine().getListaElements().get(i).getThing());

                this.getMoneyMachine().removeOneThing(this.getMoneyMachine().getListaElements().get(i).getThing());
                    
                break;

            }else if(((troco/this.getMoneyMachine().getListaElements().get(i).getThing())<1)&&(i>0)){

                carteiraTroco.addMoney(1, this.getMoneyMachine().getListaElements().get(i-1).getThing());
                
                troco %=(this.getMoneyMachine().getListaElements().get(i-1).getThing());
                this.getMoneyMachine().removeOneThing(this.getMoneyMachine().getListaElements().get(i-1).getThing());
                
                i=0;

            }
            i++;

        }
        return carteiraTroco;
    }
}
