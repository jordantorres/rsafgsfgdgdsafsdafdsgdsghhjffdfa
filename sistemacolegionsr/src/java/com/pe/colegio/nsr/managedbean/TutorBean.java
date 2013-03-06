package com.pe.colegio.nsr.managedbean;

import com.pe.colegio.nsr.bean.Grado;
import com.pe.colegio.nsr.bean.Seccion;
import com.pe.colegio.nsr.bean.Tutor;
import com.pe.colegio.nsr.dao.GradoDaoImpl;
import com.pe.colegio.nsr.dao.SeccionDaoImpl;
import com.pe.colegio.nsr.dao.TutorDaoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "tutor")
@SessionScoped
public class TutorBean {

    private int id;
    private int idTipo;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasenia;
    private String foto;
    private Integer idGrado;
    private Integer idSeccion;
    private List<Tutor> listadoTutores;
    private List<Grado> listadoGrado;
    private List<Seccion> listadoSeccion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public List<Tutor> getListadoTutores() throws SQLException {
        TutorDaoImpl dao = new TutorDaoImpl();
        listadoTutores = dao.listadoTutor();
        return listadoTutores;
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

    public void registrarTutor() throws SQLException {
        TutorDaoImpl dao = new TutorDaoImpl();
        Tutor tutor = new Tutor();

        tutor.setIdTipo(3);
        tutor.setNombre(getNombre());
        tutor.setApellido(getApellido());
        tutor.setUsuario(getUsuario());
        tutor.setEstadoDeuda("1");
        tutor.setIdSeccion(getIdSeccion());

        if (tutor != null) {
            dao.registrarTutor(tutor);
            limpiar();
        }
    }

    public void retirarTutor() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        int cod = Integer.parseInt(context.getExternalContext()
                .getRequestParameterMap().get("id"));
        TutorDaoImpl dao = new TutorDaoImpl();
        dao.eliminarTutor(cod);
    }

    public void traerTutor() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        int cod = Integer.parseInt(context.getExternalContext()
                .getRequestParameterMap().get("id"));
        TutorDaoImpl dao = new TutorDaoImpl();
        Tutor tutor = dao.buscarTutor(cod);

        setId(tutor.getId());
        setNombre(tutor.getNombre());
        setApellido(tutor.getApellido());
        setUsuario(tutor.getUsuario());
        setContrasenia(tutor.getContrasenia());
        setIdGrado(tutor.getIdGrado());
        setIdSeccion(tutor.getIdSeccion());

    }

    public void actualizarTutor() throws SQLException {
        TutorDaoImpl dao = new TutorDaoImpl();
        Tutor tutor = new Tutor();

        tutor.setId(getId());
        tutor.setNombre(getNombre());
        tutor.setApellido(getApellido());
        tutor.setUsuario(getUsuario());
        tutor.setContrasenia(getContrasenia());
        tutor.setIdSeccion(getIdSeccion());

        if (tutor != null && getIdSeccion() != null) {
            dao.actualizarTutor(tutor);
            limpiar();
        }
    }

    public void limpiar() {
        setNombre("");
        setApellido("");
        setUsuario("");
        setContrasenia("");
    }

    public String verPrincipal() {
        return "principal";
    }
}
