package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Libreta;
import java.sql.SQLException;
import java.util.List;

public interface LibretaDao {

    public List<Libreta> buscarLibreta(int idAlumno) throws SQLException;

    public Libreta traerLibretaPorAlumnoCurso(int idAlumno, int idCurso) throws SQLException;

    public int insertarNota(Integer idBimestre, Integer idCurso, Integer idAlumno, String nota) throws SQLException;
}
