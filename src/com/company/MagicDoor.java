package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Yulya on 16.10.2016.
 */
public class MagicDoor {

    final static int open = 123;

    public void magicalDoorsIsOpened() {
        System.out.println("Please,enter the  password: ");
        Scanner sc = new Scanner(System.in);
        int password = sc.nextInt();

        if (password == open) {

            System.out.println("Welcome!");
            return;
        }
        System.out.println("Illegal password!");
        magicalDoorsIsOpened();

    }

}
