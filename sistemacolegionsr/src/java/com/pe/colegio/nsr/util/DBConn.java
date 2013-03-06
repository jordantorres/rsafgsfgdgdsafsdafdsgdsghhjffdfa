package com.pe.colegio.nsr.util;

import java.sql.*;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConn {

    public Connection getConnection() {
        Connection conn = null;
        try {
            UbicadorServicios ubicador = UbicadorServicios.getInstance();
            DataSource ds = ubicador.getDataSource("java:comp/env/jdbc/school");
            conn = ds.getConnection(); // obtener prestado una conexion del pool
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        } // obtener prestado una conexion del pool
        return conn;
    }
}