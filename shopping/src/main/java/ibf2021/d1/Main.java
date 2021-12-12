package ibf2021.d1;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Store fruitstore = new Store();
        ArrayList<String> shoppingmenu = fruitstore.getShoppingMenu();
        ArrayList<String> shoppingcart = fruitstore.getShoppingCart();
        String item;
        int indexnumber;

        while(true) {
            System.out.println("Welcome to your shopping cart.");
            System.out.println("Please key in something..");

            Scanner scan = new Scanner(System.in);
            String com = scan.next();

            while (!com.startsWith("list") && 
                    !com.startsWith("add") &&
                    !com.startsWith("delete")) {
                System.out.println("Please use only list, add or delete");
                com = scan.next();
                
            }
        
            if (com.equals("list")) {
                if (fruitstore.getShoppingCart().size() == 0)
                    System.out.println("Shopping Cart is empty");
                else
                    fruitstore.printShoppingCart(); 
            
            // ADD CODE

           } else if (com.equals("add")) {
                menuloop: while(true) {
                    System.out.println("Type in what you would like to add (type back to return)?. Current menu:");
                    System.out.println(shoppingmenu);

                    item = scan.next().trim().toLowerCase();
                    String[] itemlist = item.split(",");

                    for (String itemcart: itemlist) {
                        itemcart = itemcart.trim().toLowerCase();
                        if (fruitstore.getShoppingCart().contains(itemcart)) {
                            System.out.println("Duplicate item. Please choose another item.");
                        }
                        else if (shoppingmenu.contains(itemcart)) {
                            System.out.println(itemcart + " added to cart"); 
                            fruitstore.addItem(itemcart);
                        } else if (itemcart.equals("back")) {
                            break menuloop;
                        } else {
                            System.out.printf("Invalid choice %s, we don't sell that here. ", itemcart);
                            
                        }
                    }
                }   


            //DELETE CODE

            } else if (com.equals("delete")) {
                while(true) {
                System.out.println(fruitstore.getShoppingCart());

                //item = scan.next();
                item = scan.next().trim().toLowerCase();
                indexnumber = Integer.valueOf(item)-1;

                if (indexnumber<=shoppingcart.size()) {
                    System.out.println(fruitstore.getItemAtIndexFromCart(indexnumber) + " removed from cart");
                    fruitstore.deleteItem(indexnumber);
                    break;
                } else if (item.equals("back")) {
                    break;
                } else {
                    System.out.println("Item is not in cart");
                }
            }    
            
            } else {
                System.out.println("Wrong command!"); 
            }
 
        }
    }
}


      
       
    

    




