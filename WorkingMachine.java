import java.util.Date;
import java.util.Scanner;

public class WorkingMachine {
    public static void main(String[] args) {
        MoneyMachine wallet = new MoneyMachine();
        ProductMachine pm = new ProductMachine();
        MoneyMachine mm = new MoneyMachine();
        VendingMachine vm = new VendingMachine(pm, mm);

        pm.addProduct(10, new Perishable("Milk", 10, new Date()));
        pm.addProduct(10, new Perishable("Milk", 10, new Date()));
        pm.addProduct(5, new NonPerishable("Lotion", 12.5, 3.4));
        pm.addProduct(5, new NonPerishable("Shampoo", 5.5, 3.4));
        pm.addProduct(5, new NonPerishable("Game", 7.5, 4.6));
        pm.listAllOrdered();
        
        Scanner s = new Scanner(System.in);

        System.out.println("Insira o seu dinheiro: ");
        double coin = s.nextDouble();
        wallet.addMoney(1, (float)coin);


        wallet.listAll();
        s.close();
    }
}
