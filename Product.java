package com.ata;

class Product{
    private String name;
    private double price;
    private int id;
    public Product(int id, String name, double price){
        this.name = name;
        this.price = price;
        this.id = id;
        
    }
    
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
        
    }
    public int getId(){
     return this.id;   
        
    }
    
    
    
    
    
    
}