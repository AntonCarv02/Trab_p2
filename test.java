import java.util.Date;
import java.text.SimpleDateFormat;

public class test {
    public static void main(String[] args) {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            Date d1 = sdformat.parse("2022-12-13");
            Perishable p1 = new Perishable("Fruit", 12, d1);
            System.out.println(p1.isOutDated());
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
