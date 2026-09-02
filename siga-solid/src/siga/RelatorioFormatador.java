package siga;

import java.util.List;

public class RelatorioFormatador {
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
}