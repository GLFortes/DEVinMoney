package account;

import enums.Agencia;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

public class ContaCorrente extends Conta {
    @Getter @Setter private double cheque;
    public ContaCorrente(String nome, String CPF, double rendaMensal, int numeroConta, Agencia agencia) {
        super(nome, CPF, rendaMensal, numeroConta, agencia);
        this.cheque = getRendaMensal() * 0.5;
    }

    @Override
    public void sacar(double valor){
        Scanner scanner = new Scanner(System.in);
        if (valor > getSaldo()){
            System.out.println("Saldo insuficiente");
            System.out.println("Deseja sacar o cheque? (S/N)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("S")){
                if (valor >  getCheque()){
                    System.out.println("Saldo insuficiente");
                }else{
                    setSaldo(getSaldo() - valor);
                    setCheque(getCheque() - valor);
                }
            }else{
                System.out.println("Operação cancelada");
            }
        }
}
    @Override
    public String toString(){
        return "Conta{" +
                "nome='" + getNome() + '\'' +
                ", CPF='" + getCpf() + '\'' +
                ", rendaMensal=" + getRendaMensal() +
                ", numeroConta=" + getNumeroConta() +
                ", agencia=" + getAgencia() +
                ", saldo=" + saldo +
                ", cheque=" + cheque +
                '}';
    }
}
