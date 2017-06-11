/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openfrontino.adm.logic.products;

import com.openfrontino.tools.conection.querys.Select;
import com.openfrontino.tools.session.SessionDto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author casc
 */
public class Productos {

    Connection con;
    SessionDto dtoSes;

    public Productos(Connection _con, SessionDto _dtoSes) {
        con = _con;
        dtoSes = _dtoSes;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public SessionDto getDtoSes() {
        return dtoSes;
    }

    public void setDtoSes(SessionDto dtoSes) {
        this.dtoSes = dtoSes;
    }

    /**
     *
     * @return @throws Exception
     */
    public List<UnidadDto> consultarUnidades() throws Exception {
        List arr = new ArrayList();
        Select sel = new Select(getCon());
        ResultSet rs;
        try {
            sel.sentencia("ide_und, cod_und, des_und", "pro001m", "", "", "");
            rs = sel.ejecutar();
            UnidadDto dto;
            while (rs.next()) {
                dto = new UnidadDto();
                dto.setIdeUnd(rs.getInt("ide_und"));
                dto.setCodUnd(rs.getString("cod_und"));
                dto.setDesUnd(rs.getString("des_und"));
                arr.add(dto);
            }
            rs.close();
            sel.cerrar();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return arr;
    }
    
    public ProductoDto consultarProducto(int _idePro, String _codPro) throws Exception{
        ProductoDto dto=null;
        Select sel=new Select(getCon());
        ResultSet rs;
        StringBuilder condi=new StringBuilder("");
        if(_idePro>0){
            condi.append(" ide_pro=").append(_idePro);
        }else if(_codPro!=null && !_codPro.trim().equals("")){
            condi.append(" cod_pro='").append(_codPro).append("'");
        }
        try{
            sel.sentencia("pro003m.*", "pro003m", 
                    condi.toString(), "", "");
            rs = sel.ejecutar();
            if(rs.next()){
                
            }
            rs.close();
            sel.cerrar();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return dto;
    }
}
