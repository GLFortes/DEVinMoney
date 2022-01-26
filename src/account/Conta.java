package account;

import enums.Agencia;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class Conta {
    @Getter @Setter(AccessLevel.PROTECTED) private String nome;
    @Getter @Setter(AccessLevel.PROTECTED) private String CPF;
    @Getter @Setter(AccessLevel.PROTECTED) private double rendaMensal;
    @Getter @Setter(AccessLevel.PROTECTED) private int numeroConta;
    @Getter @Setter(AccessLevel.PROTECTED) private Agencia agencia;
    @Getter protected double saldo;

    public Conta(String nome, String CPF, double rendaMensal, int numeroConta, Agencia agencia) {
        this.nome = nome;
        this.CPF = CPF;
        this.rendaMensal = rendaMensal;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        this.saldo -= valor;
    }

    public void transferir(double valor, Conta conta) {
        this.sacar(valor);
        conta.depositar(valor);
    }

    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", rendaMensal=" + rendaMensal +
                ", numeroConta=" + numeroConta +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                '}';
    }


}
