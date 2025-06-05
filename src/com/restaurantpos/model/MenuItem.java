package com.restaurantpos.model;

import java.io.Serializable;

/**
 * Class abstract yang merepresentasikan item menu restoran
 */
public abstract class MenuItem implements Serializable {
    private String nama;
    private double harga;
    
    public MenuItem(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }
    
    public String getNama() {
        return nama;
    }
    
    public double getHarga() {
        return harga;
    }
    
    /**
     * Method polymorphic untuk mendapatkan deskripsi item
     * @return Deskripsi dari menu item
     */
    public abstract String getDeskripsi();
    
    /**
     * Method untuk menghitung total harga berdasarkan jumlah
     * @param jumlah Jumlah item yang dipesan
     * @return Total harga
     */
    public double hitungTotalHarga(int jumlah) {
        return harga * jumlah;
    }
    
    @Override
    public String toString() {
        return nama + " - Rp " + harga;
    }
}