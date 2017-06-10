/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openfrontino.adm.views.conf;

import com.openfrontino.tools.conection.ConnectionTool;
import com.openfrontino.tools.conection.querys.Select;
import com.openfrontino.tools.security.Encrypting;
import com.openfrontino.tools.session.EmpresaDto;
import com.openfrontino.tools.session.Session;
import com.openfrontino.tools.session.SessionDto;
import java.io.FileWriter;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author casc
 */
public class VenSetup extends javax.swing.JDialog {

    SessionDto dtoSes;

    /**
     * Creates new form VenSetup
     */
    public VenSetup(java.awt.Frame parent, boolean modal, SessionDto _ses) {
        super(parent, modal);
        initComponents();
        dtoSes = _ses;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDataBaseUser = new javax.swing.JTextField();
        txtDataBaseName = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        txtHost = new javax.swing.JTextField();
        txtDataBasePassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtAdminUsr = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCajUsr = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtAdminPas = new javax.swing.JPasswordField();
        txtCajPas = new javax.swing.JPasswordField();
        txtCajPas2 = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtRifEmp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNomEmp = new javax.swing.JTextField();
        txtDirEmp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración inicial de OpenFrontino");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Configuración Inicial de OpenFrontino");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Conexión a Base de Datos"));

        jLabel6.setText("Contraseña de Base de Datos");

        jLabel1.setText("Dirección IP de Base de Datos");

        jLabel3.setText("Puerto de Base de Datos");

        jLabel4.setText("Nombre de Base de Datos");

        jLabel5.setText("Usuario de Base de Datos");

        txtDataBaseUser.setText("openfrontinousr");

        txtDataBaseName.setText("openfrontinodb");

        txtPort.setText("5432");

