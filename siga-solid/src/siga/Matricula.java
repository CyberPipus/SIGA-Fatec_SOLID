package siga;

/**
 * Código INICIAL da atividade — contém violações PROPOSITAIS do SOLID.
 *
 * PROBLEMA 2 — Violação do Princípio Aberto/Fechado (OCP):
 * o método calcularMensalidade usa um bloco de condicionais por TIPO de desconto
 * que cresce a cada novo tipo. Adicionar "convênio", "funcionário" ou qualquer
 * outro desconto exige MODIFICAR este método e testá-lo novamente por inteiro.
 *
 * PROBLEMA 3 — Violação do Princípio da Inversão de Dependência (DIP):
 * a classe depende DIRETAMENTE de uma implementação concreta de persistência
 * (GravadorMySQL), instanciada com "new" dentro dela. Deveria depender de uma
 * abstração (uma interface), permitindo trocar a implementação sem alterá-la.
 *
 * Tarefa (etapas 3 e 4 da ficha):
 *   - substituir o bloco condicional por polimorfismo (interface Desconto e uma
 *     classe por tipo de desconto), tornando o cálculo aberto para extensão;
 *   - inverter a dependência concreta de GravadorMySQL, fazendo a classe depender
 *     de uma interface (ex.: MatriculaRepositorio).
 */
public class Matricula {

    private Aluno aluno;
    private double valorBase;
    private String tipoDesconto;   // "NENHUM", "BOLSISTA", "CONVENIO", "FUNCIONARIO"...

    // Violação do DIP: dependência direta da classe concreta.
    private GravadorMySQL gravador = new GravadorMySQL();

    public Matricula(Aluno aluno, double valorBase, String tipoDesconto) {
        this.aluno = aluno;
        this.valorBase = valorBase;
        this.tipoDesconto = tipoDesconto;
    }

    // Violação do OCP: um novo desconto = mais um ramo condicional aqui.
    public double calcularMensalidade() {
        if (tipoDesconto.equals("BOLSISTA")) {
            return valorBase * 0.5;
        } else if (tipoDesconto.equals("CONVENIO")) {
            return valorBase * 0.8;
        } else if (tipoDesconto.equals("FUNCIONARIO")) {
            return valorBase * 0.7;
        } else {
            return valorBase; // NENHUM
        }
    }

    // Persiste a matrícula usando a implementação concreta (acoplamento indevido).
    public void salvar() {
        gravador.gravar("Matrícula de " + aluno.getNome()
                + " - mensalidade: " + calcularMensalidade());
    }
}
