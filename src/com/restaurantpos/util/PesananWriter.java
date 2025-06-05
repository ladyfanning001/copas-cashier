package com.restaurantpos.util;

import com.restaurantpos.interfaces.Printable;
import com.restaurantpos.model.Pesanan;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Class untuk mencetak dan menyimpan struk pesanan
 */
public class PesananWriter implements Printable {
    
    @Override
    public String printStruk(List<Pesanan> listPesanan, double totalHarga) {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        // Header struk
        sb.append("=======================================\n");
        sb.append("               KEDAI COPAS             \n");
        sb.append("          Jl. Semarang No. 123          \n");
        sb.append("          Telp: (024) 1234-5678         \n");
        sb.append("=======================================\n");
        sb.append(" Tanggal: ").append(sdf.format(new Date())).append("\n");
        sb.append("---------------------------------------\n");
        sb.append(" Menu                 Qty     Harga\n");
        sb.append("---------------------------------------\n");
        
        // Daftar pesanan
        for (Pesanan p : listPesanan) {
            sb.append(String.format("%-20s %3d %10.0f\n", 
                    p.getNamaItem(), 
                    p.getJumlah(), 
                    p.getTotalHarga()));
        }
        
        // Footer struk
        sb.append("--=------------------------------------\n");
        sb.append(String.format("TOTAL     %25.0f\n", totalHarga));
        sb.append("=======================================\n");
        sb.append("              TERIMA KASIH            \n");
        sb.append("            TELAH BERKUNJUNG             \n");
        sb.append("=======================================\n");
        
        return sb.toString();
    }
    
    @Override
    public boolean saveStrukToFile(String struk, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(struk);
            printWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}