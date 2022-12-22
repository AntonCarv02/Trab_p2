import java.util.ArrayList;

public class ElementarMachine<T> {

    private ArrayList<Element<T>> listaElements;

    public ElementarMachine() {
        listaElements = new ArrayList<Element<T>>();
    }

    public void addThings(int n, T coisa) {
        for (int i = 0; i < listaElements.size(); i++) {

        }
    }

    public boolean removeOneThing(T coisa) {
        for (int i = 0; i < listaElements.size(); i++) {

        }

        return false;
    }

    public void listAll() {
        for (int i = 0; i < listaElements.size(); i++) {
            System.out.println(listaElements.get(i));
        }

    }

}
