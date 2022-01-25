package application;

import account.Conta;
import account.ContaCorrente;
import enums.Agencia;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static enums.Agencia.FLORIANOPOLIS;

public class Program {
    HashSet<Conta> contas = new HashSet<Conta>();
    public void menu(){
        System.out.println("1 - Cadastrar Conta");
        System.out.println("2 - Listar Contas");
        System.out.println("3 - Sair");
    }
    public void cadastrarContaCorrente(){
        Agencia agencia = FLORIANOPOLIS;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do titular da conta");
        String nome = scanner.nextLine();
        System.out.println("Insira o cpf:");
        String cpf = scanner.nextLine();
        Pattern pattern = Pattern.compile("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}");
        Matcher matcher = pattern.matcher(cpf);
        do{
            System.out.println("Insira o cpf:");
            cpf = scanner.nextLine();
        }while(!matcher.matches());
        System.out.println("Insira a renda mensal:");
        double renda = scanner.nextDouble();

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Program program = new Program();
        program.menu();
        String resposta = scanner.nextLine();
        while(!resposta.equals("3")){
            switch (resposta){
                case "1":
                    program.cadastrarContaCorrente();
                    break;
                case "2":
                    System.out.println("O que gostaria de fazer?");
                    program.relatorios();
                    break;
                case "3":
                    System.out.println("Saindo...");
                    break;
                default:
                    program.menu();
                    System.out.println("Opção inválida");
                    break;

            }
        }
    }
}
