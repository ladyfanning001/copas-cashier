package com.restaurantpos.model;

/**
 * Class Minuman yang mewarisi MenuItem
 */
public class Minuman extends MenuItem {
    private boolean dingin;
    
    public Minuman(String nama, double harga, boolean dingin) {
        super(nama, harga);
        this.dingin = dingin;
    }
    
    public boolean isDingin() {
        return dingin;
    }
    
    @Override
    public String getDeskripsi() {
        return "Minuman: " + getNama() + (dingin ? " (Dingin)" : " (Panas)");
    }
    
    public static Minuman[] getMenuMinuman() {
        return new Minuman[] {
            new Minuman("Matcha Latte", 18000, true),
            new Minuman("Es Timun", 10000, true),
            new Minuman("Salted Caramel Coffee", 20000, true),
            new Minuman("Butterscotch Latte", 22000, false),
            new Minuman("Wedang Jahe", 15000, false),
            new Minuman("Americano", 10000, false),
            new Minuman("Lychee Tea", 20000, true),
            new Minuman("Thai Tea", 12000, true),
            new Minuman("Kopi Susu Aren", 11000, true),
            new Minuman("Vietnam Drip", 25000, false),
            new Minuman("Lemongrass Tree", 18000, false),
            new Minuman("Cotton Candy Crush", 30000, true )
        };
    }
}