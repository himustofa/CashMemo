package kamal;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author g
 */
/*

1   0        0         00   00        0         1
1  0	   0   0       0 0 0 0      0   0       1
1 0       0     0      0  0  0     0     0      1
1  0      0000000      0     0     0000000      1
1   0     0     0      0     0     0     0      0000000
-------------------------------------------------------
 Courtesy by Mustofa Kamal | www.facebook.com/hikamal
-------------------------------------------------------

 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public void Delete() throws SQLException {

        int index = tableModel.getSelectedRow();
        TableModel m = tableModel.getModel();
        String sn = m.getValueAt(index, 0).toString();

        Connection con = null;
        Statement stm = null;

        DefaultTableModel model = (DefaultTableModel) tableModel.getModel();
        model.removeRow(tableModel.getSelectedRow());

        try {
            //Register the driver class
            Class.forName("com.mysql.jdbc.Driver");

            //Create the connection object
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kamal", "root", "123");

            //Create the statement object
            stm = con.createStatement();

            //Execute the query
            int count = 0;
            count = stm.executeUpdate("delete from projecttable where serial = '" + sn + "' ");
            //DELETE FROM tableName WHERE supplier_id=1;

            //Check the query
            if (count > 0) {
                System.out.println("Inserted successfully");
            } else {
                System.out.println("Insertion failed");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            con.close();
            stm.close();
        }

    }

    public void Show() throws SQLException {

        Connection con = null;
        Statement stm = null;
        ResultSet rs;

        DefaultTableModel model = (DefaultTableModel) tableModel.getModel();

        try {
            //Register the driver class
            Class.forName("com.mysql.jdbc.Driver");

            //Create the connection object
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kamal", "root", "123");

            //Create the statement object
            stm = con.createStatement();

            //Execute the query
            int count = 0;
            rs = stm.executeQuery("SELECT * FROM projecttable");

            Vector<String> column = new Vector<String>();
            //Table column name
            column.add("Serial No");
            column.add("Name");
            column.add("Address");
            column.add("Mobile");
            column.add("Category");
            column.add("Performance");
            column.add("Model");
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> row = new Vector<Object>();
                //Database column name
                row.add(rs.getString("Serial"));
                row.add(rs.getString("Name"));
                row.add(rs.getString("Address"));
                row.add(rs.getString("Mobile"));
                row.add(rs.getString("Category"));
                row.add(rs.getString("Performance"));
                row.add(rs.getString("Model"));
                data.add(row);                                                  //add each result/row to data Vector
            }
            model.setDataVector(data, column);

            //Check the query
            if (count > 0) {
                System.out.println("Inserted successfully");
            } else {
                System.out.println("Insertion failed");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            con.close();
            stm.close();
        }

    }

    public void Search() throws SQLException {

        Connection con = null;
        Statement stm = null;
        ResultSet rs;

        DefaultTableModel model = (DefaultTableModel) tableModel.getModel();

        try {
            //Register the driver class
            Class.forName("com.mysql.jdbc.Driver");

            //Create the connection object
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kamal", "root", "123");

            //Create the statement object
            stm = con.createStatement();

            //Execute the query
            int count = 0;
            rs = stm.executeQuery("SELECT * FROM projecttable where name = '" + searchingText.getText() + "'");

            Vector<String> column = new Vector<String>();
            //Table column name
            column.add("Serial No");
            column.add("Name");
            column.add("Address");
            column.add("Mobile");
            column.add("Category");
            column.add("Performance");
            column.add("Model");
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> row = new Vector<Object>();
                //Database column name
                row.add(rs.getString("Serial"));
                row.add(rs.getString("Name"));
                row.add(rs.getString("Address"));
                row.add(rs.getString("Mobile"));
                row.add(rs.getString("Category"));
                row.add(rs.getString("Performance"));
                row.add(rs.getString("Model"));
                data.add(row);                                                  //add each result/row to data Vector
            }
            model.setDataVector(data, column);

            //Check the query
            if (count > 0) {
                System.out.println("Inserted successfully");
            } else {
                System.out.println("Insertion failed");
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            con.close();
            stm.close();
        }

    }

    public MainFrame() {
        initComponents();
        showDate();

        try {
            Show();
        } catch (Exception e) {
        }
    }

    void showDate() {
        DateFormat dF = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss a");          //"YYYY/MM/dd hh:mm:ss a" Or "YYYY-MM-dd"
        java.util.Date d = new java.util.Date();
        showDate.setText(dF.format(d));                                         //d.toString() do not need
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        searchingText = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableModel = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        userButton = new javax.swing.JButton();
        singoutButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        show = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        showLabel = new javax.swing.JLabel();
        showDate = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        add = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        tableModel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No", "Name", "Address", "Mobile", "Category", "Performance", "Model"
            }
        ));
        tableModel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableModelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableModel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchingText, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchingText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        userButton.setText("Create an User");
        userButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userButtonActionPerformed(evt);
            }
        });

        singoutButton.setText("Sing Out");
        singoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singoutButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        show.setText("Show");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userButton, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(singoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(show)
                .addGap(27, 27, 27)
                .addComponent(userButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(singoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Forte", 1, 24)); // NOI18N
        jLabel6.setText("Simple Project");

        jLabel7.setText("Mustofa Kamal | www.facebook.com/hikamal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(1, 1, 1)
                .addComponent(jLabel7))
        );

        jMenu1.setText("File");

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jMenu1.add(add);

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jMenu1.add(edit);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jMenu1.add(delete);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        menuBar.add(jMenu1);

        jMenu3.setText("Help");
        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(showLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(showDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showDate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(showLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(893, 434));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:

        AddForm x = new AddForm();
        x.setVisible(true);
        //x.setEnabled(false);
        dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        AddForm x = new AddForm();
        x.setVisible(true);
        dispose();
        x.serial.enable(false);

        int index = tableModel.getSelectedRow();

        TableModel m = tableModel.getModel();

        String sn = m.getValueAt(index, 0).toString();
        String nam = m.getValueAt(index, 1).toString();
        String add = m.getValueAt(index, 2).toString();
        String mob = m.getValueAt(index, 3).toString();

        String cat = m.getValueAt(index, 4).toString();
        if (cat.equals("Desktop")) {
            x.desk.setSelected(true);
        }
        if (cat.equals("Laptop")) {
            x.lap.setSelected(true);
        }

//        String per = m.getValueAt(index, 5).toString();
//        if (per.equals("Low")) {
//            x.low.setSelected(true);
//        }
//        if (per.equals("Medium")) {
//            x.medium.setSelected(true);
//        }
//        if (per.equals("High")) {
//            x.high.setSelected(true);
//        }
//        String mod = m.getValueAt(index, 6).toString();
//        if (mod.equals("Apple")) {
//            x.setSelectedItem(true);
//        }
//        if (mod.equals("Dell")) {
//            x.setSelectedItem(true);
//        }
//        if (mod.equals("Fujitsu")) {
//            x.setSelectedItem(true);
//        }
//        if (mod.equals("Lenovo")) {
//            x.setSelectedItem(true);
//        }
//        if (mod.equals("Sony Vio")) {
//            x.setSelectedItem(true);
//        }
//        if (mod.equals("Toshiba")) {
//            x.setSelectedItem(true);
//        }
        x.serial.setText(sn);
        x.name.setText(nam);
        x.address.setText(add);
        x.mobile.setText(mob);
        //x.serial.setText(cat);
        //x.serial.setText(per);
        //x.item.isSelected(mod);

//        DefaultTableModel model = (DefaultTableModel) tableModel.getModel();
//        model.setValueAt(serial.getText(), tableModel.getSelectedRow(), 0);
//        model.setValueAt(jComboBox1.getSelectedItem().toString(), tableModel.getSelectedRow(), 1);
//        model.setValueAt(jTextField3.getText(), tableModel.getSelectedRow(), 2);

    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) tableModel.getModel();

        try {
            Delete();
        } catch (Exception e) {
        }

        if (tableModel.getSelectedRow() == -1) {
            if (tableModel.getRowCount() == 0) {
                showLabel.setText("Table is empty");
            } else {
                showLabel.setText("You must select a product");
            }
        } else {
            model.removeRow(tableModel.getSelectedRow());
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userButtonActionPerformed
        // TODO add your handling code here:
        SingUp x = new SingUp();
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_userButtonActionPerformed

    private void singoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singoutButtonActionPerformed
        // TODO add your handling code here:
        SingInSingUp x = new SingInSingUp();
        x.setVisible(true);
        dispose();
    }//GEN-LAST:event_singoutButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        try {
            Search();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void tableModelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableModelMouseClicked
        // TODO add your handling code here:
//        DefaultTableModel model = (DefaultTableModel) tableModel.getModel();
//        name.setText(model.getValueAt(tableModel.getSelectedRow(), 0).toString());
//        address.setText(model.getValueAt(tableModel.getSelectedRow(), 1).toString());
//        item.setSelectedItem(model.getValueAt(tableModel.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tableModelMouseClicked

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        // TODO add your handling code here:
        try {
            Show();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_showActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableModel.getModel();
        try {
            Delete();
        } catch (Exception e) {
        }
        if (tableModel.getSelectedRow() == -1) {
            if (tableModel.getRowCount() == 0) {
                showLabel.setText("Table is empty");
            } else {
                showLabel.setText("You must select a product");
            }
        } else {
            model.removeRow(tableModel.getSelectedRow());
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        AddForm x = new AddForm();
        x.setVisible(true);
        //x.setEnabled(false);
        dispose();
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        AddForm x = new AddForm();
        x.setVisible(true);
        dispose();
        x.serial.enable(false);

        int index = tableModel.getSelectedRow();

        TableModel m = tableModel.getModel();

        String sn = m.getValueAt(index, 0).toString();
        String nam = m.getValueAt(index, 1).toString();
        String add = m.getValueAt(index, 2).toString();
        String mob = m.getValueAt(index, 3).toString();

        String cat = m.getValueAt(index, 4).toString();
        if (cat.equals("Desktop")) {
            x.desk.setSelected(true);
        }
        if (cat.equals("Laptop")) {
            x.lap.setSelected(true);
        }

        x.serial.setText(sn);
        x.name.setText(nam);
        x.address.setText(add);
        x.mobile.setText(mob);
    }//GEN-LAST:event_editActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(new JFrame(), "Are you sure?", "Closing application", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(new JFrame(), "Are you sure?", "Closing application", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem add;
    private javax.swing.JButton addButton;
    private javax.swing.JMenuItem delete;
    private javax.swing.JButton deleteButton;
    private javax.swing.JMenuItem edit;
    private javax.swing.JButton editButton;
    private javax.swing.JMenuItem exit;
    private javax.swing.JButton exitButton;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchingText;
    private javax.swing.JButton show;
    private javax.swing.JLabel showDate;
    private javax.swing.JLabel showLabel;
    private javax.swing.JButton singoutButton;
    private javax.swing.JTable tableModel;
    private javax.swing.JButton userButton;
    // End of variables declaration//GEN-END:variables
}
