package com.ata;
import java.util.ArrayList;

class Cart{
    private double total;
    private double taxRate = .10;
    private ArrayList<Product> products = new ArrayList<Product>();
    private String percentage = "%";
    
    public void addItem(Product p){
        this.products.add(p);
    }
    
    public void showDetails(){
        if(products.size() > 0){
         String output  =  String.format("--Cart--%nItem Count: %d%nItems:", products.size());
         System.out.println(output);
     for(Product p: products){
           total+=p.getPrice();
           output = String.format("%s: $%.2f", p.getName(), p.getPrice());
           System.out.println(output);
         
     }
            
        System.out.println(String.format("%nPre-Tax Total: $%.2f",total));
        System.out.println(String.format("Post-Tax Total (%.2f%s Tax): $%.2f", (taxRate*100),percentage, ((taxRate*total)+total)));
        }
        else{
         System.out.println("The cart is empty. Please add at least one product to see it in the cart.");   
        }
    }
    
    public boolean checkout(){
      if(products.size() <= 0){
          System.out.println("Your cart is currently empty. Please add at least one product to check out.");
          return false;
      }else{
         products.clear();
         System.out.println(String.format("Your total is $%.2f%nThank you for shopping at T-Shirt Mart.",((taxRate*total)+total)));
          return true;
        }
    }
    
   
    
    
}