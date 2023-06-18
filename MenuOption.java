package com.ata;


public enum MenuOption{
    EXIT, LIST_PRODUCTS, BUY_PRODUCT, FIND_PRODUCT, SHOW_CART, CHECKOUT;
    
    private int id;
    private String displayValue;
    
     public int getId(){
        return this.id;
    }
    public String getDisplayValue(){
     return this.displayValue;   
    }
    
}