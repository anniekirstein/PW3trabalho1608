import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private List<Conta> contas;

    public Usuario() {
        contas = new ArrayList<>();
    }

    public void cadastrarConta(String descricao, double valor, boolean ehReceber) {
        Conta novaConta = new Conta(descricao, valor, ehReceber);
        contas.add(novaConta);
    }

    public List<Conta> listarContasAPagar() {
        List<Conta> contasAPagar = new ArrayList<>();
        for (Conta conta : contas) {
            if (!conta.isEhReceber()) {
                contasAPagar.add(conta);
            }
        }
        return contasAPagar;
    }

    public List<Conta> listarContasAReceber() {
        List<Conta> contasAReceber = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.isEhReceber()) {
                contasAReceber.add(conta);
            }
        }
        return contasAReceber;
    }

    public void cadastrarPagamento(String descricao) {
        for (Conta conta : contas) {
            if (conta.getDescricao().equalsIgnoreCase(descricao) && !conta.isPaga()) {
                conta.pagar();
                System.out.println("Pagamento realizado com sucesso para a conta: " + descricao);
                return;
            }
        }
        System.out.println("Conta não encontrada ou já foi paga.");
    }

    public boolean verificarSeContaFoiPaga(String descricao) {
        for (Conta conta : contas) {
            if (conta.getDescricao().equalsIgnoreCase(descricao)) {
                return conta.isPaga();
            }
        }
        System.out.println("Conta não encontrada.");
        return false;
    }

    public List<Conta> listarContasEmAberto() {
        List<Conta> contasEmAberto = new ArrayList<>();
        for (Conta conta : contas) {
            if (!conta.isPaga()) {
                contasEmAberto.add(conta);
            }
        }
        return contasEmAberto;
    }
}

