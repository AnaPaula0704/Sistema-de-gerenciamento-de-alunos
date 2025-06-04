package N1_projeto;
 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
 
public class AlunosTeste {
    private static List<Aluno> alunos = new ArrayList<>();
    private static int contadorMatricula = 1001;
    private static Scanner leia = new Scanner(System.in);
 
    public static void main(String[] args) {
        int opcao = -1;
        do {
            System.out.println("\n------- MENU DA ESCOLA -------");
            System.out.println("1 - Adicionar novo aluno");
            System.out.println("2 - Listar todos os alunos");
            System.out.println("3 - Buscar aluno por matrícula");
            System.out.println("4 - Atualizar nota de uma disciplina");
            System.out.println("5 - Atualizar faltas de uma disciplina");
            System.out.println("6 - Remover aluno por matrícula");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");
 
            try {
                opcao = leia.nextInt();
                leia.nextLine(); // limpa buffer
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido!");
                leia.nextLine(); // limpa buffer inválido
                continue;
            }
 
            switch (opcao) {
                case 1:
                    adicionarNovoAluno();
                    break;
                case 2:
                    listarTodosAlunos();
                    break;
                case 3:
                    buscarAlunoPorMatricula();
                    break;
                case 4:
                    atualizarNotaDisciplina();
                    break;
                case 5:
                    atualizarFaltasDisciplina();
                    break;
                case 6:
                    removerAlunoPorMatricula();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
 
    private static void adicionarNovoAluno() {
        System.out.print("\nNome: ");
        String nome = leia.nextLine();
        System.out.print("Idade: ");
        int idade = leia.nextInt();
        leia.nextLine(); // limpa buffer
 
        String matricula = "" + contadorMatricula++;
        Aluno novoAluno = new Aluno(nome, idade, matricula);
 
        int semanasSemestre = 18;
 
        novoAluno.adicionarDisciplina(1, "ALGORITMOS E LINGUAGENS DE PROGRAMAÇÃO", 0, 0, 0, 6 * semanasSemestre);
        novoAluno.adicionarDisciplina(2, "AUTOMAÇÃO E COMANDOS ELÉTRICOS", 0, 0, 0, 6 * semanasSemestre);
        novoAluno.adicionarDisciplina(3, "BANCO DE DADOS", 0, 0, 0, 3 * semanasSemestre);
        novoAluno.adicionarDisciplina(4, "DESENVOLVIMENTO E VIABILIDADE DE PROJETOS", 0, 0, 0, 6 * semanasSemestre);
        novoAluno.adicionarDisciplina(5, "MANUTENÇÃO DE MICROCOMPUTADORES E PERIFÉRICOS", 0, 0, 0, 6 * semanasSemestre);
        novoAluno.adicionarDisciplina(6, "METODOLOGIA DE PESQUISA", 0, 0, 0, 3 * semanasSemestre);
 
        alunos.add(novoAluno);
        System.out.println("Aluno cadastrado com matrícula: " + matricula);
    }
 
    private static void listarTodosAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("\nAinda não há nenhum aluno cadastrado!");
        } else {
            for (Aluno aluno : alunos) {
                aluno.imprimirAluno();
                System.out.println("\n--------------------------------------------------");
            }
        }
    }
 
    private static void buscarAlunoPorMatricula() {
        if (alunos.isEmpty()) {
            System.out.println("\nAinda não há nenhum aluno cadastrado!");
            return;
        }
 
        System.out.print("Digite a matrícula: ");
        String matricula = leia.nextLine();
 
        Aluno aluno = encontrarAlunoPorMatricula(matricula);
        if (aluno != null) {
            aluno.imprimirAluno();
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
 
    private static void atualizarNotaDisciplina() {
        if (alunos.isEmpty()) {
            System.out.println("\nAinda não há nenhum aluno cadastrado!");
            return;
        }
 
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = leia.nextLine();
        Aluno aluno = encontrarAlunoPorMatricula(matricula);
 
        if (aluno != null) {
            System.out.println("Disciplinas:");
            for (int codigo : aluno.getDisciplinas().keySet()) {
                System.out.println(codigo + " - " + aluno.getDisciplinas().get(codigo).getNome());
            }
 
            System.out.print("Digite o código da disciplina: ");
            int codigo = leia.nextInt();
            leia.nextLine(); // limpa buffer
 
            if (aluno.getDisciplinas().get(codigo) == null) {
                System.out.println("Código de disciplina inválido.");
                return;
            }
 
            System.out.print("Deseja atualizar (1) só nota 1, (2) só nota 2 ou (3) as duas notas? ");
            int opc = leia.nextInt();
            leia.nextLine(); // limpa buffer
 
            if (opc == 1 || opc == 2) {
                System.out.print("Digite a nova nota: ");
                float novaNota = leia.nextFloat();
                leia.nextLine();
                aluno.atualizarNota(codigo, opc, novaNota);
                System.out.println("Nota atualizada.");
            } else if (opc == 3) {
                System.out.print("Digite a nova nota 1: ");
                float novaN1 = leia.nextFloat();
                System.out.print("Digite a nova nota 2: ");
                float novaN2 = leia.nextFloat();
                leia.nextLine();
                aluno.atualizarNotas(codigo, novaN1, novaN2);
                System.out.println("Notas atualizadas.");
            } else {
                System.out.println("Opção inválida para atualização de notas.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
 
    private static void atualizarFaltasDisciplina() {
        if (alunos.isEmpty()) {
            System.out.println("\nAinda não há nenhum aluno cadastrado!");
            return;
        }
 
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = leia.nextLine();
        Aluno aluno = encontrarAlunoPorMatricula(matricula);
 
        if (aluno != null) {
            System.out.println("Disciplinas:");
            for (int codigo : aluno.getDisciplinas().keySet()) {
                System.out.println(codigo + " - " + aluno.getDisciplinas().get(codigo).getNome());
            }
 
            System.out.print("Digite o código da disciplina: ");
            int codigo = leia.nextInt();
            leia.nextLine(); // limpa buffer
 
            if (aluno.getDisciplinas().get(codigo) == null) {
                System.out.println("Código de disciplina inválido.");
                return;
            }
 
            System.out.print("Digite o número de faltas: ");
            int novasFaltas = leia.nextInt();
            leia.nextLine();
 
            aluno.atualizarFaltas(codigo, novasFaltas);
            System.out.println("Faltas atualizadas.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
 
    private static void removerAlunoPorMatricula() {
        if (alunos.isEmpty()) {
            System.out.println("\nAinda não há nenhum aluno cadastrado!");
            return;
        }
 
        System.out.print("Digite a matrícula do aluno que deseja remover: ");
        String matricula = leia.nextLine();
 
        Aluno alunoParaRemover = encontrarAlunoPorMatricula(matricula);
 
        if (alunoParaRemover != null) {
            alunos.remove(alunoParaRemover);
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
 
    private static Aluno encontrarAlunoPorMatricula(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }
}
 
 
