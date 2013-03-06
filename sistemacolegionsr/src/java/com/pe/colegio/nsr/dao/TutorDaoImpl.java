package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Tutor;
import com.pe.colegio.nsr.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorDaoImpl implements TutorDao {

    private Connection getConnection() {
        DBConn cnx = new DBConn();
        return cnx.getConnection();
    }

    @Override
    public List<Tutor> listadoTutor() throws SQLException {
        List<Tutor> list = new ArrayList<Tutor>();
        Tutor objTutor = null;

        String sql = "{ call SP_CONSULTAR_TUTOR() }";
        Connection conn = getConnection();
        CallableStatement cstm = conn.prepareCall(sql);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objTutor = new Tutor();

            objTutor.setId(rst.getInt(1));
            objTutor.setIdTipo(rst.getInt(2));
            objTutor.setNombre(rst.getString(3));
            objTutor.setApellido(rst.getString(4));
            objTutor.setUsuario(rst.getString(5));
            objTutor.setContrasenia(rst.getString(6));
            objTutor.setEstadoDeuda(rst.getString(7));
            objTutor.setIdGrado(rst.getInt(8));
            objTutor.setNombreGrado(rst.getString(9));
            objTutor.setIdSeccion(rst.getInt(10));
            objTutor.setNombreSeccion(rst.getString(11));

            list.add(objTutor);
        }

        rst.close();
        cstm.close();
        conn.close();

        return list;
    }

    @Override
    public Tutor buscarTutor(int id) throws SQLException {
        String sql = "{ call SP_CONSULTAR_TUTOR_ID(?) }";
        Connection conn = getConnection();
        Tutor objTutor = new Tutor();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, id);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objTutor.setId(rst.getInt(1));
            objTutor.setIdTipo(rst.getInt(2));
            objTutor.setNombre(rst.getString(3));
            objTutor.setApellido(rst.getString(4));
            objTutor.setUsuario(rst.getString(5));
            objTutor.setContrasenia(rst.getString(6));
            objTutor.setEstadoDeuda(rst.getString(7));
            objTutor.setIdGrado(rst.getInt(8));
            objTutor.setNombreGrado(rst.getString(9));
            objTutor.setIdSeccion(rst.getInt(10));
            objTutor.setNombreSeccion(rst.getString(11));
        }

        rst.close();
        cstm.close();
        conn.close();

        return objTutor;
    }

    @Override
    public int eliminarTutor(int id) throws SQLException {
        String sql = "{ call SP_ELIMINAR_USUARIO(?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, id);
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }

    @Override
    public int registrarTutor(Tutor tutor) throws SQLException {
        String sql = "{ call SP_INSERTAR_TUTOR_SECCION(?,?,?,?,?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, tutor.getIdTipo());
        cstm.setString(2, tutor.getNombre());
        cstm.setString(3, tutor.getApellido());
        cstm.setString(4, tutor.getUsuario());
        cstm.setString(5, tutor.getEstadoDeuda());
        cstm.setInt(6, tutor.getIdSeccion());
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }

    @Override
    public int actualizarTutor(Tutor tutor) throws SQLException {
        String sql = "{ call SP_ACTUALIZAR_TUTOR(?,?,?,?,?,?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, tutor.getId());
        cstm.setString(2, tutor.getNombre());
        cstm.setString(3, tutor.getApellido());
        cstm.setString(4, tutor.getUsuario());
        cstm.setString(5, tutor.getContrasenia());
        cstm.setString(6, tutor.getEstadoDeuda());
        cstm.setInt(7, tutor.getIdSeccion());
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }
}