package application;

import account.Conta;
import account.ContaCorrente;
import enums.Agencia;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static enums.Agencia.FLORIANOPOLIS;

public class Plataforma {

    HashSet<Conta> contas = new HashSet<Conta>();
    public void menu(){
        System.out.println("1 - Cadastrar Conta");
        System.out.println("2 - Listar Contas");
        System.out.println("3 - Sair");
    }
    public void validarCPF(String cpf){
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do titular da conta");
        String nome = scanner.nextLine();
        System.out.println("Insira o cpf:");
        String cpf = scanner.nextLine();
        validarCPF(cpf);
        System.out.println("Insira a renda mensal:");
        double renda = scanner.nextDouble();
        contas.add(new ContaCorrente(nome, cpf, renda, 1, agencia));

    }
    public void relatorios(){
        System.out.println("1 - Listar todas as contas correntes");
        System.out.println("2 - Relatório de contas poupanças");
        System.out.println("3 - Relatório de contas de investimento");
        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();
        try{
            switch (opcao){
                case "1":
                    System.out.println("Relatório de contas correntes");
                    break;
                case "2":
                    System.out.println("Relatório de contas poupanças");
                    break;
                case "3":
                    System.out.println("Relatório de contas de investimento");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }catch(Exception e){
            System.out.println("Opção inválida");
        }
    }

}
