package N1_projeto;
 
import java.util.HashMap;
import java.util.Map;
 
public class Aluno {
    private String nome;
    private int idade;
    private String matricula;
    private Map<Integer, Disciplina> disciplinas;
 
    public Aluno(String nome, int idade, String matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.disciplinas = new HashMap<>();
    }
 
    public String getMatricula() {
        return matricula;
    }
 
    public void adicionarDisciplina(int codigo, String nome, float n1, float n2, int faltas, int aulasTotais) {
        disciplinas.put(codigo, new Disciplina(nome, n1, n2, faltas, aulasTotais));
    }
 
    public void atualizarNota(int codigo, int notaIndex, float novaNota) {
        Disciplina disciplina = disciplinas.get(codigo);
        if (disciplina != null) {
            if (notaIndex == 1) {
                disciplina.setNota1(novaNota);
            } else if (notaIndex == 2) {
                disciplina.setNota2(novaNota);
            }
        }
    }
 
    // Atualizar as duas notas de uma vez
    public void atualizarNotas(int codigo, float novaN1, float novaN2) {
        Disciplina disciplina = disciplinas.get(codigo);
        if (disciplina != null) {
            disciplina.setNota1(novaN1);
            disciplina.setNota2(novaN2);
        }
    }
 
    public void atualizarFaltas(int codigo, int novasFaltas) {
        Disciplina disciplina = disciplinas.get(codigo);
        if (disciplina != null) {
            disciplina.setFaltas(novasFaltas);
        }
    }
 
    public void imprimirAluno() {
        System.out.println("\nMatrícula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("\nDisciplinas:\n");
        for (Disciplina disciplina : disciplinas.values()) {
            disciplina.imprimirDisciplina();
        }
    }
 
    public Map<Integer, Disciplina> getDisciplinas() {
        return this.disciplinas;
    }
}