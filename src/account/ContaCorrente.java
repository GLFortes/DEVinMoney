package account;

import enums.Agencia;
import lombok.Getter;

public class ContaCorrente extends Conta {
    @Getter private double cheque;
    public ContaCorrente(String nome, String CPF, double rendaMensal, int numeroConta, Agencia agencia) {
        super(nome, CPF, rendaMensal, numeroConta, agencia);
    }

}
