package Controller;

import Model.ContactModel;
import View.ListView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContactController {

    ContactModel contactModel;
    ListView listView;

    public ContactController(ContactModel contactModel, ListView listView) {
        this.contactModel = contactModel;
        this.listView = listView;

        if (contactModel.getBanyakData() != 0){
            String dataContact[][] = contactModel.readContact();
            listView.table.setModel(new JTable(dataContact, listView.namaKolom).getModel());
        } else{
            JOptionPane.showMessageDialog(null,"Data Tidak Ada");
        }

        listView.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listView.getNoHP().equals("")){
                    String sNama = listView.getNama();
                    String sNoHP = listView.getNoHP();
                    String sUmur = listView.getUmur();
                    String sEmail = listView.getEmail();
                    contactModel.insertContact(sNama,sNoHP,sUmur,sEmail);

                    String dataContact[][] = contactModel.readContact();
                    listView.table.setModel(new JTable(dataContact,listView.namaKolom).getModel());
                    cancelMahasiswa();
                } else {
                    JOptionPane.showMessageDialog(null,"Nomor HP Tidak Boleh Kosong");
                }
            }
        });

        listView.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!listView.getNoHP().equals("")){
                    String sNama = listView.getNama();
                    String sNoHP = listView.getNoHP();
                    String sUmur = listView.getUmur();
                    String sEmail = listView.getEmail();
                    contactModel.editContact(sNama,sNoHP,sUmur,sEmail);

                    String dataContact[][] = contactModel.readContact();
                    listView.table.setModel(new JTable(dataContact,listView.namaKolom).getModel());
                    cancelMahasiswa();
                } else {
                    JOptionPane.showMessageDialog(null,"Nomor HP Tidak Boleh Kosong");
                }
            }
        });

        listView.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelMahasiswa();
            }
        });

        listView.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = listView.table.getSelectedRow();
                int kolom = listView.table.getSelectedColumn();

                String dataTerpilih = listView.table.getValueAt(baris,1).toString();

                int input = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus Nomor " + dataTerpilih + "?","Delete Contact",JOptionPane.YES_NO_OPTION);

                if (input == 0){
                    contactModel.deleteContact(dataTerpilih);
                    String dataContact[][] = contactModel.readContact();
                    listView.table.setModel(new JTable(dataContact, listView.namaKolom).getModel());
                }
            }
        });
    }

    public void cancelMahasiswa () {
        listView.setNama("");
        listView.setNoHP("");
        listView.setUmur("");
        listView.setEmail("");
    }
}
