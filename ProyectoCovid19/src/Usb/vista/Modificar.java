package Usb.vista;

import Usb.Controlador.Paises;
import Usb.modelo.Pais;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Modificar extends javax.swing.JFrame {

    private MenuPrincipal menuP;
    private File fichero;
    DefaultTableModel mdlTabla;
    Vector vCabecera = new Vector();
    Paises metodos = new Paises();
Pais pais= new Pais ();
    public Modificar(MenuPrincipal mp, File fich) {
        this.menuP = mp;
        this.fichero = fich;
        this.menuP.setVisible(false);
        initComponents();
        this.setVisible(true);
        vCabecera.addElement("PAIS");
        vCabecera.addElement("NUM. CONTAGIADOS");
        vCabecera.addElement("NUM. MUERTOS");
        mdlTabla = new DefaultTableModel(vCabecera, 0);
        tabla_paises.setModel(mdlTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonConsultar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonMenu = new javax.swing.JButton();
        Btn_mostrar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_paises = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Txt_ncontagiados = new javax.swing.JTextField();
        Txt_nmuertos = new javax.swing.JTextField();
        Txt_nombre = new javax.swing.JTextField();
        Btn_guardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COVID-19");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonConsultar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, -1, -1));

        jButtonBorrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 91, -1));

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabelTitulo.setText("COVID-19");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 338, -1));

        jButtonMenu.setText("Menú");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 110, -1));

        Btn_mostrar.setText("Mostrar");
        Btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 91, -1));

        tabla_paises.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabla_paises);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 371));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_ncontagiados, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_nmuertos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 120, 90));

        Btn_guardar.setText("Guardar");
        Btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 90, -1));

        jLabel1.setText("PAIS");

        jLabel2.setText("NUM. CONTAGIADOS ");

        jLabel3.setText("NUM. MUERTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        setSize(new java.awt.Dimension(714, 627));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed

        this.setVisible(false);
        menuP.setVisible(true);
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed

        Consultar c = new Consultar(this, fichero);


    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed

        Borrar b = new Borrar(this, fichero);
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void Btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_mostrarActionPerformed
        tabla_paises.setModel(metodos.listaPaises());
        metodos.muestraContenido();
        
        //  Txtarea_c.setText(metodos.ordenarPorBrbujaCont());
        // Txtarea_m.setText(metodos.ordenarPorBrbujaMuer());
    }//GEN-LAST:event_Btn_mostrarActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_guardar;
    private javax.swing.JButton Btn_mostrar;
    private javax.swing.JTextField Txt_ncontagiados;
    private javax.swing.JTextField Txt_nmuertos;
    private javax.swing.JTextField Txt_nombre;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabla_paises;
    // End of variables declaration//GEN-END:variables

}