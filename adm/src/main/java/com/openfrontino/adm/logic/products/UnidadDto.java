/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openfrontino.adm.logic.products;

import java.io.Serializable;

/**
 *
 * @author casc
 */
public class UnidadDto implements Serializable{
    private int ideUnd;
    private String CodUnd;
    private String DesUnd;

    public int getIdeUnd() {
        return ideUnd;
    }

    public void setIdeUnd(int ideUnd) {
        this.ideUnd = ideUnd;
    }

    public String getCodUnd() {
        return CodUnd;
    }

    public void setCodUnd(String CodUnd) {
        this.CodUnd = CodUnd;
    }

    public String getDesUnd() {
        return DesUnd;
    }

    public void setDesUnd(String DesUnd) {
        this.DesUnd = DesUnd;
    }
    
    
}
