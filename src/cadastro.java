
    import java.util.ArrayList;
import java.util.Scanner;

    class Aluno {
        String nome;
        ArrayList<Double> notas;

        Aluno(String nome) {
            this.nome = nome;
            this.notas = new ArrayList<>();
        }

        void adicionarNota(double nota) {
            notas.add(nota);
        }

        double calcularMedia() {
            if (notas.isEmpty()) {
                return 0;
            }
            double soma = 0;
            for (double nota : notas) {
                soma += nota;
            }
            return soma / notas.size();
        }
    }

    public class cadastro {
        private static ArrayList<Aluno> alunos = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int opcao;
            do {
                exibirMenu();
                opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha deixada por nextInt
                switch (opcao) {
                    case 1:
                        cadastrarAluno();
                        break;
                    case 2:
                        cadastrarNota();
                        break;
                    case 3:
                        calcularMedia();
                        break;
                    case 4:
                        listarAlunosSemNotas();
                        break;
                    case 5:
                        excluirAluno();
                        break;
                    case 6:
                        excluirNota();
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 7);
        }

        private static void exibirMenu() {
            System.out.println("MENU");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar nota");
            System.out.println("3 - Calcular média de um aluno");
            System.out.println("4 - Listar os nomes dos alunos sem notas");
            System.out.println("5 - Excluir aluno");
            System.out.println("6 - Excluir nota");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
        }

        private static void cadastrarAluno() {
            System.out.print("Nome do aluno: ");
            String nome = scanner.nextLine();
            alunos.add(new Aluno(nome));
            System.out.println("Aluno cadastrado com sucesso!");
        }

        private static void cadastrarNota() {
            System.out.print("Nome do aluno: ");
            String nome = scanner.nextLine();
            Aluno aluno = encontrarAluno(nome);
            if (aluno != null) {
                System.out.print("Nota: ");
                double nota = scanner.nextDouble();
                scanner.nextLine();  // Consumir a nova linha deixada por nextDouble
                aluno.adicionarNota(nota);
                System.out.println("Nota cadastrada com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }
        }

        private static void calcularMedia() {
            System.out.print("Nome do aluno: ");
            String nome = scanner.nextLine();
            Aluno aluno = encontrarAluno(nome);
            if (aluno != null) {
                double media = aluno.calcularMedia();
                System.out.println("Média do aluno " + nome + ": " + media);
            } else {
                System.out.println("Aluno não encontrado.");
            }
        }

        private static void listarAlunosSemNotas() {
            boolean encontrado = false;
            for (Aluno aluno : alunos) {
                if (aluno.notas.isEmpty()) {
                    System.out.println(aluno.nome);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Todos os alunos têm notas cadastradas.");
            }
        }

        private static void excluirAluno() {
            System.out.print("Nome do aluno: ");
            String nome = scanner.nextLine();
            Aluno aluno = encontrarAluno(nome);
            if (aluno != null) {
                alunos.remove(aluno);
                System.out.println("Aluno excluído com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }
        }

        private static void excluirNota() {
            System.out.print("Nome do aluno: ");
            String nome = scanner.nextLine();
            Aluno aluno = encontrarAluno(nome);
            if (aluno != null) {
                System.out.print("Nota a ser excluída: ");
                double nota = scanner.nextDouble();
                scanner.nextLine();  // Consumir a nova linha deixada por nextDouble
                if (aluno.notas.remove(nota)) {
                    System.out.println("Nota excluída com sucesso!");
                } else {
                    System.out.println("Nota não encontrada.");
                }
            } else {
                System.out.println("Aluno não encontrado.");
            }
        }

        private static Aluno encontrarAluno(String nome) {
            for (Aluno aluno : alunos) {
                if (aluno.nome.equalsIgnoreCase(nome)) {
                    return aluno;
                }
            }
            return null;
        }
    }


