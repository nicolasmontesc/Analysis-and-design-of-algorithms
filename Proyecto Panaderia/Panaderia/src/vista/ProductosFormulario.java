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

//    private Session session;
//    private PreparedStatement pr;
//    private ResultSet rs;
    public ProductosFormulario(Menu menu) {
        this.menu = menu;
        initComponents();
//        TextPrompt texto = new TextPrompt("Ingrese ID", idText);

    }

    public ArrayList<Productos> getlistaProductos() {
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
                listaProductos.add(productos);
            }
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
        Object[] fila = new Object[0];
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

        setBackground(new java.awt.Color(102, 102, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 8));

        idLabel.setBackground(new java.awt.Color(255, 255, 255));
        idLabel.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idLabel.setText("ID");

        idText.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N
        idText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        idText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("04b", 0, 36)); // NOI18N
        jLabel1.setText("PANADERIA DON JUANCHO");

        jLabel2.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NOMBRE");

        jLabel3.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CANTIDAD");

        jLabel4.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("COSTO");

        jLabel5.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("MARCA");

        jLabel6.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DIA DE VENTA");

        jLabel7.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FECHA DE VENCIMIENTO");

        jLabel8.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("PESO");

        botonAgregar.setBackground(new java.awt.Color(0, 0, 0));
        botonAgregar.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(0, 204, 255));
        botonAgregar.setText("AGREGAR");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonActualizar.setBackground(new java.awt.Color(0, 0, 0));
        botonActualizar.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonActualizar.setForeground(new java.awt.Color(0, 204, 255));
        botonActualizar.setText("ACTUALIZAR");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonEliminar.setBackground(new java.awt.Color(0, 0, 0));
        botonEliminar.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(0, 204, 255));
        botonEliminar.setText("ELIMINAR");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        nombreText.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N

        cantidadText.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N
        cantidadText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadTextActionPerformed(evt);
            }
        });

        marcaText.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N

        costoText.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N

        pesoBox.setFont(new java.awt.Font("04b", 0, 14)); // NOI18N
        pesoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libras", "Litros" }));
        pesoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoBoxActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("04b", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 204, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PRODUCTOS");

        diaVentaCalendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        diaVentaCalendar.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N

        fechaVencCalendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fechaVencCalendar.setFont(new java.awt.Font("04b", 0, 12)); // NOI18N

        botonBuscar.setBackground(new java.awt.Color(0, 0, 0));
        botonBuscar.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(0, 204, 255));
        botonBuscar.setText("BUSCAR POR ID");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonVerContenido.setBackground(new java.awt.Color(0, 0, 0));
        botonVerContenido.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonVerContenido.setForeground(new java.awt.Color(0, 204, 255));
        botonVerContenido.setText("VER REPORTE");
        botonVerContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerContenidoActionPerformed(evt);
            }
        });

        botonVaciar.setBackground(new java.awt.Color(0, 0, 0));
        botonVaciar.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        botonVaciar.setForeground(new java.awt.Color(0, 204, 255));
        botonVaciar.setText("VACIAR CAMPOS");
        botonVaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVaciarActionPerformed(evt);
            }
        });

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaDatos);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("04b", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("VACIAR REPORTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(fechaVencCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(diaVentaCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(idText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(marcaText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(costoText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(idLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nombreText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cantidadText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pesoBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(botonVaciar)))
                .addGap(8, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonVerContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(268, 268, 268))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(marcaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(costoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pesoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diaVentaCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaVencCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonAgregar)
                        .addGap(20, 20, 20)
                        .addComponent(botonActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscar)
                    .addComponent(botonVerContenido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(botonVaciar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
