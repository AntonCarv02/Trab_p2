import java.util.Date;

public class test {
    public static void main(String[] args) {

        ElementarMachine<String> sm1 = new ElementarMachine<String>();
        
        try {
            ProductMachine pm = new ProductMachine();
            pm.addProduct(10, new Perishable("Milk", 10, new Date()));
            pm.addProduct(10, new Perishable("Milk", 10, new Date()));
            pm.addProduct(5, new NonPerishable("Lotion", 12.5, 3.4));
            pm.addProduct(5, new NonPerishable("Shampoo", 5.5, 3.4));
            pm.addProduct(5, new NonPerishable("Game", 7.5, 4.6));
            pm.listAllOrdered();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            MoneyMachine mm = new MoneyMachine();
            mm.addThings(10, 2.0f);
            mm.addThings(10, 0.5f);
            mm.addThings(10, 1f);
            mm.addThings(10, 0.5f);
            mm.listAll();
            System.out.println("Ordered");
            System.out.println(mm.getTotalValue());
        } catch (Exception e) {
            
            System.out.println("Exception");
        }


        try {
            MoneyMachine mm1 = new MoneyMachine();
            mm1.addMoney(10, 0.5f);
            mm1.addMoney(10, 1.0f);
            mm1.addMoney(10, 0.1f);
        
            ProductMachine pm1 = new ProductMachine();
            pm1.addProduct(5, new NonPerishable("Lotion", 2.55, 3.4));
        
            VendingMachine vm1 = new VendingMachine(pm1, mm1);
        
            VendingMachine.saveMachine(vm1, "file.dat");
        
            vm1.getMoneyMachine().addMoney(10, 2f);
        
            System.out.println("Money machine of vending machine 1: listaAll");
            vm1.getMoneyMachine().listAll();
        
            VendingMachine vm2 = VendingMachine.restoreMachine("file.dat");
        
            System.out.println("Money machine of vending machine 1: listaAll");
            vm2.getMoneyMachine().listAll();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
