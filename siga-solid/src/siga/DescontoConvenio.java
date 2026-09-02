package siga;

public class DescontoConvenio implements Desconto {
    @Override
    public double aplicar(double valor) {
        double desconto = valor * 0.2; // 20% de desconto para convênios
        double valorComDesconto = valor - desconto;
        return valorComDesconto;
    }
}
