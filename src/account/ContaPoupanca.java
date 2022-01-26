package account;

import enums.Agencia;

public class ContaPoupanca extends Conta{
    private double rentabilidade;

    public ContaPoupanca(String nome, String CPF, double rendaMensal, int numeroConta, Agencia agencia) {
        super(nome, CPF, rendaMensal, numeroConta, agencia);
    }
}
