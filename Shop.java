package com.ata;
import java.util.ArrayList;
import java.util.Arrays;

public class Shop{
   private ArrayList<Product> products;
   private String name;
   private Cart cart = new Cart();
    public Shop(){
     System.out.println("Default");   
    }
    
    public Shop(String name, Product[] var){
      this.name = name;
      this.products = new ArrayList<>(Arrays.asList(var));
     
        
    }
    
    public void printProducts(){
        System.out.println("--Products--");
       for(Product product: products){
           System.out.println("ID " + product.getId() + ": " + product.getName() + " - $"+product.getPrice());
           
           
       }
    }
    
    public int findProducts(String searchText){
        for(Product prods: products){
            if(searchText.equals(prods.getName())){
             return prods.getId();   
            }
            
        }
        return -1;
    
    }
    public String getName(){
      return this.name;  
        
    }
    public Product getProductById(int id){
     return products.get(id);   
        
    }
    public void purchase(int x){
       boolean added = false;
     for(Product p: products){
      if(p.getId() == x){
          cart.addItem(p);
          System.out.println(String.format("%s has been added to your cart.", p.getName()));
          added = true;
      }
     }
        if(added == false){
            System.out.println("That item ID is invalid and could not be added to the cart.");
        }
    }
    
    public void show(){
        cart.showDetails();
    }
    
    public void checkout(){
       cart.checkout(); 
    }
    
    
    
}