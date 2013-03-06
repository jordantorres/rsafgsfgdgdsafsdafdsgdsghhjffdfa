package com.pe.colegio.nsr.managedbean;

import com.pe.colegio.nsr.bean.ConsultaOrdenMerito;
import com.pe.colegio.nsr.bean.Libreta;
import com.pe.colegio.nsr.bean.Observacion;
import com.pe.colegio.nsr.bean.Usuario;
import com.pe.colegio.nsr.dao.LibretaDaoImpl;
import com.pe.colegio.nsr.dao.ObservacionDaoImpl;
import com.pe.colegio.nsr.dao.OrdenMeritoDaoImpl;
import com.pe.colegio.nsr.dao.UsuarioDaoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "usuarioAlumno")
@SessionScoped
public class UsuarioAlumno {

    private int id;
    private int idTipo;
    private String nombre;
    private String apellido;
    private String apoderado;
    private String usuario;
    private String contrasenia;
    private String foto;
    private Boolean estadoDeuda;
    private Integer idAlumnoBuscar;
    private String contraseniaActual;
    private String contraseniaNueva;
    private List<Libreta> listadoNotas;
    private List<Observacion> listadoObservacion;
    private List<ConsultaOrdenMerito> listadoOrdenMerito;

    public UsuarioAlumno() {
        obtenerSession();
    }

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

    public String getApoderado() {
        return apoderado;
    }

    public void setApoderado(String apoderado) {
        this.apoderado = apoderado;
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

    public Boolean getEstadoDeuda() {
        return estadoDeuda;
    }

    public void setEstadoDeuda(Boolean estadoDeuda) {
        this.estadoDeuda = estadoDeuda;
    }

    public Integer getIdAlumnoBuscar() {
        return idAlumnoBuscar;
    }

    public void setIdAlumnoBuscar(Integer idAlumnoBuscar) {
        this.idAlumnoBuscar = idAlumnoBuscar;
    }

    public String getContraseniaActual() {
        return contraseniaActual;
    }

    public void setContraseniaActual(String contraseniaActual) {
        this.contraseniaActual = contraseniaActual;
    }

    public String getContraseniaNueva() {
        return contraseniaNueva;
    }

    public void setContraseniaNueva(String contraseniaNueva) {
        this.contraseniaNueva = contraseniaNueva;
    }

    public List<Libreta> getListadoNotas() throws SQLException {
        if (getIdAlumnoBuscar() != null && getIdAlumnoBuscar() != 0) {
            LibretaDaoImpl dao = new LibretaDaoImpl();
            listadoNotas = dao.buscarLibreta(getIdAlumnoBuscar());
        } else {
            listadoNotas = new ArrayList<Libreta>();
        }
        return listadoNotas;
    }

    public List<Observacion> getListadoObservacion() throws SQLException {
        if (getIdAlumnoBuscar() != null && getIdAlumnoBuscar() != 0) {
            ObservacionDaoImpl dao = new ObservacionDaoImpl();
            listadoObservacion = dao.consultarObservacionPorAlumno(getIdAlumnoBuscar());
        } else {
            listadoObservacion = new ArrayList<Observacion>();
        }
        return listadoObservacion;
    }

    public List<ConsultaOrdenMerito> getListadoOrdenMerito() throws SQLException {
        if (getIdAlumnoBuscar() != null && getIdAlumnoBuscar() != 0) {
            OrdenMeritoDaoImpl dao = new OrdenMeritoDaoImpl();
            listadoOrdenMerito = dao.consultarOrdenMeritoPorAlumno(getIdAlumnoBuscar());
        } else {
            listadoOrdenMerito = new ArrayList<ConsultaOrdenMerito>();
        }
        return listadoOrdenMerito;
    }

    public void obtenerSession() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
        Usuario objUsuario = (Usuario) httpSession.getAttribute("alumnoLogeado");
//        Integer objUsuario = Integer.parseInt(httpSession.getAttribute("idAlumno").toString());

        setIdAlumnoBuscar(objUsuario.getId());
        setId(objUsuario.getId());
        setIdTipo(objUsuario.getIdTipo());
        setNombre(objUsuario.getNombre());
        setApellido(objUsuario.getApellido());
        setApoderado(objUsuario.getApoderado());
        setUsuario(objUsuario.getUsuario());
        setContrasenia(objUsuario.getContrasenia());
        if (objUsuario.getEstadoDeuda().equals("0")) {
            setEstadoDeuda(true);
        }
        if (objUsuario.getEstadoDeuda().equals("1")) {
            setEstadoDeuda(false);
        }
    }

    public void cambiarContrasenia() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg = null;
        UsuarioDaoImpl dao = new UsuarioDaoImpl();

        if (getContraseniaActual() != null && !getContraseniaActual().equals("") && getContraseniaNueva() != null && !getContraseniaNueva().equals("")) {
            if (dao.cambiarContraseniaUsuario(getId(), getContraseniaActual(), getContraseniaNueva()) == 1) {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Su contraseña fue cambiado.");
                setContraseniaActual("");
                setContraseniaNueva("");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Su contraseña antigua no coincide. ¡Vuelva a Intentarlo!");
            }
        }

        context.addMessage(null, msg);
    }

    public void limpiar() {
        setNombre("");
        setApellido("");
        setApoderado("");
        setUsuario("");
        setContrasenia("");
        setEstadoDeuda(false);
    }

    public String verPrincipal() {
        return "principalAlumno";
    }
}
