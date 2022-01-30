package account;

import enums.Agencia;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public abstract class Conta {

    @Getter @Setter(AccessLevel.PROTECTED) private String nome;
    @Getter @Setter(AccessLevel.PROTECTED) private String cpf;
    @Getter @Setter(AccessLevel.PROTECTED) private double rendaMensal;
    @Getter @Setter(AccessLevel.PROTECTED) private int numeroConta;
    @Getter @Setter(AccessLevel.PROTECTED) private Agencia agencia;
    @Getter @Setter(AccessLevel.PROTECTED) protected double saldo;
    @Getter @Setter(AccessLevel.PROTECTED) protected ArrayList<String> transactions = new ArrayList<String>();

    public Conta(String nome, String cpf, double rendaMensal, int numeroConta, Agencia agencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
        this.saldo += valor;
        transactions.add("Deposito de R$" + valor + " na conta de " + this.nome);}
        else {
            System.out.println("Operação inválida");
        }
    }

    public void sacar(double valor) {
        if (valor >= 0) {
        this.saldo -= valor;
        transactions.add("Saque de R$" + valor + " na conta de " + this.nome);}
        else {
            System.out.println("Operação inválida");
        }
    }

    public void transferir(double valor, Conta conta) {
        if (valor >= 0) {
        this.sacar(valor);
        conta.depositar(valor);}
        else {
            System.out.println("Operação inválida");
        }
    }

    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                ", rendaMensal=" + rendaMensal +
                ", numeroConta=" + numeroConta +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                '}';
    }

 //get all transactions
 public void getTransactions(){
     System.out.println("Transações da conta corrente: ");
     for (int i = 0; i < transactions.size(); i++) {
         System.out.println(transactions.get(i));
     }
 }
}
