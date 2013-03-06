package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Grado;
import java.sql.SQLException;
import java.util.List;

public interface GradoDao {

    public List<Grado> listadoGrado() throws SQLException;

    public int insertarGrado(Grado grado) throws SQLException;

    public int actualizarGrado(Grado grado) throws SQLException;

    public int eliminarGrado(int id) throws SQLException;

    public Grado buscarGrado(int id) throws SQLException;
}
