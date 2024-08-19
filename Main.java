import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar nova conta");
            System.out.println("2 - Listar contas a pagar");
            System.out.println("3 - Listar contas a receber");
            System.out.println("4 - Cadastrar pagamento");
            System.out.println("5 - Verificar se uma conta foi paga");
            System.out.println("6 - Listar contas em aberto");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a descrição da conta:");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite o valor da conta:");
                    double valor = scanner.nextDouble();
                    System.out.println("Essa conta é a pagar (0) ou a receber (1)?");
                    boolean ehReceber = scanner.nextInt() == 1;
                    usuario.cadastrarConta(descricao, valor, ehReceber);
                    System.out.println("Conta cadastrada com sucesso.");
                    break;

                case 2:
                    System.out.println("Contas a Pagar:");
                    List<Conta> contasAPagar = usuario.listarContasAPagar();
                    if (contasAPagar.isEmpty()) {
                        System.out.println("Nenhuma conta a pagar.");
                    } else {
                        for (Conta conta : contasAPagar) {
                            System.out.println(conta);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Contas a Receber:");
                    List<Conta> contasAReceber = usuario.listarContasAReceber();
                    if (contasAReceber.isEmpty()) {
                        System.out.println("Nenhuma conta a receber.");
                    } else {
                        for (Conta conta : contasAReceber) {
                            System.out.println(conta);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Digite a descrição da conta a pagar:");
                    String descricaoPagamento = scanner.nextLine();
                    usuario.cadastrarPagamento(descricaoPagamento);
                    break;

                case 5:
                    System.out.println("Digite a descrição da conta:");
                    String descricaoVerificar = scanner.nextLine();
                    boolean foiPaga = usuario.verificarSeContaFoiPaga(descricaoVerificar);
                    if (foiPaga) {
                        System.out.println("Conta já foi paga.");
                    } else {
                        System.out.println("Conta em aberto.");
                    }
                    break;

                case 6:
                    System.out.println("Contas em Aberto:");
                    List<Conta> contasEmAberto = usuario.listarContasEmAberto();
                    if (contasEmAberto.isEmpty()) {
                        System.out.println("Nenhuma conta em aberto.");
                    } else {
                        for (Conta conta : contasEmAberto) {
                            System.out.println(conta);
                        }
                    }
                    break;

                case 0:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}

