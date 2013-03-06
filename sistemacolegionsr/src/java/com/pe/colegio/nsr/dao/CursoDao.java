package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Curso;
import java.sql.SQLException;
import java.util.List;

public interface CursoDao {

    public List<Curso> buscarCursoporGrado(int idGrado) throws SQLException;
}
