package com.restaurantpos;

import com.restaurantpos.ui.MainFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.io.File;

/**
 * Main class untuk menjalankan aplikasi Restaurant POS
 */
public class RestaurantPOS {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Atur look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Gagal mengatur Look and Feel: " + e.getMessage());
        }
        
        // Buat direktori untuk data jika belum ada
        createDataDirectories();
        
        // Start aplikasi pada EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    }
    
    /**
     * Buat direktori untuk penyimpanan data pesanan
     */
    private static void createDataDirectories() {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }
        
        File pesananDir = new File("data/pesanan");
        if (!pesananDir.exists()) {
            pesananDir.mkdir();
        }
    }
}