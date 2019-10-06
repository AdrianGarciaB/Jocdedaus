package Dau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dau1 {

    private static int getRandomIntBetweenRange(double min, double max){
        double random = Math.random();
        return (int) ((random*((max-min)+1))+min);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> arrlist = new ArrayList<>();
        System.out.print("Introduce el numero de tiradas: ");

        int tiros = in.nextInt();

        for (int i = 0; i < tiros; i++) {
            int dado1 = getRandomIntBetweenRange(1,6);
            int dado2 = getRandomIntBetweenRange(1,6);
            arrlist.add(dado1 + dado2);
        }
        for (int i = 2; i <= 12; i++) {

            System.out.println("El numero " + i + " ha salido: "+Collections.frequency(arrlist, i) + " veces.");
        }
    }
}
