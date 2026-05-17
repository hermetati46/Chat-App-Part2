package com.poepart2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login auth = new Login();

        System.out.println("Registration");
        System.out.print("Enter First Name: ");
        String fName = input.nextLine();
        System.out.print("Enter Last Name: ");
        String lName = input.nextLine();
        System.out.print("Enter Username: ");
        String user = input.nextLine();
        System.out.print("Enter Password: ");
        String pass = input.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = input.nextLine();

        String regStatus = auth.registerUser(user, pass, fName, lName, phone);
        System.out.println(regStatus);

        if (regStatus.contains("successfully captured")) {
            System.out.println("\nLOGIN");
            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();
            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            boolean loginResult = auth.loginUser(loginUser, loginPass);
            System.out.println(auth.returnLoginStatus(loginResult));
        }
    }
}