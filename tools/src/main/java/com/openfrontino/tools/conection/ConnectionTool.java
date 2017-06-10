package com.openfrontino.tools.conection;

import java.sql.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

import com.openfrontino.tools.security.Encrypting;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionTool {

    private Connection _con = null;


    public ConnectionTool() {
        
    }
    
     public boolean connect(String _server, String _port, String _db, String _user, String _pass) {
         boolean result=false;
        try {
            Class.forName("org.postgresql.Driver");
            _con = DriverManager.getConnection("jdbc:postgresql://" + _server
                    + ":" + _port + "/" + _db,
                    _user,
                    Encrypting
                            .desCrypt(_pass)
            );
            _con.setAutoCommit(false);
            _con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            result =true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
     
     /**
      * Realizar la conexion y recibe el password sin encriptar
      * @param _server
      * @param _port
      * @param _db
      * @param _user
      * @param _pass
      * @return 
      */
     public boolean connectNoEncrypr(String _server, String _port, String _db, String _user, String _pass) {
         boolean result=false;
        try {
            Class.forName("org.postgresql.Driver");
            _con = DriverManager.getConnection("jdbc:postgresql://" + _server
                    + ":" + _port + "/" + _db,
                    _user,
                    _pass
            );
            _con.setAutoCommit(false);
            _con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            result =true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public Connection getConexion() {
        return _con;
    }

    public void cerrar() {
        try {
            if (!_con.isClosed()) {
                _con.close();
            }
        } catch (SQLException ex) {
            System.out.println("5 - [Conexion][com.sy.conexion.getConexion] "
                    + ex.toString());
        } finally {
            _con = null;
        }
    }
    
    public static void killConnection(Connection _con){
        try {
            if(_con!=null){
                _con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error matando conexion " + ex.getMessage());
        }
    }
    
    public static void rollBackTrans(Connection _con){
        try {
            if(_con!=null){
                _con.rollback();
            }
        } catch (SQLException ex) {
            System.out.println("Error matando conexion " + ex.getMessage());
        }
    }

}
