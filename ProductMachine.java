
public class ProductMachine extends ElementarMachine<Product> {

    ElementarMachine<Product> listaProd = new ElementarMachine<Product>();

    public void addProduct(int n, Product p) {
        this.listaProd.addThings(n, p);
        

    }


    public boolean hasProduct(Product p) {
        for (int i = 0; i < this.getListaElements().size(); i++) {

            if (this.getListaElements().get(i).getThing().getName().equals(p.getName())) {

                return true;
            }
        }
        return false;
    }

    public void listAllOrdered() {
        ElementarMachine<Product> elements = new ElementarMachine<Product>();

        elements.setListaElements(listaProd.getListaElements());
        elements.getListaElements().sort((element1, element2) -> Double.compare(element1.getThing().getCost() ,(element2.getThing().getCost())));

        elements.listAll();

    }

}
