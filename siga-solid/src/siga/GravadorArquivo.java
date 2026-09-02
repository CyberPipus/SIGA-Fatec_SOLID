package siga;

public class GravadorArquivo implements MatriculaRepositorio {
    @Override
    public void gravar(String conteudo) {
        System.out.println("[Arquivo] Gravando: " + conteudo);
    }
    
}
