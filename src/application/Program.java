package application;
import account.Conta;
import account.ContaCorrente;

import java.util.Scanner;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();
        plataforma.showMenu();
        String resposta = scanner.nextLine();
        while(!resposta.equals("4")){
            switch (resposta){
                case "1":
                    //Menu conta corrente
                    System.out.println("Bem-vindo à aba de correntistas. O que gostaria de fazer?");
                    System.out.println("1 - Cadastrar correntista");
                    System.out.println("2 - Listar correntistas");
                    System.out.println("3 - Buscar correntista");
                    System.out.println("4 - Voltar ao menu principal");
                    resposta = scanner.next();
                    if (resposta.equals("1")){
                        plataforma.cadastrarContaCorrente();
                    }else if (resposta.equals("2")){
                        plataforma.listarContasCorrentes();
                    }else if (resposta.equals("3")){
                        System.out.println("Buscar correntista. Digite o número do CPF da conta:");
                        String cpf = scanner.nextLine();
                        Conta contazord = plataforma.buscarContaCorrente(cpf);
                        if (plataforma.buscarContaCorrente(cpf) == null){
                            System.out.println("Conta não encontrada");
                        }else{
                            System.out.println("Qual operação deseja realizar?\n 1 - Depositar\n 2 - Sacar\n 3 - Transferir\n 4 - Voltar ao menu anterior");
                            resposta = scanner.next();
                            switch(resposta){
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
                            }
                        }

                    }


                    break;
                case "2":
                    System.out.println("O que gostaria de fazer?");
                    plataforma.relatorios();
                    plataforma.showMenu();
                    resposta = scanner.nextLine();
                    break;
                case "3":

                case "4":
                    break;
                default:
                    System.out.println("Opção inválida");
                    plataforma.showMenu();
                    resposta = scanner.nextLine();
                    break;

            }
        }System.out.println("Encerrando...");
    }
}
