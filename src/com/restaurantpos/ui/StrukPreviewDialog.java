package com.restaurantpos.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.restaurantpos.model.Pesanan;
import com.restaurantpos.util.PesananWriter;

/**
 * Dialog untuk preview dan cetak struk
 */
public class StrukPreviewDialog extends JDialog {
    private final JTextArea textAreaStruk;
    private final JButton btnSimpan;
    private final JButton btnTutup;
    private final String struk;

    public StrukPreviewDialog(Frame parent, List<Pesanan> listPesanan, double totalHarga) {
        super(parent, "Preview Struk", true);

        // Create struk
        PesananWriter writer = new PesananWriter();
        this.struk = writer.printStruk(listPesanan, totalHarga);

        // Initialize components
        textAreaStruk = new JTextArea(20, 40);
        textAreaStruk.setEditable(false);
        textAreaStruk.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textAreaStruk.setText(struk);

        JScrollPane scrollPane = new JScrollPane(textAreaStruk);

        btnSimpan = new JButton("Simpan Struk");
        btnTutup = new JButton("Tutup");

        // Layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSimpan);
        buttonPanel.add(btnTutup);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Event listeners
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanStruk();
            }
        });

        btnTutup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Finalize dialog
        pack();
        setLocationRelativeTo(parent);
    }

    private void simpanStruk() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Simpan Struk");

        // Default filename dengan timestamp
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String defaultFilename = "struk_" + sdf.format(new Date()) + ".txt";
        fileChooser.setSelectedFile(new File(defaultFilename));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            PesananWriter writer = new PesananWriter();
            boolean success = writer.saveStrukToFile(struk, fileToSave.getAbsolutePath());

            if (success) {
                JOptionPane.showMessageDialog(this,
                        "Struk berhasil disimpan ke " + fileToSave.getName(),
                        "Simpan Berhasil",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Gagal menyimpan struk!",
                        "Kesalahan",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}