package siga;

public class SemDesconto implements Desconto {
    @Override
    public double aplicar(double valor) {
        return valor;
    }
}
