package application;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();
        plataforma.showMenu();
        String resposta = scanner.nextLine();
        while(!resposta.equals("3")){
            switch (resposta){
                case "1":
                    plataforma.cadastrarContaCorrente();
                    plataforma.showMenu();
                    resposta = scanner.nextLine();
                    break;
                case "2":
                    System.out.println("O que gostaria de fazer?");
                    plataforma.relatorios();
                    plataforma.showMenu();
                    resposta = scanner.nextLine();
                    break;
                case "3":
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
