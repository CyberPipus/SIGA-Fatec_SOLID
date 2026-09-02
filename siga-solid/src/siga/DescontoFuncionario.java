package siga;

public class DescontoFuncionario implements Desconto {
    @Override
    public double aplicar(double valor) {
        double desconto = valor * 0.3; // 30% de desconto para funcionários
        double valorComDesconto = valor - desconto;
        return valorComDesconto;
    }
}
