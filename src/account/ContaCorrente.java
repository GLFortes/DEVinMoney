package account;

import enums.Agencia;
import lombok.Getter;

import java.util.Scanner;

public class ContaCorrente extends Conta {
    @Getter private double cheque = saldo * 0.5;
    public ContaCorrente(String nome, String CPF, double rendaMensal, int numeroConta, Agencia agencia) {
        super(nome, CPF, rendaMensal, numeroConta, agencia);
    }

    @Override
    public void sacar(double valor){
        Scanner scanner = new Scanner(System.in);
        if (valor > getSaldo()){
            System.out.println("Saldo insuficiente");
            System.out.println("Você gostaria de utilizar o cheque especial? (S/N)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("S")){
                if (valor > getSaldo() + getCheque()){
                    System.out.println("Saldo insuficiente.");
                }else{
                    double saldoSaqueCheque = this.saldo + this.cheque;
                    this.cheque = this.cheque - (valor - getSaldo());
                    this.saldo = saldoSaqueCheque - valor;
                }
            }else{
                System.out.println("Encerrando operação...");
            }
        }
    }
}
