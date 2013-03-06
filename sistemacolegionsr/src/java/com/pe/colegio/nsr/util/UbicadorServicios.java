package com.pe.colegio.nsr.util;

import java.util.*;
import javax.naming.*;
import javax.sql.*;

public class UbicadorServicios implements java.io.Serializable {

    private static final long serialVersionUID = -5512952148980114705L;
    private InitialContext ic = null;
    private Map<String, DataSource> cache = null;
    private static UbicadorServicios instance;

    private UbicadorServicios() throws NamingException {
        try {
            ic = new InitialContext();
            cache = Collections.synchronizedMap(new HashMap<String, DataSource>());
        } catch (NamingException ne) {

            throw ne;
        }
    }

    private UbicadorServicios(InitialContext iCtx) {
        ic = iCtx;
    }

    public static UbicadorServicios getInstance() throws NamingException {
        if (instance == null) {
            instance = new UbicadorServicios();
        }
        return instance;
    }

    public static InitialContext getInitialContext() throws NamingException {
        return new InitialContext();
    }

    public DataSource getDataSource(String dataSourceName)
            throws NamingException {

        DataSource dataSource = null;
        try {
            if (cache.containsKey(dataSourceName)) {
                dataSource = cache.get(dataSourceName);

            } else {
                dataSource = (DataSource) ic.lookup(dataSourceName);
                cache.put(dataSourceName, dataSource);

            }
        } catch (NamingException nex) {
            throw new NamingException();

        } catch (Exception ex) {
            throw new NamingException();
        }
        return dataSource;
    }
}