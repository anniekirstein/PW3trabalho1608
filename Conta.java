public class Conta {
    private String descricao;
    private double valor;
    private boolean paga;
    private boolean ehReceber; // true se é uma conta a receber, false se é uma conta a pagar

    public Conta(String descricao, double valor, boolean ehReceber) {
        this.descricao = descricao;
        this.valor = valor;
        this.paga = false;
        this.ehReceber = ehReceber;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public boolean isPaga() {
        return paga;
    }

    public void pagar() {
        this.paga = true;
    }

    public boolean isEhReceber() {
        return ehReceber;
    }

    @Override
    public String toString() {
        return descricao + " - Valor: " + valor + " - " + (paga ? "Paga" : "Em Aberto");
    }
}
