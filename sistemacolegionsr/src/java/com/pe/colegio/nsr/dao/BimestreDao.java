package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Bimestre;
import java.sql.SQLException;
import java.util.List;

public interface BimestreDao {

    public List<Bimestre> listadoBimestre() throws SQLException;
}
