package application;

import account.Conta;
import account.ContaCorrente;
import account.ContaInvestimento;
import account.ContaPoupanca;
import enums.Agencia;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static enums.Agencia.FLORIANOPOLIS;

public class Plataforma {
    Scanner scanner = new Scanner(System.in);
    HashSet<Conta> contas = new HashSet<Conta>();

    public void showMenu(){
        System.out.println("1 - Cadastrar Conta");
        System.out.println("2 - Listar Contas");
        System.out.println("3 - Sair");
    }
    public void validarCPF(String cpf){
        Pattern pattern = Pattern.compile("([0-9]{11})");
        Matcher matcher = pattern.matcher(cpf);
        if(matcher.matches()){
            System.out.println("CPF válido");
        }else{
            System.out.println("CPF inválido");
            System.out.println("Digite novamente");
            cpf = scanner.nextLine();
            validarCPF(cpf);
        }
    }

    public void cadastrarContaCorrente(){
        Agencia agencia = FLORIANOPOLIS;
        System.out.println("Digite o nome do titular da conta: ");
        String nome = scanner.next();
        System.out.println("Insira o cpf: ");
        String cpf = scanner.next();
        validarCPF(cpf);
        System.out.println("Insira a renda mensal:");
        double renda = scanner.nextDouble();
        contas.add(new ContaCorrente(nome, cpf, renda, 1, agencia));
        System.out.println("Conta cadastrada com sucesso");
    }

    public void relatorios(){
        System.out.println("1 - Listar todas as contas correntes");
        System.out.println("2 - Relatório de contas poupanças");
        System.out.println("3 - Relatório de contas de investimento");
        String opcao = scanner.next();
        try{
            switch (opcao){
                case "1":
                    System.out.println("Relatório de contas correntes");
                    listarContasCorrentes();
                    break;
                case "2":
                    System.out.println("Relatório de contas poupanças");
                    listarContasPoupança();
                    break;
                case "3":
                    System.out.println("Relatório de contas de investimento");
                    listarContasInvestimento();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }catch(Exception e){
            System.out.println("Opção inválida");
        }
    }
    public void listarContasCorrentes(){
        for(Conta conta : contas){
            if(conta instanceof ContaCorrente){
                System.out.println(conta);
            }
        }
    }
    public void listarContasPoupança(){
        for(Conta conta : contas){
            if(conta instanceof ContaPoupanca){
                System.out.println(conta);
            }
        }
    }
    public void listarContasInvestimento(){
        for(Conta conta : contas){
            if(conta instanceof ContaInvestimento){
                System.out.println(conta);
            }
        }
    }

}
