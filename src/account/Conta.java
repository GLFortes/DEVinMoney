package account;

import enums.Agencia;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Conta {
    @Getter @Setter(AccessLevel.PROTECTED) private LocalDateTime dia;
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
            setDia(LocalDateTime.now());
        transactions.add("Deposito de R$" + valor + " realizado no dia " + getDia());}
        else {
            System.out.println("Operação inválida");
        }
    }

    public void sacar(double valor) {
        if(getSaldo() >= valor){
            if (valor > 0) {
            saldo -= valor;
                setDia(LocalDateTime.now());
            transactions.add("Saque de R$" + valor + " realizado no dia " + getDia());}
            else {
                System.out.println("Operação inválida");
        }}
        else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void transferir(double valor, Conta conta) {
        if (valor > 0) {
            setDia(LocalDateTime.now());
        sacar(valor);
        conta.depositar(valor);
        transactions.add("Transferência de R$" + valor + " para a conta de " + conta.getNome() + " no dia " + getDia());}
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
 public void extrato(){
        if(transactions == null){
            System.out.println("Não há transações");
        }else{
     System.out.println("Transações da conta corrente: ");
     for (int i = 0; i < transactions.size(); i++) {
         System.out.println(transactions.get(i));}
     }
 }

}
