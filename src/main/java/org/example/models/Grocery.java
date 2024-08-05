package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();


    public static boolean checkItemIsInList(String product) {

        for (String grocery: groceryList) {
            if(grocery.toUpperCase().equals(product.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static void addItems(String input) {
        String[] items = input.split("\\s*,\\s*");
        for (String item : items) {
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            } else {
                System.out.println("Ürün listede zaten var: " + item);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split("\\s*,\\s*");
        for (String item : items) {
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println("Ürün listede zaten var: " + item);
            }
        }
        printSorted();
    }

    public static void printSorted() {
        Collections.sort(groceryList);

        for (String grocery : groceryList) {
            System.out.println("Grocery List: " + grocery);
        }
    }

    public void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("0: Uygulamayı durdur, 1: Listeye Ürün Ekle, 2: Listeden Ürün Çıkar");
            System.out.print("Seçiminiz: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "0":
                    System.out.println("Uygulama durduruldu");
                    run = false;
                    break;
                case "1":
                    System.out.println("Eklemek istediğiniz ürünü giriniz:");
                    String input = scanner.nextLine();
                    addItems(input);
                    break;
                case "2":
                    System.out.println("Çıkarmak istediğiniz ürünü giriniz:");
                    String inputRemove = scanner.nextLine();
                    removeItems(inputRemove);
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız! Sadece 0, 1 veya 2 değerlerini girebilirsiniz ");
                    break;
            }
        }
        scanner.close();
    }


}
