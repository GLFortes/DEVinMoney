package application;
import account.Conta;
import account.ContaCorrente;
import account.ContaInvestimento;
import account.ContaPoupanca;

import java.util.Scanner;

import static enums.Agencia.FLORIANOPOLIS;
import static enums.Agencia.SAO_JOSE;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();
        ContaCorrente conta1 = new ContaCorrente("João da Silva", "12365489710", 3500, 1, FLORIANOPOLIS);
        plataforma.adicionaConta(conta1);
        ContaPoupanca conta2 = new ContaPoupanca("Maria da Silva", "12365489711", 3500, 2, SAO_JOSE);
        plataforma.adicionaConta(conta2);
        ContaInvestimento conta3 = new ContaInvestimento("José da Silva", "12365489712", 3500, 3, FLORIANOPOLIS);
        plataforma.adicionaConta(conta3);
        plataforma.showMenu();
        String resposta = scanner.nextLine();
        System.out.println("");
        while(!resposta.equals("4")){
            switch (resposta){
                case "1":
                    //Menu conta corrente
                    System.out.println("Bem-vindo à aba de correntistas. O que gostaria de fazer?");
                    System.out.println("1 - Cadastrar correntista");
                    System.out.println("2 - Listar correntistas");
                    System.out.println("3 - Buscar correntista");
                    System.out.println("4 - Voltar ao menu principal");
                    String resposta2 = scanner.nextLine();
                    System.out.println("");
                    switch (resposta2){
                        case "1":
                            plataforma.cadastrarContaCorrente();
                            System.out.println("");
                            break;
                        case "2":
                            plataforma.listarContasCorrentes();
                            System.out.println("");
                            break;
                        case "3":
                            System.out.println("Buscar correntista. Digite o número do CPF da conta:");
                            String cpf = scanner.next();
                            Conta contazord = plataforma.buscarContaCorrente(cpf);
                            if (plataforma.buscarContaCorrente(cpf) == null){
                                System.out.println("Conta não encontrada");
                            }else{
                                System.out.println("Qual operação deseja realizar?\n 1 - Depositar\n 2 - Sacar\n 3 - Transferir\n 4 - Extrato de transações\n 5 - Sair");
                                String resposta3 = scanner.next();
                                switch(resposta3){
                                    case "1":
                                        System.out.println("Digite o valor a ser depositado:");
                                        double valor = scanner.nextDouble();
                                        contazord.depositar(valor);
                                        break;
                                    case "2":
                                        System.out.println("Digite o valor a ser sacado:");
                                        valor = scanner.nextDouble();
                                        contazord.sacar(valor);
                                        break;
                                    case "3":
                                        System.out.println("Digite o número da conta a ser transferido:");
                                        int numeroConta = scanner.nextInt();
                                        Conta contaTransf = plataforma.buscarContaPorNumero(numeroConta);
                                        if (contaTransf == null){
                                            System.out.println("Conta não encontrada");
                                        }else{
                                            System.out.println("Digite o valor a ser transferido:");
                                            valor = scanner.nextDouble();
                                            contazord.transferir(valor, contaTransf);
                                        }
                                        break;
                                    case "4":
                                        contazord.extrato();
                                    case "5":
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        break;
                                }
                            }
                            break;
                        case "4":
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    System.out.println("");
                    break;

                case "2":
                    System.out.println("Setor dos poupançudos. O que você deseja fazer?\n 1 - Cadastrar poupança\n 2 - Listar poupançudos\n 3 - Buscar poupança\n 4 - Sair");
                    resposta2 = scanner.nextLine();
                    switch (resposta2){
                        case "1":
                            plataforma.cadastrarContaPoupanca();
                            System.out.println("");
                            break;
                        case "2":
                            plataforma.listarContasPoupanca();
                            System.out.println("");
                            break;
                        case "3":
                            System.out.println("Buscar poupança. Digite o número da conta:");
                            int numeroContaPoup = scanner.nextInt();
                            Conta contaPoup = plataforma.buscarContaPorNumero(numeroContaPoup);
                            if (contaPoup == null){
                                System.out.println("Conta não encontrada");
                            }else{
                                System.out.println("Escolha uma das opções:\n 1 - Sacar\n 2 - Depositar\n 3 - Transferir\n 4 - Extrato\n 5 - Sair");
                                String resposta3 = scanner.next();
                                switch(resposta3){
                                    case "1":
                                        System.out.println("Digite o valor a ser sacado:");
                                        double valor = scanner.nextDouble();
                                        contaPoup.sacar(valor);
                                        break;
                                    case "2":
                                        System.out.println("Digite o valor a ser depositado:");
                                        valor = scanner.nextDouble();
                                        contaPoup.depositar(valor);
                                        break;
                                    case "3":
                                        System.out.println("Digite o número da conta a ser transferido:");
                                        int numeroConta = scanner.nextInt();
                                        Conta contaTransf = plataforma.buscarContaPorNumero(numeroConta);
                                        if (contaTransf == null){
                                            System.out.println("Conta não encontrada");
                                        }else{
                                            System.out.println("Digite o valor a ser transferido:");
                                            valor = scanner.nextDouble();
                                            contaPoup.transferir(valor, contaTransf);
                                        }
                                        break;
                                    case "4":
                                        contaPoup.extrato();
                                        break;
                                    case "5":
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                }

                            }
                    }
                    break;

                case "3":
                    System.out.println("Sessão de investimentos. O que você deseja fazer?\n 1 - Cadastrar investimento\n 2 - Listar investimentos\n 3 - Buscar investimento\n 4 - Sair");
                    resposta2 = scanner.nextLine();
                    switch (resposta2){
                        case "1":
                            plataforma.cadastrarContaInvestimento();
                            System.out.println("");
                            break;
                        case "2":
                            plataforma.listarContasInvestimento();
                            System.out.println("");
                            break;
                        case "3":
                            System.out.println("Informe o número da conta à ser buscada:");
                            int numeroContaInv = scanner.nextInt();
                            Conta contaInv = plataforma.buscarContaPorNumero(numeroContaInv);
                            if (contaInv == null){
                                System.out.println("Conta não encontrada");
                            }else{
                                System.out.println("Escolha uma das opções:\n 1 - Sacar\n 2 - Depositar\n 3 - Transferir\n 4 - Extrato\n 5 - Investir\n 6 - Sair");
                                String resposta3 = scanner.next();
                                switch(resposta3){
                                    case "1":
                                        System.out.println("Digite o valor a ser sacado:");
                                        double valor = scanner.nextDouble();
                                        contaInv.sacar(valor);
                                        break;
                                    case "2":
                                        System.out.println("Digite o valor a ser depositado:");
                                        valor = scanner.nextDouble();
                                        contaInv.depositar(valor);
                                        break;
                                    case "3":
                                        System.out.println("Digite o número da conta a ser transferido:");
                                        int numeroConta3 = scanner.nextInt();
                                        Conta contaTransf = plataforma.buscarContaPorNumero(numeroConta3);
                                        if (contaTransf == null){
                                            System.out.println("Conta não encontrada");
                                        }else{
                                            System.out.println("Digite o valor a ser transferido:");
                                            valor = scanner.nextDouble();
                                            contaInv.transferir(valor, contaTransf);
                                        }
                                }
                            }
                    }

                case "4":
                    break;
                default:
                    System.out.println("Opção inválida");
                    plataforma.showMenu();
                    resposta2 = scanner.nextLine();
                    break;

            }
        }System.out.println("Encerrando...");
    }
}
