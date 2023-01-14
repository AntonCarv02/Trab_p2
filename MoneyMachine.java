public class MoneyMachine extends ElementarMachine<Float> {
    // Quando é criar a MoneyMachine, cria a ElementarMachine associada.
    public MoneyMachine() {
        super();
    }

    // Este método retorna o total do valor presente na máquina.
    public float getTotalValue() {
        int amount = 0;
        float res = 0, coin = 0;

        // Percorre a lista retornada pelo método getListaElements().
        for (int i = 0; i < this.getListaElements().size(); i++) {
            amount = this.getListaElements().get(i).getCount(); // Quantidade das moedas que estão na máquina.
            coin = this.getListaElements().get(i).getThing(); // O respetivo tipo da moeda.
            res += (amount * coin); // Multiplica as moedas pelo valor da moeda.
        }
        return res; // total do valor presente na máquina.
    }

    // Este método insere dinheiro, a quantidade e a quantia de cada moeda.
    public void addMoney(int n, float money) {
        this.addThings(n, money);
    }
    

    public static boolean verifyInput(MoneyMachine cart, float coin) {
        float[] moedas = { 0.1f, 0.2f, 0.5f, 1f, 2f, 5f, 10f, 20f };

        for (int i = 0; i < moedas.length; i++) {
            if (coin == moedas[i]) {
                cart.addMoney(1, coin);
                return true;
            }
        }

        return false;
    }

    
}
