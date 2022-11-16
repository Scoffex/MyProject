package com.auriga.web;
import java.util.Scanner;
import com.auriga.logic.*;

public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
   
        System.out.println("Inserisci primo numero->");
        int num1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Inserisci secondo numero->");
        int num2 = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Select the operation \n1)Add \n2)subtraction \n3)multiplication \n4)division");
        int risposta = sc.nextInt();
        sc.nextLine();
        
        Logic localLogic = new Logic(num1, num2, risposta);
        System.out.println(localLogic.print());
    }

}
