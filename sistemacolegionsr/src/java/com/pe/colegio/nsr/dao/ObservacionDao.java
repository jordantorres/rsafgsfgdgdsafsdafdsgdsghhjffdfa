package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Observacion;
import java.sql.SQLException;
import java.util.List;

public interface ObservacionDao {

    public List<Observacion> consultarObservacionPorAlumno(Integer idAlumno) throws SQLException;

    public int insertarObservacion(Observacion observacion) throws SQLException;
}
