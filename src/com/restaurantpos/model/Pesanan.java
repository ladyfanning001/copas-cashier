package com.restaurantpos.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class yang merepresentasikan satu item pesanan
 */
public class Pesanan implements Serializable {
    private MenuItem menuItem;
    private int jumlah;
    private Date waktuPesan;
    
    public Pesanan(MenuItem menuItem, int jumlah) {
        this.menuItem = menuItem;
        this.jumlah = jumlah;
        this.waktuPesan = new Date();
    }
    
    public MenuItem getMenuItem() {
        return menuItem;
    }
    
    public int getJumlah() {
        return jumlah;
    }
    
    public Date getWaktuPesan() {
        return waktuPesan;
    }
    
    public String getNamaItem() {
        return menuItem.getNama();
    }
    
    public double getHargaSatuan() {
        return menuItem.getHarga();
    }
    
    public double getTotalHarga() {
        return menuItem.hitungTotalHarga(jumlah);
    }
    
    public String getFormattedWaktu() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(waktuPesan);
    }
    
    @Override
    public String toString() {
        return menuItem.getNama() + " x" + jumlah + " = Rp " + getTotalHarga();
    }
}