package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Curso;
import com.pe.colegio.nsr.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDaoImpl implements CursoDao {

    private Connection getConnection() {
        DBConn cnx = new DBConn();
        return cnx.getConnection();
    }

    @Override
    public List<Curso> buscarCursoporGrado(int idGrado) throws SQLException {
        String sql = "{ call SP_CONSULTAR_CURSO_POR_GRADO(?) }";
        List<Curso> list = new ArrayList<Curso>();
        Curso objCurso = null;
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, idGrado);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objCurso = new Curso();

            objCurso.setId(rst.getInt(1));
            objCurso.setNombre(rst.getString(2));

            list.add(objCurso);
        }

        rst.close();
        cstm.close();
        conn.close();

        return list;
    }
}
