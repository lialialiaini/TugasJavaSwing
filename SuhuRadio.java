import javax.swing.*;
import java.awt.*;

// Tugas 2: Konversi Suhu dengan Radio Button & Switch getActionCommand()
public class SuhuRadio extends JFrame {
    public SuhuRadio() {
        super("Konversi Suhu");

        // 1. Terapkan Look and Feel Nimbus (Materi PPT)
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}

        // 2. Komponen Utama
        JTextField txt = new JTextField(8);
        ButtonGroup g = new ButtonGroup();
        JRadioButton f = new JRadioButton("Fahrenheit", true);
        JRadioButton k = new JRadioButton("Kelvin");
        JRadioButton r = new JRadioButton("Reamur");

        f.setActionCommand("F"); 
        k.setActionCommand("K"); 
        r.setActionCommand("R");
        
        g.add(f); g.add(k); g.add(r);

        JButton btn = new JButton("Konversi");
        JLabel hasil = new JLabel("Hasil: -");

        // 3. Event Listener Tombol
        btn.addActionListener(e -> {
            try {
                double c = Double.parseDouble(txt.getText().trim());
                switch (g.getSelection().getActionCommand()) {
                    case "F": hasil.setText(String.format("Hasil: %.2f F", c * 9 / 5 + 32)); break;
                    case "K": hasil.setText(String.format("Hasil: %.2f K", c + 273.15)); break;
                    default:  hasil.setText(String.format("Hasil: %.2f R", c * 4 / 5));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Isi suhu dengan angka.");
            }
        });

        // 4. Menu Bar Sederhana (Nilai Plus dari Materi PPT)
        JMenuBar mb = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenuItem mKeluar = new JMenuItem("Keluar");
        mKeluar.addActionListener(e -> System.exit(0));
        mFile.add(mKeluar);
        mb.add(mFile);
        setJMenuBar(mb);

        // 5. Layout & Tampilan Jendela
        setLayout(new GridLayout(0, 1, 5, 5));
        add(new JLabel("Suhu (Celcius):")); 
        add(txt); 
        add(f); 
        add(k); 
        add(r); 
        add(btn); 
        add(hasil);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tugas2_SuhuRadio().setVisible(true));
    }
}

