package application;

import account.Conta;
import account.ContaCorrente;
import account.ContaInvestimento;
import account.ContaPoupanca;
import enums.Investimentos;

import java.util.InputMismatchException;
import java.util.Scanner;

import static enums.Agencia.FLORIANOPOLIS;
import static enums.Agencia.SAO_JOSE;

public class Program {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Plataforma plataforma = new Plataforma();
            double valorInvestido = 0;
            ContaCorrente conta1 = new ContaCorrente("João da Silva", "12365489710", 3500, 1, FLORIANOPOLIS);
            plataforma.adicionaConta(conta1);
            ContaPoupanca conta2 = new ContaPoupanca("Maria da Silva", "12365489711", 3500, 2, SAO_JOSE);
            plataforma.adicionaConta(conta2);
            ContaInvestimento conta3 = new ContaInvestimento("José da Silva", "12365489712", 3500, 3, FLORIANOPOLIS);
            conta3.depositar(30000);
            plataforma.adicionaConta(conta3);
            plataforma.showMenu();
            String resposta = scanner.next();
            System.out.println("");
            while (!resposta.equals("5")) {
                //Switch opções
                switch (resposta) {
                    case "1":
                        //Menu conta corrente
                        System.out.println("Setor de correntistas. Seleciona uma das opções abaixo: \n 1 - Cadastrar Correntista\n 2 - Listar correntistas \n3 - Buscar correntista e realizar operações\n4 - Menu anterior");
                        String resposta2 = scanner.next();
                        System.out.println("");
                        if (resposta2.equals("4")) {
                            plataforma.showMenu();
                            resposta = scanner.next();
                        } else {
                            //Switch menu conta corrente
                            switch (resposta2) {
                                case "1":
                                    plataforma.cadastrarContaCorrente();
                                    break;
                                case "2":
                                    plataforma.listarContasCorrentes();
                                    break;
                                case "3":
                                    System.out.println("Buscar correntista. Digite o número do CPF da conta:");
                                    String cpf = scanner.next();
                                    ContaCorrente contaCorrente = (ContaCorrente) plataforma.buscarContaCPF(cpf);
                                    if (plataforma.buscarContaCPF(cpf) == null) {
                                        System.out.println("Conta não encontrada");
                                    } else {
                                        plataforma.showMenuCorrente();
                                        String resposta3 = scanner.next();
                                        switch (resposta3) {
                                            case "1":
                                                //DEPÓSITOS
                                                System.out.println("Digite o valor a ser depositado:");
                                                double valor = scanner.nextDouble();
                                                contaCorrente.depositar(valor);
                                                break;
                                            case "2":
                                                //SAQUE
                                                System.out.println("Digite o valor a ser sacado:");
                                                valor = scanner.nextDouble();
                                                contaCorrente.sacar(valor);
                                                break;
                                            case "3":
                                                //TRANSFERENCIA
                                                System.out.println("Digite o número da conta a ser transferido:");
                                                int numeroConta = scanner.nextInt();
                                                scanner.nextLine();
                                                Conta contaTransf = plataforma.buscarContaPorNumero(numeroConta);
                                                if (contaTransf == null) {
                                                    System.out.println("Conta não encontrada");
                                                } else {
                                                    System.out.println("Digite o valor a ser transferido:");
                                                    valor = scanner.nextDouble();
                                                    contaCorrente.transferir(valor, contaTransf);
                                                }
                                                break;
                                            case "4":
                                                //EXTRATO
                                                contaCorrente.extrato();
                                                break;
                                            case "5":
                                                break;
                                            default:
                                                System.out.println("Opção inválida");
                                                break;
                                        }//fim switch resposta3
                                    }//fim while resposta3
                                    break;

                                case "4":
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                                    break;
                            }//Fim do switch conta corrente
                        }//Fim do if conta corrente
                        break;

                    //Conta Poupança
                    case "2":
                        System.out.println("Setor de contas-poupança. Selecione uma das opções abaixo:\n 1 - Cadastrar conta-poupança\n 2 - Listar contas-poupança\n 3 - Buscar conta-poupança e realizar operações\n 4 - Menu anterior");
                        resposta2 = scanner.next();
                        if (resposta2.equals("4")) {
                            plataforma.showMenu();
                            resposta = scanner.next();
                        } else {
                            switch (resposta2) {
                                //Cadastrar conta poupança
                                case "1":
                                    plataforma.cadastrarContaPoupanca();
                                    break;
                                //Listar contas poupança
                                case "2":
                                    plataforma.listarContasPoupanca();
                                    break;
                                //Buscar conta poupança e realizar operações como saque, deposito, transferência e extrato
                                case "3":
                                    System.out.println("Buscar poupança. Digite o CPF do poupançudo:");
                                    String cpf = scanner.next();
                                    ContaPoupanca contaPoup = (ContaPoupanca) plataforma.buscarContaCPF(cpf);
                                    if (plataforma.buscarContaCPF(cpf) == null) {
                                        System.out.println("Conta não encontrada");
                                    } else {
                                        plataforma.showMenuPoup();
                                        String resposta3 = scanner.next();
                                        switch (resposta3) {
                                            //Saque
                                            case "1":
                                                System.out.println("Digite o valor a ser sacado:");
                                                double valor = scanner.nextDouble();
                                                contaPoup.sacar(valor);
                                                break;
                                            //Depósito
                                            case "2":
                                                System.out.println("Digite o valor a ser depositado:");
                                                valor = scanner.nextDouble();
                                                contaPoup.depositar(valor);
                                                break;
                                            //Transferência
                                            case "3":
                                                System.out.println("Digite o número da conta a ser transferido:");
                                                int numeroConta = scanner.nextInt();
                                                scanner.nextLine();
                                                Conta contaTransf = plataforma.buscarContaPorNumero(numeroConta);
                                                if (contaTransf == null) {
                                                    System.out.println("Conta não encontrada");
                                                } else {
                                                    System.out.println("Digite o valor a ser transferido:");
                                                    valor = scanner.nextDouble();
                                                    contaPoup.transferir(valor, contaTransf);
                                                }
                                                break;
                                            //Extrato da conta
                                            case "4":
                                                contaPoup.extrato();
                                                break;
                                            //Consultar rentabilidade
                                            case "5":
                                                System.out.println("Você gostaria de saber a rentabilidade da sua poupança em quantos meses?");
                                                int meses = scanner.nextInt();
                                                scanner.nextLine();
                                                contaPoup.simularRent(meses);
                                                break;
                                            //Voltar ao menu principal
                                            case "6":
                                                break;
                                            //Mensagem de erro caso o usuário digite uma opção inválida
                                            default:
                                                System.out.println("Opção inválida");
                                                break;
                                        }
                                    }
                                    break;
                                //Voltar ao menu principal
                                case "4":
                                    break;
                                //Mensagem de erro caso o usuário digite uma opção inválida
                                default:
                                    System.out.println("Opção inválida");
                                    break;
                            }
                        }
                        break;

                    //Case conta investimento
                    case "3":
                        System.out.println("Setor de investimentos. Selecione uma das opções abaixo:\n 1 - Cadastrar conta-investimento\n 2 - Listar contas-investimento\n 3 - Buscar conta-investimento e realizar operações\n 4 - Menu anterior");
                        resposta2 = scanner.next();
                        if (resposta2.equals("4")) {
                            plataforma.showMenu();
                            resposta = scanner.next();
                        } else {
                            switch (resposta2) {
                                //Cadastrar conta investimento
                                case "1":
                                    plataforma.cadastrarContaInvestimento();
                                    break;
                                //Listar contas investimento
                                case "2":
                                    plataforma.listarContasInvestimento();
                                    break;
                                //Buscar conta investimento e realizar operações
                                case "3":
                                    System.out.println("Informe o cpf da conta à ser buscada:");
                                    String cpf = scanner.next();
                                    ContaInvestimento contaInv = (ContaInvestimento) plataforma.buscarContaCPF(cpf);
                                    if (plataforma.buscarContaCPF(cpf) == null) {
                                        System.out.println("Conta não encontrada");
                                    } else {
                                        System.out.println("Escolha uma das opções:\n 1 - Sacar\n 2 - Depositar\n 3 - Transferir\n 4 - Extrato\n 5 - Investir\n 6 - Menu anterior");
                                        String resposta3 = scanner.next();
                                        switch (resposta3) {
                                            //Sacar
                                            case "1":
                                                System.out.println("Digite o valor a ser sacado:");
                                                double valor = scanner.nextDouble();
                                                contaInv.sacar(valor);
                                                break;
                                            //Depositar
                                            case "2":
                                                System.out.println("Digite o valor a ser depositado:");
                                                valor = scanner.nextDouble();
                                                contaInv.depositar(valor);
                                                break;
                                            //Transferir
                                            case "3":
                                                System.out.println("Digite o número da conta a ser transferido:");
                                                int numeroConta3 = scanner.nextInt();
                                                scanner.nextLine();
                                                Conta contaTransf = plataforma.buscarContaPorNumero(numeroConta3);
                                                if (contaTransf == null) {
                                                    System.out.println("Conta não encontrada");
                                                } else {
                                                    System.out.println("Digite o valor a ser transferido:");
                                                    valor = scanner.nextDouble();
                                                    contaInv.transferir(valor, contaTransf);
                                                }
                                                break;
                                            //Extrato
                                            case "4":
                                                contaInv.extrato();
                                                break;
                                            //Investir
                                            case "5":
                                                System.out.println("Investimento disponíveis: LCA, CDB e LCI");
                                                System.out.println("Digite o valor a ser investido:");
                                                valor = scanner.nextDouble();
                                                System.out.println("Digite o tipo de investimento:");
                                                String tipo = scanner.next();
                                                contaInv.investir(valor, Investimentos.valueOf(tipo));
                                                valorInvestido += valor;
                                                break;
                                            //Menu anterior
                                            case "6":
                                                break;
                                            //Mensagem de erro
                                            default:
                                                System.out.println("Opção inválida");
                                                break;
                                        }
                                    }
                                    break;
                                //Menu de conta corrente
                                case "4":
                                    break;
                                //Menu de conta poupança
                                default:
                                    System.out.println("Opção inválida");
                                    break;
                            }
                        }
                        break;

                    //Menu do ADM
                    case "4":
                        System.out.println("Setor adminstrativo. Selecione uma das opções abaixo:");
                        plataforma.showMenuRelatorios();
                        resposta2 = scanner.next();
                        if (resposta2.equals("7")) {
                            plataforma.showMenu();
                            resposta = scanner.next();
                        } else {
                            switch (resposta2) {
                                //Relatório de clientes com conta corrente
                                case "1":
                                    System.out.println("Relatório de contas correntes:");
                                    plataforma.listarContasCorrentes();
                                    break;
                                //Relatório de clientes com conta poupança
                                case "2":
                                    System.out.println("Relatório de contas poupanças:");
                                    plataforma.listarContasPoupanca();
                                    break;
                                //Relatório de clientes com conta investimento
                                case "3":
                                    System.out.println("Relatório de contas investimento:");
                                    plataforma.listarContasInvestimento();
                                    break;
                                //Relatório de clientes com conta corrente, poupança e investimento
                                case "4":
                                    System.out.println("Relatório de todas as contas:");
                                    plataforma.listarContas();
                                    break;
                                //Relatório de clientes com saldo negativo
                                case "5":
                                    System.out.println("Relatorio de contas com saldo negativo: ");
                                    plataforma.getAccountsWithNegativeBalance();
                                    break;
                                //Total investido dentro da plataforma
                                case "6":
                                    System.out.println("Total de valor investido: R$" + valorInvestido);
                                    break;
                                //Menu anterior
                                case "7":
                                    break;
                                //Mensagem de erro
                                default:
                                    System.out.println("Opção inválida");
                                    break;
                            }
                        }
                        break;

                    //Opção que encerra o programa
                    case "5":
                        break;
                    //Mensagem de erro
                    default:
                        System.out.println("Opção inválida");
                        break;

                }//fim switch resposta
            }
            System.out.println("Encerrando...");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Encerrando... ");
        }
    }
}
