/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openfrontino.tools.session;

import com.openfrontino.tools.conection.ConnectionTool;
import com.openfrontino.tools.conection.querys.Insert;
import com.openfrontino.tools.conection.querys.Select;
import com.openfrontino.tools.conection.querys.Update;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

/**
 *
 * @author casc
 */
public class Session {

    private Connection con;

    public void setCon(Connection con) {
        this.con = con;
    }

    public Properties getProperties() throws Exception {
        Properties prop = new Properties();
        InputStream input;
        try {
            input = new FileInputStream("./openfrontino.properties");
            prop.load(input);
        } catch (FileNotFoundException ex) {
            throw new Exception(ex.getMessage());
        } catch (IOException ex) {
            throw new Exception(ex.getMessage());
        }
        return prop;
    }

    public SessionDto obtenerParametros() {
        SessionDto dto = new SessionDto();
        try {
            Properties prop = this.getProperties();
            dto.setDbhost(prop.getProperty("dbhost"));
            dto.setDbport(prop.getProperty("dbport"));
            dto.setDbname(prop.getProperty("dbname"));
            dto.setDbuser(prop.getProperty("dbuser"));
            dto.setDbpassword(prop.getProperty("dbpassword"));
            ConnectionTool conex = new ConnectionTool();
            if (!conex.connect(dto.getDbhost(), dto.getDbport(), dto.getDbname(), dto.getDbuser(),
                    dto.getDbpassword())) {
                return null;
            }
            this.setCon(conex.getConexion());
            dto.setDtoEmp(this.consultarEmpresa());
            if (dto.getDtoEmp() == null) {
                return null;
            }
            int nroCaj;
            try {
                nroCaj = Integer.parseInt(prop.getProperty("nrocaja"));
            } catch (NumberFormatException ex) {
                nroCaj = 0;
            }
            if (nroCaj == 0) {
                return null;
            }
            dto.setNrocaja(nroCaj);
            obtenerParametrosGenerales(prop, dto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dto;
    }

    public EmpresaDto consultarEmpresa() throws Exception {
        EmpresaDto dto = null;
        Select sel = new Select(con);
        ResultSet rs;
        try {
            sel.sentencia("ide_emp, rif_emp, nom_emp, dir_emp", "emp001m", "", "", "");
            rs = sel.ejecutar();
            if (rs.next()) {
                dto = new EmpresaDto();
                dto.setRifEmp(rs.getString("rif_emp"));
                dto.setNomEmp(rs.getString("nom_emp"));
                dto.setDirEmp(rs.getString("dir_emp"));
            }
            sel.cerrar();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        return dto;
    }

    /**
     *
     * @param _logUsu
     * @param _pasUsu
     * @return
     * @throws Exception
     */
    public UsuarioDto logearUsuario(String _logUsu, String _pasUsu) throws Exception {
        UsuarioDto dto = null;
        Select sel = new Select(con);
        ResultSet rs;
        try {
            sel.sentencia("log_usu, nom_usu, tip_usu", "seg001m",
                    "log_usu='" + _logUsu + "' and pas_usu=md5('" + _pasUsu + "')",
                    "", "");
            rs = sel.ejecutar();
            if (rs.next()) {
                dto = new UsuarioDto();
                dto.setLogUsu(_logUsu);
                dto.setNomUsu(rs.getString("nom_usu"));
                dto.setTipUsu(rs.getString("tip_usu").charAt(0));
            }
            sel.cerrar();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return dto;
    }

    /**
     *
     * @param _rifEmp
     * @param _nomEmp
     * @param _dirEmp
     * @return
     * @throws Exception
     */
    public boolean crearEmpresa(
            String _rifEmp, String _nomEmp, String _dirEmp
    ) throws Exception {
        boolean result = false;
        Insert ins = new Insert(con);
        try {
            ins.sentencia("emp001m", "rif_emp, nom_emp, dir_emp ",
                    "'" + _rifEmp + "','" + _nomEmp + "','" + _dirEmp + "'"
            );
            result = ins.ejecutar(false);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return result;
    }

    /**
     * Obligamos a que sea cajero por el cambio de contraseña
     *
     * @param _logUsu
     * @param _pasUsu
     * @param _nomUsu
     * @return
     * @throws Exception
     */
    public boolean agregarCajero(String _logUsu, String _pasUsu, String _nomUsu) throws Exception {
        boolean result = false;
        Select sel = new Select(con);
        ResultSet rs;
        try {
            sel.sentencia("log_usu, nom_usu, tip_usu", "seg001m",
                    "log_usu='" + _logUsu + "'",
                    "", "");
            rs = sel.ejecutar();
            if (rs.next()) {
                if (!rs.getString("tip_usu").equals("3")) {
                    throw new Exception("Usuario agregado no es de tipo cajero");
                }
                //Actualizar password
                Update upd = new Update(con);
                upd.sentencia("seg001m", "pas_usu=md5('" + _pasUsu + "')",
                        "log_usu='" + _logUsu + "'");
                upd.ejecutar(false);
            } else {
                //Incluir
                Insert ins = new Insert(con);
                ins.sentencia("seg001m", "log_usu, pas_usu, nom_usu, tip_usu",
                        "'" + _logUsu + "',md5('" + _pasUsu + "'),'" + _nomUsu + "','3'");
                result = ins.ejecutar(false);
                ins.cerrar();
            }
            sel.cerrar();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return result;
    }

    /**
     *
     * @param _ideCaj
     * @return
     * @throws Exception
     */
    public int agregarCaja(int _ideCaj) throws Exception {
        int result = _ideCaj;
        Select sel = new Select(con);
        ResultSet rs;
        try {
            sel.sentencia("ide_caj", "caj001m",
                    "ide_caj=" + _ideCaj,
                    "", "");
            rs = sel.ejecutar();
            if (!rs.next()) {
                sel.sentencia("max(ide_caj) caja", "caj001m",
                        "",
                        "", "");
                rs = sel.ejecutar();

                if (rs.next()) {
                    result = rs.getInt("caja") + 1;
                    //Incluir
                    Insert ins = new Insert(con);
                    ins.sentencia("caj001m", "ide_caj",
                            String.valueOf(result));
                    ins.ejecutar(false);
                    ins.cerrar();
                }
            }
            sel.cerrar();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return result;
    }

    public void obtenerParametrosGenerales(Properties _prop, SessionDto _dtoSes) {
        try {
            _dtoSes.setImpExe(Double.valueOf(_prop.getProperty("impexe")));
        } catch (NumberFormatException e) {
            _dtoSes.setImpExe(0);
        }
        try {
            _dtoSes.setImpGen(Double.valueOf(_prop.getProperty("impgen")));
        } catch (NumberFormatException e) {
            _dtoSes.setImpExe(12);
        }
        try {
            _dtoSes.setImpRed(Double.valueOf(_prop.getProperty("impred")));
        } catch (NumberFormatException e) {
            _dtoSes.setImpExe(8);
        }
        try {
            _dtoSes.setImpAdi(Double.valueOf(_prop.getProperty("impadi")));
        } catch (NumberFormatException e) {
            _dtoSes.setImpExe(27);
        }
    }
}
