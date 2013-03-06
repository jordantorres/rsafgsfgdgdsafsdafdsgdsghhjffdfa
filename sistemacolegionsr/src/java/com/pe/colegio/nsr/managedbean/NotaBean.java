package com.pe.colegio.nsr.managedbean;

import com.pe.colegio.nsr.bean.Bimestre;
import com.pe.colegio.nsr.bean.Curso;
import com.pe.colegio.nsr.bean.Grado;
import com.pe.colegio.nsr.bean.Seccion;
import com.pe.colegio.nsr.bean.Alumno;
import com.pe.colegio.nsr.dao.BimestreDaoImpl;
import com.pe.colegio.nsr.dao.CursoDaoImpl;
import com.pe.colegio.nsr.dao.GradoDaoImpl;
import com.pe.colegio.nsr.dao.LibretaDaoImpl;
import com.pe.colegio.nsr.dao.SeccionDaoImpl;
import com.pe.colegio.nsr.dao.AlumnoDaoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "nota")
@SessionScoped
public class NotaBean {

    private String nota;
    private Integer idGrado;
    private Integer idSeccion;
    private Integer idAlumno;
    private Integer idCurso;
    private Integer idBimestre;
    private List<Grado> listadoGrado;
    private List<Seccion> listadoSeccion;
    private List<Alumno> listadoAlumno;
    private List<Curso> listadoCurso;
    private List<Bimestre> listadoBimestre;

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdBimestre() {
        return idBimestre;
    }

    public void setIdBimestre(Integer idBimestre) {
        this.idBimestre = idBimestre;
    }

    public List<Grado> getListadoGrado() throws SQLException {
        GradoDaoImpl dao = new GradoDaoImpl();
        listadoGrado = dao.listadoGrado();
        return listadoGrado;
    }

    public List<Seccion> handleGradoChange() throws SQLException {
        if (getIdGrado() != null && getIdGrado() != 0) {
            SeccionDaoImpl dao = new SeccionDaoImpl();
            listadoSeccion = dao.buscarSeccionporGrado(getIdGrado());
        } else {
            listadoSeccion = new ArrayList<Seccion>();
        }
        return listadoSeccion;
    }

    public List<Alumno> handleSeccionChange() throws SQLException {
        if (getIdGrado() != null && getIdGrado() != 0 && getIdSeccion() != null && getIdSeccion() != 0) {
            AlumnoDaoImpl dao = new AlumnoDaoImpl();
            listadoAlumno = dao.buscarAlumnoGradoSeccion(getIdGrado(), getIdSeccion());
        } else {
            listadoAlumno = new ArrayList<Alumno>();
        }
        return listadoAlumno;
    }

    public List<Curso> handleGradoCursoChange() throws SQLException {
        if (getIdGrado() != null && getIdGrado() != 0) {
            CursoDaoImpl dao = new CursoDaoImpl();
            listadoCurso = dao.buscarCursoporGrado(getIdGrado());
        } else {
            listadoCurso = new ArrayList<Curso>();
        }
        return listadoCurso;
    }

    public List<Bimestre> getListadoBimestre() throws SQLException {
        BimestreDaoImpl dao = new BimestreDaoImpl();
        listadoBimestre = dao.listadoBimestre();
        return listadoBimestre;
    }

    public void registrarNota() throws SQLException {
        LibretaDaoImpl dao = new LibretaDaoImpl();
        if (getIdBimestre() != null && getIdBimestre() != null && getIdCurso() != null && getIdCurso() != null
                && getIdAlumno() != null && getIdAlumno() != null && getNota() != null && getNota() != null) {
            dao.insertarNota(getIdBimestre(), getIdCurso(), getIdAlumno(), getNota());
            limpiar();
        }
    }

    public void limpiar() {
        setNota("");
    }

    public String verPrincipal() {
        return "principal";
    }
}