        txtHost.setText("localhost");
        txtHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHost, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txtDataBasePassword))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addGap(27, 27, 27)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDataBaseName)
                        .addComponent(txtDataBaseUser)
                        .addComponent(txtPort, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDataBasePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtDataBaseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtDataBaseUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Usuario"));

        jLabel7.setText("Usuario Administrador");

        txtAdminUsr.setText("master");
        txtAdminUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminUsrActionPerformed(evt);
            }
        });

        jLabel8.setText("Password Administrador");

        jLabel9.setText("Usuario Cajero");

        txtCajUsr.setText("cajero");
        txtCajUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCajUsrActionPerformed(evt);
            }
        });

        jLabel10.setText("Password Cajero");

        jLabel11.setText("Repetir Password Cajero");

        jLabel12.setText("Catos para crear cajero");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAdminUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAdminPas, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCajUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCajPas)
                            .addComponent(txtCajPas2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAdminUsr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAdminPas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCajUsr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCajPas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCajPas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos para Creación de Empresa"));

        jLabel13.setText("R.I.F.");

        txtRifEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRifEmpActionPerformed(evt);
            }
        });

        jLabel14.setText("Nombre");

        txtNomEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomEmpActionPerformed(evt);
            }
        });

        txtDirEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirEmpActionPerformed(evt);
            }
        });

        jLabel15.setText("Dirección");

        jLabel16.setText("<html>\nSolo para creación de nuevas empresas\nsi la empresa ya existe esta información \nserá omitida\n</html>");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDirEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRifEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtRifEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtDirEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addContainerGap())
        );

        btnGenerar.setText("Genera Configuracion");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(btnGenerar)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void txtAdminUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminUsrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminUsrActionPerformed

    private void txtHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHostActionPerformed

    private void txtCajUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCajUsrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCajUsrActionPerformed

    private void txtRifEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRifEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRifEmpActionPerformed

    private void txtNomEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEmpActionPerformed

    private void txtDirEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirEmpActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if (this.txtHost.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar Dirección de Servidor", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (this.txtPort.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar Puerto de Servidor", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (this.txtDataBaseName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar Nombre de Base de Datos", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (this.txtDataBaseUser.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar Usuario Base de Datos", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (this.txtDataBasePassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar Contraseña Base de Datos", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        //Usuario maestr
        if (this.txtAdminUsr.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar Usuario Administrador", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (this.txtAdminPas.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar Contraseña Base de Administrador", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        //Cajero no se valida porque puede ser solo admin
        dtoSes.setDbhost(this.txtHost.getText());
        dtoSes.setDbport(this.txtPort.getText());
        dtoSes.setDbname(this.txtDataBaseName.getText());
        dtoSes.setDbuser(this.txtDataBaseUser.getText());
        StringBuilder passwordDb = new StringBuilder();
        for (int i = 0; i < this.txtDataBasePassword.getPassword().length; i++) {
            passwordDb.append(this.txtDataBasePassword.getPassword()[i]);
        }
        dtoSes.setDbpassword(passwordDb.toString());
        ConnectionTool conex = new ConnectionTool();
        if (!conex.connectNoEncrypr(dtoSes.getDbhost(), dtoSes.getDbport(), dtoSes.getDbname(), dtoSes.getDbuser(),
                dtoSes.getDbpassword()
        )) {
            dtoSes = new SessionDto();
            JOptionPane.showMessageDialog(null, "Error Conectando con Base de Datos", "Configuración", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Connection con = conex.getConexion();
        boolean commit = false;
        try {
            Session ses = new Session();
            ses.setCon(con);
            //Validar Usuario
            StringBuilder passwordAdmin = new StringBuilder();
            StringBuilder pasCaj = new StringBuilder();
            StringBuilder pasCaj2 = new StringBuilder();
            for (int i = 0; i < this.txtAdminPas.getPassword().length; i++) {
                passwordAdmin.append(this.txtAdminPas.getPassword()[i]);
            }
            dtoSes.setDtoUsu(ses.logearUsuario(this.txtAdminUsr.getText(), passwordAdmin.toString()));
            if (dtoSes.getDtoUsu() == null || dtoSes.getDtoUsu().getTipUsu() != '1') {
                JOptionPane.showMessageDialog(null, "Datos de Usuario Administrador Incorrectos", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            //Validar usuario cajero en caso de que se ingrese
            if (!txtCajUsr.getText().trim().equals("")) {
                if (this.txtCajPas.getPassword().length == 0 || this.txtCajPas2.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar Contraseña Cajero", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                for (int i = 0; i < this.txtCajPas.getPassword().length; i++) {
                    pasCaj.append(this.txtCajPas.getPassword()[i]);
                }
                for (int i = 0; i < this.txtCajPas2.getPassword().length; i++) {
                    pasCaj2.append(this.txtCajPas2.getPassword()[i]);
                }
                if (!pasCaj.toString().equals(pasCaj2.toString())) {
                    JOptionPane.showMessageDialog(null, "Contraseñas de Cajero no coinciden", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            //Validar Empresa
            dtoSes.setDtoEmp(ses.consultarEmpresa());
            if (dtoSes.getDtoEmp() == null) {
                if (this.txtRifEmp.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar Rif de Empresa", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (this.txtNomEmp.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar Nombre de Empresa", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (this.txtDirEmp.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe Ingresar Dirección de Empresa", "Validacion de Datos", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                //Inluir Empresa
                commit = ses.crearEmpresa(txtRifEmp.getText(), txtNomEmp.getText(), txtDirEmp.getText());
                dtoSes.setDtoEmp(new EmpresaDto());
                dtoSes.getDtoEmp().setRifEmp(txtRifEmp.getText());
                dtoSes.getDtoEmp().setNomEmp(txtNomEmp.getText());
                dtoSes.getDtoEmp().setDirEmp(txtDirEmp.getText());
            }
            if (!txtCajUsr.getText().trim().equals("")) {
                commit = ses.agregarCajero(txtCajUsr.getText(), pasCaj.toString(), txtCajUsr.getText());
            }
            Properties prop = ses.getProperties();
            String nrocaja = prop.getProperty("nrocaja");
            prop.setProperty("nrocaja",
                    String.valueOf(ses.agregarCaja(
                            (nrocaja != null && !nrocaja.trim().equals(""))
                            ? Integer.parseInt(nrocaja) : 0)));
            prop.setProperty("dbhost", txtHost.getText());
            prop.setProperty("dbport", txtPort.getText());
            prop.setProperty("dbname", txtDataBaseName.getText());
            prop.setProperty("dbuser", txtDataBaseUser.getText());
            prop.setProperty("dbpassword", Encrypting.crypt(passwordDb.toString()));
            prop.store(new FileWriter("./openfrontino.properties"),"Bienvenida");
            con.commit();
            this.dispose();
        } catch (Exception ex) {
            ConnectionTool.rollBackTrans(con);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Configuración", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionTool.killConnection(con);
        }
        

    }//GEN-LAST:event_btnGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtAdminPas;
    private javax.swing.JTextField txtAdminUsr;
    private javax.swing.JPasswordField txtCajPas;
    private javax.swing.JPasswordField txtCajPas2;
    private javax.swing.JTextField txtCajUsr;
    private javax.swing.JTextField txtDataBaseName;
    private javax.swing.JPasswordField txtDataBasePassword;
    private javax.swing.JTextField txtDataBaseUser;
    private javax.swing.JTextField txtDirEmp;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtNomEmp;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtRifEmp;
    // End of variables declaration//GEN-END:variables
}
