package org.lessons.java.christmas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
public class WishList {

    public static void fillWishList(Scanner utente, boolean exit, ArrayList wishList){
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
    }
    public static void main(String[] args) throws IOException {
        Scanner utente = new Scanner(System.in);

        ArrayList<String> wishList = new ArrayList<>();
        boolean exit = false;

        // Controllo se il file myWishList.txt esiste
        File myWishList = new File("./myWishList.txt");
        if (myWishList.exists()) {
            // Se il file esiste, leggo il contenuto e lo carico nella wishList
            try (Scanner fileScanner = new Scanner(myWishList)) {
                while (fileScanner.hasNextLine()) {
                    String previousPresents = fileScanner.nextLine();
                    wishList.add(previousPresents);
                }
                fillWishList(utente, exit, wishList);
            } catch (IOException e) {
                System.out.println("Errore durante la lettura del file myWishList.txt");
            }
        } else {
            fillWishList(utente, exit, wishList);
            boolean fileCreated = myWishList.createNewFile();

            if (fileCreated) {
                FileWriter myWriter = new FileWriter(myWishList);
                for (String present : wishList) {
                    myWriter.write("\n" + present);
                }
                myWriter.close();
                System.out.println("Il file myWishList.txt è stato creato con successo");
            } else {
                System.out.println("Errore durante la creazione del file myWishList.txt");
            }
        }

//        do{
//            System.out.println("Vuoi inserire un regalo nella tua wish list? (s/n)");
//            String choice = utente.nextLine();
//            if(choice.equals("s")){
//                System.out.println("Inserisci un regalo");
//                String present = utente.nextLine();
//                wishList.add(present);
//                System.out.println("Al momento ci sono " + wishList.size() + " elementi nella tua wish list");
//            } else if (choice.equals("n")) {
//                exit = true;
//                System.out.println("Sei uscito dalla tua wish list");
//            } else {
//                System.out.println("Devi inserire 's' o 'n', che equivalgono a 'si' o 'no'");
//            }
//        }while(!exit);

        System.out.println("\nEcco la tua wish list: ");
        Collections.sort(wishList);
        for (String present : wishList) {
            System.out.println(present);
        }

        utente.close();


    }
}
