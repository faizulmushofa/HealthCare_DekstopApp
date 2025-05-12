package com.example.main_project.EngineSearch;

import  java.util.Scanner;
public class Pemecah {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Masukkan gejala: ");
        String userInput = input.nextLine();
        userInput = userInput.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] division = userInput.split(" ");
        for (String i: division){
            System.out.println(i);
        }

    }
}
