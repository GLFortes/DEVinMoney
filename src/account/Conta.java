package account;

import enums.Agencia;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Conta {
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private LocalDateTime dia;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private LocalDateTime dataAgora = LocalDateTime.now();
    String dSemana = dataAgora.getDayOfWeek().toString();
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private String nome;
    @Getter
    private String cpf;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private double rendaMensal;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private int numeroConta;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private Agencia agencia;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    protected double saldo;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    //Cada conta criada terá um ArrayList que guarda todas movimentações
    protected ArrayList<String> transactions = new ArrayList<String>();

    public Conta(String nome, String cpf, double rendaMensal, int numeroConta, Agencia agencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }

    //Deposito
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado.");
            setDia(LocalDateTime.now());
            transactions.add("Deposito de R$" + valor + " realizado no dia " + getDia());
        } else {
            System.out.println("Operação inválida");

        }
    }

    //Saque
    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            if (valor > 0) {
                saldo -= valor;
                setDia(LocalDateTime.now());
                System.out.println("Saque realizado com sucesso!");
                transactions.add("Saque de R$" + valor + " realizado no dia " + getDia());
            } else {
                System.out.println("Operação inválida");
            }
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    //Transferencia
    public void transferir(double valor, Conta conta) {
        if (dSemana.equals("SUNDAY") || dSemana.equals("SATURDAY")) {
            System.out.println(("Operação inválida. Não é possível realizar depósitos nos finais de semana"));
        } else if (conta == this) {
            System.out.println("Operação inválida. Não é possível transferir para a mesma conta");
        } else {
            if (valor > 0) {
                setDia(LocalDateTime.now());
                sacar(valor);
                conta.depositar(valor);
                transactions.add("Transferência de R$" + valor + " para a conta de " + conta.getNome() + " no dia " + getDia());
            } else {
                System.out.println("Operação inválida");
            }
        }
    }


    public String toString() {
        return "Conta{" +
                "nome = '" + nome + '\'' +
                ", CPF = '" + cpf + '\'' +
                ", Renda Mensal =" + rendaMensal +
                ", Numero da Conta=" + numeroConta +
                ", Agencia=" + agencia +
                ", Saldo= R$" + saldo +
                '}';
    }

    //Extrato de transações
    public void extrato() {
        if (transactions == null) {
            System.out.println("Não há transações");
        } else {
            System.out.println("Transações da conta: ");
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println(transactions.get(i));
            }
        }
    }

}
