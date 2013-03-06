package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.ConsultaOrdenMerito;
import com.pe.colegio.nsr.bean.OrdenMerito;
import java.sql.SQLException;
import java.util.List;

public interface OrdenMeritoDao {

    public List<ConsultaOrdenMerito> consultarOrdenMeritoPorAlumno(Integer idAlumno) throws SQLException;

    public int insertarOrdenMerito(OrdenMerito ordenMerito) throws SQLException;
}
