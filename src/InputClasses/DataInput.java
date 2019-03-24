package InputClasses;

import java.util.Scanner;

public class DataInput {

    public static int GetNumber(String str) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(str);
                int n = sc.nextInt();
                return n;
            } catch (Exception e) {
                System.out.println("Houve um erro: " + e.getMessage());
            }

        }

    }

    public static String GetText(String str) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(str);
                String n = sc.next();
                return n;
            } catch (Exception e) {
                System.out.println("Houve um erro: " + e.getMessage());
            }

        }

    }
    
}
