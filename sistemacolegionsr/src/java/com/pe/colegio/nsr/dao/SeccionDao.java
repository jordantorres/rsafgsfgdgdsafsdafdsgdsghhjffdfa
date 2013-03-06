package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Seccion;
import java.sql.SQLException;
import java.util.List;

public interface SeccionDao {

    public List<Seccion> listadoSeccion() throws SQLException;

    public int insertarSeccion(Seccion seccion) throws SQLException;

    public int actualizarSeccion(Seccion seccion) throws SQLException;

    public int eliminarSeccion(int id) throws SQLException;

    public Seccion buscarSeccion(int id) throws SQLException;

    public List<Seccion> buscarSeccionporGrado(int idGrado) throws SQLException;
}
