
public class ProductMachine extends ElementarMachine<Product>{

    ElementarMachine<Product> listaProd;

    
    public ProductMachine() {
        setListaProd(new ElementarMachine<Product>());
    }


    public ElementarMachine<Product> getListaProd() {
        return listaProd;
    }


    public void setListaProd(ElementarMachine<Product> listaProd) {
        this.listaProd = listaProd;
    }



    public void addProduct(int n, Product p) {
        
        this.listaProd.addThings(n, p);

    }


    public boolean hasProduct(Product p) {
        for (int i = 0; i < this.getListaElements().size(); i++) {

            if (getListaElements().get(i).getThing().getName().equals(p.getName())) {

                return true;
            }
        }
        return false;
    }


    public void listAllOrdered() {
        
        listaProd.getListaElements().sort((element1, element2) -> Double.compare(element1.getThing().getCost() ,(element2.getThing().getCost())));

        listaProd.listAll();

    }
}
