package com.pe.colegio.nsr.managedbean;

import com.pe.colegio.nsr.bean.*;
import com.pe.colegio.nsr.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DIEGO PISCO
 */
@WebServlet(name = "ValidaUsuario", urlPatterns = {"/ValidaUsuario"})
public class ValidaUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String usuarioWeb = request.getParameter("txtUsuario");
        String claveWeb = request.getParameter("txtClave");
        try {
            Usuario oUsuario = new Usuario();
            oUsuario.setUsuario(usuarioWeb);
            oUsuario.setContrasenia(claveWeb);
            UsuarioDaoImpl oUsuarioLoginDao = new UsuarioDaoImpl();
            oUsuario = oUsuarioLoginDao.retornaUsuario(oUsuario);

            int idUsuario = oUsuario.getId();
            String tipoUsuario = oUsuario.getIdTipo() + "" == null ? "" : oUsuario.getIdTipo() + "";
            String deudor = oUsuario.getEstadoDeuda() == null ? "" : oUsuario.getEstadoDeuda().toString();
            Configuracion oConfiguracion = new Configuracion();
            if (!tipoUsuario.equals("0")) {
                if (tipoUsuario.equals("2")) {
                    if (deudor.equals("0")) {
                        out.print("<font color=\"red\">Acceso restringido por deuda</font>");
                    } else {
                        session.setAttribute("alumnoLogeado", oUsuario);
                        session.setAttribute("idAlumno", idUsuario);
                        oConfiguracion = oUsuarioLoginDao.retornaConfiguracion("principalAlumno");
                        out.print("<script>location.href='" + oConfiguracion.getValor().toString() + "';</script>");
                    }
                } else {
                    oConfiguracion = oUsuarioLoginDao.retornaConfiguracion("sistemaPrincipal");
                    out.print("<script>location.href='" + oConfiguracion.getValor().toString() + "';</script>");
                }
            } else {
                out.print("<font color=\"red\">Usuario o Clave incorrecto</font>");
            }

        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ValidaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
