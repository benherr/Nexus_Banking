package com.bank.main;

import java.util.Scanner;

import com.bank.exception.CustomerInvalidDataException;
import com.bank.service.CustomerService;

public class Home{

    
    static void slowPrint(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
    	
    	CustomerService customerService = new CustomerService();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            slowPrint("Enter");
            slowPrint("1. For Customer Registration");
            slowPrint("2. For Customer Login");
            slowPrint("3. For Admin Login");

           

            switch (scanner.nextInt()) {

                case 1:
                    slowPrint("Customer Registration");
                    try {
                    	customerService.customerRegistration();
                    }
                    catch(CustomerInvalidDataException e) {
                    	System.out.println(e.getMsg());
                    }
                    
                    break;

                case 2:
                    slowPrint("Customer Login");
                    try {
                    	customerService.customerLogin();
                    }
                    catch(CustomerInvalidDataException e) {
                    	System.out.println(e.getMsg());
                    }
                    break;

                case 3:
                    slowPrint("Admin Login");
                    break;

                default:
                    slowPrint("Invalid request");
                    break;
            }

            slowPrint("Do you want to continue?");
            slowPrint("1.for Yes");
            slowPrint("2. for No");

            if (scanner.nextInt()!=1) {
                slowPrint("Thank you");
                break;
            }
        }
    }
}
