package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Configuracion;
import com.pe.colegio.nsr.bean.Usuario;
import com.pe.colegio.nsr.util.DBConn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DIEGO PISCO
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private Connection getConnection() {
        DBConn cnx = new DBConn();
        return cnx.getConnection();
    }

    @Override
    public Usuario retornaUsuario(Usuario oUsuario) {
        try {
            String sql = "select * from usuario where usuario='" + oUsuario.getUsuario() + "' and contrasenia='" + oUsuario.getContrasenia() + "'";
            Connection conn = getConnection();
            CallableStatement cstm = conn.prepareCall(sql);
            ResultSet rst = cstm.executeQuery(sql);
            while (rst.next()) {
                oUsuario.setId(rst.getInt("id"));
                oUsuario.setIdTipo(rst.getInt("idTipo"));
                oUsuario.setNombre(rst.getString("nombre"));
                oUsuario.setApellido(rst.getString("apellido"));
                oUsuario.setApoderado(rst.getString("apoderado"));
                oUsuario.setUsuario(rst.getString("usuario"));
                oUsuario.setContrasenia(rst.getString("contrasenia"));
                oUsuario.setEstadoDeuda(rst.getString("estadoDeuda"));
            }

            rst.close();
            cstm.close();
            conn.close();

            return oUsuario;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Configuracion retornaConfiguracion(String objeto) {
        try {
            String sql = "SELECT * FROM configuracion WHERE objeto='" + objeto + "'";
            Connection conn = getConnection();
            CallableStatement cstm = conn.prepareCall(sql);
            ResultSet rst = cstm.executeQuery(sql);
            Configuracion oConfiguracion = new Configuracion();
            while (rst.next()) {
                oConfiguracion.setValor(rst.getObject("valor").toString());
            }
            rst.close();
            cstm.close();
            conn.close();
            return oConfiguracion;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public int eliminarUsuario(int id) throws SQLException {
        String sql = "{ call SP_ELIMINAR_USUARIO(?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, id);
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }

    @Override
    public int cambiarContraseniaUsuario(int id, String contraseniaAntigua, String contraseniaNueva) throws SQLException {
        String sql = "{ call SP_CAMBIAR_CONTRASENIA_USUARIO(?,?,?) }";
        Connection conn = getConnection();

        CallableStatement cstm = conn.prepareCall(sql);
        cstm.setInt(1, id);
        cstm.setString(2, contraseniaAntigua);
        cstm.setString(3, contraseniaNueva);
        int n = cstm.executeUpdate();

        cstm.close();
        conn.close();

        return n;
    }
}
