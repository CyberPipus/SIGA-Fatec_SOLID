package siga;

public class DescontoBolsista implements Desconto {
    @Override
    public double aplicar(double valor) {
        double desconto = valor * 0.5; // 50% de desconto para bolsistas
        double valorComDesconto = valor - desconto;
        return valorComDesconto;
    }
}
