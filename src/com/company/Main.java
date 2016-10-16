package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        new MagicDoor().magicalDoorsIsOpened();

        System.out.println("Введіть ціле число:");
        Scanner sc = new Scanner(System.in);
        String full = sc.nextLine();
        char[] arr = full.toCharArray();
        List<Byte> list = new ArrayList<>();
        List<Character> char_list = new ArrayList<>();


        for (char anArr : arr) {

            if (!Character.isDigit(anArr)) {
                char_list.add(anArr);

            } else {
                list.add((byte) charToInt(anArr));

            }
        }
        Byte[] bytes = new Byte[list.size()];
        list.toArray(bytes);

        System.out.println("Total list" + Arrays.toString(arr));
        if (char_list.size() != 0) {

            System.out.println("Total number of characters: " + char_list.size());
            System.out.println("Characters list: " + char_list);
            System.out.println("Reduced to numerical format of the symbols" + listaOfCharToInt(char_list));

        } else {
            System.out.println("Characters not found");
        }

        System.out.println(finalSummator(bytes));


    }

    public static Byte[] arrToByte(int sum) {

        Byte[] bytes = new Byte[(sum + "").length()];

        for (int i = bytes.length - 1; i >= 0; i--) {

            if (sum < 10) {
                bytes[i] = (byte) sum;

            } else {
                int a = sum % 10;
                bytes[i] = (byte) a;
                sum = sum / 10;
            }
        }

        return bytes;

    }

    public static int charToInt(char chararcter) {
        int a = (int) chararcter - 48;

            System.out.println("charToInt:" + a);


        return a;
    }

    public static List listaOfCharToInt(List<Character> characters) {
        List<Integer> convert_list = new ArrayList<>();

       for (int i=0; i < characters.size(); i++){
           convert_list.add(charToInt(characters.get(i)));
       }

        return convert_list;
    }


    public static byte finalSummator(Byte[] arr) {
        Byte sum = 0;
        System.out.println("finalSummator:" + Arrays.toString(arr));

        for (Byte anArr : arr) {

            if (anArr == 9 || anArr == 0)
                continue;

            byte temp = anArr;
            sum = (byte) (sum + temp);

        }

        if (sum < 10) {
            System.out.print("Final sum is:");
            return sum;
        } else {
            Byte[] arr1 = arrToByte(sum);
            return finalSummator(arr1);

        }
    }

}

