/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import bd.Conexion;
import bo.Productos_BO;

import com.github.cassandra.jdbc.internal.datastax.driver.core.ResultSet;
import com.github.cassandra.jdbc.internal.datastax.driver.core.Row;
import com.github.cassandra.jdbc.internal.datastax.driver.core.Session;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import modelo.Productos;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Nicolas
 */
public class ProductosFormulario extends javax.swing.JPanel {

    private Productos_BO productosBO = new Productos_BO();

    private Menu menu;

    private DefaultTableModel modelo;
    private DefaultTableModel modeloId;
    private DefaultTableModel modeloVentas;

    private ArrayList<Productos> listaProductos = new ArrayList<>();
    private ArrayList<Productos> listaId = new ArrayList<>();
    private ArrayList<Productos> listaVentas = new ArrayList<>();

    public ProductosFormulario(Menu menu) {
        this.menu = menu;
        initComponents();
//        TextPrompt texto = new TextPrompt("Ingrese ID", idText);

    }

    public ArrayList<Productos> getlistaProductos() {

        int sumatoria = 0;
        try (Session session = Conexion.getConnection()) {
            ResultSet rs = session.execute("SELECT * FROM productos;");
            Iterator<Row> iterator = rs.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                Productos productos = new Productos();
                productos.setId(row.getInt("Id"));
                productos.setCantidad(row.getInt("cantidad"));
                productos.setCosto(row.getInt("costo"));
                productos.setDia_venta(row.getString("dia_venta"));
                productos.setFecha_vencimiento(row.getString("fecha_vencimiento"));
                productos.setMarca(row.getString("marca"));
                productos.setNombre(row.getString("nombre"));
                productos.setPeso(row.getString("peso"));
                sumatoria += row.getInt("costo");
                listaProductos.add(productos);
            }
            reporte.setText("El dinero total de ventas es: " + sumatoria);
            
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return listaProductos;
    }

    public DefaultTableModel mostrar() {

        String[] columnas = {"ID", "Cantidad", "Costo", "Dia Venta", "Dia Vencimiento", "Marca", "Nombre", "Peso"};

        modelo = new DefaultTableModel(null, columnas);

        ArrayList<Productos> listaProductos = getlistaProductos();

        Object[] fila = new Object[8];

        for (int i = 0; i < listaProductos.size(); i++) {
            fila[0] = listaProductos.get(i).getId();
            fila[1] = listaProductos.get(i).getCantidad();
            fila[2] = listaProductos.get(i).getCosto();
            fila[3] = listaProductos.get(i).getDia_venta();
            fila[4] = listaProductos.get(i).getFecha_vencimiento();
            fila[5] = listaProductos.get(i).getMarca();
            fila[6] = listaProductos.get(i).getNombre();
            fila[7] = listaProductos.get(i).getPeso();
            modelo.addRow(fila);
        }
        return modelo;
    }

    public ArrayList<Productos> getListaId() {
        try (Session session = Conexion.getConnection()) {
            ResultSet rs = session.execute("SELECT * FROM panaderia.productos WHERE id=" + idText.getText() + ";");
            Iterator<Row> iterator = rs.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                Productos productos = new Productos();
                productos.setId(row.getInt("Id"));
                productos.setCantidad(row.getInt("cantidad"));
                productos.setCosto(row.getInt("costo"));
                productos.setDia_venta(row.getString("dia_venta"));
                productos.setFecha_vencimiento(row.getString("fecha_vencimiento"));
                productos.setMarca(row.getString("marca"));
                productos.setNombre(row.getString("nombre"));
                productos.setPeso(row.getString("peso"));

                listaId.add(productos);
            }
             reporte.setText(null);
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return listaId;
    }

    public DefaultTableModel mostrarId() {

        String[] columnas = {"ID", "Cantidad", "Costo", "Dia Venta", "Dia Vencimiento", "Marca", "Nombre", "Peso"};

        modeloVentas = new DefaultTableModel(null, columnas);

        ArrayList<Productos> listaId = getListaId();

        Object[] fila = new Object[8];

        for (int i = 0; i < listaId.size(); i++) {
            fila[0] = listaId.get(i).getId();
            fila[1] = listaId.get(i).getCantidad();
            fila[2] = listaId.get(i).getCosto();
            fila[3] = listaId.get(i).getDia_venta();
            fila[4] = listaId.get(i).getFecha_vencimiento();
            fila[5] = listaId.get(i).getMarca();
            fila[6] = listaId.get(i).getNombre();
            fila[7] = listaId.get(i).getPeso();
            modeloVentas.addRow(fila);
        }
        return modeloVentas;
    }

