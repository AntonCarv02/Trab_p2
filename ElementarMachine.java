import java.util.ArrayList;


public class ElementarMachine<T> {

    private ArrayList<Element<T>> listaElements;

    public ElementarMachine() {
        listaElements = new ArrayList<Element<T>>();
    }

    public void addThings(int n, T coisa) {
        
        boolean newthing = true;


        for (int i = 0; i < listaElements.size(); i++) {
            
                if(listaElements.get(i).getThing().equals(coisa)){

                    listaElements.get(i).setCount( (listaElements.get(i).getCount()) + n);
                    newthing = false;
                    break;
                }
        }


        if(newthing){
            Element<T> novo = new Element<T>(n, coisa);
            listaElements.add(novo);
        }
    }


    public boolean removeOneThing(T coisa) {
        
        for (int i = 0; i < listaElements.size(); i++) {   
            
            if(listaElements.get(i).getThing().equals(coisa)){
                
                if((listaElements.get(i).getCount()) < 2){
                    
                    listaElements.remove(i);
                }else{

                    listaElements.get(i).setCount( (listaElements.get(i).getCount()) - 1);
                }
                return true;
            }

        }

        return false;
    }

    public void listAll() {
        for (int i = 0; i < listaElements.size(); i++) {
            System.out.println(listaElements.get(i));
        }

    }

}
