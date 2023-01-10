import java.io.*;
import java.util.ArrayList;

public class VendingMachine implements Serializable {
    ProductMachine pm;
    MoneyMachine mm;

    /*
     * Construtor
     */
    public VendingMachine(ProductMachine pm, MoneyMachine mm) {
        setProductMachine(pm);
        setMoneyMachine(mm);
    }

    /*
     * getters e setters
     */
    public ProductMachine getProductMachine() {// Este método retorna o
        return pm;
    }

    public void setProductMachine(ProductMachine pm) {
        this.pm = pm;
    }

    public MoneyMachine getMoneyMachine() {// Este método retorna o
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
    public static void saveMachine(VendingMachine vm, String ficheiro) throws IOException {
        
        FileOutputStream foutStream = new FileOutputStream(ficheiro);
        ObjectOutputStream outputStream = new ObjectOutputStream(foutStream);

        try  {
            outputStream.writeObject(vm.getProductMachine().getListaElements());
            outputStream.writeObject(vm.getMoneyMachine().getListaElements());
            outputStream.close();
            foutStream.close();

        } catch (IOException e) {
            e.printStackTrace();
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



    public void buy(String prod){
    for (int i = 0; i < pm.getListaElements().size(); i++) {
        
        if(pm.getListaElements().get(i).getThing().getName().equalsIgnoreCase(prod)){
            boolean removed = (pm.removeOneThing(pm.getListaElements().get(i).getThing()));
        }
    
    }
}
}
