package usb.Controlador;

import Usb.vista.Consultar;
import Usb.vista.Modificar;
import java.io.*;

import java.util.*;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import Usb.modelo.Pais;

public class metodos {

    LinkedList<Pais> paises = new LinkedList<Pais>();

    //PROCEDIMIENT PARA GUARDADR DATOS EN EL ARREGLO
    public void guardar(String unPais) {
        Pais p = new Pais(unPais);
        paises.add(p);

    }

    //PROCEDIMIENTO PARA ELMINAR DATOS EN EL ARREGLO
    public void eliminarPais(Pais paisAEliminar) {
        if (paisAEliminar == null) {
            System.out.println("No se elimino el pais");
        } else {
            paises.remove(paisAEliminar);
        }
    }

    public String mostrar_texto() {

        String salida = "";
        for (Object listaPais : paises) {
            salida = salida + listaPais
                    + "\n-------------------------------------\n";
        }
        System.out.println(paises);
        return salida;

    }

    public String ordenarPorBrbujaCont() {
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
        return mostrar_texto();
    }

    public String ordenarPorBrbujaMuer() {
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
        return mostrar_texto();
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

    //FUNCION PARA MOSTRAR DATOS 
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
