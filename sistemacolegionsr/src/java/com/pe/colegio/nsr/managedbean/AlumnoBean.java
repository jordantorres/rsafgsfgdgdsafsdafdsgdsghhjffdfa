package com.pe.colegio.nsr.managedbean;

import com.pe.colegio.nsr.bean.Alumno;
import com.pe.colegio.nsr.bean.Bimestre;
import com.pe.colegio.nsr.bean.ConsultaOrdenMerito;
import com.pe.colegio.nsr.bean.Grado;
import com.pe.colegio.nsr.bean.Libreta;
import com.pe.colegio.nsr.bean.Observacion;
import com.pe.colegio.nsr.bean.OrdenMerito;
import com.pe.colegio.nsr.bean.Seccion;
import com.pe.colegio.nsr.dao.AlumnoDaoImpl;
import com.pe.colegio.nsr.dao.BimestreDaoImpl;
import com.pe.colegio.nsr.dao.GradoDaoImpl;
import com.pe.colegio.nsr.dao.LibretaDaoImpl;
import com.pe.colegio.nsr.dao.ObservacionDaoImpl;
import com.pe.colegio.nsr.dao.OrdenMeritoDaoImpl;
import com.pe.colegio.nsr.dao.SeccionDaoImpl;
import com.pe.colegio.nsr.dao.UsuarioDaoImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "alumno")
@SessionScoped
public class AlumnoBean {

    private int id;
    private int idTipo;
    private String nombre;
    private String apellido;
    private String apoderado;
    private String usuario;
    private String contrasenia;
    private String foto;
    private Boolean estadoDeuda;
    private Integer idGrado;
    private Integer idSeccion;
    private Integer idAlumnoBuscar;
    private Integer idBimestre;
    private String observacion;
    private String conducta;
    private String inasistencia;
    private String tardanza;
    private Integer idCurso;
    private String curso;
    private String notaBimestre1;
    private String notaBimestre2;
    private String notaBimestre3;
    private String notaBimestre4;
    private List<Grado> listadoGrado;
    private List<Seccion> listadoSeccion;
    private List<Alumno> listadoAlumnos;
    private List<Libreta> listadoLibreta;
    private List<Observacion> listadoLibretaObservacion;
    private List<ConsultaOrdenMerito> listadoLibretaOrdenMerito;
    private List<Libreta> listadoNotas;
    private List<Bimestre> listadoBimestre;
    private List<Observacion> listadoObservacion;
    private List<ConsultaOrdenMerito> listadoOrdenMerito;

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

    public Integer getIdAlumnoBuscar() {
        return idAlumnoBuscar;
    }

    public void setIdAlumnoBuscar(Integer idAlumnoBuscar) {
        this.idAlumnoBuscar = idAlumnoBuscar;
    }

    public Integer getIdBimestre() {
        return idBimestre;
    }

