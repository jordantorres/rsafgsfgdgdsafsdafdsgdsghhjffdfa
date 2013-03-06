package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Alumno;
import java.sql.SQLException;
import java.util.List;

public interface AlumnoDao {

    public Alumno buscarAlumno(int id) throws SQLException;

    public int matricularAlumno(Alumno alumno) throws SQLException;

    public List<Alumno> buscarAlumnoGradoSeccion(int idGrado, int idSeccion) throws SQLException;

    public int actualizarAlumno(Alumno alumno) throws SQLException;
}
