# SIGA — Atividade de Refatoração SOLID (código inicial)

**Técnicas de Programação II (TP2) · Aula 3** — CST em Desenvolvimento de Software Multiplataforma · Fatec de Porto Ferreira

Este é o **código inicial** da atividade prática da Aula 3. Ele contém, de forma **proposital**, três violações dos princípios SOLID que você deverá identificar e corrigir. O programa compila e executa — o problema não é o funcionamento, e sim a resistência do código à mudança.

## Estrutura do projeto

```
siga-solid/
├── README.md
└── src/
    └── siga/
        ├── Aluno.java          (entidade de domínio — NÃO é alvo da refatoração)
        ├── RelatorioAluno.java (viola o SRP: formata + grava + envia)
        ├── Matricula.java      (viola o OCP e o DIP)
        ├── GravadorMySQL.java  (implementação concreta usada por Matricula)
        └── Main.java           (demonstra os três problemas em execução)
```

## Como compilar e executar

Pré-requisito: JDK 17 ou superior (`java -version` para verificar).

```bash
# 1. Compilar (a saída vai para a pasta "bin")
javac -d bin src/siga/*.java

# 2. Executar
java -cp bin siga.Main
```

## As três violações propositais

| Arquivo | Princípio violado | O que está errado |
|---|---|---|
| `RelatorioAluno.java` | **SRP** (Responsabilidade Única) | A classe formata, grava em disco e envia e-mail — três motivos para mudar. |
| `Matricula.java` | **OCP** (Aberto/Fechado) | `calcularMensalidade` usa condicionais por tipo de desconto que crescem a cada novo tipo. |
| `Matricula.java` | **DIP** (Inversão de Dependência) | Depende diretamente da classe concreta `GravadorMySQL` (instanciada com `new`). |

## Sua tarefa

Siga as etapas da ficha de atividade prática. Em resumo:

1. **Analisar** a classe `RelatorioAluno` e identificar, por escrito, as responsabilidades misturadas (SRP).
R: A classe 'RelatorioAluno' possuía três responsabilidades: 1 - receber uma lista e a converter em texto; 2 - gravar tal texto no disco por um caminho específico e 3 - enviar o mesmo texto por e-mail para o destinatário desejado. O Princípio de Responsabilidade Única (Single Responsibility Principle - SRP) descreve que uma classe somente deve ser responsável perante um ator, por exemplo, a coordenação requer o recebimento de uma lista que já esteja em um formato de texto. O setor de TI é quem precisa aprovar ou não gravações deste texto em um disco por um caminho específico. A direção é quem regula o envio dos textos por e-mail para alunos, professores ou coordenadores. Com a distinção de três atores, espera-se três classes distintas para atendê-los.

2. **Separar** cada responsabilidade em sua própria classe (por exemplo: `RelatorioFormatador`, `RelatorioRepositorio`, `ServicoEmail`), cada uma com um único motivo para mudar.
R: Agora temos `RelatorioFormatador`, `RelatorioRepositorio`, `ServicoEmail` presentes e operantes no código.

3. **Substituir** o bloco condicional de `calcularMensalidade` por polimorfismo: crie uma interface `Desconto` com um método `aplicar(double valor)` e uma classe para cada tipo (`DescontoBolsista`, `DescontoConvenio`, `DescontoFuncionario`, `SemDesconto`). Assim, um novo desconto passa a ser uma nova classe, sem modificar `Matricula` (OCP).
R: Anteriormente, a classe "Matricula" decidia o desconto comparando um "String", forçando sua modificação caso surgisse um novo tipo. Com a implementação da interface "Desconto" como regra, a Matricula recebe um Desconto e o calcularMensalidade delega o cálculo a ele, corrigindo a violação do OCP da antiga comparação por "String", assim como catalogado por Fowler, que é substituição de condicionais por polimorfismo. Agora, um desconto novo é um arquivo novo, sem alterar nenhuma linha de código em "Matricula", provado pela saída no "Terminal" ainda sendo 500.0 e 1000.0. Para a mensalidade sem desconto é aplicado um NullObject, o que elimina a dependência de um if para cada vez que não é aplicado um desconto.
A solução condiz ao padrão Strategy de Gamma et al. (1994).

4. **Inverter** a dependência: crie uma interface (por exemplo, `MatriculaRepositorio`) que `GravadorMySQL` implemente, e faça `Matricula` depender da interface — recebendo-a pelo construtor — em vez de instanciar a classe concreta (DIP).
R: Antes, a "Matricula" instanciava "GravadorMySQL" diretamente, decidindo por conta a tecnologia de persistência. Agora passa a depender da interface "MatriculaRepositorio", recebida por construtor, e o "GravadorMySQL" é aquilo que passa a implementar. Portanto invertemos a dependência: detalhe técnico aponta para abstração, e não o contrário. Por fim, quem quiser trocar o meio de gravação não precisará alterar nada em "Matricula".
A solução condiz com a injeção por construtor conforme Bloch (Effective Java, Item 5), abstração no padrão Repository descrita por Fowler (2002) e o princípio formulado por Martin (2002).

5. **Listar**, no README da sua entrega, os *code smells* que você encontrou no código original.
R:

## Critério de sucesso

Ao final, deve ser possível **adicionar um novo tipo de desconto** e **trocar o meio de persistência** sem modificar a classe `Matricula`. Esse é o teste prático de que os princípios OCP e DIP foram aplicados.

## Padrão de entrega

Conforme a ficha de atividade prática: identificadores em português, código formatado, entrega no repositório Git com README e commits descritivos. O uso de IA para gerar o código é proibido nesta atividade (ver seção 5.3 da ficha).
