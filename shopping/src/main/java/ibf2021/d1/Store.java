package ibf2021.d1;

import java.util.ArrayList;
import java.util.Arrays;

public class Store {
    public ArrayList<String> ShoppingCart;
    public ArrayList<String> ShoppingMenu;

    public Store() {
        this.ShoppingCart = new ArrayList<String>();
        this.ShoppingMenu = new ArrayList<String>(
            Arrays.asList("apple",
                          "orange",
                          "pear",
                          "grape"));
    }

    public ArrayList<String> getShoppingMenu() {
        return this.ShoppingMenu;
    }

    public void addItem(String item) {
        this.ShoppingCart.add(item);
    }

    public void deleteItem(int i) {
        this.ShoppingCart.remove(i);  
        
    }

    public String getItemAtIndexFromCart(int i) {
        return this.ShoppingCart.get(i);

    }

    public ArrayList<String> getShoppingCart() {
        return this.ShoppingCart;
    }

    public void printShoppingCart() {
        for (int counter = 0; counter < this.ShoppingCart.size(); counter++) { 		      
            System.out.printf("%d. %s\n", counter + 1, this.ShoppingCart.get(counter)); 
            		
        }   
    }
}