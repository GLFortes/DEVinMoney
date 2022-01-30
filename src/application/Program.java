package application;
import account.Conta;
import account.ContaCorrente;
import account.ContaInvestimento;
import account.ContaPoupanca;
import enums.Investimentos;

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
            //Switch opções
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
                    if (resposta2.equals("4")) {
                    plataforma.showMenu();
                    resposta = scanner.nextLine();
                }else{
                    System.out.println("");
                    //Switch menu conta corrente
                    switch (resposta2){
                        case "1":
                            plataforma.cadastrarContaCorrente();
                            System.out.print("");
                            break;
                        case "2":
                            plataforma.listarContasCorrentes();
                            System.out.print("");
                            break;
                        case "3":
                            System.out.println("Buscar correntista. Digite o número do CPF da conta:");
                            String cpf = scanner.next();
                            ContaCorrente contazord = (ContaCorrente)plataforma.buscarContaCPF(cpf);
                            if (plataforma.buscarContaCPF(cpf) == null){
                                System.out.println("Conta não encontrada");
                            }else {
                                plataforma.showMenuCorrente();
                                String resposta3 = scanner.next();
                                switch (resposta3) {
                                    case "1":
                                        //DEPÓSITOS
                                        System.out.println("Digite o valor a ser depositado:");
                                        double valor = scanner.nextDouble();
                                        contazord.depositar(valor);
                                        System.out.println("Operação realizada com sucesso.");
                                        plataforma.showMenuCorrente();
                                        resposta3 = scanner.next();
                                        System.out.println("");
                                        break;
                                    case "2":
                                        //SAQUE
                                        System.out.println("Digite o valor a ser sacado:");
                                        valor = scanner.nextDouble();
                                        contazord.sacar(valor);
                                        System.out.println("Operação realizada com sucesso.");
                                        plataforma.showMenuCorrente();
                                        resposta3 = scanner.nextLine();
                                        System.out.println("");
                                        break;
                                    case "3":
                                        //TRANSFERENCIA
                                        System.out.println("Digite o número da conta a ser transferido:");
                                        int numeroConta = scanner.nextInt();
                                        Conta contaTransf = plataforma.buscarContaPorNumero(numeroConta);
                                        if (contaTransf == null) {
                                            System.out.println("Conta não encontrada");
                                        } else {
                                            System.out.println("Digite o valor a ser transferido:");
                                            valor = scanner.nextDouble();
                                            contazord.transferir(valor, contaTransf);
                                        }
                                        System.out.println("Operação realizada com sucesso");
                                        plataforma.showMenuCorrente();
                                        resposta3 = scanner.nextLine();
                                        System.out.println("");
                                        break;
                                    case "4":
                                        //EXTRATO
                                        contazord.extrato();
                                        System.out.print("Operação realizada com sucesso.");
                                        plataforma.showMenuCorrente();
                                        resposta3 = scanner.nextLine();
                                        System.out.println("");
                                        break;
                                    case "5":
                                        System.out.println("");
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        System.out.println("");
                                        plataforma.showMenuCorrente();
                                        resposta3 = scanner.nextLine();
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

                case "2":
                    System.out.println("Setor dos poupançudos. O que você deseja fazer?\n 1 - Cadastrar poupança\n 2 - Listar poupançudos\n 3 - Buscar poupança\n 4 - Extratos\n 5 - Verificar rentabilidade\n 6 - Sair");
                    resposta2 = scanner.nextLine();
                    if (resposta2.equals("4")) {
                        plataforma.showMenu();
                        resposta = scanner.nextLine();}
                    else{
                        switch (resposta2){
                        case "1":
                            plataforma.cadastrarContaPoupanca();
                            System.out.println("Operação realizada com sucesso.");

                            System.out.println("");
                            break;
                        case "2":
                            plataforma.listarContasPoupanca();
                            System.out.println("");
                            break;
                        case "3":
                            System.out.println("Buscar poupança. Digite o CPF do poupançudo:");
                            String cpf = scanner.next();
                            ContaPoupanca contaPoup = (ContaPoupanca) plataforma.buscarContaCPF(cpf);
                            if (plataforma.buscarContaCPF(cpf) == null){
                                System.out.println("Conta não encontrada");
                            }else{
                                System.out.println("Escolha uma das opções:\n 1 - Sacar\n 2 - Depositar\n 3 - Transferir\n 4 - Extrato\n 5 - Sair");
                                String resposta3 = scanner.next();
                                switch(resposta3){
                                    case "1":
                                        System.out.println("Digite o valor a ser sacado:");
                                        double valor = scanner.nextDouble();
                                        contaPoup.sacar(valor);
                                        System.out.println("Operação realizada com sucesso");
                                        plataforma.showMenuPoup();
                                        resposta3 = scanner.nextLine();
                                        break;
                                    case "2":
                                        System.out.println("Digite o valor a ser depositado:");
                                        valor = scanner.nextDouble();
                                        contaPoup.depositar(valor);
                                        System.out.println("Operação realizada com sucesso");
                                        plataforma.showMenuPoup();
                                        resposta3 = scanner.nextLine();
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
                                        System.out.println("Operação realizada com sucesso");
                                        plataforma.showMenuPoup();
                                        resposta3 = scanner.nextLine();
                                        break;
                                    case "4":
                                        contaPoup.extrato();
                                        System.out.println("Operação realizada com sucesso");
                                        plataforma.showMenuPoup();
                                        resposta3 = scanner.nextLine();
                                        break;
                                        case "5":
                                            System.out.println("Você gostaria de saber a rentabilidade da sua poupança em quantos meses?");
                                            int meses = scanner.nextInt();
                                            contaPoup.simularRent(meses);
                                            System.out.println("Operação realizada com sucesso");
                                            plataforma.showMenuPoup();
                                            resposta3 = scanner.nextLine();
                                    case "6":
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        plataforma.showMenuPoup();
                                        resposta3 = scanner.nextLine();
                                        break;
                                }

                            }
                    }}
                    break;

                    //Case conta investimento
                case "3":
                    System.out.println("Sessão de investimentos. O que você deseja fazer?\n 1 - Cadastrar investimento\n 2 - Listar investimentos\n 3 - Buscar investimento\n 4 - Sair");
                    resposta2 = scanner.nextLine();
                    if (resposta2.equals("4")) {
                        plataforma.showMenu();
                        resposta = scanner.nextLine();}
                    else{
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
                            System.out.println("Informe o cpf da conta à ser buscada:");
                            String cpf = scanner.next();
                            ContaInvestimento contaInv = (ContaInvestimento) plataforma.buscarContaCPF(cpf);
                            if (plataforma.buscarContaCPF(cpf) == null){
                                System.out.println("Conta não encontrada");
                            }else{
                                System.out.println("Escolha uma das opções:\n 1 - Sacar\n 2 - Depositar\n 3 - Transferir\n 4 - Extrato\n 5 - Investir\n 6 - Sair");
                                String resposta3 = scanner.next();
                                switch(resposta3){
                                    case "1":
                                        System.out.println("Digite o valor a ser sacado:");
                                        double valor = scanner.nextDouble();
                                        contaInv.sacar(valor);
                                        System.out.println("Operação realizada com sucesso");
                                        plataforma.showMenuInvest();
                                        resposta3 = scanner.nextLine();
                                        break;
                                    case "2":
                                        System.out.println("Digite o valor a ser depositado:");
                                        valor = scanner.nextDouble();
                                        contaInv.depositar(valor);
                                        System.out.println("Operação realizada com sucesso");
                                        plataforma.showMenuInvest();
                                        resposta3 = scanner.nextLine();
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
                                        System.out.println("Operação realizada com sucesso");
                                        plataforma.showMenuInvest();
                                        resposta3 = scanner.nextLine();

                                        break;
                                    case "4":
                                        contaInv.extrato();
                                        System.out.println("Operação realizada com sucesso");
                                        plataforma.showMenuInvest();
                                        resposta3 = scanner.nextLine();
                                        break;
                                    case "5":
                                        System.out.println("Investimento disponíveis: LCA, CDB e LCI");
                                        System.out.println("Digite o valor a ser investido:");
                                        valor = scanner.nextDouble();
                                        System.out.println("Digite o tipo de investimento:");
                                        String tipo = scanner.next();
                                        contaInv.investir(valor, Investimentos.valueOf(tipo));
                                        System.out.println("Operação realizada com sucesso");
                                        plataforma.showMenuInvest();
                                        resposta3 = scanner.nextLine();
                                        break;
                                    case "6":
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        plataforma.showMenuInvest();
                                        resposta3 = scanner.nextLine();
                                        break;
                                }
                            }
                    }}
                    break;
                case "4":
                    resposta = "4";
                    break;
                default:
                    System.out.println("Opção inválida");
                    plataforma.showMenu();
                    resposta2 = scanner.nextLine();
                    break;

            }//fim switch resposta
        }System.out.println("Encerrando...");
    }
}
