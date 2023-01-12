import java.io.*;
import java.util.ArrayList;

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

        FileOutputStream foutStream = new FileOutputStream(ficheiro);
        ObjectOutputStream outputStream = new ObjectOutputStream(foutStream); // tas ai?

        try {
            outputStream.writeObject(vm.getProductMachine().getListaElements());
            outputStream.writeObject(vm.getMoneyMachine().getListaElements());
            outputStream.close();
            foutStream.close();

            // System.out.println("here");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

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

    public boolean buy(String prod, MoneyMachine carteira) {

        float totalCarteira = carteira.getTotalValue();
        double custo = 0;

        for (int i = 0; i < this.getProductMachine().getListaElements().size(); i++) {
            if (this.getProductMachine().getListaElements().get(i).getThing().getName().equalsIgnoreCase(prod)) {
                
                custo = this.getProductMachine().getListaElements().get(i).getThing().getCost();
                
                if (custo > totalCarteira) {
                    System.out.println("valor insuficiente");
                    return false;
                
                } else {

                    
                    return this.getProductMachine().removeOneThing(this.getProductMachine().getListaElements().get(i).getThing());
                }
            }
        }
        return false;
    }
}
