package siga;
public class RelatorioRepositorio {
    public void salvar(String conteudo, String caminho) {
        System.out.println("[disco] Gravando relatório em: " + caminho);
        System.out.println(conteudo);
    }
}