    public ArrayList<Productos> getListaVentas() {
        try (Session session = Conexion.getConnection()) {
            ResultSet rs = session.execute("SELECT sum(costo) AS costo_total FROM productos;");
            Iterator<Row> iterator = rs.iterator();
            Row row = iterator.next();
            Productos productos = new Productos();
            productos.setCosto(row.getInt("costo"));
            listaVentas.add(productos);
            session.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return listaVentas;
    }

    public DefaultTableModel mostrarVentas() {
        String[] columnas = {"Reporte Total de Ventas"};
        modeloVentas = new DefaultTableModel(null, columnas);
        ArrayList<Productos> listaVentas = getListaVentas();
        Object[] fila = new Object[1];
        for (int i = 0; i < listaVentas.size(); i++) {
            fila[0] = listaVentas.get(i).getCosto();
            modeloVentas.addRow(fila);
        }
        return modeloVentas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        nombreText = new javax.swing.JTextField();
        cantidadText = new javax.swing.JTextField();
        marcaText = new javax.swing.JTextField();
        costoText = new javax.swing.JTextField();
        pesoBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        diaVentaCalendar = new com.toedter.calendar.JDateChooser();
        fechaVencCalendar = new com.toedter.calendar.JDateChooser();
        botonBuscar = new javax.swing.JButton();
        botonVerContenido = new javax.swing.JButton();
        botonVaciar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        reporte = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 8));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idLabel.setBackground(new java.awt.Color(255, 255, 255));
        idLabel.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idLabel.setText("ID");
        add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 77, 99, -1));

        idText.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N
        idText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        idText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextActionPerformed(evt);
            }
        });
        add(idText, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 98, 99, -1));

        jLabel1.setFont(new java.awt.Font("04b", 0, 36)); // NOI18N
        jLabel1.setText("PANADERIA DON JUANCHO");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 20, 718, 46));

        jLabel2.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOMBRE");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 77, 110, -1));

        jLabel3.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CANTIDAD");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 135, 110, -1));

        jLabel4.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("COSTO");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 193, 100, -1));

        jLabel5.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MARCA");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 135, 99, -1));

        jLabel6.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DIA DE VENTA");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 265, 163, -1));

        jLabel7.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FECHA DE VENCIMIENTO");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 328, -1, -1));

        jLabel8.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("PESO");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 193, 110, -1));

        botonAgregar.setBackground(new java.awt.Color(0, 0, 0));
        botonAgregar.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(0, 204, 255));
        botonAgregar.setText("AGREGAR");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 384, 243, -1));

        botonActualizar.setBackground(new java.awt.Color(0, 0, 0));
        botonActualizar.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonActualizar.setForeground(new java.awt.Color(0, 204, 255));
        botonActualizar.setText("ACTUALIZAR");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 431, 243, -1));

        botonEliminar.setBackground(new java.awt.Color(0, 0, 0));
        botonEliminar.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(0, 204, 255));
        botonEliminar.setText("ELIMINAR");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 476, 243, -1));

        nombreText.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N
        add(nombreText, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 98, 110, -1));

        cantidadText.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N
        cantidadText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadTextActionPerformed(evt);
            }
        });
        add(cantidadText, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 156, 110, -1));

        marcaText.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N
        add(marcaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 156, 99, -1));

        costoText.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N
        add(costoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 216, 100, -1));

        pesoBox.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        pesoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libras", "Litros" }));
        pesoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoBoxActionPerformed(evt);
            }
        });
        add(pesoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 214, 110, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("04b", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 204, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PRODUCTOS");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 19, 243, 47));

        diaVentaCalendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        diaVentaCalendar.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N
        add(diaVentaCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 286, 163, -1));

        fechaVencCalendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fechaVencCalendar.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N
        add(fechaVencCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 349, 164, -1));

        botonBuscar.setBackground(new java.awt.Color(0, 0, 0));
        botonBuscar.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(0, 204, 255));
        botonBuscar.setText("BUSCAR POR ID");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        add(botonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, -1, -1));

        botonVerContenido.setBackground(new java.awt.Color(0, 0, 0));
        botonVerContenido.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonVerContenido.setForeground(new java.awt.Color(0, 204, 255));
        botonVerContenido.setText("VER REPORTE");
        botonVerContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerContenidoActionPerformed(evt);
            }
        });
        add(botonVerContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 550, 293, -1));

        botonVaciar.setBackground(new java.awt.Color(0, 0, 0));
        botonVaciar.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonVaciar.setForeground(new java.awt.Color(0, 204, 255));
        botonVaciar.setText("VACIAR CAMPOS");
        botonVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVaciarActionPerformed(evt);
            }
        });
        add(botonVaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 574, -1, -1));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaDatos);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 77, 820, 426));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("VACIAR REPORTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 293, -1));

        reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 370, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void idTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextActionPerformed

    }//GEN-LAST:event_idTextActionPerformed

    private void cantidadTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadTextActionPerformed

    private void pesoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesoBoxActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        if (idText.getText().isEmpty()
                || nombreText.getText().isEmpty()
                || marcaText.getText().isEmpty()
                || cantidadText.getText().isEmpty()
                || costoText.getText().isEmpty()
                || diaVentaCalendar.getDate() == null
                || fechaVencCalendar.getDate() == null) {
            JOptionPane.showMessageDialog(null, "¡Error! Por favor llene los campos. ");
        } else {
            SimpleDateFormat simpleFormat = new SimpleDateFormat("d/MM/yyyy");
            Productos productos = new Productos();
            productos.setId(Integer.parseInt(idText.getText()));
            productos.setNombre(nombreText.getText());
            productos.setMarca(marcaText.getText());
            productos.setCantidad(Integer.parseInt(cantidadText.getText()));
            productos.setCosto(Integer.parseInt(costoText.getText()));
            productos.setDia_venta(simpleFormat.format(diaVentaCalendar.getDate()));
            productos.setFecha_vencimiento(simpleFormat.format(fechaVencCalendar.getDate()));
            productos.setPeso(pesoBox.getSelectedItem().toString());
            productosBO.crear(productos);
            limpiar();

        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonVaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVaciarActionPerformed
        limpiar();
    }//GEN-LAST:event_botonVaciarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if (idText.getText().isEmpty()
                || nombreText.getText().isEmpty()
                || marcaText.getText().isEmpty()
                || cantidadText.getText().isEmpty()
                || costoText.getText().isEmpty()
                || diaVentaCalendar.getDate() == null
                || fechaVencCalendar.getDate() == null) {
            JOptionPane.showMessageDialog(null, "¡Error! Por favor llene los campos. ");
        } else {
            SimpleDateFormat simpleFormat = new SimpleDateFormat("d/MM/yyyy");
            Productos productos = new Productos();
            productos.setId(Integer.parseInt(idText.getText()));
            productos.setNombre(nombreText.getText());
            productos.setMarca(marcaText.getText());
            productos.setCantidad(Integer.parseInt(cantidadText.getText()));
            productos.setCosto(Integer.parseInt(costoText.getText()));
            productos.setDia_venta(simpleFormat.format(diaVentaCalendar.getDate()));
            productos.setFecha_vencimiento(simpleFormat.format(fechaVencCalendar.getDate()));
            productos.setPeso(pesoBox.getSelectedItem().toString());
            productosBO.editar(productos);
            limpiar();

        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (idText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡Error! Por favor llene los campos. ");
        } else {
            productosBO.eliminar(Integer.parseInt(idText.getText()));
            limpiar();
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        tablaDatos.setModel(mostrarId());

        listaId.clear();

    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonVerContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerContenidoActionPerformed

        tablaDatos.setModel(mostrar());

        listaProductos.clear();

    }//GEN-LAST:event_botonVerContenidoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int fila = tablaDatos.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
        tablaDatos.setModel(modelo);

    }//GEN-LAST:event_jButton1ActionPerformed
    public void limpiar() {
        idText.setText("");
        nombreText.setText("");
        marcaText.setText("");
        cantidadText.setText("");
        costoText.setText("");
        diaVentaCalendar.setDate(null);
        fechaVencCalendar.setDate(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonVaciar;
    private javax.swing.JButton botonVerContenido;
    private javax.swing.JTextField cantidadText;
    private javax.swing.JTextField costoText;
    private com.toedter.calendar.JDateChooser diaVentaCalendar;
    private com.toedter.calendar.JDateChooser fechaVencCalendar;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField marcaText;
    private javax.swing.JTextField nombreText;
    private javax.swing.JComboBox<String> pesoBox;
    private javax.swing.JLabel reporte;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
