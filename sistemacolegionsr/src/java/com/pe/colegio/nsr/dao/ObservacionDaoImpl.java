package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Observacion;
import com.pe.colegio.nsr.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObservacionDaoImpl implements ObservacionDao {

    private Connection getConnection() {
        DBConn cnx = new DBConn();
        return cnx.getConnection();
    }

    @Override
    public List<Observacion> consultarObservacionPorAlumno(Integer idAlumno) throws SQLException {
        String sql = "{ call SP_CONSULTAR_OBSERVACION(?) }";
        List<Observacion> list = new ArrayList<Observacion>();
        Observacion objObservacion = null;
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, idAlumno);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objObservacion = new Observacion();

            objObservacion.setId(rst.getInt(1));
            objObservacion.setIdUsuario(rst.getInt(2));
            objObservacion.setIdBimestre(rst.getInt(3));
            objObservacion.setObservacion(rst.getString(4));

            list.add(objObservacion);
        }

        rst.close();
        cstm.close();
        conn.close();

        return list;
    }

    @Override
    public int insertarObservacion(Observacion observacion) throws SQLException {
        String sql = "{ call SP_INSERTAR_OBSERVACION(?,?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, observacion.getIdUsuario());
        cstm.setInt(2, observacion.getIdBimestre());
        cstm.setString(3, observacion.getObservacion());
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }
}
