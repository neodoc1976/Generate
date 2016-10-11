package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("Введіть ціле число:");
        Scanner sc = new Scanner(System.in);
        String full = sc.nextLine();
        char[] arr = full.toCharArray();
        List<Byte> list = new ArrayList<>();
        List<Character> char_list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            if (!Character.isDigit(arr[i])) {
                char_list.add(arr[i]);

            } else {
                list.add((byte) charToInt(arr[i]));

            }
        }
        Byte[] bytes = new Byte[list.size()];
        list.toArray(bytes);

        if (char_list.size() != 0) {

            System.out.println("char list" + char_list);

        } else {
            System.out.println("Letters not found");
        }
        System.out.println("Total list" + Arrays.toString(arr));
        System.out.println(finalSummator(bytes));


    }

    public static Byte[] arrToByte(int sum) {
        Byte[] bytes = new Byte[(sum + "").length()];
        for (int i = bytes.length - 1; i > 0; i--) {
            int a = sum % 10;
            bytes[i] = (byte) a;
            sum = a;
        }
        return bytes;

    }


    public static int charToInt(char chararcter) {
        int a = (int) chararcter - 48;

        System.out.println("charToInt:" + a);

        return a;
    }

    public static byte finalSummator(Byte[] arr) {
        Byte sum = 0;
        System.out.println("finalSummator:" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 9 || arr[i] == 0)
                continue;

            byte temp = arr[i];
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

