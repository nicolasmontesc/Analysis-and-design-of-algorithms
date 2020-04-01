package Usb.Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Usb.modelo.Pais;

public class Paises {

    LinkedList<Pais> paises = new LinkedList<Pais>();

    public void agregarPais(Pais pais) {
        paises.add(pais);

    }

    public boolean eliminarPais(Pais paisAEliminar) {
        boolean elimino = false;

        if (paisAEliminar == null) {
            elimino = false;
        } else {
            paises.remove(paisAEliminar);
            elimino = true;
        }
        return elimino;

    }

    public String mostrarPaisesContagiados() {
        String listado = null;
        for (Pais pais : paises) {
            if (listado != null) {
                listado = listado + " \n" + pais.toStringContagios();
            } else {
                listado = pais.toStringContagios() + " \n";
            }
        }
        return listado;
    }

    public String mostrarPaisesMuertes() {
        String listado = null;
        for (Pais pais : paises) {
            if (listado != null) {
                listado = listado + " \n" + pais.toStringMuertos();
            } else {
                listado = pais.toStringMuertos() + " \n";
            }
        }
        return listado;
    }

    public Pais buscarPorNombre(String nombreBuscado) {
        Pais objAux = null;
        for (Pais pais : paises) {
            if (nombreBuscado.equals(pais.getNombre())) {
                objAux = pais;
                return objAux;
            }
        }
        return objAux;
    }

    public void ordenarPorBrbujaCont() {
        for (int i = 0; i < paises.size() - 1; i++) {
            for (int j = 0; j < paises.size() - 1; j++) {

                if (paises.get(j).getNumeroContagiados() < paises.get(j + 1).getNumeroContagiados()) {
                    Pais aux = paises.get(j + 1);
                    Pais aux2 = paises.get(j);
                    paises.set(j, aux);
                    paises.set(j + 1, aux2);

                }

            }
        }
    }

    public void ordenarPorBrbujaMuer() {
        for (int i = 0; i < paises.size() - 1; i++) {
            for (int j = 0; j < paises.size() - 1; j++) {

                if (paises.get(j).getNumeroMuertos() < paises.get(j + 1).getNumeroMuertos()) {
                    Pais aux = paises.get(j + 1);
                    Pais aux2 = paises.get(j);
                    paises.set(j, aux);
                    paises.set(j + 1, aux2);

                }

            }
        }
    }
        //Procedimiento para guaradr en un archivo txt
    public void guardarArchivo(Pais pais) {
        try {
            FileWriter fw = new FileWriter("Paises.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter ow = new PrintWriter(bw);
            ow.print(pais.getNombre());
            ow.print(" " + pais.getNumeroContagiados());
            ow.print(" " + pais.getNumeroMuertos() + "\n");
            ow.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    public void muestraContenido()  {
        try {
            FileReader fr = new FileReader("Paises.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            LinkedList<String> p = new LinkedList<String>();
           
            while ((d = br.readLine()) != null) {
                System.out.println(d);
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public DefaultTableModel listaPaises() {

        Vector cabecera = new Vector();
        cabecera.add("PAIS");
        cabecera.add("NUMERO DE CONTAGIADOS");
        cabecera.add("NUMERO DE MUERTOS");
        // venctor que contiene pais # conta y # muertos 
        //creamos un modelo de tabla para agrefar el vector en la ubicacion 
        DefaultTableModel mdlTabla = new DefaultTableModel(cabecera, 0);

        try {
            FileReader fr = new FileReader("Paises.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                StringTokenizer dato = new StringTokenizer(d, " ");
                Vector x = new Vector();
                while (dato.hasMoreTokens()) {
                    x.addElement(dato.nextToken());
                }
                mdlTabla.addRow(x);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return mdlTabla;
    }
}
