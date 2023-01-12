# Relatório do Trabalho de Programação II

## Introdução
Este trabalho prático de Programação II tem como objetivo simular a operação de uma máquina de distribuição de produtos. Como aquelas que encontramos na Universidade. 
- Este trabalho está divido em quatro partes. Em cada parte devemos implementar as seguintes Classes, os respetivos atributos e métodos.
    - Parte 1:
        - Classe `Product`: atributos `name` (nome do Produto) e `cost` (custo do Produto). Tem duas subclasses (`Perishable` e `NonPersihable`):
            - Classe `Perishable`: tem atributo extra `limitDate` (data limite para os produtos perecíveis).
                - Esta classe implementa a interface `Freshness`.
            - Classe `NonPersihable`: tem atributo extra `volume` (valor do volume do produto).
    - Parte 2:
        - Classe `ElementarMachine<T>`: Tem como atributo a **ArrayList** `listaElements` (Guarda os valores dos elementos). 
        - Tem duas subclasses (`ProductMachine` e `MoneyMachine`).
    - Parte 3:
        - Classe `ProductMachine`: Ao criar a ProductMachine, cria a ElementarMachine associada, onde o `tipo T` é `Product`.
        - Classe `MoneyMachine`: Ao criar a MoneyMachine, cria a ElementarMachine associada, onde o `tipo T` é `Float`.
        - Classe `VendingMachine`: Tem como atributos: `pm`, uma ProductMachine. `mm`, uma MoneyMachine.
    - Parte 4:
        - É onde se realiza a mecânica da compra do produto. Criámos o método **public boolean buy(String prod, MoneyMachine carteira)** na classe `VendingMachine`.

## Implementações
Parte  1:
- A classe `Product` é abstrata para não ser possível criar uma instância desta classe. O seu construtor **protected Product(String name, double cost)** cria o produto.
    - Os métodos **public String getName()** / **public double getCost()**, retornam, respetivamente, o nome do produto e o seu custo.
    - Os métodos **public void setName(String name)** / **public void setCost(double cost)**, insere, respetivamente, no atributo `name` o nome do produto e no atributo `cost` o custo do produto dados pelo utilizador.
- A subclasse `Perishable`. O seu construtor faz referência ao construtor da classe pai `Product` e como é um produto com validade, vai ter a instância limitDate.
    - O método **public Date getLimitDate()**, retorna a respetiva limitDate e o método **public void setLimitDate(Date limitDate)**, insere, no atributo `limitDate` a data limite para o consumo do produto, dada pelo utilizador.
    - É utilizada a interface dada pelo professor `Freshness`, onde com o método **public boolean isOutDated()** retorna *true*, se a data limite já passou, e *false*, caso contrário. O método **public boolean isFromToday()**, retorna *true* se a data limite do produto é de hoje, e *false*, caso contrário.
- A subclasse `NonPerishable`. O seu construtor faz referência ao construtor da classe pai `Product`, mas têm a característica adicional, como atributo `volume`.
    - O método **public double getVolume()**, retorna o respetivo volume e o método **public void setVolume(double volume)**, insere, no atributo `volume`, o volume do produto.

Parte 2:
- Para inicializar a classe `ElementarMachine<T>`, temos como instância uma **ArrayList** `listaElements`, onde armazena os valores dos elementos.
    - O construtor da classe **public ElementarMachine()** cria a **ArrayList** dos elementos.
    - O método **public ArrayList<Element<T>> getListaElements()** retorna a **ArrayList** dos elementos. E o método **public void setListaElements(ArrayList<Element<T>> listaElements)** insere na **ArrayList**, os valores dos elementos dados pelo utilizador.
    - O método **public void addThings(int n, T coisa)** adiciona a coisa **T** e a sua respetiva quantidade à **ArrayList**. Para tal, percorre a respetiva lista e verifica se a coisa a adicionar já existe ou não. Se a classe da coisa é igual à classe de um elemento na **ArrayList** e se no nome da classe da coisa tem "Perishable", significa que é um produto, então fizemos uma condição para verificar se os nomes dos produtos coincidem ou não. Caso seja verdade, então basta aumentar a quantidade do elemento (produto).  
    Caso não seja um produto, mas se a coisa for igual ao elemento, então aumenta a respetiva quantidade.
    De notar, que em ambos os casos, se não for encontrado a coisa, na **ArrayList** é necessário criar um elemento novo (com o auxílio do construtor da classe `Element<T>`), com a respetiva quantidade e a coisa, para adicionar à **ArrayList**.
    - O método **public boolean removeOneThing(T coisa)** percorre a **ArrayList** com o ciclo "for".
        - Se a coisa for um produto e este tiver o mesmo nome que um elemento presente na **ArrayList** então fizemos duas condições. Se a sua quantidade for menor que dois, ou seja apenas tem um, então como vamos remover, retira-se simplesmente da **ArrayList** o elemento. Caso a quantidade seja maior que dois, subtrai-se simplesmente por -1 a respetiva quantidade, pois só se remove uma coisa. O mesmo acontece para a coisa quando é um tipo de moeda (quando não é um produto).
    - O método **public void listAll()** dá print de todos os elementos da lista sem ser um produto (pois o método encontra-se na classe `ProductMachine`).

Parte 3:
- Classe `ProductMachine`:
    - O construtor faz refência ao construtor da classe `ElementarMachine<T>`. A coisa do `tipo T` torna-se do tipo `Product`.
    - O método **public void addProduct(int n, Product p)** adiciona à ArrayL
