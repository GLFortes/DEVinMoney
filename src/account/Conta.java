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
    @Getter private double saldo;

    public Conta(String nome, String CPF, double rendaMensal, int numeroConta, Agencia agencia) {
        this.nome = nome;
        this.CPF = CPF;
        this.rendaMensal = rendaMensal;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }

}
