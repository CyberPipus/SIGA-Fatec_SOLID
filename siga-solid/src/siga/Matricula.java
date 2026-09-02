package siga;

/**
 * Código INICIAL da atividade — contém violações PROPOSITAIS do SOLID.
 *
 * PROBLEMA 3 — Violação do Princípio da Inversão de Dependência (DIP):
 * a classe depende DIRETAMENTE de uma implementação concreta de persistência
 * (GravadorMySQL), instanciada com "new" dentro dela. Deveria depender de uma
 * abstração (uma interface), permitindo trocar a implementação sem alterá-la.
 *
 * Tarefa (etapa 4 da ficha):
 *   - inverter a dependência concreta de GravadorMySQL, fazendo a classe depender
 *     de uma interface (ex.: MatriculaRepositorio).
 */
public class Matricula {

    private Aluno aluno;
    private double valorBase;
    private final Desconto desconto; // Dependência de abstração (interface)
    private final MatriculaRepositorio gravador; // Dependência de abstração (interface)
    

    public Matricula(Aluno aluno, double valorBase, Desconto desconto, MatriculaRepositorio gravador) {
        this.aluno = aluno;
        this.valorBase = valorBase;
        this.desconto = desconto;
        this.gravador = gravador;
    }

    public double calcularMensalidade() {
        return desconto.aplicar(valorBase);
    }

    public void gravar() {
        String conteudo = "Matrícula de " + aluno.getNome() + " - mensalidade: " + calcularMensalidade();
        gravador.gravar(conteudo);
    }
}
