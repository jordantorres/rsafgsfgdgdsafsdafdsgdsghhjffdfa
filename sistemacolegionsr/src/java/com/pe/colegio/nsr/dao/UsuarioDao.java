package com.pe.colegio.nsr.dao;

import com.pe.colegio.nsr.bean.Configuracion;
import com.pe.colegio.nsr.bean.Usuario;
import java.sql.SQLException;

/**
 *
 * @author DIEGO PISCO
 */
public interface UsuarioDao {

    public Usuario retornaUsuario(Usuario oUsuario);

    public Configuracion retornaConfiguracion(String objeto);

    public int eliminarUsuario(int id) throws SQLException;
    
    public int cambiarContraseniaUsuario(int id, String contraseniaAntigua, String contraseniaNueva) throws SQLException;
}
