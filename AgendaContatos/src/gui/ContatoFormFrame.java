/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import agendacontatos.Alterar;
import agendacontatos.Cadastrar;
import agendacontatos.Consultar;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import javax.swing.JOptionPane;
import modelo.Contato;

/**
 *
 * @author leo
 */
public class ContatoFormFrame extends javax.swing.JFrame {

    private int id = -1;
    

    /**
     * Creates new form ContatoFormFrame
     */
    public ContatoFormFrame() {
        initComponents();
    }
    
    public ContatoFormFrame(int id) {
        this();
        this.id = id;
        this.setTitle("Alterar Contato");
        
        try {
            Consultar consultar = new Consultar();
            
            Contato contato = consultar.consultar(id);
            
            nomeField.setText(contato.getNome());
            emailField.setText(contato.getEmail());
            
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataNascField.setText(contato.getDataNasc().format(formato));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, 
                    "Opss! Ocorreu um erro: " + e.getMessage());
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

        nomeLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        dataNascLabel = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        dataNascField = new javax.swing.JTextField();
        salvarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Contatos");

        nomeLabel.setText("Nome:");

        emailLabel.setText("E-mail:");

        dataNascLabel.setText("Data Nasc.:");

        nomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFieldActionPerformed(evt);
            }
        });

        salvarButton.setText("Salvar");
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtonActionPerformed(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataNascLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(emailLabel)
                        .addComponent(nomeLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataNascField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nomeField)
                        .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salvarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelarButton)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataNascLabel)
                    .addComponent(dataNascField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarButton)
                    .addComponent(cancelarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed
        // TODO add your handling code here:
        if (id == -1) {
        
            try {
                Cadastrar cadastrar = new Cadastrar();

                cadastrar.inserir(
                    nomeField.getText(), 
                    emailField.getText(), 
                    dataNascField.getText()
                );

                JOptionPane.showMessageDialog(this, "Registro cadastrado!");

                limparFormulario();

            } catch(SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao inserir registro:\n"
                        + e.getMessage());
            }
        } else {
            try {
                Alterar alterar = new Alterar();
                alterar.alterar(id, nomeField.getText(), emailField.getText(), dataNascField.getText());

                JOptionPane.showMessageDialog(this, "Registro alterado!");
                dispose();
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao inserir registro:\n"
                        + e.getMessage());
            }
        }
    }//GEN-LAST:event_salvarButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(this, "Deseja fechar janela?", "Fechar", JOptionPane.OK_CANCEL_OPTION);
        
        if (resp == JOptionPane.OK_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_cancelarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ContatoFormFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContatoFormFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContatoFormFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContatoFormFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContatoFormFrame().setVisible(true);
            }
        });
    }
    
    private void limparFormulario() {
        nomeField.setText("");
        emailField.setText("");
        dataNascField.setText("");
        
        nomeField.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField dataNascField;
    private javax.swing.JLabel dataNascLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JButton salvarButton;
    // End of variables declaration//GEN-END:variables
}