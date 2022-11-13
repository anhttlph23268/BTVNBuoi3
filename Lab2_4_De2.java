package View;

import Service.ServiceLab2_4_De2;
import ViewModel.DongVat;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Lab2_4_De2 extends javax.swing.JFrame {
    
    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcm;
    private final ServiceLab2_4_De2 sv;
    private final ButtonGroup b;
    private final Dialog dialog;
    
    public Lab2_4_De2() {
        initComponents();
        setLocationRelativeTo(null);// set Jframe giữa màn hình
        this.dialog = new Dialog();
        this.dtm = new DefaultTableModel();
        this.dcm = new DefaultComboBoxModel();
        this.sv = new ServiceLab2_4_De2();
        b = new ButtonGroup();
        b.add(this.rdoDuc);
        b.add(this.rdoCai);
        this.rdoDuc.setSelected(true);
        this.addComboBox();
        this.addColums();
        this.loadTable(this.sv.getList());
        this.statup();
    }
    
    void addComboBox() {
        ArrayList<String> listCBB = new ArrayList<>();
        listCBB.add("2000");
        listCBB.add("2001");
        listCBB.add("2002");
        listCBB.add("2003");
        listCBB.add("2004");
        listCBB.add("2005");
        listCBB.add("2006");
        listCBB.add("2007");
        listCBB.add("2008");
        listCBB.add("2009");
        
        dcm = (DefaultComboBoxModel) this.cbNamSinh.getModel();
        
        for (String item : listCBB) {
            dcm.addElement(item);
        }
        this.cbNamSinh.setSelectedIndex(0);
    }
    
    void addColums() {
        ArrayList<String> listColums = new ArrayList<>();
        listColums.add("Mã ĐV");
        listColums.add("Tên ĐV");
        listColums.add("Cân Nặng");
        listColums.add("Giới Tính");
        listColums.add("Năm Sinh");
        listColums.add("Trạng Thái");
        
        dtm = (DefaultTableModel) this.tbStudentList.getModel();
        dtm.setRowCount(0);
        for (String item : listColums) {
            dtm.addColumn(item);
        }
    }
    
    void loadTable(ArrayList<DongVat> listDV) {
        dtm = (DefaultTableModel) this.tbStudentList.getModel();
        dtm.setRowCount(0);
        
        for (DongVat dongVat : listDV) {
            Object[] rowData = {
                dongVat.getMaDV(),
                dongVat.getTenDv(),
                dongVat.getCanNang(),
                dongVat.isGioiTinh(),
                dongVat.getNamSinh(),
                dongVat.trangThai()
            };
            dtm.addRow(rowData);
        }
    }
    
    void statup() {
        int row = 2;
        this.txtMaDV.setText(this.tbStudentList.getValueAt(row, 0).toString());
        this.txtTenDV.setText(this.tbStudentList.getValueAt(row, 1).toString());
        this.txtCanNang.setText(this.tbStudentList.getValueAt(row, 2).toString());
        if (this.tbStudentList.getValueAt(row, 3).toString().equals(true)) {
            this.rdoDuc.setSelected(true);
        }
        if (this.tbStudentList.getValueAt(row, 3).toString().equals(false)) {
            this.rdoCai.setSelected(true);
        }
        this.cbNamSinh.setSelectedItem(this.tbStudentList.getValueAt(row, 4).toString());
    }
    
    void clearForm() {
        this.txtTenSearch.setText("");
        this.txtCanNangMin.setText("");
        this.txtCanNangMax.setText("");
        this.txtMaDV.setText("");
        this.txtTenDV.setText("");
        this.txtCanNang.setText("");
        this.rdoDuc.setSelected(true);
        this.cbNamSinh.setSelectedIndex(0);
        
    }
    
    public DongVat getFormData() {
        String maStr = this.txtMaDV.getText().trim();
        String tenStr = this.txtTenDV.getText().trim();
        String canNangStr = this.txtCanNang.getText().trim();
        boolean gioiTinhStr = true;
        String namSinhStr = this.cbNamSinh.getSelectedItem().toString();
        
        if (maStr.equals("") || tenStr.equals("") || canNangStr.equals("")) {
            JOptionPane.showMessageDialog(this, "Thiếu dữ liệu!");
            return null;
        }
        
        int canNang = -1;
        try {
            canNang = Integer.parseInt(canNangStr);
            if (canNang < 0) {
                JOptionPane.showMessageDialog(this, "Cân nặng phải > 0!");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cân nặng phải là số!");
            return null;
        }
        
        if (this.rdoDuc.isSelected()) {
            gioiTinhStr = true;
        }
        if (this.rdoCai.isSelected()) {
            gioiTinhStr = false;
        }
        
        int namSinh = Integer.parseInt(namSinhStr);
        
        DongVat dv = new DongVat(maStr, tenStr, canNang, gioiTinhStr, namSinh);
        return dv;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSearch = new javax.swing.JTextField();
        btnSearchByName = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCanNangMin = new javax.swing.JTextField();
        txtCanNangMax = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaDV = new javax.swing.JTextField();
        txtCanNang = new javax.swing.JTextField();
        txtTenDV = new javax.swing.JTextField();
        rdoDuc = new javax.swing.JRadioButton();
        rdoCai = new javax.swing.JRadioButton();
        cbNamSinh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnTop5 = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStudentList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel1.setText("Search theo tên");

        jLabel2.setText("Tên");

        btnSearchByName.setText("Search By Name");
        btnSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Search theo khoảng cân nặng");

        jLabel4.setText("Cân Nặng Min");

        jLabel5.setText("Cân Nặng Max");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Mã ĐV");

        jLabel8.setText("Tên ĐV");

        jLabel9.setText("Cân Nặng");

        jLabel10.setText("Giới Tính");

        jLabel11.setText("Năm Sinh");

        txtMaDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaDVMouseClicked(evt);
            }
        });

        txtCanNang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCanNangMouseClicked(evt);
            }
        });

        txtTenDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenDVMouseClicked(evt);
            }
        });

        rdoDuc.setText("Đực");
        rdoDuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDucMouseClicked(evt);
            }
        });

        rdoCai.setText("Cái");
        rdoCai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoCaiMouseClicked(evt);
            }
        });

        cbNamSinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbNamSinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(rdoDuc)
                                        .addGap(80, 80, 80)
                                        .addComponent(rdoCai))
                                    .addComponent(cbNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCanNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdoDuc)
                    .addComponent(rdoCai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(50, 50, 50))
        );

        jLabel6.setText("Information");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnTop5.setText("Top 5");

        btnSort.setText("Sort");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText(" Student List");

        tbStudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbStudentList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnClear)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdd)
                                    .addComponent(btnTop5)
                                    .addComponent(btnSort)
                                    .addComponent(btnExit)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCanNangMax)
                                            .addComponent(txtCanNangMin)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addGap(58, 58, 58)
                                .addComponent(txtTenSearch)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearchByName)
                            .addComponent(btnSearch))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClear)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchByName))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCanNangMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCanNangMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnTop5)
                        .addGap(18, 18, 18)
                        .addComponent(btnSort)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit)))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        int max = Integer.parseInt(this.txtCanNangMax.getText().trim());
        int min = Integer.parseInt(this.txtCanNangMin.getText().trim());
        this.loadTable(this.sv.getListSearch(max, min));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DongVat dv = this.getFormData();
        
        if (dv == null) {
            return;
        }
        this.sv.addList(dv);
        this.loadTable(this.sv.getList());
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByNameActionPerformed
        String nameSearch = this.txtTenSearch.getText().trim();
        if (nameSearch.equals("")) {
            JOptionPane.showMessageDialog(this, "Tên search rỗng!");
        } else {
            this.loadTable(this.sv.getListSearchByName(nameSearch));
            JOptionPane.showMessageDialog(this, "Search thành công!");
        }
    }//GEN-LAST:event_btnSearchByNameActionPerformed

    private void txtMaDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaDVMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtMaDVMouseClicked

    private void txtTenDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenDVMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtTenDVMouseClicked

    private void txtCanNangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCanNangMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtCanNangMouseClicked

    private void cbNamSinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNamSinhMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cbNamSinhMouseClicked

    private void rdoDucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDucMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rdoDucMouseClicked

    private void rdoCaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoCaiMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rdoCaiMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lab2_4_De2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchByName;
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btnTop5;
    private javax.swing.JComboBox<String> cbNamSinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoCai;
    private javax.swing.JRadioButton rdoDuc;
    private javax.swing.JTable tbStudentList;
    private javax.swing.JTextField txtCanNang;
    private javax.swing.JTextField txtCanNangMax;
    private javax.swing.JTextField txtCanNangMin;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextField txtTenDV;
    private javax.swing.JTextField txtTenSearch;
    // End of variables declaration//GEN-END:variables
}
