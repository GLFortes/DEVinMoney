package account;

import enums.Agencia;
import enums.Investimentos;

import java.util.ArrayList;

public class ContaInvestimento extends Conta {
    private Investimentos investimento;

    public ContaInvestimento(String nome, String CPF, double rendaMensal, int numeroConta, Agencia agencia) {
        super(nome, CPF, rendaMensal, numeroConta, agencia);
    }

    //solicitar qual investimento
    public void investir(double valor, Investimentos investimento) {
        //não realizar operações no fim de semana

        if (valor > getSaldo()) {
            System.out.println("Saldo insuficiente");
        } else {
            if (investimento == Investimentos.CDB) {
                this.setSaldo(this.getSaldo() + valor * 0.15);
                transactions.add("Investimento CDB: R$" + valor);
            } else if (investimento == Investimentos.LCI) {
                this.setSaldo(this.getSaldo() + valor * 0.10);
                transactions.add("Investimento LCI: R$" + valor);
            } else if (investimento == Investimentos.LCA) {
                this.setSaldo(this.getSaldo() + valor * 0.05);
                transactions.add("Investimento LCA: R$" + valor);
            } else {
                System.out.println("Investimento não encontrado");
            }
        }

    }

}
