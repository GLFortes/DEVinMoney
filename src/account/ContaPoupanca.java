package account;

import enums.Agencia;

public class ContaPoupanca extends Conta{
    private static double rentabilidade = 0.05;

    public ContaPoupanca(String nome, String CPF, double rendaMensal, int numeroConta, Agencia agencia) {
        super(nome, CPF, rendaMensal, numeroConta, agencia);
    }

    public void simularRent(int meses){
        double saldo = this.getSaldo();
        for(int i = 0; i < meses; i++){
            saldo += saldo * rentabilidade;
        }
        this.setSaldo(saldo);
    }
        }