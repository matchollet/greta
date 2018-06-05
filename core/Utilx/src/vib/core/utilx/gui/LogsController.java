/*
 * This file is part of VIB (Virtual Interactive Behaviour).
 */
package vib.core.utilx.gui;

import vib.core.util.log.LogOutput;
import vib.core.util.log.Logs;

/**
 *
 * @author Andre-Marie Pez
 */
public class LogsController extends javax.swing.JFrame {

    /** Creates new form LogsControler */
    public LogsController() {
        initComponents();
    }


    public boolean hasDebug(){
        return this.debugCheck.isSelected();
    }


    public void setDebug(boolean b){
        this.debugCheck.setSelected(b);
        changeLogsLevel();
    }


    public boolean hasInfo(){
        return this.InfoCheck.isSelected();
    }


    public void setInfo(boolean b){
        this.InfoCheck.setSelected(b);
        changeLogsLevel();
    }


    public boolean hasWarning(){
        return this.warningCheck.isSelected();
    }


    public void setWarning(boolean b){
        this.warningCheck.setSelected(b);
        changeLogsLevel();
    }


    public boolean hasError(){
        return this.errorCheck.isSelected();
    }


    public void setError(boolean b){
        this.errorCheck.setSelected(b);
        changeLogsLevel();
    }


    private void changeLogsLevel(){
        int level = 0;
        if(hasDebug()) {
            level += Logs.DEBUG;
        }
        if(hasInfo()) {
            level += Logs.INFO;
        }
        if(hasWarning()) {
            level += Logs.WARNING;
        }
        if(hasError()) {
            level += Logs.ERROR;
        }
        Logs.setLevel(level);
    }

    public void addLogOutput(LogOutput logOutput){
        Logs.add(logOutput);
    }
    public void removeLogOutput(LogOutput logOutput){
        Logs.remove(logOutput);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        debugCheck = new vib.core.utilx.gui.ToolBox.LocalizedJCheckBox("word.debug");
        InfoCheck = new vib.core.utilx.gui.ToolBox.LocalizedJCheckBox("word.info");
        warningCheck = new vib.core.utilx.gui.ToolBox.LocalizedJCheckBox("word.warning");
        errorCheck = new vib.core.utilx.gui.ToolBox.LocalizedJCheckBox("word.error");

        setTitle("Logs Control");
        setResizable(false);

        debugCheck.setSelected(true);
        debugCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugCheckActionPerformed(evt);
            }
        });

        InfoCheck.setSelected(true);
        InfoCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoCheckActionPerformed(evt);
            }
        });

        warningCheck.setSelected(true);
        warningCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warningCheckActionPerformed(evt);
            }
        });

        errorCheck.setSelected(true);
        errorCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InfoCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(debugCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(warningCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(errorCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(debugCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InfoCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(warningCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorCheck)
                .addContainerGap(15, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void debugCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugCheckActionPerformed
        changeLogsLevel();
    }//GEN-LAST:event_debugCheckActionPerformed

    private void InfoCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoCheckActionPerformed
        changeLogsLevel();
    }//GEN-LAST:event_InfoCheckActionPerformed

    private void warningCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warningCheckActionPerformed
        changeLogsLevel();
    }//GEN-LAST:event_warningCheckActionPerformed

    private void errorCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorCheckActionPerformed
        changeLogsLevel();
    }//GEN-LAST:event_errorCheckActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox InfoCheck;
    private javax.swing.JCheckBox debugCheck;
    private javax.swing.JCheckBox errorCheck;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox warningCheck;
    // End of variables declaration//GEN-END:variables
}