package Dau;

import java.util.Scanner;

public class Dau2 {
    private static void menu() {
        System.out.println("T- Tirar");
        System.out.println("Cualquier otra tecla - Salir");
        System.out.println("Opcion: ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int npartidas = 0;
        int partidasganadas = 0;
        int partidasperdidas = 0;

        Dau2.menu();
        boolean seguirJugando = in.nextLine().equals("T");

        while (seguirJugando) {
            JocdeDaus jocdeDaus = new JocdeDaus();
            jocdeDaus.jugar();

            if (jocdeDaus.isWinner()) partidasganadas++;
            else partidasperdidas++;


            Dau2.menu();
            seguirJugando = in.nextLine().equals("T");
            npartidas++;

        }
        System.out.println("\n"+"Partidas jugadas: " + npartidas);
        System.out.println("Partidas ganadas: "+ partidasganadas);
        System.out.println("Partidas perdidas " + partidasperdidas);

    }

    static int getRandomIntBetweenRange(int min, int max){
        return (int) ((Math.random()*((max-min)+1))+min);
    }

}

class JocdeDaus {
    private Dau dado1;
    private Dau dado2;
    private Dau dado3;
    private boolean win;

    public JocdeDaus(){
        dado1 = new Dau();
        dado2 = new Dau();
        dado3 = new Dau();
    }

    void jugar(){
        dado1.tirar();
        System.out.print("Dado1: ");
        dado1.imprimir();

        dado2.tirar();
        System.out.print("Dado2: ");
        dado2.imprimir();

        dado3.tirar();
        System.out.print("Dado3: ");
        dado3.imprimir();

        System.out.println();

        if (dado1.getvalor() == dado2.getvalor() && dado1.getvalor() == dado3.getvalor()) win = true;
    }

    boolean isWinner(){
        return win;
    }

}

class Dau {
    private int valor;

    void tirar(){
        valor = Dau2.getRandomIntBetweenRange(1, 6);
    }

    void imprimir(){
        System.out.print("valor="+ getvalor() + "\n");
    }

    int getvalor(){
        return valor;
    }
}