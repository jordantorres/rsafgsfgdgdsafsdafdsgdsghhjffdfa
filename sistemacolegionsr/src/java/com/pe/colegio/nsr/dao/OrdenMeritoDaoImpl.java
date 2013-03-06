package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.ConsultaOrdenMerito;
import com.pe.colegio.nsr.bean.OrdenMerito;
import com.pe.colegio.nsr.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdenMeritoDaoImpl implements OrdenMeritoDao {

    private Connection getConnection() {
        DBConn cnx = new DBConn();
        return cnx.getConnection();
    }

    @Override
    public List<ConsultaOrdenMerito> consultarOrdenMeritoPorAlumno(Integer idAlumno) throws SQLException {
        String sql = "{ call SP_CONSULTAR_ORDENMERITO(?) }";
        List<ConsultaOrdenMerito> list = new ArrayList<ConsultaOrdenMerito>();
        ConsultaOrdenMerito objConsultaOrdenMerito = null;
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, idAlumno);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objConsultaOrdenMerito = new ConsultaOrdenMerito();

            objConsultaOrdenMerito.setOrdenMerito(rst.getString(1));
            objConsultaOrdenMerito.setBimestre1(rst.getString(2));
            objConsultaOrdenMerito.setBimestre2(rst.getString(3));
            objConsultaOrdenMerito.setBimestre3(rst.getString(4));
            objConsultaOrdenMerito.setBimestre4(rst.getString(5));

            list.add(objConsultaOrdenMerito);
        }

        rst.close();
        cstm.close();
        conn.close();

        return list;
    }

    @Override
    public int insertarOrdenMerito(OrdenMerito ordenMerito) throws SQLException {
        String sql = "{ call SP_INSERTAR_ORDENMERITO(?,?,?,?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, ordenMerito.getIdUsuario());
        cstm.setInt(2, ordenMerito.getIdBimestre());
        cstm.setString(3, ordenMerito.getConducta());
        cstm.setString(4, ordenMerito.getInasistencias());
        cstm.setString(5, ordenMerito.getTardanzas());
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }
}
