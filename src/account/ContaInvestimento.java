package account;

import enums.Agencia;

public class ContaInvestimento extends Conta {
    private double rendimento;
    public ContaInvestimento(String nome, String CPF, double rendaMensal, int numeroConta, Agencia agencia) {
        super(nome, CPF, rendaMensal, numeroConta, agencia);
    }
}
