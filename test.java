public class test {
    public static void main(String[] args) {
        int [] arr ={21,12,2022};
        
        Perishable food = new Perishable("sandes",3.99, arr);
        Product chocolate = new NonPerishable("twix", 1, 0);

        if(food.isFromToday()){
            System.out.println("sim\n");
            System.out.println(chocolate.getClass());
        }
    }
}