    public void setIdBimestre(Integer idBimestre) {
        this.idBimestre = idBimestre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getConducta() {
        return conducta;
    }

    public void setConducta(String conducta) {
        this.conducta = conducta;
    }

    public String getInasistencia() {
        return inasistencia;
    }

    public void setInasistencia(String inasistencia) {
        this.inasistencia = inasistencia;
    }

    public String getTardanza() {
        return tardanza;
    }

    public void setTardanza(String tardanza) {
        this.tardanza = tardanza;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNotaBimestre1() {
        return notaBimestre1;
    }

    public void setNotaBimestre1(String notaBimestre1) {
        this.notaBimestre1 = notaBimestre1;
    }

    public String getNotaBimestre2() {
        return notaBimestre2;
    }

    public void setNotaBimestre2(String notaBimestre2) {
        this.notaBimestre2 = notaBimestre2;
    }

    public String getNotaBimestre3() {
        return notaBimestre3;
    }

    public void setNotaBimestre3(String notaBimestre3) {
        this.notaBimestre3 = notaBimestre3;
    }

    public String getNotaBimestre4() {
        return notaBimestre4;
    }

    public void setNotaBimestre4(String notaBimestre4) {
        this.notaBimestre4 = notaBimestre4;
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

    public List<Libreta> getListadoLibreta() {
        return listadoLibreta;
    }

    public void setListadoLibreta(List<Libreta> listadoLibreta) {
        this.listadoLibreta = listadoLibreta;
    }

    public List<Observacion> getListadoLibretaObservacion() {
        return listadoLibretaObservacion;
    }

    public void setListadoLibretaObservacion(List<Observacion> listadoLibretaObservacion) {
        this.listadoLibretaObservacion = listadoLibretaObservacion;
    }

    public List<ConsultaOrdenMerito> getListadoLibretaOrdenMerito() {
        return listadoLibretaOrdenMerito;
    }

    public void setListadoLibretaOrdenMerito(List<ConsultaOrdenMerito> listadoLibretaOrdenMerito) {
        this.listadoLibretaOrdenMerito = listadoLibretaOrdenMerito;
    }

    public List<Bimestre> getListadoBimestre() throws SQLException {
        BimestreDaoImpl dao = new BimestreDaoImpl();
        listadoBimestre = dao.listadoBimestre();
        return listadoBimestre;
    }

    public void matricularAlumno() throws SQLException {
        AlumnoDaoImpl dao = new AlumnoDaoImpl();
        Alumno alumno = new Alumno();

        alumno.setIdTipo(2);
        alumno.setNombre(getNombre());
        alumno.setApellido(getApellido());
        alumno.setApoderado(getApoderado());
        alumno.setUsuario(getUsuario());
        alumno.setEstadoDeuda("1");
        alumno.setIdSeccion(getIdSeccion());

        if (alumno != null && getIdSeccion() != null) {
            dao.matricularAlumno(alumno);
            limpiar();
        }
    }

    public List<Alumno> buscarAlumnoGradoSeccion() throws SQLException {
        if (getIdGrado() != null && getIdGrado() != 0 && getIdSeccion() != null && getIdSeccion() != 0) {
            AlumnoDaoImpl dao = new AlumnoDaoImpl();
            listadoAlumnos = dao.buscarAlumnoGradoSeccion(getIdGrado(), getIdSeccion());

            for (Alumno u : listadoAlumnos) {
                String vEstadoDeuda = u.getEstadoDeuda();
                if (vEstadoDeuda.equals("0")) {
                    vEstadoDeuda = "SI";
                    u.setEstadoDeuda(vEstadoDeuda);
                }
                if (vEstadoDeuda.equals("1")) {
                    vEstadoDeuda = "NO";
                    u.setEstadoDeuda(vEstadoDeuda);
                }
            }
        } else {
            listadoAlumnos = new ArrayList<Alumno>();
        }
        return listadoAlumnos;
    }

    public void verLibreta() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        Integer cod = Integer.parseInt(context.getExternalContext()
                .getRequestParameterMap().get("id"));

        LibretaDaoImpl dao = new LibretaDaoImpl();
        ObservacionDaoImpl daoObs = new ObservacionDaoImpl();
        OrdenMeritoDaoImpl daoOrden = new OrdenMeritoDaoImpl();
        setListadoLibreta(dao.buscarLibreta(cod));
        setListadoLibretaOrdenMerito(daoOrden.consultarOrdenMeritoPorAlumno(cod));
        setListadoLibretaObservacion(daoObs.consultarObservacionPorAlumno(cod));
    }

    public List<Libreta> verNotas() throws SQLException {
        if (getIdAlumnoBuscar() != null && getIdAlumnoBuscar() != 0) {
            LibretaDaoImpl dao = new LibretaDaoImpl();
            listadoNotas = dao.buscarLibreta(getIdAlumnoBuscar());
        } else {
            listadoNotas = new ArrayList<Libreta>();
        }
        return listadoNotas;
    }

    public List<Observacion> verObservaciones() throws SQLException {
        if (getIdAlumnoBuscar() != null && getIdAlumnoBuscar() != 0) {
            ObservacionDaoImpl dao = new ObservacionDaoImpl();
            listadoObservacion = dao.consultarObservacionPorAlumno(getIdAlumnoBuscar());
        } else {
            listadoObservacion = new ArrayList<Observacion>();
        }
        return listadoObservacion;
    }

    public List<ConsultaOrdenMerito> verOrdenMerito() throws SQLException {
        if (getIdAlumnoBuscar() != null && getIdAlumnoBuscar() != 0) {
            OrdenMeritoDaoImpl dao = new OrdenMeritoDaoImpl();
            listadoOrdenMerito = dao.consultarOrdenMeritoPorAlumno(getIdAlumnoBuscar());
        } else {
            listadoOrdenMerito = new ArrayList<ConsultaOrdenMerito>();
        }
        return listadoOrdenMerito;
    }

    public void grabarObservacion() throws SQLException {
        ObservacionDaoImpl dao = new ObservacionDaoImpl();
        Observacion observacion = new Observacion();

        observacion.setIdUsuario(getIdAlumnoBuscar());
        observacion.setIdBimestre(getIdBimestre());
        observacion.setObservacion(getObservacion());

        if (observacion != null) {
            dao.insertarObservacion(observacion);
            limpiar();
        }
    }

    public void grabarOrdenMertio() throws SQLException {
        OrdenMeritoDaoImpl dao = new OrdenMeritoDaoImpl();
        OrdenMerito ordenMerito = new OrdenMerito();

        ordenMerito.setIdUsuario(getIdAlumnoBuscar());
        ordenMerito.setIdBimestre(getIdBimestre());
        ordenMerito.setConducta(getConducta());
        ordenMerito.setInasistencias(getInasistencia());
        ordenMerito.setTardanzas(getTardanza());

        if (ordenMerito != null) {
            dao.insertarOrdenMerito(ordenMerito);
            limpiar();
        }
    }

    public void retirarUsuario() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        int cod = Integer.parseInt(context.getExternalContext()
                .getRequestParameterMap().get("id"));
        UsuarioDaoImpl dao = new UsuarioDaoImpl();
        dao.eliminarUsuario(cod);
    }

    public void traerAlumno() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        int cod = Integer.parseInt(context.getExternalContext()
                .getRequestParameterMap().get("id"));
        AlumnoDaoImpl dao = new AlumnoDaoImpl();
        Alumno alumno = dao.buscarAlumno(cod);

        setId(alumno.getId());
        setNombre(alumno.getNombre());
        setApellido(alumno.getApellido());
        setApoderado(alumno.getApoderado());
        setUsuario(alumno.getUsuario());
        setContrasenia(alumno.getContrasenia());
        if (alumno.getEstadoDeuda().equals("1")) {
            setEstadoDeuda(true);
        }
        if (alumno.getEstadoDeuda().equals("0")) {
            setEstadoDeuda(false);
        }
        setIdGrado(alumno.getIdGrado());
        setIdSeccion(alumno.getIdSeccion());

    }

