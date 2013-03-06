package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Grado;
import com.pe.colegio.nsr.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradoDaoImpl implements GradoDao {

    private Connection getConnection() {
        DBConn cnx = new DBConn();
        return cnx.getConnection();
    }

    @Override
    public List<Grado> listadoGrado() throws SQLException {
        List<Grado> list = new ArrayList<Grado>();
        Grado objGrado = null;

        String sql = "{ call SP_CONSULTAR_GRADO() }";
        Connection conn = getConnection();
        CallableStatement cstm = conn.prepareCall(sql);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objGrado = new Grado();

            objGrado.setId(rst.getInt(1));
            objGrado.setNombre(rst.getString(2));

            list.add(objGrado);
        }

        rst.close();
        cstm.close();
        conn.close();

        return list;
    }

    @Override
    public int insertarGrado(Grado grado) throws SQLException {
        String sql = "{ call SP_INSERTAR_GRADO(?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setString(1, grado.getNombre());
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }

    @Override
    public int actualizarGrado(Grado grado) throws SQLException {
        String sql = "{ call SP_ACTUALIZAR_GRADO(?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, grado.getId());
        cstm.setString(2, grado.getNombre());

        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }

    @Override
    public int eliminarGrado(int id) throws SQLException {
        String sql = "{ call SP_ELIMINAR_GRADO(?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, id);
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }

    @Override
    public Grado buscarGrado(int id) throws SQLException {
        String sql = "{ call SP_CONSULTAR_GRADO_ID(?) }";
        Connection conn = getConnection();
        Grado objGrado = new Grado();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, id);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objGrado.setId(rst.getInt(1));
            objGrado.setNombre(rst.getString(2));
        }

        rst.close();
        cstm.close();
        conn.close();

        return objGrado;
    }
}
