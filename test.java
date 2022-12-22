

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

        
    }
}
