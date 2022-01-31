package application;

import account.Conta;
import account.ContaCorrente;
import account.ContaInvestimento;
import account.ContaPoupanca;
import enums.Agencia;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static enums.Agencia.FLORIANOPOLIS;
import static enums.Agencia.SAO_JOSE;

public class Plataforma {
    LocalDateTime data;
    Scanner scanner = new Scanner(System.in);
    HashSet<Conta> contas = new HashSet<>();
    List<List<String>> todasTransacoes = Collections.singletonList(new ArrayList<String>());

    public void adicionaConta(Conta conta) {
        contas.add(conta);
    }


    public void showMenu() {
        System.out.println("1 - Correntista");
        System.out.println("2 - Poupança");
        System.out.println("3 - Investimento");
        System.out.println("4 - Menu Administrador");
        System.out.println("5 - Sair");
    }

    public HashSet<Conta> getContas() {
        return contas;
    }

    public void validarCPF(String cpf) {
        Pattern pattern = Pattern.compile("([0-9]{11})");
        Matcher matcher = pattern.matcher(cpf);
        if (matcher.matches()) {
            System.out.println("CPF válido");
        } else {
            System.out.println("CPF inválido");
            System.out.println("Digite novamente");
            cpf = scanner.nextLine();
            validarCPF(cpf);
        }
    }

    public void cadastrarContaCorrente() {
        //selecionar agencia
        boolean agenciaLoop = true;
        System.out.println("Selecione a agência: ");
        System.out.println("1 - Florianópolis");
        System.out.println("2 - São José");
        String agencia = scanner.nextLine();
        Agencia agenciaSelecionada = null;
        while(agenciaLoop){
        switch (agencia) {
                case "1":
                    agenciaSelecionada = FLORIANOPOLIS;
                    agenciaLoop = false;
                    break;
                case "2":
                    agenciaSelecionada = SAO_JOSE;
                    agenciaLoop = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("Selecione a agência: ");
                    System.out.println("1 - Florianópolis");
                    System.out.println("2 - São José");
                    agencia = scanner.nextLine();
                    break;
            }}
        System.out.println("Digite o nome do titular da conta: ");
        String nome = scanner.nextLine();
        System.out.println("Insira o cpf: ");
        String cpf = scanner.nextLine();
        validarCPF(cpf);
        System.out.println("Insira a renda mensal:");
        double renda = scanner.nextDouble();
        scanner.nextLine();
        int numeroConta = contas.size() + 1;
        contas.add(new ContaCorrente(nome, cpf, renda, numeroConta, agenciaSelecionada));
        System.out.println("Conta cadastrada com sucesso");
    }

    public void cadastrarContaPoupanca() {
        //selecionar agencia
        boolean agenciaLoop = true;
        System.out.println("Selecione a agência: ");
        System.out.println("1 - Florianópolis");
        System.out.println("2 - São José");
        String agencia = scanner.nextLine();
        Agencia agenciaSelecionada = null;
        while(agenciaLoop){
            switch (agencia) {
                case "1":
                    agenciaSelecionada = FLORIANOPOLIS;
                    agenciaLoop = false;
                    break;
                case "2":
                    agenciaSelecionada = SAO_JOSE;
                    agenciaLoop = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("Selecione a agência: ");
                    System.out.println("1 - Florianópolis");
                    System.out.println("2 - São José");
                    agencia = scanner.nextLine();
                    break;
            }}
        System.out.println("Digite o nome do titular da conta: ");
        String nome = scanner.nextLine();
        System.out.println("Insira o cpf: ");
        String cpf = scanner.nextLine();
        validarCPF(cpf);
        System.out.println("Insira a renda mensal:");
        double renda = scanner.nextDouble();
        scanner.nextLine();
        int numeroConta = contas.size() + 1;
        contas.add(new ContaPoupanca(nome, cpf, renda, numeroConta, agenciaSelecionada));
        System.out.println("Conta cadastrada com sucesso");
    }

    public void cadastrarContaInvestimento() {
        //selecionar agencia
        boolean agenciaLoop = true;
        System.out.println("Selecione a agência: ");
        System.out.println("1 - Florianópolis");
        System.out.println("2 - São José");
        String agencia = scanner.nextLine();
        System.out.println("");
        Agencia agenciaSelecionada = null;
        while(agenciaLoop){
            switch (agencia) {
                case "1":
                    agenciaSelecionada = FLORIANOPOLIS;
                    agenciaLoop = false;
                    break;
                case "2":
                    agenciaSelecionada = SAO_JOSE;
                    agenciaLoop = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("Selecione a agência: ");
                    System.out.println("1 - Florianópolis");
                    System.out.println("2 - São José");
                    agencia = scanner.nextLine();
                    break;
            }}
        System.out.println("Digite o nome do titular da conta: ");
        String nome = scanner.nextLine();
        System.out.println("Insira o cpf: ");
        String cpf = scanner.nextLine();
        validarCPF(cpf);
        System.out.println("Insira a renda mensal:");
        double renda = scanner.nextDouble();
        scanner.nextLine();
        int numeroConta = contas.size() + 1;
        contas.add(new ContaInvestimento(nome, cpf, renda, numeroConta, agenciaSelecionada));
        System.out.println("Conta cadastrada com sucesso");
    }

    public void listarContasCorrentes() {
        for (Conta conta : contas) {
            if (conta instanceof ContaCorrente) {
                System.out.println(conta);
            }
        }
    }

    public void listarContasPoupanca() {
        for (Conta conta : contas) {
            if (conta instanceof ContaPoupanca) {
                System.out.println(conta);
            }
        }
    }

    public void listarContasInvestimento() {
        for (Conta conta : contas) {
            if (conta instanceof ContaInvestimento) {
                System.out.println(conta);
            }
        }
    }

    public void listarContas() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    //get accounts with negative balance
    public void getAccountsWithNegativeBalance() {
        for (Conta conta : contas) {
            if (conta.getSaldo() < 0) {
                System.out.println(conta);
            }
        }
    }

    //get total value of investment
    public void getTotalValueOfInvestment() {
        double total = 0;
        for (Conta conta : contas) {
            if (conta instanceof ContaInvestimento) {
                total += conta.getSaldo();
            }
        }
        System.out.println("Total de investimentos: " + total);
    }

    //search an account
    public Conta buscarContaCPF(String cpf) {
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf)) {
                return conta;
            }
        }
        return null;
    }

    //Buscar conta pelo numero;
    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numero) {
                return conta;
            }
        }
        return null;
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

    public void showMenuCorrente() {
        System.out.println("Qual operação deseja realizar?\n 1 - Depositar\n 2 - Sacar\n 3 - Transferir\n 4 - Extrato de transações\n 5 - Sair");

    }

    public void showMenuInvest() {
        System.out.println("Escolha uma das opções:\n 1 - Sacar\n 2 - Depositar\n 3 - Transferir\n 4 - Extrato\n 5 - Investir\n 6 - Sair");

    }

    public void showMenuPoup() {
        System.out.println("Escolha uma das opções:\n 1 - Sacar\n 2 - Depositar\n 3 - Transferir\n 4 - Extrato\n 5 - Verificar rentabilidade\n 6 - Sair");
    }

    public void showMenuRelatorios() {
        System.out.println("1 - Relatório de Contas Corrente\n 2 - Relatório de Contas Poupança\n 3 - Relatório de Contas Investimento\n 4 - Relatório de todas as Contas\n 5 - Relatório de contas com saldo negativo \n 6 - Relatório total de investimentos\n 7 - Sair");
    }

    public void historicoTransferencias(Conta origem, Conta destino, double valor) {


    }
}


