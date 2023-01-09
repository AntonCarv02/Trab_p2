import java.io.*;

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
        

        try (FileOutputStream outStream = new FileOutputStream(ficheiro);
                ObjectOutputStream outputStream = new ObjectOutputStream(outStream);) {
           

            outputStream.close();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    
    }



    public static VendingMachine restoreMachine(String ficheiro) throws IOException, ClassNotFoundException {

        File f = new File(ficheiro);
        FileReader instream = new FileReader(f);
        BufferedReader InputStream = new BufferedReader(instream);



        ProductMachine prod = new ProductMachine();
        
        MoneyMachine mon = new MoneyMachine();


        

        VendingMachine vm = new VendingMachine(prod, mon);

        InputStream.close();
        instream.close();
        return vm;

    }
}
