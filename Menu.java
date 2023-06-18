package com.ata;
import java.util.Scanner;

/**
 * Menu class is responsible for greeting the user, showing a menu
 * to the user for interaction with the application.
 * The class maintains a String[] array of menu options, which it
 * uses for printing the menu to standard out.
 * The class is also responsible for responding to user interaction
 * with respect to its menu.
 */
public class Menu { 
    private String[] menuOptions = {"Exit","List Products", "Buy Product", "Find Product", "Show Cart", "Checkout"};
    private Scanner scanner;
    
    private Shop shop;
    /**
     * Class constructor, which expects a Scanner object
     * It allows for the user to specify how a Scanner is to
     * be configured outside this class and for basic inversion of control.
     * @param scanner takes in a Scanner object to initialize
     */
    public Menu(Scanner scanner, Shop shop) {
        this.scanner = scanner;
        this.shop = shop;
    }


    /**
     * Prints the menu to standard output, using the class's menuOptions array.
     * It accepts user input using the encapsulated Scanner instance.
     * All output is printed to standard out.
     * All input is collected from standard in.
     */
    public void executeMenu() {
        printMenu();
        
        while(scanner.hasNextInt()||scanner.hasNextLine()){
        int x =  getNextIntFromUser();
        if(x==0){
           exit();
           break;
        }
        if(x == 1){
        shop.printProducts();
        printMenu();
        }
        if(x==2){
         System.out.println("Please enter the ID of the product you would like to purchase:");
         int id = getNextIntFromUser();
         shop.purchase(id);
         printMenu();
            
            
            
        }
        if(x == 3){
           System.out.println("Enter the item to search for:");
           String itemToFind = getNextStringLineFromUser();
           int output = shop.findProducts(itemToFind);
           if(output==-1){
           System.out.println("That product was not found.");
           }
            else{
                System.out.println(shop.getProductById(output).getName()+" was found and its product id is " + output);
            }
            printMenu();
        }
          if(x == 4){
              shop.show();
              printMenu();
          }
            if(x==5){
               shop.checkout(); 
               printMenu();
            }
        }    
        
        
        
    }

    /**
     * Asks the user to enter their name.
     * After the
     user provides their name, it outputs a greeting to the user to standard out.
     */
    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();

        System.out.println("Welcome " + name + " to " + shop.getName());
        
    }

    /**
     * Prints the menu header and menu options.
     */
    private void printMenu() {
        System.out.println();
        System.out.println("--Main Menu--");
        System.out.println("Select an option using one of the numbers shown");
        System.out.println();

        for (int i = 0; i < menuOptions.length; i++) {
            System.out.print(i + ": ");
            System.out.println(menuOptions[i]);
        }
    }

    /**
     * Prints an exit statement and closes the scanner object.
     */
    private void exit() {
        System.out.println("Exiting now. Goodbye.\n");
        scanner.close();
    }

    /**
     * Collects next user-entered int.
     * @return integer value denoting the user selection
     */
    private int getNextIntFromUser() {
        return scanner.nextInt();
    }

    /**
     * Skips a line of empty input from the scanner's input stream
     * and then returns the next available line.
     * @return string representing the line of input typed by the user
     */
    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }
   
    
}
