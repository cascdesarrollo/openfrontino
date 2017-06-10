/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openfrontino.adm;

import com.openfrontino.adm.views.VenFrontinoAdm;
import com.openfrontino.tools.session.Session;
import com.openfrontino.tools.session.SessionDto;


/**
 *
 * @author casc
 */
public class InicioFrontinoAdm {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Session ses=new Session();
                SessionDto dtoSes =  ses.obtenerParametros();
                new VenFrontinoAdm(dtoSes).setVisible(true);
            }
        });
    }
}
