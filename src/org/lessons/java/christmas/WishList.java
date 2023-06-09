package org.lessons.java.christmas;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class WishList {
    public static void main(String[] args) {
        Scanner utente = new Scanner(System.in);

        ArrayList<String> wishList = new ArrayList<>();
        boolean exit = false;

        do{
            System.out.println("Vuoi inserire un regalo nella tua wish list? (s/n)");
            String choice = utente.nextLine();
            if(choice.equals("s")){
                System.out.println("Inserisci un regalo");
                String present = utente.nextLine();
                wishList.add(present);
                System.out.println("Al momento ci sono " + wishList.size() + " elementi nella tua wish list");
            } else if (choice.equals("n")) {
                exit = true;
                System.out.println("Sei uscito dalla tua wish list");
            } else {
                System.out.println("Devi inserire 's' o 'n', che equivalgono a 'si' o 'no'");
            }
        }while(!exit);

        System.out.println("\nEcco la tua wish list: ");
        Collections.sort(wishList);
        for (String present : wishList) {
            System.out.println(present);
        }
    }
}
