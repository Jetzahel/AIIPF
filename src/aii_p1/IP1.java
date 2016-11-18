/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aii_p1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Joel
 */
public class IP1 extends javax.swing.JFrame {
    
    AL1 al1 = new AL1();
    Tabla it = new Tabla();

    static DefaultTableModel modelo = new DefaultTableModel();
    
    public IP1() {
        initComponents();   
        modelo.setColumnIdentifiers(new Object [] {"idToken", "Lexema","Linea","Valor"}); 
        tabla.setModel(modelo);    
        tabla.setEnabled(false);
        alb.setEnabled(false);
        asb.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        alb = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areat = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        mme = new javax.swing.JTextArea();
        asb = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        abrir = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        guardarc = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        alb.setForeground(new java.awt.Color(255, 255, 51));
        alb.setText("Análisis léxico");
        alb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                albMouseClicked(evt);
            }
        });
        alb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albActionPerformed(evt);
            }
        });

        areat.setColumns(20);
        areat.setRows(5);
        areat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areatKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                areatKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areatKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(areat);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        mme.setEditable(false);
        mme.setColumns(20);
        mme.setRows(5);
        mme.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(mme);

        asb.setText("Análisis Sintáctico");

        jMenu2.setText("Archivo");

        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jMenu2.add(nuevo);
        jMenu2.add(jSeparator2);

        abrir.setText("Abrir...");
        abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirMouseClicked(evt);
            }
        });
        jMenu2.add(abrir);
        jMenu2.add(jSeparator1);

        guardarc.setText("Guardar como...");
        guardarc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarcMouseClicked(evt);
            }
        });
        jMenu2.add(guardarc);

        jMenu5.setText("Guardar");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(asb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(asb))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirMouseClicked
        String aux="",   
        texto="";
        try
        {
         /**llamamos el metodo que permite cargar la ventana*/
         JFileChooser file=new JFileChooser();
         FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
         file.setFileFilter(filtro);
         file.setCurrentDirectory(new File("microp"));
         file.showOpenDialog(this);
         /*abrimos el archivo seleccionado*/
         File abre=file.getSelectedFile();

         /**recorremos el archivo, lo leemos para plasmarlo
         *en el area de texto*/
         if(abre!=null)
         {     
            FileReader archivos=new FileReader(abre);
            BufferedReader lee=new BufferedReader(archivos);
            while((aux=lee.readLine())!=null){
               texto+= aux+ "\n";
            }
               lee.close();
               areat.setText(texto);//El texto se almacena en el JTextArea
          }    
         }
         catch(IOException ex)
         {
           JOptionPane.showMessageDialog(null,ex+"" +
                 "\nNo se ha encontrado el archivo",
                       "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
          }
        
        alb.setEnabled(true);
    }//GEN-LAST:event_abrirMouseClicked

    public String leer(){
    String data = areat.getText();
    return data;
}
   
    private void guardarcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarcMouseClicked
        al1.guardarCopia(leer());                                   
    }//GEN-LAST:event_guardarcMouseClicked

    private void albMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_albMouseClicked

    }//GEN-LAST:event_albMouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        al1.guardarCopia(leer());        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5MouseClicked

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        alb.setEnabled(false);
        areat.setText("");    // TODO add your handling code here:
    }//GEN-LAST:event_nuevoActionPerformed

    private void albActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albActionPerformed
        mme.setText("");
        it.limpiaTabla();
        al1.generarTokens(leer());
        
        if(mme.getText().equals("")){
            alb.setForeground(Color.GREEN);
            asb.setEnabled(true);
            alb.setBackground(Color.red);
        }else{
            asb.setEnabled(false);
            alb.setForeground(Color.RED);
        }      
    }//GEN-LAST:event_albActionPerformed

    private void areatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areatKeyPressed
        // TODO add your handling code here:    
    }//GEN-LAST:event_areatKeyPressed

    private void areatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areatKeyTyped
        // TODO add your handling code here:    
    }//GEN-LAST:event_areatKeyTyped

    private void areatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areatKeyReleased
        // TODO add your handling code here:
        if(areat.getSelectionStart()==0){
            alb.setEnabled(false);           
        }else if(areat.getSelectionStart()!=0){
            alb.setEnabled(true);
        }
    }//GEN-LAST:event_areatKeyReleased

    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu abrir;
    public static javax.swing.JButton alb;
    public static javax.swing.JTextArea areat;
    private static javax.swing.JButton asb;
    private javax.swing.JMenu guardarc;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    static javax.swing.JTextArea mme;
    private javax.swing.JMenuItem nuevo;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
