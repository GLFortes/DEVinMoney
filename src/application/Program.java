package application;

import account.ContaCorrente;

import static enums.Agencia.FLORIANOPOLIS;

public class Program {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente("Guilherme", "12345-6", 3500.0, 1111, FLORIANOPOLIS);

    }
}
