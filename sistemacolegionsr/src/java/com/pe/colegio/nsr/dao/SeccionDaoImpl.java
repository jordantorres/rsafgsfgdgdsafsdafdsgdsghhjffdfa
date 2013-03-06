package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Seccion;
import com.pe.colegio.nsr.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeccionDaoImpl implements SeccionDao {

    private Connection getConnection() {
        DBConn cnx = new DBConn();
        return cnx.getConnection();
    }

    @Override
    public List<Seccion> listadoSeccion() throws SQLException {
        List<Seccion> list = new ArrayList<Seccion>();
        Seccion objSeccion = null;

        String sql = "{ call SP_CONSULTAR_SECCION() }";
        Connection conn = getConnection();
        CallableStatement cstm = conn.prepareCall(sql);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objSeccion = new Seccion();

            objSeccion.setId(rst.getInt(1));
            objSeccion.setNombre(rst.getString(2));
            objSeccion.setIdGrado(rst.getInt(3));
            objSeccion.setVacantes(rst.getInt(4));

            list.add(objSeccion);
        }

        rst.close();
        cstm.close();
        conn.close();

        return list;
    }

    @Override
    public int insertarSeccion(Seccion seccion) throws SQLException {
        String sql = "{ call SP_INSERTAR_SECCION(?,?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setString(1, seccion.getNombre());
        cstm.setInt(2, seccion.getIdGrado());
        cstm.setInt(3, seccion.getVacantes());
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }

    @Override
    public int actualizarSeccion(Seccion seccion) throws SQLException {
        String sql = "{ call SP_ACTUALIZAR_SECCION(?,?,?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, seccion.getId());
        cstm.setString(2, seccion.getNombre());
        cstm.setInt(3, seccion.getIdGrado());
        cstm.setInt(4, seccion.getVacantes());
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }

    @Override
    public int eliminarSeccion(int id) throws SQLException {
        String sql = "{ call SP_ELIMINAR_SECCION(?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, id);
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }

    @Override
    public Seccion buscarSeccion(int id) throws SQLException {
        String sql = "{ call SP_CONSULTAR_SECCION_ID(?) }";
        Connection conn = getConnection();
        Seccion objSeccion = new Seccion();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, id);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objSeccion.setId(rst.getInt(1));
            objSeccion.setNombre(rst.getString(2));
            objSeccion.setIdGrado(rst.getInt(3));
            objSeccion.setVacantes(rst.getInt(4));

        }

        rst.close();
        cstm.close();
        conn.close();

        return objSeccion;
    }

    @Override
    public List<Seccion> buscarSeccionporGrado(int idGrado) throws SQLException {
        String sql = "{ call SP_CONSULTAR_SECCION_POR_GRADO(?) }";
        List<Seccion> list = new ArrayList<Seccion>();
        Seccion objSeccion = null;
        Connection conn = getConnection();


        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, idGrado);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objSeccion = new Seccion();

            objSeccion.setId(rst.getInt(1));
            objSeccion.setNombre(rst.getString(2));
            objSeccion.setIdGrado(rst.getInt(3));
            objSeccion.setVacantes(rst.getInt(4));

            list.add(objSeccion);
        }

        rst.close();
        cstm.close();
        conn.close();

        return list;
    }
}