    public void traerLibretaCurso() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        int cod = Integer.parseInt(context.getExternalContext()
                .getRequestParameterMap().get("id"));
        LibretaDaoImpl dao = new LibretaDaoImpl();
        Libreta libreta = dao.traerLibretaPorAlumnoCurso(getIdAlumnoBuscar(), cod);

        setIdCurso(libreta.getIdCurso());
        setCurso(libreta.getCurso());
        setNotaBimestre1(libreta.getNotaBimestre1());
        setNotaBimestre2(libreta.getNotaBimestre2());
        setNotaBimestre3(libreta.getNotaBimestre3());
        setNotaBimestre4(libreta.getNotaBimestre4());

    }

    public void actualizarAlumno() throws SQLException {
        AlumnoDaoImpl dao = new AlumnoDaoImpl();
        Alumno alumno = new Alumno();

        alumno.setId(getId());
        alumno.setNombre(getNombre());
        alumno.setApellido(getApellido());
        alumno.setApoderado(getApoderado());
        alumno.setUsuario(getUsuario());
        alumno.setContrasenia(getContrasenia());
        if (getEstadoDeuda() == true) {
            alumno.setEstadoDeuda("1");
        }
        if (getEstadoDeuda() == false) {
            alumno.setEstadoDeuda("0");
        }
        alumno.setIdSeccion(getIdSeccion());

        if (alumno != null && getIdSeccion() != null) {
            dao.actualizarAlumno(alumno);
            limpiar();
        }
    }

    public void grabarNotaCurso() throws SQLException {
        LibretaDaoImpl dao = new LibretaDaoImpl();
        if (getIdCurso() != null && getIdAlumnoBuscar() != null) {
            dao.insertarNota(1, getIdCurso(), getIdAlumnoBuscar(), getNotaBimestre1());
            dao.insertarNota(2, getIdCurso(), getIdAlumnoBuscar(), getNotaBimestre2());
            dao.insertarNota(3, getIdCurso(), getIdAlumnoBuscar(), getNotaBimestre3());
            dao.insertarNota(4, getIdCurso(), getIdAlumnoBuscar(), getNotaBimestre4());
            limpiar();
        }
    }

    public void limpiar() {
        setNombre("");
        setApellido("");
        setApoderado("");
        setUsuario("");
        setContrasenia("");
        setEstadoDeuda(false);
        setObservacion("");
        setConducta("");
        setInasistencia("");
        setTardanza("");
        setIdCurso(0);
        setCurso("");
        setNotaBimestre1("");
        setNotaBimestre2("");
        setNotaBimestre3("");
        setNotaBimestre4("");
    }

    public String verPrincipal() {
        return "principal";
    }
}
