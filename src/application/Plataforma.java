package application;

import account.Conta;
import account.ContaCorrente;
import account.ContaInvestimento;
import account.ContaPoupanca;
import enums.Agencia;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static enums.Agencia.FLORIANOPOLIS;
import static enums.Agencia.SAO_JOSE;

public class Plataforma {
    Scanner scanner = new Scanner(System.in);
    HashSet<Conta> contas = new HashSet<Conta>();

    public void showMenu(){
        System.out.println("1 - Correntista");
        System.out.println("2 - Poupança");
        System.out.println("3 - Investimento");
        System.out.println("4 - Sair");
    }

    public HashSet<Conta> getContas() {
        return contas;
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
        //selecionar agencia
        System.out.println("Selecione a agência: ");
        System.out.println("1 - Florianópolis");
        System.out.println("2 - São José");
        String agencia = scanner.next();
        Agencia agenciaSelecionada = null;
        try{
            switch (agencia){
                case "1":
                    agenciaSelecionada = FLORIANOPOLIS;
                    break;
                case "2":
                    agenciaSelecionada = SAO_JOSE;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        catch(Exception e){
            System.out.println("Opção inválida");
        }
        System.out.println("Digite o nome do titular da conta: ");
        String nome = scanner.next();
        System.out.println("Insira o cpf: ");
        String cpf = scanner.next();
        validarCPF(cpf);
        System.out.println("Insira a renda mensal:");
        double renda = scanner.nextDouble();
        int numeroConta = contas.size() + 1;
        contas.add(new ContaCorrente(nome, cpf, renda, numeroConta, agenciaSelecionada));
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

    //get accounts with negative balance
    public void getAccountsWithNegativeBalance(){
        for(Conta conta : contas){
            if(conta.getSaldo() < 0){
                System.out.println(conta);
            }
        }
    }

    //get total value of investment
    public void getTotalValueOfInvestment(){
        double total = 0;
        for(Conta conta : contas){
            if(conta instanceof ContaInvestimento){
                total += conta.getSaldo();
            }
        }
        System.out.println("Total de investimentos: " + total);
    }

    //search an account
    public Conta buscarContaCorrente(String cpf){
        for(Conta conta : contas){
            if(conta.getCpf().equals(cpf)){
                return conta;
            }
        }return null;
    }

    //Buscar conta pelo numero;
    public Conta buscarContaPorNumero(int numero){
        for(Conta conta : contas){
            if(conta.getNumeroConta() == numero){
                return conta;
            }
        }return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plataforma that = (Plataforma) o;
        return Objects.equals(scanner, that.scanner) && Objects.equals(contas, that.contas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scanner, contas);
    }
}
