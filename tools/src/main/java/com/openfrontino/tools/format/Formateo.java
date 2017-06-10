/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openfrontino.tools.format;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author casc
 */
public class Formateo {
    public static String sepMil = ".";
	public static String sepDec = ",";

	/**
	 * da formato a numero por cantidad de decimales y devueldve un double
	 * 
	 * @param _valor
	 * @param _decimales
	 * @return
	 * @throws Exception
	 */
	public static double numeroFormateadoDlb(double _valor, int _decimales)
			throws Exception {
		try {
			_valor = new BigDecimal(String.valueOf(_valor)).setScale(_decimales,
					BigDecimal.ROUND_HALF_UP).doubleValue();
		} catch (Exception ex) {
			throw new Exception("GENERAL:" + "com.sy.formateo:"
					+ "numeroFormateado: Error en formateo de numeros");
		}
		return _valor;
	}

	/**
	 * Da formato a numero y lo devuelve formateado String con formato de numero
	 * 
	 * @param _valor
	 * @param _decimales
	 * @return
	 * @throws Exception
	 */
	public static String numeroFormateadoStr(double _valor, int _decimales)
			throws Exception {
		String dec = "";
		for (int i = 0; i < _decimales; i++) {
			dec += "0";
		}
		try {
			DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
			simbolos.setDecimalSeparator(sepDec.charAt(0));

			DecimalFormat formateador = new DecimalFormat("#,##0." + dec);
			dec = formateador.format(_valor);
		} catch (Exception ex) {
			throw new Exception("GENERAL:" + "com.sy.formateo:"
					+ "numeroFormateado: Error en formateo de numeros");
		}
		return dec;
	}

	public static double valor(String _val, boolean _formateado) {
		double valor = 0;
		String texto = _val.trim();
		try {
			if (_formateado) {
				// texto = _val.trim().replace(".", "").replace(",", ".");
				texto = _val.trim().replace(sepMil, "").replace(sepDec, ".");
			}
			if (!texto.equals("")) {
				valor = Double.parseDouble(texto);
			}
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		}
		return valor;
	}

	/**
	 * 
	 * @param _valor
	 * @param _decimales
	 * @return
	 * @throws Exception
	 */
	public static String numeroFormateadoStrJava(double _valor, int _decimales)
			throws Exception {
		String valor = String.valueOf(_valor);
		try {
			valor = new BigDecimal(String.valueOf(_valor)).setScale(_decimales,
					BigDecimal.ROUND_HALF_UP).toString();
		} catch (Exception ex) {
			throw new Exception("GENERAL:" + "com.sy.formateo:"
					+ "numeroFormateado: Error en formateo de numeros");
		}
		return valor;
	}

	/**
	 * 
	 * @param _valor
	 * @return
	 * @throws Exception
	 */
	public static double quitarFormatoDouble(String _valor){
		double result = 0;
		if (_valor == null || _valor.trim().equals("")) {
			return result;
		}
		try {
			String decimal = sepDec;
			String miles = sepMil;
			if (sepMil.equals(".")) {
				miles = "[.]";
			}
			if (sepDec.equals(".")) {
				decimal = "[.]";
			}
			result = Double.valueOf(_valor.replaceAll(miles, "").replace(
					decimal, "."));
		} catch (Exception ex) {
			return result;
		}
		return result;
	}

	/**
	 * 
	 * @param _valor
	 * @return
	 * @throws Exception
	 */
	public static String quitarFormatoString(String _valor) throws Exception {
		String result = "0";
		if (_valor == null || _valor.trim().equals("")) {
			return result;
		}
		try {
			String decimal = sepDec;
			String miles = sepMil;
			if (sepMil.equals(".")) {
				miles = "[.]";
			}
			if (sepDec.equals(".")) {
				decimal = "[.]";
			}
			result = _valor.replaceAll(miles, "").replace(decimal, ".");
		} catch (Exception ex) {
			throw new Exception("GENERAL:" + "com.sy.formateo:"
					+ "numeroFormateado: Error en formateo de numeros");
		}
		return result;
	}
}