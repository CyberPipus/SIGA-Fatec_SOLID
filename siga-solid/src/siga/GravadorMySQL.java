package siga;

/**
 * Código INICIAL da atividade.
 *
 * Implementação concreta de persistência. Hoje a classe Matricula depende
 * DIRETAMENTE desta classe (via "new GravadorMySQL()"), o que caracteriza a
 * violação do Princípio da Inversão de Dependência (DIP).
 *
 * Na refatoração (etapa 4), esta classe deve passar a implementar uma
 * abstração (por exemplo, uma interface MatriculaRepositorio), e a classe
 * Matricula deve depender dessa abstração — não desta implementação concreta.
 */
public class GravadorMySQL {

    public void gravar(String dados) {
        // Simulação de gravação em banco MySQL.
        System.out.println("[MySQL] Gravando: " + dados);
    }
}
