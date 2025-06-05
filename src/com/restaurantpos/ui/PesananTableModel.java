package com.restaurantpos.ui;
import com.restaurantpos.model.Pesanan;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 * Table model untuk menampilkan daftar pesanan
 */
public class PesananTableModel extends AbstractTableModel {
    private final List<Pesanan> listPesanan;
    private final String[] columnNames = {"Nama Item", "Jumlah", "Harga Satuan", "Total"};
   private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(
    new Locale.Builder().setLanguage("id").setRegion("ID").build());
    public PesananTableModel(List<Pesanan> listPesanan) {
        this.listPesanan = listPesanan;
    }
    
    @Override
    public int getRowCount() {
        return listPesanan.size();
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pesanan pesanan = listPesanan.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return pesanan.getNamaItem();
            case 1: return pesanan.getJumlah();
            case 2: return currencyFormat.format(pesanan.getHargaSatuan());
            case 3: return currencyFormat.format(pesanan.getTotalHarga());
            default: return null;
        }
    }
    
    /**
     * Menghitung total harga dari semua pesanan
     * @return Total harga
     */
    public double calculateTotalPrice() {
        double total = 0;
        for (Pesanan pesanan : listPesanan) {
            total += pesanan.getTotalHarga();
        }
        return total;
    }
    
    /**
     * Menambahkan pesanan baru ke tabel
     * @param pesanan Pesanan yang akan ditambahkan
     */
    public void addPesanan(Pesanan pesanan) {
        listPesanan.add(pesanan);
        fireTableDataChanged();
    }
    
    /**
     * Menghapus semua pesanan dari tabel
     */
    public void clearPesanan() {
        listPesanan.clear();
        fireTableDataChanged();
    }
}