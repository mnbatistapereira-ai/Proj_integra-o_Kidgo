import java.util.Scanner;
import java.util.ArrayList;

public class KidGO {
    private static ArrayList<Aluno> alunosCadastrados = new ArrayList<>();
    private static ArrayList<PontoParada> roteiro = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean sistemaRodando = true;

            while (sistemaRodando) {
                System.out.println("\n=== PAINEL DO MOTORISTA - KID&GO ===");
                System.out.println("1 - Cadastrar Novo Aluno (RF01)");
                System.out.println("2 - Gerenciar Rota Manualmente (RF06)");
                System.out.println("3 - Ver Roteiro Atual");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                try {
                    int opcao = Integer.parseInt(scanner.nextLine());

                    switch (opcao) {
                        case 1 -> cadastrarAluno(scanner);
                        case 2 -> gerenciarRota(scanner);
                        case 3 -> {
                            listarRota();
                            System.out.print("\n...");
                            scanner.nextLine();
                        }
                        case 0 -> {
                            System.out.println("Encerrando o sistema...");
                            sistemaRodando = false;
                        }
                        default -> System.out.println("Opção inválida!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Digite um número válido para o menu.");
                }
            }
        }
    }

    private static void cadastrarAluno(Scanner scanner) {
        System.out.println("\n--- NOVO CADASTRO ---");
        System.out.print("Nome do aluno: ");
        String nomeAluno = scanner.nextLine();
        System.out.print("Endereço do aluno: ");
        String enderecoAluno = scanner.nextLine();
        System.out.print("Nome do responsável: ");
        String nomeResponsavel = scanner.nextLine();
        System.out.print("Telefone do responsável: ");
        String telefoneResponsavel = scanner.nextLine();
        System.out.print("Nome da escola: ");
        String nomeEscola = scanner.nextLine();
        System.out.print("Endereço da escola: ");
        String enderecoEscola = scanner.nextLine();

        alunosCadastrados.add(
            new Aluno(
                nomeAluno, enderecoAluno, nomeResponsavel,
                telefoneResponsavel, nomeEscola, enderecoEscola
            )
        );

        // Adiciona o endereço do aluno no roteiro
        roteiro.add(new PontoParada("Aluno", nomeAluno, enderecoAluno));

        boolean escolaExiste = false;
        for (PontoParada parada : roteiro) {
            if (parada.getTipo().equals("Escola") &&
                    parada.getNome().equalsIgnoreCase(nomeEscola)) {
                escolaExiste = true;
                break;
            }
        }

        // Se a escola for nova, adiciona na rota
        if (!escolaExiste) {
            roteiro.add(new PontoParada("Escola", nomeEscola, enderecoEscola));
        }
    }

    private static void gerenciarRota(Scanner scanner) {
        while (true) {
            System.out.println("\n--- GERENCIAR ROTA (ORDENAÇÃO MANUAL) ---");
            if (roteiro.isEmpty()) {
                System.out.println("Nenhuma parada cadastrada.");
                return;
            }

            listarRota();

            try {
                System.out.print("\nDigite [1] Fazer alteração: ");
                int ordenar = Integer.parseInt(scanner.nextLine());
                if (ordenar != 1) {
                    break;
                }

                System.out.print("Digite o ID do item que deseja MOVER: ");
                int origem = Integer.parseInt(scanner.nextLine());
                origem--;

                System.out.print("Digite o ID da NOVA POSIÇÃO deste item: ");
                int destino = Integer.parseInt(scanner.nextLine());
                destino--;

                // Validação para evitar erros de índice fora da lista
                if (origem >= 0 && origem < roteiro.size() &&
                        destino >= 0 && destino < roteiro.size()) {
                    // Remove da posição antiga e insere na nova
                    PontoParada itemMovido = roteiro.remove(origem);
                    roteiro.add(destino, itemMovido);
                    System.out.println("Ordem do roteiro atualizada com sucesso!");
                } else {
                    System.out.println("Erro: Os IDs informados não existem na lista.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida. Use apenas números.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Erro ao reposicionar o item.");
            }
        }
    }

    private static void listarRota() {
        System.out.println("\n--- ROTEIRO ATUAL ---");
        if (roteiro.isEmpty()) {
            System.out.println("Nenhuma parada cadastrada.");
        } else {
            for (int i = 0; i < roteiro.size(); i++) {
                System.out.println("ID " + (i + 1) + " : " + roteiro.get(i).get());
            }
        }
    }
}