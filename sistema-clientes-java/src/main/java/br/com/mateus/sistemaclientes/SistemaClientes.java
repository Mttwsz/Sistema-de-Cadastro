package br.com.mateus.sistemaclientes;

import java.util.Optional;
import java.util.Scanner;

/**
 * Ponto de entrada da aplicação de cadastro de clientes.
 */
public class SistemaClientes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro(scanner, "Escolha uma opção: ");

            try {
                switch (opcao) {
                    case 1 -> cadastrarCliente(scanner, clienteService);
                    case 2 -> listarClientes(clienteService);
                    case 3 -> buscarCliente(scanner, clienteService);
                    case 4 -> atualizarCliente(scanner, clienteService);
                    case 5 -> removerCliente(scanner, clienteService);
                    case 0 -> System.out.println("\nPrograma encerrado. Até logo!");
                    default -> System.out.println("\nOpção inválida. Tente novamente.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro: " + e.getMessage());
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("        SISTEMA DE CLIENTES");
        System.out.println("========================================");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Buscar cliente");
        System.out.println("4 - Atualizar cliente");
        System.out.println("5 - Remover cliente");
        System.out.println("0 - Sair");
        System.out.println("========================================");
    }

    private static void cadastrarCliente(Scanner scanner, ClienteService service) {
        System.out.println("\n===== CADASTRO DE CLIENTE =====");
        String nome = lerTexto(scanner, "Nome: ");
        String email = lerTexto(scanner, "E-mail: ");
        String telefone = lerTexto(scanner, "Telefone: ");

        Cliente cliente = service.cadastrar(nome, email, telefone);
        System.out.println("\nCliente cadastrado com sucesso!");
        System.out.println(cliente);
    }

    private static void listarClientes(ClienteService service) {
        System.out.println("\n===== CLIENTES CADASTRADOS =====");

        if (service.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        service.listar().forEach(System.out::println);
    }

    private static void buscarCliente(Scanner scanner, ClienteService service) {
        System.out.println("\n===== BUSCAR CLIENTE =====");
        int id = lerInteiro(scanner, "Digite o ID do cliente: ");

        Optional<Cliente> cliente = service.buscarPorId(id);

        if (cliente.isPresent()) {
            System.out.println("\nCliente encontrado:");
            System.out.println(cliente.get());
        } else {
            System.out.println("\nCliente não encontrado.");
        }
    }

    private static void atualizarCliente(Scanner scanner, ClienteService service) {
        System.out.println("\n===== ATUALIZAR CLIENTE =====");
        int id = lerInteiro(scanner, "Digite o ID do cliente: ");
        String nome = lerTexto(scanner, "Novo nome: ");
        String email = lerTexto(scanner, "Novo e-mail: ");
        String telefone = lerTexto(scanner, "Novo telefone: ");

        boolean atualizado = service.atualizar(id, nome, email, telefone);

        if (atualizado) {
            System.out.println("\nCliente atualizado com sucesso!");
        } else {
            System.out.println("\nCliente não encontrado.");
        }
    }

    private static void removerCliente(Scanner scanner, ClienteService service) {
        System.out.println("\n===== REMOVER CLIENTE =====");
        int id = lerInteiro(scanner, "Digite o ID do cliente: ");

        if (service.remover(id)) {
            System.out.println("\nCliente removido com sucesso!");
        } else {
            System.out.println("\nCliente não encontrado.");
        }
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static String lerTexto(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }
}
