package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Alumno;
import com.pe.colegio.nsr.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDaoImpl implements AlumnoDao {

    private Connection getConnection() {
        DBConn cnx = new DBConn();
        return cnx.getConnection();
    }


    @Override
    public Alumno buscarAlumno(int id) throws SQLException {
        String sql = "{ call SP_CONSULTAR_ALUMNO_ID(?) }";
        Connection conn = getConnection();
        Alumno objAlumno = new Alumno();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, id);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objAlumno.setId(rst.getInt(1));
            objAlumno.setNombre(rst.getString(2));
            objAlumno.setApellido(rst.getString(3));
            objAlumno.setApoderado(rst.getString(4));
            objAlumno.setUsuario(rst.getString(5));
            objAlumno.setContrasenia(rst.getString(6));
            objAlumno.setEstadoDeuda(rst.getString(7));
            objAlumno.setIdSeccion(rst.getInt(8));
            objAlumno.setIdGrado(rst.getInt(9));
        }

        rst.close();
        cstm.close();
        conn.close();

        return objAlumno;
    }

    @Override
    public int matricularAlumno(Alumno alumno) throws SQLException {
        String sql = "{ call SP_INSERTAR_ALUMNO_SECCION(?,?,?,?,?,?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, alumno.getIdTipo());
        cstm.setString(2, alumno.getNombre());
        cstm.setString(3, alumno.getApellido());
        cstm.setString(4, alumno.getApoderado());
        cstm.setString(5, alumno.getUsuario());
        cstm.setString(6, alumno.getEstadoDeuda());
        cstm.setInt(7, alumno.getIdSeccion());
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }

    @Override
    public List<Alumno> buscarAlumnoGradoSeccion(int idGrado, int idSeccion) throws SQLException {
        String sql = "{ call SP_CONSULTAR_ALUMNO_GRADO_SECCION(?,?) }";
        List<Alumno> list = new ArrayList<Alumno>();
        Alumno objAlumno = null;
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, idGrado);
        cstm.setInt(2, idSeccion);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objAlumno = new Alumno();

            objAlumno.setId(rst.getInt(1));
            objAlumno.setApellido(rst.getString(2));
            objAlumno.setNombre(rst.getString(3));
            objAlumno.setIdTipo(rst.getInt(4));
            objAlumno.setApoderado(rst.getString(5));
            objAlumno.setUsuario(rst.getString(6));
            objAlumno.setContrasenia(rst.getString(7));
            objAlumno.setEstadoDeuda(rst.getString(8));

            list.add(objAlumno);
        }

        rst.close();
        cstm.close();
        conn.close();

        return list;
    }

    @Override
    public int actualizarAlumno(Alumno alumno) throws SQLException {
        String sql = "{ call SP_ACTUALIZAR_ALUMNO(?,?,?,?,?,?,?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, alumno.getId());
        cstm.setString(2, alumno.getNombre());
        cstm.setString(3, alumno.getApellido());
        cstm.setString(4, alumno.getApoderado());
        cstm.setString(5, alumno.getUsuario());
        cstm.setString(6, alumno.getContrasenia());
        cstm.setString(7, alumno.getEstadoDeuda());
        cstm.setInt(8, alumno.getIdSeccion());
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }
}
