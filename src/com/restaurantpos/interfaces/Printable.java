package com.restaurantpos.interfaces;

import java.util.List;
import com.restaurantpos.model.Pesanan;

/**
 * Interface untuk mencetak struk
 */
public interface Printable {
    /**
     * Mencetak struk pembelian
     * @param listPesanan List pesanan yang akan dicetak
     * @param totalHarga Total harga dari semua pesanan
     * @return String hasil cetak struk
     */
    String printStruk(List<Pesanan> listPesanan, double totalHarga);
    
    /**
     * Menyimpan struk ke file
     * @param struk String struk yang akan disimpan
     * @param filePath Path file tujuan
     * @return true jika berhasil disimpan, false jika gagal
     */
    boolean saveStrukToFile(String struk, String filePath);
}