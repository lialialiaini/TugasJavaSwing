import javax.swing.*;
import java.awt.*;

public class Seminar extends JFrame {
    public Seminar() {
        super("Pendaftaran Seminar");

        // Terapkan Nimbus agar tampilan lebih rapi
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {}

        // Komponen Utama
        JTextField nama = new JTextField(14);
        JRadioButton mhs = new JRadioButton("Mahasiswa (Rp 50.000)", true);
        JRadioButton umum = new JRadioButton("Umum (Rp 100.000)");
        ButtonGroup g = new ButtonGroup(); 
        g.add(mhs); g.add(umum);

        JCheckBox ws = new JCheckBox("Workshop (+Rp 30.000)");
        JCheckBox makan = new JCheckBox("Makan Siang (+Rp 25.000)");
        JCheckBox sert = new JCheckBox("Sertifikat (+Rp 10.000)");

        JButton btn = new JButton("Daftar");
        JLabel hasil = new JLabel("Belum mendaftar");

        // Menu Bar Sederhana (Nilai Plus dari Materi)
        JMenuBar mb = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem mKeluar = new JMenuItem("Keluar");
        mKeluar.addActionListener(e -> System.exit(0));
        mFile.add(mKeluar);
        mb.add(mFile);
        setJMenuBar(mb);

        // Aksi Tombol
        btn.addActionListener(e -> {
            if (nama.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int total = mhs.isSelected() ? 50000 : 100000;
            if (ws.isSelected()) total += 30000;
            if (makan.isSelected()) total += 25000;
            if (sert.isSelected()) total += 10000;

            int j = JOptionPane.showConfirmDialog(this, "Total Rp " + total + ". Daftar sekarang?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (j == JOptionPane.YES_OPTION) {
                hasil.setText(nama.getText().trim() + " terdaftar, Rp " + total);
            } else {
                hasil.setText("Pendaftaran dibatalkan");
            }
        });

        // Layout & Pengaturan Jendela
        setLayout(new GridLayout(0, 1, 3, 3));
        add(new JLabel("Nama:")); add(nama);
        add(mhs); add(umum);
        add(ws); add(makan); add(sert);
        add(btn); add(hasil);

        setSize(320, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Seminar().setVisible(true));
    }
}
