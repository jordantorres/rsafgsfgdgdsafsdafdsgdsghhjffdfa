package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Libreta;
import com.pe.colegio.nsr.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibretaDaoImpl implements LibretaDao {

    private Connection getConnection() {
        DBConn cnx = new DBConn();
        return cnx.getConnection();
    }

    @Override
    public List<Libreta> buscarLibreta(int idAlumno) throws SQLException {
        String sql = "{ call SP_CONSULTAR_LIBRETA(?) }";
        List<Libreta> list = new ArrayList<Libreta>();
        Libreta objLibreta = null;
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, idAlumno);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objLibreta = new Libreta();

            objLibreta.setIdCurso(rst.getInt(1));
            objLibreta.setCurso(rst.getString(2));
            objLibreta.setNotaBimestre1(rst.getString(3));
            objLibreta.setNotaBimestre2(rst.getString(4));
            objLibreta.setNotaBimestre3(rst.getString(5));
            objLibreta.setNotaBimestre4(rst.getString(6));

            list.add(objLibreta);
        }

        rst.close();
        cstm.close();
        conn.close();

        return list;
    }

    @Override
    public Libreta traerLibretaPorAlumnoCurso(int idAlumno, int idCurso) throws SQLException {
        String sql = "{ call SP_CONSULTAR_LIBRETA_CURSO_ALUMNO(?,?) }";
        Libreta objLibreta = null;
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, idAlumno);
        cstm.setInt(2, idCurso);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objLibreta = new Libreta();

            objLibreta.setIdCurso(rst.getInt(1));
            objLibreta.setCurso(rst.getString(2));
            objLibreta.setNotaBimestre1(rst.getString(3));
            objLibreta.setNotaBimestre2(rst.getString(4));
            objLibreta.setNotaBimestre3(rst.getString(5));
            objLibreta.setNotaBimestre4(rst.getString(6));

        }

        rst.close();
        cstm.close();
        conn.close();

        return objLibreta;
    }

    @Override
    public int insertarNota(Integer idBimestre, Integer idCurso, Integer idAlumno, String nota) throws SQLException {
        String sql = "{ call SP_INSERTAR_NOTA(?,?,?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, idBimestre);
        cstm.setInt(2, idCurso);
        cstm.setInt(3, idAlumno);
        cstm.setString(4, nota);

        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }
}
