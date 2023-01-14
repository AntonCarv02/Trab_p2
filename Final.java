
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
        float coin = 0;



        
        System.out.println("Insira o seu dinheiro (Formato: 0.5), \nquando não quiser inserir mais dinheiro escreva '-' : ");
        do {   
        
        coin = s.nextFloat();
        
        }while(MoneyMachine.verifyInput(wallet,coin));
        
        wallet.listAll();



        System.out.println("Nome do produto:");
        in = s.next();
        s.close();



        MoneyMachine mm = new MoneyMachine();
        for (int i = 0; i < wallet.getListaElements().size(); i++) {
            mm.addMoney(wallet.getListaElements().get(i).getCount(), wallet.getListaElements().get(i).getThing());
        }
        mm.addMoney(10, 0.1f);
        mm.addMoney(10, 0.5f);
        mm.addMoney(10, 1.0f);
        
        VendingMachine vm = new VendingMachine(pm, mm);
        


        try {
            float troco = VendingMachine.buy(vm, in, wallet.getTotalValue());

            wallet = vm.calcTroco(troco);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        
        System.out.println("\nTroco");
        wallet.listAll();

        System.out.println("\n");
        pm.listAllOrdered();
    }
}
