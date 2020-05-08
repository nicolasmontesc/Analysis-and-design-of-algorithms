package bd;

import com.github.cassandra.jdbc.internal.datastax.driver.core.Cluster;
import com.github.cassandra.jdbc.internal.datastax.driver.core.Session;

/**
 *
 * @author Juan Nicolas
 */
public class Conexion {

    public static Session session = null;
    public static Cluster cluster = null;

    public static Session getConnection() {

        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("panaderia");
        return session;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
    
    public void desconexion (){
        session.close();
        cluster.close();
    }
    
    

    public static void main(String[] args) {
        Conexion clase = new Conexion();
        clase.getConnection();
        if (clase.getSession() != null) {
            System.out.println("Conexion establecida: SOY DIOS");
        } else {
            System.out.println("Conexion no establecida");
        }
    }
}
