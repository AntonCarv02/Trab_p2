import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {

        Perishable p2 = new Perishable("Bread", 12, new Date());
        System.out.println(p2.isFromToday());


        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sdformat.parse("2022-12-13");
            Perishable p1 = new Perishable("Fruit", 12, d1);
            System.out.println(p1.isOutDated());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        NonPerishable np = new NonPerishable("Lotion", 1.2, 1.3);
        System.out.println(np.getVolume());

        /*/
        ElementarMachine<String> sm1 = new ElementarMachine<String>();
        sm1.addThings(10, "foo");
        sm1.addThings(10, "bar");
        sm1.addThings(10, "foo");
        sm1.removeOneThing("foo");
        sm1.listAll();


        /*
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
        /*
         * Element [NonPerishable=Product [name=Shampoo, cost=5.5], count = 5]
         * Element [NonPerishable=Product [name=Game, cost=7.5], count = 5]
         * Element [Perishable=Product [name=Milk, cost=10.0], count = 20]
         * Element [NonPerishable=Product [name=Lotion, cost=12.5], count = 5]
         *



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
        } /*
           * Element [Float=2.0, count = 10]
           * Element [Float=0.5, count = 20]
           * Element [Float=1.0, count = 10]
           * Ordered
           * 40.0
           *



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

        }/*
         * Money machine of vending machine 1: listaAll
         * Element [Float=0.5, count = 10]
         * Element [Float=1.0, count = 10]
         * Element [Float=0.1, count = 10]
         * Element [Float=2.0, count = 10]
         * Money machine of vending machine 1: listaAll
         * Element [Float=0.5, count = 10]
         * Element [Float=1.0, count = 10]
         * Element [Float=0.1, count = 10]
         */
    }
}
