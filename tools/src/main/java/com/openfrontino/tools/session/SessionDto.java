/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openfrontino.tools.session;

import com.openfrontino.tools.format.Formateo;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author casc
 */
public class SessionDto implements Serializable {

    //Base de datos
    private String dbhost;
    private String dbport;
    private String dbname;
    private String dbuser;
    private String dbpassword;
    //Cajaa
    private int nrocaja;
    //USuario
    private UsuarioDto dtoUsu;
    //Empresa
    private EmpresaDto dtoEmp;
    //Registro nuevo
    private String admimUsr;
    private String adminPas;
    private String cajUsr;
    private String cajPas;
    private String cajPas2;
    //Generales
    private double impExe;
    private double impGen;
    private double impRed;
    private double impAdi;
    private String separadordecimal;
    private String separadormiles;
    
    public double valorDoubleFomateado(String _valor) {
        return Formateo.valor(getSeparadormiles(), getSeparadordecimal(), _valor, true);
    }
    
    public double valorDouble(String _valor) {
        return Formateo.valor(getSeparadormiles(), getSeparadordecimal(), _valor, false);
    }

    public String formatearString(String _valor) {
        try {
            return Formateo.numeroFormateadoStr(getSeparadordecimal(), Formateo.valor(getSeparadormiles(), getSeparadordecimal(), _valor, false), 2);
        } catch (Exception ex) {
            return "0";
        }
    }
    
    public String quitarFormatoString(String _valor){
        try {
            return Formateo.quitarFormatoString(getSeparadormiles(),getSeparadordecimal(),_valor);
        } catch (Exception ex) {
            return "0";
        }
    }
    
    public String numeroFormateadoStr(double _valor){
        try {
            return Formateo.numeroFormateadoStr(getSeparadordecimal(), _valor, 2);
        } catch (Exception ex) {
            return "0";
        }
    }

    //-- GETTERRS Y SETTERS -- /
    
    public String getDbhost() {
        return dbhost;
    }

    public void setDbhost(String dbhost) {
        this.dbhost = dbhost;
    }

    public String getDbport() {
        return dbport;
    }

    public void setDbport(String dbport) {
        this.dbport = dbport;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDbuser() {
        return dbuser;
    }

    public void setDbuser(String dbuser) {
        this.dbuser = dbuser;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    public String getAdmimUsr() {
        return admimUsr;
    }

    public void setAdmimUsr(String admimUsr) {
        this.admimUsr = admimUsr;
    }

    public String getAdminPas() {
        return adminPas;
    }

    public void setAdminPas(String adminPas) {
        this.adminPas = adminPas;
    }

    public String getCajUsr() {
        return cajUsr;
    }

    public void setCajUsr(String cajUsr) {
        this.cajUsr = cajUsr;
    }

    public String getCajPas() {
        return cajPas;
    }

    public void setCajPas(String cajPas) {
        this.cajPas = cajPas;
    }

    public String getCajPas2() {
        return cajPas2;
    }

    public void setCajPas2(String cajPas2) {
        this.cajPas2 = cajPas2;
    }

    public int getNrocaja() {
        return nrocaja;
    }

    public void setNrocaja(int nrocaja) {
        this.nrocaja = nrocaja;
    }

    public EmpresaDto getDtoEmp() {
        return dtoEmp;
    }

    public void setDtoEmp(EmpresaDto dtoEmp) {
        this.dtoEmp = dtoEmp;
    }

    public UsuarioDto getDtoUsu() {
        return dtoUsu;
    }

    public void setDtoUsu(UsuarioDto dtoUsu) {
        this.dtoUsu = dtoUsu;
    }

    public double getImpExe() {
        return impExe;
    }

    public void setImpExe(double impExe) {
        this.impExe = impExe;
    }

    public double getImpGen() {
        return impGen;
    }

    public void setImpGen(double impGen) {
        this.impGen = impGen;
    }

    public double getImpRed() {
        return impRed;
    }

    public void setImpRed(double impRed) {
        this.impRed = impRed;
    }

    public double getImpAdi() {
        return impAdi;
    }

    public void setImpAdi(double impAdi) {
        this.impAdi = impAdi;
    }

    public String getSeparadordecimal() {
        return separadordecimal;
    }

    public void setSeparadordecimal(String separadordecimal) {
        this.separadordecimal = separadordecimal;
    }

    public String getSeparadormiles() {
        return separadormiles;
    }

    public void setSeparadormiles(String separadormiles) {
        this.separadormiles = separadormiles;
    }

    
    
}
