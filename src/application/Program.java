package application;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();
        plataforma.showMenu();
        String resposta = scanner.nextLine();
        while(!resposta.equals("4")){
            switch (resposta){
                case "1":
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
                        plataforma.buscarContaCorrente(cpf);

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
