import java.io.*;


public class VendingMachine implements Serializable{
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
        File f = new File(ficheiro);
        FileOutputStream outStream = new FileOutputStream( f );
        ObjectOutputStream outputStream = new ObjectOutputStream( outStream );
        

        outputStream.write(vm.getProductMachine().getListaElements().size());

        for (int i = 0; i <vm.getProductMachine().getListaElements().size() ; i++) {
            System.out.println((vm.getMoneyMachine().getListaElements().get(i).toString()));
            outputStream.writeObject((vm.getProductMachine().getListaElements()));

        }

        
        
        outputStream.writeInt(vm.getMoneyMachine().getListaElements().size());

        //for (int i = 0; i <vm.getMoneyMachine().getListaElements().size() ; i++) {
           /*
           java.lang.NoSuchFieldException: serialPersistentFields" / serialVersionUID"
           */
           outputStream.writeObject(vm.getMoneyMachine().getListaElements());

        //}

        outStream.close();
        outputStream.close();
    }



    public static VendingMachine restoreMachine(String ficheiro) throws IOException, ClassNotFoundException {
        
        File f = new File(ficheiro);
        FileInputStream InStream = new FileInputStream( f );
        ObjectInputStream InputStream = new ObjectInputStream( InStream );

        
        ProductMachine prod= new ProductMachine();
        
        ElementarMachine<Product> elm = null;
        
        int prodsize = InputStream.readInt();

        //fazer for para input de cada Element
        for (int i = 0; i < prodsize; i++) {
            elm = (ElementarMachine<Product>) InputStream.readObject();
        
        }
        prod.setListaProd(elm);



        MoneyMachine mon = new MoneyMachine();
        ElementarMachine<Float> elm1 = new ElementarMachine<Float>();

        int moneysize = InputStream.readInt();
        for (int i = 0; i < moneysize; i++) {
            elm1.getListaElements().add((Element<Float>) InputStream.readObject());
        
        }
        mon.setListaMoney(elm1);
        

        VendingMachine vm = new VendingMachine(prod, mon);

        InputStream.close();
        return vm;

    }
}
