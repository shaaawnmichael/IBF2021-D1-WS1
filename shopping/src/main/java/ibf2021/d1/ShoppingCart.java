package ibf2021.d1;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {

    ArrayList<String> cart = new ArrayList<String>();
    boolean isloggedin = false;
    String user;
    //Cartdb a = new Cartdb();

    public static void main(String[] args) {
        ShoppingCart a = new ShoppingCart();
        //a.welcome();
        a.checkLogin();
        
    }

    public void checkLogin() {
        
        if (isloggedin == true) {
        welcome();
        
        }
        else {
        Console input=System.console();
        
        String loginInput=input.readLine("Welcome to your shopping cart. Please log in. ");
        Scanner scanlogin=new Scanner(loginInput);
        String scannx=scanlogin.next();

        if (scannx.equals("login")) {
            String user=loginInput.substring(6);
            System.out.println("Hello " + user + "." );

            try {
            File createUserDB = new File("D:\\1.Java\\IBF2021-D1-WS1\\shopping\\src\\cartdb\\"+ user + ".txt");
            if (createUserDB.createNewFile()) {
                System.out.println("  ");
            } else {
                System.out.println(" ");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
            
            }
            isloggedin=true;
            checkLogin();
        }
        
        checkLogin();
        }
    
        

        public void welcome() {
            
            while (true) {
            System.out.println("Welcome to your shopping Cart");
            System.out.println("Please key in only the following commands: list, add, delete, logout");

            Scanner scan = new Scanner(System.in);
            String com = scan.next();

            while (!com.startsWith("list") && 
                    !com.startsWith("delete") &&  
                    !com.startsWith("add") && 
                    !com.startsWith("logout") && 
                    !com.startsWith("save")) {
                System.out.println("Please use only list, add, delete, save or logout.");
                com = scan.next();
            } 
                if(com.equals("list")) {
                    if (cart.size() == 0)
                    System.out.println("Shopping cart is empty. Please add something to cart.");
                    else {
                        for (int counter = 0; counter < cart.size(); counter++) { 		      
                        System.out.printf("%d. %s\n", counter + 1, cart.get(counter));    
                        }  
                    }
                }

                else if (com.equals("add")) {
                    Console cons = System.console();
                    String inputItem = cons.readLine("Key in what would you like to add?");
                    inputItem = inputItem.trim();

                    String[] itemsplit = inputItem.split(",");

                    for (String itemcart: itemsplit) {

                    if (cart.contains(itemcart)) {
                        System.out.println("Duplicate item. Please key in another item.");

                    } 

                    else {
                        cart.add(itemcart);
                        System.out.println(itemcart + " added to cart.");
                    }
                }

                }
                    else if (com.equals("delete")) {
                        Console cons2 = System.console();
                        String deleteItem = cons2.readLine("Key in what would you like to delete?");
                        
                        deleteItem = deleteItem.trim();

                        if (!cart.contains(deleteItem)) {
                            System.out.println(deleteItem + " not found in cart. Please key in something else.");
                            break;
                        }
                        else 
                        cart.remove(deleteItem);
                        System.out.println(deleteItem + " removed from cart.");
                        for (int counter = 0; counter < cart.size(); counter++)
                        System.out.printf("Shopping Cart contains: "  + "%d. %s\n", counter + 1, cart.get(counter));
                    }

                    else if (com.equals("logout")) {
                        System.out.println("You has been logged out.");
                        isloggedin=false;
                        checkLogin();

                    }

            }
        }
 
}
