package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Bimestre;
import com.pe.colegio.nsr.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BimestreDaoImpl implements BimestreDao {

    private Connection getConnection() {
        DBConn cnx = new DBConn();
        return cnx.getConnection();
    }

    @Override
    public List<Bimestre> listadoBimestre() throws SQLException {
        List<Bimestre> list = new ArrayList<Bimestre>();
        Bimestre objBimestre = null;

        String sql = "{ call SP_CONSULTAR_BIMESTRE() }";
        Connection conn = getConnection();
        CallableStatement cstm = conn.prepareCall(sql);
        ResultSet rst = cstm.executeQuery();

        while (rst.next()) {
            objBimestre = new Bimestre();

            objBimestre.setId(rst.getInt(1));
            objBimestre.setNombre(rst.getString(2));

            list.add(objBimestre);
        }

        rst.close();
        cstm.close();
        conn.close();

        return list;
    }
}
