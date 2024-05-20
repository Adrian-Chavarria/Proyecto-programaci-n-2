/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nuevoClienteServidor;

import Servidor.ClientAuthentication;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ESTUDIANTE
 */
public class CheckIn extends javax.swing.JFrame {

    backgroundPanel fondo = new backgroundPanel();

    private ClientAuthentication authentication = new ClientAuthentication();

    public CheckIn() {
        this.setContentPane(fondo);
        initComponents();
        addPlaceHolderStyle(txtUserNew);
        addPlaceHolderStyle(txtPasswordNew);
    }
    // pone el estilo

    public void addPlaceHolderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }

    // quita el estilo
    public void removePlaceHolderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.black);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new backgroundPanel();
        jLabel5 = new javax.swing.JLabel();
        txtUserNew = new javax.swing.JTextField();
        btnCheckIn = new javax.swing.JButton();
        txtPasswordNew = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon("D:\\Usuarios\\ESTUDIANTE\\Documents\\NO BORRAR\\usuario.png")); // NOI18N

        txtUserNew.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtUserNew.setText("Usuario");
        txtUserNew.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNewFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNewFocusLost(evt);
            }
        });

        btnCheckIn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCheckIn.setText("Registrarse");
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });

        txtPasswordNew.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPasswordNew.setText("Contraseña");
        txtPasswordNew.setEchoChar('\u0000');
        txtPasswordNew.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordNewFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordNewFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPasswordNew, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserNew, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(btnCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUserNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtPasswordNew, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNewFocusGained
        if (txtUserNew.getText().equals("Usuario")) {
            txtUserNew.setText(null);
            txtUserNew.requestFocus();

            removePlaceHolderStyle(txtUserNew);

        }
    }//GEN-LAST:event_txtUserNewFocusGained

    private void txtUserNewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNewFocusLost
        if (txtUserNew.getText().length() == 0) {
            addPlaceHolderStyle(txtUserNew);
            txtUserNew.setText("Usuario");

        }
    }//GEN-LAST:event_txtUserNewFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.requestFocusInWindow();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        String userName = txtUserNew.getText();
        String password = txtPasswordNew.getText();

        if (!userName.equals("Usuario") && !password.equals("Contraseña")) {
            authentication.checkInUsers(userName, password, "Usuario");
            LoginCliente newFrame = new LoginCliente();
            newFrame.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor llene todo los campos");

        }

        
    }//GEN-LAST:event_btnCheckInActionPerformed

    private void txtPasswordNewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordNewFocusGained
        if (txtPasswordNew.getText().equals("Contraseña")) {
            txtPasswordNew.setText(null); 
            txtPasswordNew.requestFocus();
            
            txtPasswordNew.setEchoChar('*');
            
            removePlaceHolderStyle(txtPasswordNew);          
        }
    }//GEN-LAST:event_txtPasswordNewFocusGained

    private void txtPasswordNewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordNewFocusLost
         if(txtPasswordNew.getText().length()== 0){
        addPlaceHolderStyle(txtPasswordNew);
        txtPasswordNew.setText("Contraseña");
        txtPasswordNew.setEchoChar('\u0000');
    }
    }//GEN-LAST:event_txtPasswordNewFocusLost

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
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPasswordNew;
    private javax.swing.JTextField txtUserNew;
    // End of variables declaration//GEN-END:variables

    class backgroundPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {

            imagen = new ImageIcon(getClass().getResource("/Imagenes/fondoAzul.png")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }

    }
}
