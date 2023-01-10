
import java.util.ArrayList;


public class ElementarMachine<T> {

    protected ArrayList<Element<T>> listaElements; // Variável listaElements: guarda os valores dos elementos. 

    /*
    * Construtor da classe ElementarMachine<T>.
    *  
    */
    public ElementarMachine() {
        setListaElements(new ArrayList<Element<T>>());
    }

    // Este método retorna a lista dos elementos.
    public ArrayList<Element<T>> getListaElements() {
        return listaElements;
    }

    // Este método insere na variável listaElements, os valores dos elementos dados pelo utilizador.
    public void setListaElements(ArrayList<Element<T>> listaElements) {
        this.listaElements = listaElements;
    }


    /*  
    *   Método addThings
    *   Este método percorre a arraylist com o for, à procura se a T coisa já existe, caso exista (newThing = false)
    *   se não encontrar, então adiciona a coisa à lista.
    */ 
    public void addThings(int n, T coisa) {

        boolean newThing = true;

        for (int i = 0; i < listaElements.size(); i++) {  
            
            // Com o método .get(), retiramos o element i da lista. Com o uso do método .getThing() retiramos o parâmetro 'coisa' que corresponde ao produto/tipo de moeda.
            // Com os métodos .getClass().getSimpleName() vai retornar a classe do elemento,
            // Queremos ver se a classe do elemento é igual à classe da coisa, para verificar se o elemento já existe ou não.
            if ((listaElements.get(i).getThing().getClass().equals(coisa.getClass()))
                    && (coisa.getClass().getSimpleName().contains("Perishable"))) { // Verifica se o nome da classe da coisa contém Perishable no nome.
                
                // Faz referência à classe Product. Retirar o nome do produto com o método .getName() para verificar se têm o mesmo nome da coisa.
                if (((Product) listaElements.get(i).getThing()).getName().equals(((Product) coisa).getName())) {

                    listaElements.get(i).setCount((listaElements.get(i).getCount()) + n); // Aumenta a quantidade do elemento.
                    newThing = false; // Como não é nova coisa, a variável newThing fica falso.
                    break;
                }

            } else if ((listaElements.get(i).getThing().equals(coisa))) { // Caso não seja um produto e se for igual â coisa.

                listaElements.get(i).setCount((listaElements.get(i).getCount()) + n); // Aumenta a quantidade do elemento.
                newThing = false; // Como não é nova coisa, a variável newThing fica falso.
                break;
            }
        }
        // Se após percorrer a lista, e a variável newThing permanecer a true, significa que a coisa é nova.
        if (newThing) {
            Element<T> novo = new Element<T>(n, coisa); // Cria um novo elemento com n quantidade e a respetiva coisa.
            listaElements.add(novo); // Adiciona a lista a nova coisa.
        }
    }


    /*  
    *   Método removeOneThing
    *   Este método percorre a arraylist com o for, e remove uma coisa.
    */
    public boolean removeOneThing(T coisa) {

        for (int i = 0; i < listaElements.size(); i++) {
            // Se o elemento i da lista, o nome da classe contém Perishable no nome, é um produto. Se o nome do produto é igual ao nome da coisa que queremos
            // remover então entra no if.
            if ((listaElements.get(i).getThing().getClass().getSimpleName().contains("Perishable"))
                    &&((Product) listaElements.get(i).getThing()).getName().equals(coisa)){
                    
                if ((listaElements.get(i).getCount()) < 2) { // Se a quantidade do produto na máquina for apenas 1,
                    listaElements.remove(i);  // Então remove-se o elemento da lista.
                } else { // Se a quantidade for maior ou igual a 2.

                    listaElements.get(i).setCount((listaElements.get(i).getCount()) - 1); // Retira-se, subtraindo a quantidade por -1.
                }
                return true; // Retorna true após remover a coisa.

            } else if (listaElements.get(i).getThing().equals(coisa)) { // Se a coisa do elemento for igual â coisa que queremos remover.

                if ((listaElements.get(i).getCount()) < 2) { 

                    listaElements.remove(i);
                } else {

                    listaElements.get(i).setCount((listaElements.get(i).getCount()) - 1);
                }
                return true;
            }
        }
        return false; // Retorna falso se não foi possível remover a coisa. 
    }

    /*
    * Este método serve para dar print de todos os elementos da lista.
    */ 
    public void listAll() {
        for (int i = 0; i < listaElements.size(); i++) {  // Percorre a lista.
            System.out.println(listaElements.get(i).toString()); // Retira o elemento e envia para o método toString onde retorna uma string que representa o objeto.
        }

    }
}
