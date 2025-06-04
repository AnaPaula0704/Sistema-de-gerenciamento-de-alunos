package N1_projeto;
 
public class Disciplina {
    private String nome;
    private float nota1;
    private float nota2;
    private int faltas;
    private int aulasTotais;
 
    public Disciplina(String nome, float nota1, float nota2, int faltas, int aulasTotais) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.faltas = faltas;
        this.aulasTotais = aulasTotais;
    }
 
    public String getNome() {
        return nome;
    }
 
    public float getNota1() {
        return nota1;
    }
 
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }
 
    public float getNota2() {
        return nota2;
    }
 
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }
 
    public float calcularMedia() {
        return (nota1 + nota2) / 2;
    }
 
    public int getFaltas() {
        return faltas;
    }
 
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
 
    public int getAulasTotais() {
        return aulasTotais;
    }
 
    public void setAulasTotais(int aulasTotais) {
        this.aulasTotais = aulasTotais;
    }
 
    public float calcularFrequencia() {
        return ((float) (aulasTotais - faltas) / aulasTotais) * 100;
    }
 
    public void imprimirDisciplina() {
        System.out.println("  " + nome);
        System.out.println("    Nota 1: " + nota1);
        System.out.println("    Nota 2: " + nota2);
        System.out.println("    Média: " + calcularMedia());
        System.out.println("    Faltas: " + faltas);
        System.out.println("    Frequência: " + calcularFrequencia() + "%");
    }
}
