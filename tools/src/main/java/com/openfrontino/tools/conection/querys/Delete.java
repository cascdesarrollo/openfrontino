package com.openfrontino.tools.conection.querys;

import java.sql.*;


public class Delete {
	private Connection _con = null;
	private StringBuffer _tSql;
	private PreparedStatement _stm;

	public Delete(Connection con) {
		_con = con;

	}

	public void procesar(String tabla, String condicion) {
		try {
			/*
			 * Comente porq creo q era para la parte de seguridad
			 * 
			 * // Connection querytabla; Connection pasele; ResultSet rtabla;
			 * ResultSet rdata;
			 * 
			 * ResultSetMetaData mdata; //Control cc = new Control(); //Usuario
			 * usu = new Usuario(); pasele = _con; Listar sele = new
			 * Listar(pasele); Listar seletwo = new Listar(pasele); Incluir inc
			 * = new Incluir(_con); sele.sentencia("*", tabla, "", "", "");
			 * seletwo.sentencia("*", tabla, condicion, "", ""); rdata =
			 * seletwo.ejecutar(); rtabla = sele.ejecutar(); mdata =
			 * rtabla.getMetaData(); String columnName = "";
			 * 
			 * int numColumns = mdata.getColumnCount(); String usux = gusu;
			 * String empx = gemp; System.out.println(usux);
			 * System.out.println(empx);
			 * 
			 * while (rdata.next()) {
			 * 
			 * for (int i = 1; i < numColumns + 1; i++) { columnName =
			 * mdata.getColumnName(i);
			 * System.out.println(rdata.getString(columnName));
			 * inc.sentencia("cysseg09m", "codemp,logusu,tabbit,valbit,cambit",
			 * "?,?,?,?,?");
			 * 
			 * inc.addParam(1, empx); inc.addParam(2, usux); inc.addParam(3,
			 * tabla); inc.addParam(4, rdata.getString(columnName));
			 * inc.addParam(5, columnName);
			 * 
			 * inc.ejecutar(false); }
			 * 
			 * }
			 * 
			 * rdata.close(); rtabla.close(); seletwo.cerrar(); sele.cerrar();
			 * inc.cerrar();
			 */

		} catch (Exception e) {
			System.out.println("IOException " + e);
		}
	}

	public void sentencia(String tabla, String condicion) throws Exception {

		try {
			_tSql = new StringBuffer("delete from ").append(tabla);
			if (!condicion.trim().equals("")) {
				_tSql.append(" where ").append(condicion.trim());
			}

			System.out.println(_tSql.toString()); // /Imprime la sentencia

			if (_stm != null) {
				_stm.close();
				_stm = null;
			}
			_stm = _con.prepareStatement(_tSql.toString());

		} catch (SQLException ex) {
			System.out.println("[com.sy.sentencias.Eliminar.sentencia] "
					+ ex.toString());
			throw new Exception("GENERAL:com.openfrontino.tools.conection.querys:sentencia:"
					+ ex.getMessage());

		}

	}

	public boolean ejecutar(boolean hacerCommit) throws Exception {
		boolean r = true;
		try {
			_stm.executeUpdate();
			if (hacerCommit) {
				_con.commit();
			}
		} catch (SQLException ex) {
			System.out.println("[com.sy.sentencias.Eliminar.ejecutar] "
					+ ex.toString());
			r = false;
			throw new Exception("GENERAL:com.openfrontino.tools.conection.querys:ejecutar:"
					+ ex.getMessage());

		}
		return r;
	}

	public void cerrar() throws Exception {
		try {
			if (_stm != null) {
				/*Comentado por error de versiones parace ser que 
				 * versiones de postgres no soportan el metodo 
				 */
				//!_stm.isClosed()
				_stm.close();
			}
			_stm = null;

		} catch (SQLException ex) {
			System.out.println("[com.sy.sentencias.Listar.cerrar] "
					+ ex.toString());

			throw new Exception("GENERAL:com.openfrontino.tools.conection.querys:cerrar:"
					+ ex.getMessage());

		}

	}

}
