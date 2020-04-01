
package Usb.vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Usb.modelo.Pais;
import Usb.Controlador.Paises;


/**
 *
 * @author jimmy rios
 */
public class Covid_19 extends javax.swing.JFrame {

  
    Pais pais= new Pais ();
    Paises metodos= new Paises();
    DefaultTableModel mdlTabla;
    Vector vCabecera = new Vector();
    private File fichero;
     private MenuPrincipal menuP;
    public Covid_19(MenuPrincipal mp,File fich) {
        initComponents();
        this.menuP = mp;
        this.fichero = fich;
        vCabecera.addElement("PAIS");
        vCabecera.addElement("NUM. CONTAGIADOS");
        vCabecera.addElement("NUM. MUERTOS");
        mdlTabla= new DefaultTableModel(vCabecera,0);
        tabla_paises.setModel(mdlTabla);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_paises = new javax.swing.JTable();
        Btn_guardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Txt_ncontagiados = new javax.swing.JTextField();
        Txt_nmuertos = new javax.swing.JTextField();
        Txt_nombre = new javax.swing.JTextField();
        Btn_mostrar = new javax.swing.JButton();
        Btn_eliminar = new javax.swing.JButton();
        Btn_consultar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COVID 19");

        jLabel1.setText("PAIS");

        jLabel2.setText("NUM. CONTAGIADOS ");

        jLabel3.setText("NUM. MUERTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(6, 6, 6))
        );

        tabla_paises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_paises.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_paisesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_paises);

        Btn_guardar.setText("Guardar");
        Btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_nmuertos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_ncontagiados, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Txt_ncontagiados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Txt_nmuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Btn_mostrar.setText("Mostrar");
        Btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_mostrarActionPerformed(evt);
            }
        });

        Btn_eliminar.setText("EliminarContagiados");
        Btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_eliminarActionPerformed(evt);
            }
        });

        Btn_consultar.setText("jButton1");
        Btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_consultarActionPerformed(evt);
            }
        });

        jButtonBorrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonConsultar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btn_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Btn_consultar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonConsultar))
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(Btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Btn_consultar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jButtonBorrar)
                                .addGap(5, 5, 5)
                                .addComponent(jButtonConsultar)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_guardarActionPerformed
        
        String paises = Txt_nombre.getText();
        String ncontagiados = Txt_ncontagiados.getText();
        String nmuertos = Txt_nmuertos.getText();
        
        pais.setNombre(paises);
        pais.setNumeroContagiados(Integer.parseInt(ncontagiados));
        pais.setNumeroMuertos(Integer.parseInt(nmuertos));
        metodos.agregarPais(pais);
        metodos.guardarArchivo(pais);
        
        Txt_nombre.setText("");
        Txt_ncontagiados.setText("");
        Txt_nmuertos.setText("");
    }//GEN-LAST:event_Btn_guardarActionPerformed

    private void Btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_mostrarActionPerformed
        tabla_paises.setModel(metodos.listaPaises());
    }//GEN-LAST:event_Btn_mostrarActionPerformed

    private void Btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_eliminarActionPerformed
       
        Borrar b = new Borrar(this, fichero);
    }//GEN-LAST:event_Btn_eliminarActionPerformed

    private void tabla_paisesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_paisesMouseClicked
        int fila_seleccionada = tabla_paises.getSelectedRow();
        Txt_nombre.setText(tabla_paises.getValueAt(fila_seleccionada, 0).toString());
        Txt_ncontagiados.setText(tabla_paises.getValueAt(fila_seleccionada, 1).toString());
        Txt_nmuertos.setText(tabla_paises.getValueAt(fila_seleccionada, 2).toString());

        filas = fila_seleccionada;
    }//GEN-LAST:event_tabla_paisesMouseClicked

    private void Btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_consultarActionPerformed
        Consultar c = new Consultar(this, fichero);
    }//GEN-LAST:event_Btn_consultarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed

        Borrar b = new Borrar(this, fichero);
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed

        Consultar c = new Consultar(this, fichero);

    }//GEN-LAST:event_jButtonConsultarActionPerformed
int filas;
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_consultar;
    private javax.swing.JButton Btn_eliminar;
    private javax.swing.JButton Btn_guardar;
    private javax.swing.JButton Btn_mostrar;
    private javax.swing.JTextField Txt_ncontagiados;
    private javax.swing.JTextField Txt_nmuertos;
    private javax.swing.JTextField Txt_nombre;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_paises;
    // End of variables declaration//GEN-END:variables
}
