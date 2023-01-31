package com.dtwain.demos.fulldemo;
import com.dynarithmic.twain.DTwainJavaAPI;
import com.dynarithmic.twain.exceptions.DTwainJavaAPIException;
import com.dynarithmic.twain.highlevel.TwainSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.swing.DefaultListModel;

public class DTwainSelectSourceCustomDialog extends javax.swing.JDialog {

    private DTwainJavaAPI m_api;
    private long SelectedSource = 0;
    TreeMap<String, Long> m_sourceMap;

    /**
     * Creates new form SelectSourceCustomDialog
     */
    public DTwainSelectSourceCustomDialog(java.awt.Frame parent, boolean modal, TwainSession twainSession) {
        super(parent, modal);
        initComponents();
        m_api = twainSession.getAPIHandle();
        try {
            DefaultListModel listModel = new DefaultListModel();
            long [] allSources = m_api.DTWAIN_EnumSources();
            List<String> aSources = new ArrayList<String>();
            for (int i = 0; i < allSources.length; ++i) {
                aSources.add(m_api.DTWAIN_GetSourceInfo(allSources[i]).getProductName());
            }
            Collections.sort(aSources);
            for (int i = 0; i < aSources.size(); ++i) {
                listModel.addElement(aSources.get(i));
            }
            lstSourceNames.setModel(listModel);
            lstSourceNames.setSelectedIndex(0);
            lblNumSources.setText(aSources.size() + " TWAIN Source(s) Available for Selection");
        }
        catch (DTwainJavaAPIException e)
        {
        }
    }

    public long getSelectedSource() { return SelectedSource; }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSourceNames = new javax.swing.JList();
        btnSelect = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblNumSources = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Custom Select Source Dialog");
        setAlwaysOnTop(true);

        jLabel1.setText("Sorted Source Names:");

        lstSourceNames.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lstSourceNames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstSourceNames);

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblNumSources.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNumSources, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNumSources)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        try {
            SelectedSource = m_api.DTWAIN_SelectSourceByName(lstSourceNames.getSelectedValue().toString());
            setVisible(false);
        }
        catch (DTwainJavaAPIException e)
        {
        }
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
            SelectedSource = 0;
            setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumSources;
    private javax.swing.JList lstSourceNames;
    // End of variables declaration//GEN-END:variables
}
