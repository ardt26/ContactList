package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListView extends JFrame {

    JLabel lTitle = new JLabel("Contact List", JLabel.CENTER);
    JLabel lNama = new JLabel("Nama : ");
    JTextField tfNama = new JTextField();
    JLabel lNoHP = new JLabel("No. HP : ");
    JTextField tfNoHP = new JTextField();
    JLabel lUmur = new JLabel("Umur : ");
    JTextField tfUmur = new JTextField();
    JLabel lEmail = new JLabel("Email : ");
    JTextField tfEmail = new JTextField();

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnCancel = new JButton("Cancel");
    public JButton btnEdit = new JButton("Edit");

    public JPanel panel;
    public JTable table;
    public Object namaKolom[] = {"Nama","No. HP","Umur","E-mail"};
    DefaultTableModel tableModel;
    JScrollPane scrollPanel;

    Color serenity = new Color(146,168,209);
    Color half = new Color(197,185,205);

    public ListView(){
        tableModel = new DefaultTableModel(namaKolom,0);
        table = new JTable(tableModel);
        table.setFont(new Font("Gilroy Light", Font.PLAIN,15));
        table.setBackground(half);
        table.setForeground(Color.white);
        scrollPanel = new JScrollPane(table);

        setTitle("Contact List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(700,500);

        add(lTitle);
        lTitle.setFont(new Font("Big John", Font.PLAIN,24));
        lTitle.setBounds(250,10,200,40);
        lTitle.setForeground(half);

        add(lNama);
        lNama.setBounds(50,60,90,20);
        lNama.setFont(new Font("Gilroy Light", Font.PLAIN,18));
        add(tfNama);
        tfNama.setBounds(150,60,150,20);

        add(lNoHP);
        lNoHP.setBounds(400,60,90,20);
        lNoHP.setFont(new Font("Gilroy Light", Font.PLAIN,18));
        add(tfNoHP);
        tfNoHP.setBounds(500,60,150,20);

        add(lUmur);
        lUmur.setBounds(50,90,90,20);
        lUmur.setFont(new Font("Gilroy Light", Font.PLAIN,18));
        add(tfUmur);
        tfUmur.setBounds(150,90,150,20);

        add(lEmail);
        lEmail.setBounds(400,90,90,20);
        lEmail.setFont(new Font("Gilroy Light", Font.PLAIN,18));
        add(tfEmail);
        tfEmail.setBounds(500,90,150,20);

        add(btnTambah);
        btnTambah.setBounds(155,140,100,20);
        btnTambah.setFont(new Font("Gilroy Light", Font.PLAIN,15));
        btnTambah.setForeground(Color.white);
        btnTambah.setBackground(serenity);

        add(btnEdit);
        btnEdit.setBounds(295,140,100,20);
        btnEdit.setFont(new Font("Gilroy Light", Font.PLAIN,15));
        btnEdit.setForeground(Color.white);
        btnEdit.setBackground(serenity);

        add(btnCancel);
        btnCancel.setBounds(435,140,100,20);
        btnCancel.setFont(new Font("Gilroy Light", Font.PLAIN,15));
        btnCancel.setForeground(Color.white);
        btnCancel.setBackground(serenity);

        add(scrollPanel);
        scrollPanel.setBounds(25, 200, 650, 200);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public String getNama() {
        return tfNama.getText();
    }

    public void setNama(String tfNama) {
        this.tfNama.selectAll();
        this.tfNama.replaceSelection(tfNama);
    }

    public String getNoHP() {
        return tfNoHP.getText();
    }

    public void setNoHP(String tfNoHP) {
        this.tfNoHP.selectAll();
        this.tfNoHP.replaceSelection(tfNoHP);
    }

    public String getUmur() {
        return tfUmur.getText();
    }

    public void setUmur(String tfUmur) {
        this.tfUmur.selectAll();
        this.tfUmur.replaceSelection(tfUmur);
    }

    public String getEmail() {
        return tfEmail.getText();
    }

    public void setEmail(String tfEmail) {
        this.tfEmail.selectAll();
        this.tfEmail.replaceSelection(tfEmail);
    }
}
