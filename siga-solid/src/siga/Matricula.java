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

    // Violação do DIP: dependência direta da classe concreta.
    private GravadorMySQL gravador = new GravadorMySQL();

    public Matricula(Aluno aluno, double valorBase, Desconto desconto) {
        this.aluno = aluno;
        this.valorBase = valorBase;
        this.desconto = desconto;
    }

    public double calcularMensalidade() {
        return desconto.aplicar(valorBase);
    }

    // Persiste a matrícula usando a implementação concreta (acoplamento indevido).
    public void salvar() {
        gravador.gravar("Matrícula de " + aluno.getNome()
                + " - mensalidade: " + calcularMensalidade());
    }
}
