package siga;

/**
 * Sistema de Gestão Acadêmica Simplificado (SIGA)
 * Técnicas de Programação II - Fatec de Porto Ferreira
 * Atividade prática da Aula 3 (Padrões de Projeto e SOLID).
 *
 * Entidade de domínio. Esta classe está razoável do ponto de vista de
 * encapsulamento (atributos privados com acessores) e NÃO é o alvo da
 * refatoração: ela apenas fornece os dados usados pelas classes que
 * violam os princípios SOLID (RelatorioAluno e Matricula).
 */
public class Aluno {

    private String nome;
    private String matricula;
    private String email;
    private double media;
    private boolean bolsista;

    public Aluno(String nome, String matricula, String email, double media, boolean bolsista) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.media = media;
        this.bolsista = bolsista;
    }

    public String getNome()      { return nome; }
    public String getMatricula() { return matricula; }
    public String getEmail()     { return email; }
    public double getMedia()     { return media; }
    public boolean isBolsista()  { return bolsista; }
}
