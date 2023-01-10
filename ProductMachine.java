
public class ProductMachine extends ElementarMachine<Product> {

    private ElementarMachine<Product> listaProd;

    
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
        for (int i = 0; i < listaProd.getListaElements().size(); i++) {

            if (listaProd.getListaElements().get(i).getThing().getName().equals(p.getName())) {

                return true;
            }
        }
        return false;
    }

    ///no other way
    public void listAllOrdered() {
        //ou aprendes ou ves outra maneira -- sort
        listaProd.getListaElements().sort((element1, element2) -> Double.compare(element1.getThing().getCost() ,(element2.getThing().getCost())));

        for (int i = 0; i < listaProd.getListaElements().size(); i++) {
            System.out.println("Element ["+ listaProd.getListaElements().get(i).getThing().getClass().getSimpleName() + " = Product [name=" + 
            listaProd.getListaElements().get(i).getThing().getName()+ ", cost=" +listaProd.getListaElements().get(i).getThing().getCost() + "], count = " + listaProd.getListaElements().get(i).getCount() + "]");
        }
    }
}
