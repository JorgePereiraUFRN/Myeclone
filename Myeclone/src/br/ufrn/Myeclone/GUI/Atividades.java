/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.Myeclone.GUI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import br.ufrn.Myeclone.Exceptions.ServiceException;
import br.ufrn.Myeclone.controler.Service.AtividadesService;
import br.ufrn.Myeclone.model.Atividade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author jorge
 */
public class Atividades extends javax.swing.JFrame {

    private AtividadesService atService = new AtividadesService();
    private List<Atividade> atividades = new ArrayList<Atividade>();

    private DefaultTableModel tmAtividades = new DefaultTableModel(null,
            new String[]{"Atividade", "Data", "Hora", "Cumprido"});

    private ListSelectionModel lsmAtividades;
 

    public Atividades() {
        initComponents();

        try {
            atividades = atService.list();
            exibirDadosTabela(atividades);

        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void consultar(String text) {

    }

    private void exibirDadosTabela(List<Atividade> atividades) {

        while (tmAtividades.getRowCount() > 0) {
            tmAtividades.removeRow(0);
        }

        SimpleDateFormat dtFormat = new SimpleDateFormat("dd-MM-yyyy");

        String[] campos = new String[]{null, null, null, null};

        for (int i = 0; i < atividades.size(); i++) {
            tmAtividades.addRow(campos);
            
            tmAtividades.setValueAt(atividades.get(i).getAtividade(), i, 0);
            tmAtividades.setValueAt(
                    dtFormat.format(atividades.get(i).getData()), i, 1);
            tmAtividades.setValueAt(atividades.get(i).getHorario(), i, 2);

            setarCelulaCumprido(i, atividades.get(i).isCumprido());

        }

    }
    
    private void atualizarAtividade(Atividade atividade) throws ServiceException{
        atService.update(atividade);
    }

    private class JTableRenderer extends DefaultTableCellRenderer {

        protected void setValue(Object value) {
            if (value instanceof ImageIcon) {
                if (value != null) {
                    ImageIcon d = (ImageIcon) value;
                    setIcon(d);
                } else {
                    setText("");
                    setIcon(null);
                }
            } else {
                super.setValue(value);
            }
        }
    }

    private void novo() {

    }

    private void setarCelulaCumprido(int linha, boolean cumprido) {

        TableColumnModel columnModel = jTableAtividades.getColumnModel();
        JTableRenderer renderer = new JTableRenderer();
        columnModel.getColumn(3).setCellRenderer(renderer);

        if (cumprido) {
            tmAtividades.setValueAt(new ImageIcon(
                    "src/br/ufrn/Myeclone/icones/cumprido.png"), linha, 3);
        } else {
            tmAtividades.setValueAt(new ImageIcon(
                    "src/br/ufrn/Myeclone/icones/nao_cumprido.png"), linha, 3);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        jMenuItemCumprido = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemMostarTarefa = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTpesquisar = new javax.swing.JTextField();
        jBpesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAtividades = new javax.swing.JTable();
        jBnovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenuItemCumprido.setText("Alterar estado da tarefa");
        jMenuItemCumprido.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jMenuItemCumpridoComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jMenuItemCumpridoComponentShown(evt);
            }
        });
        jMenuItemCumprido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCumpridoActionPerformed(evt);
            }
        });
        jMenuItemCumprido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jMenuItemCumpridoFocusGained(evt);
            }
        });
        jPopupMenu.add(jMenuItemCumprido);
        jPopupMenu.add(jSeparator1);

        jMenuItemMostarTarefa.setText("Exibir dados da tarefa");
        jPopupMenu.add(jMenuItemMostarTarefa);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ATIVIDADES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atividades"));

        jBpesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/Myeclone/icones/pesquisar.png"))); // NOI18N
        jBpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBpesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jTpesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBpesquisar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBpesquisar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmAtividades= jTableAtividades.getSelectionModel();
        jTableAtividades.setModel(tmAtividades);
        jTableAtividades.setComponentPopupMenu(jPopupMenu);
        jTableAtividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAtividadesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableAtividadesMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableAtividadesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAtividades);

        jBnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/Myeclone/icones/relogio.png"))); // NOI18N
        jBnovo.setText("Novo");
        jBnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnovoActionPerformed(evt);
            }
        });

        jLabel1.setText("Propagandas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBnovo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBnovo)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAtividadesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAtividadesMouseEntered

        //evento errado
    }//GEN-LAST:event_jTableAtividadesMouseEntered

    private void jTableAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAtividadesMouseClicked
        //evento errado
    }//GEN-LAST:event_jTableAtividadesMouseClicked

    private void jTableAtividadesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAtividadesMousePressed

    }//GEN-LAST:event_jTableAtividadesMousePressed

    private void jMenuItemCumpridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCumpridoActionPerformed
        if(jTableAtividades.getSelectedRow() != -1){
            try {
                Atividade at = atividades.get(jTableAtividades.getSelectedRow());
                at.setCumprido(!at.isCumprido());
                atualizarAtividade(at);
                exibirDadosTabela(atividades);
                //setarCelulaCumprido(jTableAtividades.getSelectedRow(), !at.isCumprido());
                
                
            } catch (ServiceException ex) {
                Logger.getLogger(Atividades.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela.","Selecionar linha", JOptionPane.INFORMATION_MESSAGE);
        }        
    }//GEN-LAST:event_jMenuItemCumpridoActionPerformed

    private void jMenuItemCumpridoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMenuItemCumpridoFocusGained
        
            
        
    }//GEN-LAST:event_jMenuItemCumpridoFocusGained

    private void jMenuItemCumpridoComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jMenuItemCumpridoComponentHidden
        
    }//GEN-LAST:event_jMenuItemCumpridoComponentHidden

    private void jMenuItemCumpridoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jMenuItemCumpridoComponentShown
       if(jTableAtividades.getSelectedRow() != -1){
            
            
            if(jTableAtividades.getSelectedColumn() == 3){
                jMenuItemCumprido.setText("Alterar estado Cumprido");
                
            }else{
                jMenuItemCumprido.setText("Exibir Dados Tarefa");
            }
            
        }
    }//GEN-LAST:event_jMenuItemCumpridoComponentShown

    private void jBpesquisarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBpesquisarActionPerformed
        consultar(jTpesquisar.getText().trim());
    }// GEN-LAST:event_jBpesquisarActionPerformed

    private void jBnovoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBnovoActionPerformed
        novo();
    }// GEN-LAST:event_jBnovoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
        // desc=" Look and feel setting code (optional) ">
		/*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase
         * /tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Atividades.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atividades.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atividades.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atividades.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
		// </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBnovo;
    private javax.swing.JButton jBpesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItemCumprido;
    private javax.swing.JMenuItem jMenuItemMostarTarefa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTableAtividades;
    private javax.swing.JTextField jTpesquisar;
    // End of variables declaration//GEN-END:variables

}
