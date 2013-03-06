package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Tutor;
import java.sql.SQLException;
import java.util.List;

public interface TutorDao {

    public List<Tutor> listadoTutor() throws SQLException;

    public Tutor buscarTutor(int id) throws SQLException;

    public int eliminarTutor(int id) throws SQLException;

    public int registrarTutor(Tutor tutor) throws SQLException;

    public int actualizarTutor(Tutor tutor) throws SQLException;
}
