/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.CustomerDAO;
import Controllers.ProductDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro
 */
public class Customer extends javax.swing.JFrame {
    CustomerDAO customersDAO = new CustomerDAO();
    /**
     * Creates new form Product
     */
    public Customer() {
        initComponents();
        this.refreshProductsTable("init");
    }

    public void refreshProductsTable(String mode) {
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
        ArrayList<Models.Customer> productsList = customersDAO.listCustomers();
        // int rows = model.getRowCount();

        model.setRowCount(0);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        for (int i = 0; i < productsList.size(); i++) {
            model.addRow(new Object[]{
                productsList.get(i).getCustomer_id(),
                productsList.get(i).getCustomer_name(),
                productsList.get(i).getCustomer_phone(),
                productsList.get(i).getCustomer_address(),
            });
        }

        productsList.clear();
    }
    
    public void clearFields() {
        jTextFieldCustomerName.setText("");
        jTextFieldCustomerPhone.setText("");
        jTextFieldCustomerAddress.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelProductTitle = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        jButtonCreate = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelProdName = new javax.swing.JLabel();
        jTextFieldCustomerName = new javax.swing.JTextField();
        jLabelProdDescription = new javax.swing.JLabel();
        jLabelProdName1 = new javax.swing.JLabel();
        jTextFieldCustomerAddress = new javax.swing.JTextField();
        jTextFieldCustomerPhone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelProductTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelProductTitle.setText("Manage Customers");

        jButtonDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonCreate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCreate.setText("Create");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Phone", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableProducts);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jLabelProdName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProdName.setForeground(new java.awt.Color(97, 97, 97));
        jLabelProdName.setText("Name");

        jTextFieldCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCustomerNameActionPerformed(evt);
            }
        });

        jLabelProdDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProdDescription.setForeground(new java.awt.Color(97, 97, 97));
        jLabelProdDescription.setText("Phone");

        jLabelProdName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProdName1.setForeground(new java.awt.Color(97, 97, 97));
        jLabelProdName1.setText("Address");

        jTextFieldCustomerAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCustomerAddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelProdName)
                    .addComponent(jTextFieldCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(jLabelProdDescription)
                    .addComponent(jLabelProdName1)
                    .addComponent(jTextFieldCustomerAddress)
                    .addComponent(jTextFieldCustomerPhone))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProdName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelProdDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelProdName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabelProductTitle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelProductTitle)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        int row = jTableProducts.getSelectedRow();
        String id = jTableProducts.getValueAt(row, 0).toString();
        String name = jTableProducts.getValueAt(row, 1).toString();
        String phone = jTableProducts.getValueAt(row, 2).toString();

        Models.Customer customer = new Models.Customer();

        customer.setCustomer_id(Integer.parseInt(id));
        customer.setCustomer_name(name);
        customer.setCustomer_phone(phone);
        
        customersDAO.deleteCustomer(customer);
        this.refreshProductsTable("delete");
        this.clearFields();
        JOptionPane.showMessageDialog(null, "The customer was successfully deleted!", "Success", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        String name = jTextFieldCustomerName.getText();
        String address = jTextFieldCustomerAddress.getText();
        String phone = jTextFieldCustomerPhone.getText();

        if (name.equals("") || phone.equals("")) {
            JOptionPane.showMessageDialog(null, "Some fields require your attention!", "Fill in all the fields!", JOptionPane.ERROR_MESSAGE);
        } else {
            Models.Customer customer = new Models.Customer();

            customer.setCustomer_name(name);
            customer.setCustomer_phone(phone);
            customer.setCustomer_address(address);
            
            customersDAO.CreateCustomer(customer);
            JOptionPane.showMessageDialog(
                null,
                "The customer was successfully created!",
                "Success",
                JOptionPane.PLAIN_MESSAGE
            );
            this.clearFields();
            this.refreshProductsTable("add");
        }
    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        int row = jTableProducts.getSelectedRow();
        String id = jTableProducts.getValueAt(row, 0).toString();
        String name = jTableProducts.getValueAt(row, 1).toString();
        String phone = jTableProducts.getValueAt(row, 2).toString();
        String address = jTableProducts.getValueAt(row, 3).toString();
        
        if (address == "") {
            address = null;
        }
        
        System.out.println("Address:" + address);

        // ArrayList<Models.Product> productsList = productsDAO.listProducts();
        
        Models.Customer customer = new Models.Customer(
            Integer.parseInt(id),
            name,
            phone,
            address
        );

        customersDAO.updateCustomer(customer);
        this.refreshProductsTable("update");
        this.clearFields();
        JOptionPane.showMessageDialog(null, "The customer was successfully updated!", "Success", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jTextFieldCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustomerNameActionPerformed

    private void jTextFieldCustomerAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCustomerAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustomerAddressActionPerformed

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelProdDescription;
    private javax.swing.JLabel jLabelProdName;
    private javax.swing.JLabel jLabelProdName1;
    private javax.swing.JLabel jLabelProductTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JTextField jTextFieldCustomerAddress;
    private javax.swing.JTextField jTextFieldCustomerName;
    private javax.swing.JTextField jTextFieldCustomerPhone;
    // End of variables declaration//GEN-END:variables
}
