import java.io.Serializable;
import java.util.ArrayList;


public class ElementarMachine<T> implements Serializable{

    private ArrayList<Element<T>> listaElements;


    public ElementarMachine() {
        setListaElements(new ArrayList<Element<T>>());
    }



    public ArrayList<Element<T>> getListaElements() {
        return listaElements;
    }


    public void setListaElements(ArrayList<Element<T>> listaElements) {
        this.listaElements = listaElements;
    }

/*
 * 
 * falta função para set count
 */
    public void addThings(int n, T coisa) {

        boolean newthing = true;

        for (int i = 0; i < listaElements.size(); i++) {

            if ((listaElements.get(i).getThing().getClass().equals(coisa.getClass()))
                    && (coisa.getClass().getSimpleName().contains("Perishable"))) {

                if (((Product) listaElements.get(i).getThing()).getName().equals(((Product) coisa).getName())) {

                    listaElements.get(i).setCount((listaElements.get(i).getCount()) + n);
                    newthing = false;
                    break;
                }

            } else if ((listaElements.get(i).getThing().equals(coisa))) {

                listaElements.get(i).setCount((listaElements.get(i).getCount()) + n);
                newthing = false;
                break;
            }
        }
        if (newthing) {
            Element<T> novo = new Element<T>(n, coisa);
            listaElements.add(novo);
        }
    }


    /*
     * 
     * falta fazer função para os if the dentro
     * 
     */
    public boolean removeOneThing(T coisa) {

        for (int i = 0; i < listaElements.size(); i++) {
            if ((listaElements.get(i).getThing().getClass().getSimpleName().contains("Perishable"))&&((Product) listaElements.get(i).getThing()).getName().equals(coisa)){
                    
                if ((listaElements.get(i).getCount()) < 2) {

                    listaElements.remove(i);
                } else {

                    listaElements.get(i).setCount((listaElements.get(i).getCount()) - 1);
                }
                return true;
                

            } else if (listaElements.get(i).getThing().equals(coisa)) {

                if ((listaElements.get(i).getCount()) < 2) {

                    listaElements.remove(i);
                } else {

                    listaElements.get(i).setCount((listaElements.get(i).getCount()) - 1);
                }
                return true;
            }
        }
        return false;
    }


    public void listAll() {
        for (int i = 0; i < listaElements.size(); i++) {
            System.out.println(listaElements.get(i).toString());
        }

    }
}
