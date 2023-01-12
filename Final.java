
import java.util.*;

public class Final {
    public static void main(String[] args) {
        MoneyMachine wallet = new MoneyMachine();
        ProductMachine pm = new ProductMachine();
        
        pm.addProduct(10, new Perishable("Milk", 10, new Date()));
        pm.addProduct(10, new Perishable("Milk", 10, new Date()));
        pm.addProduct(5, new NonPerishable("Lotion", 12.5, 3.4));
        pm.addProduct(5, new NonPerishable("Shampoo", 5.5, 3.4));
        pm.addProduct(5, new NonPerishable("Game", 7.5, 4.6));
        pm.listAllOrdered();

        Scanner s = new Scanner(System.in);
        
        String in = new String();

        
        System.out.println("Insira o seu dinheiro (Formato: 0.5), \nquando não quiser inserir mais dinheiro escreva '-' : ");
        do {
            
            in = s.nextLine();
            float coin = Float.parseFloat(in);
            
        } while (in.equals("-"));


        MoneyMachine mm = wallet;
        VendingMachine vm = new VendingMachine(pm, mm);

        wallet.listAll();
        s.close();
    }
}
