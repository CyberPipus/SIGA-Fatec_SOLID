package siga;

import java.util.List;

/**
 * Código INICIAL da atividade — contém violações PROPOSITAIS do SOLID.
 *
 * PROBLEMA 1 — Violação do Princípio da Responsabilidade Única (SRP):
 * esta classe acumula TRÊS responsabilidades que mudam por motivos diferentes:
 *   (a) formatar o relatório (apresentação);
 *   (b) gravar o relatório em disco (persistência);
 *   (c) enviar o relatório por e-mail (comunicação).
 * Uma mudança em qualquer uma dessas áreas obriga a mexer nesta mesma classe.
 *
 * Tarefa (etapas 1 e 2 da ficha): identificar as responsabilidades misturadas
 * e separá-las em classes distintas (ex.: RelatorioFormatador, RelatorioRepositorio,
 * ServicoEmail), cada uma com um único motivo para mudar.
 */
public class RelatorioAluno {

    // Responsabilidade (a): FORMATAÇÃO
    public String formatar(List<Aluno> alunos) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Relatório de Alunos ===\n");
        for (Aluno aluno : alunos) {
            sb.append(aluno.getMatricula())
              .append(" - ")
              .append(aluno.getNome())
              .append(" - média: ")
              .append(aluno.getMedia())
              .append("\n");
        }
        return sb.toString();
    }

    // Responsabilidade (b): PERSISTÊNCIA (gravar em arquivo)
    public void salvarEmArquivo(String conteudo, String caminho) {
        // Simulação de gravação em disco (a implementação real não importa para a atividade).
        System.out.println("[disco] Gravando relatório em: " + caminho);
        System.out.println(conteudo);
    }

    // Responsabilidade (c): COMUNICAÇÃO (enviar por e-mail)
    public void enviarPorEmail(String conteudo, String destinatario) {
        // Simulação de envio de e-mail.
        System.out.println("[email] Enviando relatório para: " + destinatario);
        System.out.println(conteudo);
    }
}
