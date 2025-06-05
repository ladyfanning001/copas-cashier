package com.restaurantpos.model;

/**
 * Class Makanan yang mewarisi MenuItem
 */
public class Makanan extends MenuItem {
    private String kategori;
    
    public Makanan(String nama, double harga, String kategori) {
        super(nama, harga);
        this.kategori = kategori;
    }
    
    public String getKategori() {
        return kategori;
    }
    
    @Override
    public String getDeskripsi() {
        return "Makanan: " + getNama() + " (" + kategori + ")";
    }
 
    public static Makanan[] getMenuMakanan() {
        return new Makanan[] {
            new Makanan("Ayam Geprek", 20000, "Ayam"),
            new Makanan("Bebek Goreng", 30000, "Bebek"),
            new Makanan("Mie Ayam Bumbu Bali", 25000, "Mie"),
            new Makanan("Nasi Goreng Bebek Cabe Ijo", 28000, "Nasi"),
            new Makanan("Nasi Katsu", 22000, "Nasi"),
            new Makanan("Jasuke", 10000, "Snack"),
            new Makanan("Tahu Bakso", 3000, "Snack"),
            new Makanan("Es Potong", 5000, "Snack"),
            new Makanan("Spicy Mentai Pasta", 14000, "Pasta"),
            new Makanan("Spagethi Carbonara", 12000, "Pasta"),
            new Makanan("Enoki Crispy", 10000, "Snack"),
            new Makanan("Onion Ring", 10000, "Snack")

        };
    }
}