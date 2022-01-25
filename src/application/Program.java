package application;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();
        plataforma.menu();
        String resposta = scanner.nextLine();
        while(!resposta.equals("3")){
            switch (resposta){
                case "1":
                    plataforma.cadastrarContaCorrente();
                    break;
                case "2":
                    System.out.println("O que gostaria de fazer?");
                    plataforma.relatorios();
                    break;
                case "3":
                    System.out.println("Saindo...");
                    break;
                default:
                    plataforma.menu();
                    System.out.println("Opção inválida");
                    break;

            }
        }
    }
}
