package com.restaurantpos.util;

import com.restaurantpos.model.Pesanan;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Class untuk mengelola data pesanan
 */
public class DataManager {
    private static final String DATA_DIR = "data/pesanan/";
    
    /**
     * Menyimpan list pesanan ke file serialization
     * @param listPesanan List pesanan yang akan disimpan
     * @param fileName Nama file
     * @return true jika berhasil disimpan, false jika gagal
     */
    public static boolean savePesanan(List<Pesanan> listPesanan, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(DATA_DIR + fileName + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listPesanan);
            oos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Membaca list pesanan dari file serialization
     * @param fileName Nama file
     * @return List pesanan yang dibaca
     */
    @SuppressWarnings("unchecked")
    public static List<Pesanan> loadPesanan(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(DATA_DIR + fileName + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Pesanan> listPesanan = (List<Pesanan>) ois.readObject();
            ois.close();
            fis.close();
            return listPesanan;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}