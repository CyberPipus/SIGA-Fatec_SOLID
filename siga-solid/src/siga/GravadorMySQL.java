package siga;

public class GravadorMySQL implements MatriculaRepositorio {
    @Override
    public void gravar(String conteudo) {
        System.out.println("[MySQL] Gravando: " + conteudo);
    }
}
