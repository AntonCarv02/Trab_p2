import java.io.*;
import java.util.ArrayList;


public class VendingMachine {
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
    public static void saveMachine(VendingMachine vm, String ficheiro) throws IOException {

        
        FileOutputStream outStream = new FileOutputStream( ficheiro );
        ObjectOutputStream outputStream = new ObjectOutputStream( outStream );
        
        outputStream.writeObject(vm.getProductMachine().getListaElements());
        outputStream.writeObject(vm.getMoneyMachine().getListaElements());
        outStream.close();
    }



    public static VendingMachine restoreMachine(String ficheiro) throws IOException, ClassNotFoundException {
        
        FileInputStream InStream = new FileInputStream( ficheiro );
        ObjectInputStream InputStream = new ObjectInputStream( InStream );


        ProductMachine pm= new ProductMachine();/*
        ElementarMachine<Product> elm = new ElementarMachine<Product>();

        elm.setListaElements((ArrayList<Element<Product>>) InputStream.readObject());
        pm.setListaProd(elm);
*/

        MoneyMachine mm = new MoneyMachine();
        ElementarMachine<Float> elm1 = new ElementarMachine<Float>();

        elm1.setListaElements((ArrayList<Element<Float>>) InputStream.readObject());
        mm.setListaMoney(elm1);
        

        VendingMachine vm = new VendingMachine(pm, mm);

        InputStream.close();
        return vm;

    }
}
