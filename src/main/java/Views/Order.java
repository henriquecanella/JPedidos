/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.CustomerDAO;
import Controllers.OrderDAO;
import Controllers.ProductDAO;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author lucas
 */
public class Order extends javax.swing.JFrame {
    ArrayList<JTextField> fieldsArr = new ArrayList<JTextField>();
    ProductDAO productController = new ProductDAO();
    OrderDAO orderController = new OrderDAO();
    CustomerDAO customerController = new CustomerDAO();
    ArrayList<Models.Product> productsList = productController.listProducts();
    ArrayList<Models.Customer> customerList = customerController.listCustomers();
    private String userId = "";
    private int customerId;
    
    /**
     * Creates new form PrototipoTelaPedidos
     */
    public Order() {}
    public Order(String userId) {
        this.userId = userId;

        System.out.println("userId: " + userId);
        initComponents();        
        insertProduct(productsList);
        populateCustomers(customerList);
    }

    public float calculateTotalPrice() {
        float total = 0;

        for (int i = 0; i < this.fieldsArr.size(); i++) {
            try {
                int prodAmount = Integer.parseInt(this.fieldsArr.get(i).getText());
                float prodPrice = productsList.get(i).getProduct_price();

                total = total + (prodAmount * prodPrice);
            } catch (NumberFormatException ex) {
                System.out.println("Exception: Invalid format!");
            }
        }

        this.jLabelTotalResult.setText(String.valueOf(total));
        return total;
    }
    
    public void populateCustomers(ArrayList<Models.Customer> customersList) {
        if (customersList.size() > 0) {
            for (int i = 0; i < customersList.size(); i++) {
                jComboBoxCustomerName.addItem(customersList.get(i).getCustomer_name());
            }
        }
    }

    public void insertProduct(ArrayList<Models.Product> productsList) {
        if (productsList.size() > 0) {
            jPanel1.setLayout(new GridLayout(productsList.size() + 1, 1, 0, 0));
            for (int i = 0; i < productsList.size(); i++) {
                JCheckBox checkBox = new JCheckBox();
                JLabel labelPrice = new JLabel();
                JTextField textFieldAmount = new JTextField();
                JPanel panelTest = new JPanel();

                panelTest.setLayout(new GridLayout());

                labelPrice.setText(String.valueOf(productsList.get(i).getProduct_price()));
                checkBox.setText(productsList.get(i).getProduct_name());
                checkBox.setPreferredSize(new Dimension(73, 23));
                textFieldAmount.setSize(27, 10);
                textFieldAmount.setMaximumSize(new Dimension(30, 10));
                textFieldAmount.setText("0");

                if (textFieldAmount != null) {
                    fieldsArr.add(textFieldAmount);
                }

                panelTest.add(checkBox);
                panelTest.add(labelPrice);
                panelTest.add(textFieldAmount);

                jPanel1.add(panelTest);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSaveOrder = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jLabelTotalResult = new javax.swing.JLabel();
        jLabelCustomerName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonCalculate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxCustomerName = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonSaveOrder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSaveOrder.setText("Save");
        jButtonSaveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveOrderActionPerformed(evt);
            }
        });

        jLabelTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTotal.setText("Total $:");

        jLabelTotalResult.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTotalResult.setText("0.00");

        jLabelCustomerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCustomerName.setText("Nome do Cliente");

        jButtonCalculate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCalculate.setText("Calculate");
        jButtonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateActionPerformed(evt);
            }
        });

        jScrollPane1.setMaximumSize(new java.awt.Dimension(32767, 500));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Product Name");
        jPanel2.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Price");
        jPanel2.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Amount");
        jPanel2.add(jLabel9);

        jPanel1.add(jPanel2);

        jScrollPane1.setViewportView(jPanel1);

        jComboBoxCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCustomerNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCustomerName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotal)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTotalResult, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButtonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSaveOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 202, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCustomerName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTotalResult)
                        .addComponent(jLabelTotal)
                        .addComponent(jButtonSaveOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculateActionPerformed
        this.calculateTotalPrice();
    }//GEN-LAST:event_jButtonCalculateActionPerformed

    private void jButtonSaveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveOrderActionPerformed

        String customerName = this.jComboBoxCustomerName.getSelectedItem().toString();
        int customerId = customerController.getCustomerId(customerName);
        //int customerId = 1;
        System.out.println("ID CUSTOMER: " + customerId);
        float total = this.calculateTotalPrice();

        if (total <= 0) {
            JOptionPane.showMessageDialog(
                null,
                "You must select at least one product!",
                "Error!",
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            Models.Order order = new Models.Order();
            ArrayList<Models.Product> selectedProducts = new ArrayList<Models.Product>();
            
            // order.setOrder_amount(1);
            order.setCustomer_id(customerId);
            order.setOrder_total(total);
            order.setUser_id(Integer.parseInt(this.userId));

            for (int i = 0; i < this.fieldsArr.size(); i++) {
                try {
                    int prodAmount = Integer.parseInt(this.fieldsArr.get(i).getText());
                    
                    if (prodAmount > 0) {
                        selectedProducts.add(this.productsList.get(i));
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Exception: Invalid format!");
                }
            }
            
            for (int i = 0; i < selectedProducts.size(); i++) {
                System.out.println("selectedProduct:" + selectedProducts.get(i).getProduct_name());
            }

            orderController.createOrder(order, selectedProducts);
            JOptionPane.showMessageDialog(
                null,
                "The order was successfully saved!",
                "Done!",
                JOptionPane.PLAIN_MESSAGE
            );
            
            selectedProducts.clear();
            // new ListOrders().refreshOrdersTable("refresh");
        }
    }//GEN-LAST:event_jButtonSaveOrderActionPerformed

    private void jComboBoxCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCustomerNameActionPerformed

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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalculate;
    private javax.swing.JButton jButtonSaveOrder;
    private javax.swing.JComboBox<String> jComboBoxCustomerName;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalResult;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

}
