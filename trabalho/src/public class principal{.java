public class principal{
    public static void main(String[] args) {
        Hackatona hackatona = new Hackatona();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("----- Hackatona PUCRS -----");
            System.out.println("1. Criar time");
            System.out.println("2. Adicionar aluno ao time");
            System.out.println("3. Adicionar nota de avaliador");
            System.out.println("4. Identificar time vencedor");
            System.out.println("5. Mostrar todos os alunos participantes");
            System.out.println("6. Mostrar times com nota acima de 20");
            System.out.println("7. Mostrar informações de um time específico");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do time: ");
                    String nomeTime = scanner.next();
                    hackatona.criarTime(nomeTime);
                    break;
                case 2:
                    System.out.print("Digite o nome do time: ");
                    nomeTime = scanner.next();
                    System.out.print("Digite o nome do aluno: ");
                    String nomeAluno = scanner.next();
                    System.out.print("Digite a matrícula do aluno: ");
                    int Smatricula = scanner.nextInt();
                    System.out.print("Digite o curso do aluno: ");
                    String curso = scanner.next();
                    System.out.print("Digite o email do aluno: ");
                    String email = scanner.next();
                    Aluno aluno = new Aluno(Smatricula, nomeAluno, curso, email);
                    hackatona.adicionarAluno(nomeTime, aluno);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Digite o nome do time: ");
                    String time = scanner.nextLine();
                    System.out.println("Digite a nota do avaliador: ");
                    double nota = scanner.nextDouble();
                    hackatona.adicionarAvaliador(nota, time);
                    break;
                case 4:
                    Time vencedor = hackatona.identificarTimeVencedor();
                    if (vencedor != null) {
                        System.out.println("Time vencedor: " + vencedor.getNome() + " (Nota: " + vencedor.calcularMedia() + ")");
                    } else {
                        System.out.println("Nenhum time cadastrado.");
                    }
    
                    break;
                case 5:
                    List<Aluno> alunos = hackatona.listarAlunos();
                    System.out.println("Alunos participantes: ");
                    for (int i=0;i<alunos.size();i++) {
                        System.out.println(alunos.get(i).toString());
                    }
                    break;
                case 6:
                    List<Time> timesAcimaDe20 = hackatona.listarTimesComNotaAcimaDe20();
                    System.out.println("Times com nota acima de 20: ");
                    for (Time time2 : timesAcimaDe20) {
                        System.out.println(time2.getNome());
                    }
                    break;
                case 7:
                    System.out.print("Digite o nome do time: ");
                    scanner.nextLine();
                    String nomeTime2 = scanner.nextLine();
                    Time time3 = hackatona.encontrarTime(nomeTime2);
                    if (time3 != null) {
                        System.out.println("Time: " + time3.getNome());
                        System.out.println("Alunos: ");
                        for (Aluno a : time3.getAlunos()) {
                            System.out.println(a.getNome());
                        }
                        System.out.println("Notas: ");
                        for (double n : time3.getNotas()) {
                            System.out.print(n+ " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Time não encontrado.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            
            System.out.println();
            
        } while (opcao != 0);
        
        scanner.close();
    }
}