package siga;

import java.util.Arrays;
import java.util.List;

/**
 * Ponto de entrada do SIGA (código INICIAL da atividade da Aula 3).
 *
 * Esta classe demonstra, em execução, os três problemas de design que você
 * deverá corrigir aplicando os princípios SOLID. Rode o programa e observe:
 * ele FUNCIONA — mas o código não resiste bem à mudança, como discutido em aula.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Refatoração SOLID (código inicial) ===\n");

        List<Aluno> alunos = Arrays.asList(
            new Aluno("Maria Silva", "2026001", "maria@exemplo.edu", 8.5, true),
            new Aluno("João Souza",  "2026002", "joao@exemplo.edu",  6.0, false),
            new Aluno("Ana Pereira", "2026003", "ana@exemplo.edu",   9.2, false)
        );

        // PROBLEMA 1 (SRP): uma única classe formata, grava E envia o relatório.
        RelatorioAluno relatorio = new RelatorioAluno();
        String conteudo = relatorio.formatar(alunos);
        relatorio.salvarEmArquivo(conteudo, "relatorios/alunos.txt");
        relatorio.enviarPorEmail(conteudo, "coordenacao@exemplo.edu");

        System.out.println();

        // PROBLEMA 2 (OCP): o cálculo usa condicionais que crescem a cada desconto.
        Matricula m1 = new Matricula(alunos.get(0), 1000.0, "BOLSISTA");
        Matricula m2 = new Matricula(alunos.get(1), 1000.0, "NENHUM");
        System.out.println("Mensalidade (bolsista): " + m1.calcularMensalidade());
        System.out.println("Mensalidade (sem desconto): " + m2.calcularMensalidade());

        // PROBLEMA 3 (DIP): Matricula depende diretamente de GravadorMySQL.
        m1.salvar();
        m2.salvar();

        System.out.println("\nObserve: para adicionar um novo tipo de desconto, é preciso");
        System.out.println("MODIFICAR a classe Matricula; e trocar o meio de persistência");
        System.out.println("exigiria alterá-la também. Sua tarefa é corrigir isso com SOLID.");
    }
}
