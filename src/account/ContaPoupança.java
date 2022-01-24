package account;

import enums.Agencia;

public class ContaPoupança extends Conta{
    private double rentabilidade;

    public ContaPoupança(String nome, String CPF, double rendaMensal, int numeroConta, Agencia agencia) {
        super(nome, CPF, rendaMensal, numeroConta, agencia);
    }
}
