package com.openfrontino.tools.conection.querys;

import java.sql.*;

public class Select {
	private StringBuffer _tSql;
	public PreparedStatement _stm;
	private Connection _con = null;

	private String sentencia;

	public Select(Connection con) {
		_con = con;

	}

	public void sentencia(String campos, String tablas, String condicion,
			String grupo, String orden) throws Exception {

		try {

			StringBuffer _cond = new StringBuffer();

			if (!condicion.equals("")) {
				_cond.append(" WHERE ").append(condicion);
			}

			condicion = _cond.toString();

			if (!grupo.trim().equals("")) {
				grupo = new StringBuffer(" GROUP BY ").append(grupo).toString();
			}
			if (!orden.trim().equals("")) {
				orden = new StringBuffer(" ORDER BY ").append(orden).toString();
			}

			_tSql = new StringBuffer("SELECT ").append(campos).append(" FROM ")
					.append(tablas).append(" ").append(condicion).append(grupo)
					.append(orden);

			if (_stm != null) {
				_stm.close();
				_stm = null;
			}
			System.out.println("----------------------");
			System.out.println(_tSql.toString()); // /Imprime la sentencia
			System.out.println("");
			setSentencia(_tSql.toString());
		} catch (SQLException ex) {
			throw new Exception("GENERAL:com.sy.sentencias.listar:sentencia:"
					+ ex.toString());
		} finally {

		}
	}

	public ResultSet ejecutar() throws Exception {
		ResultSet r = null;
		try {
			r = _stm.executeQuery();
		} catch (SQLException ex) {
			r = null;
			String[] cadError = ex.getMessage().split(":");
			if (cadError[0].equalsIgnoreCase("GENERAL")) {
				throw new Exception("GENERAL:" + cadError[1] + ":"
						+ cadError[2] + ":" + cadError[3]);
			} else {
				throw new Exception("GENERAL:" + "com.sy.sentencias.listar:"
						+ "ejecutar:" + ex.getMessage().replace(":", ""));
			}
		}
		return r;
	}

	public void cerrar() throws Exception {

		try {
			if (_stm != null ) {
				/*Toco comentarlo porque por la version
				 * de postgres este metodo da error
				 */
				//if(!_stm.isClosed()){
				_stm.close();
				//}
			}
			_stm = null;} catch (SQLException ex) {
			System.out.println("[com.sy.sentencias.Listar.close] "
					+ ex.toString());
			throw new Exception("GENERAL:com.sy.sentencias.listar:cerrar:"
					+ ex.toString());
		} catch (Exception ex1) {
			System.out.println("[com.sy.sentencias.Listar.close] "
					+ ex1.toString());
			throw new Exception("GENERAL:com.sy.sentencias.listar:cerrar:"
					+ ex1.toString());
		}

	}

	public String getSentencia() {
		return sentencia;
	}

	public void setSentencia(String sentencia) throws Exception {
		this.sentencia = sentencia;
		try {
			_stm = _con.prepareStatement(this.sentencia);
		} catch (SQLException ex) {
			String[] cadError = ex.getMessage().split(":");
			if (cadError[0].equalsIgnoreCase("GENERAL")) {
				throw new Exception("GENERAL:" + cadError[1] + ":"
						+ cadError[2] + ":" + cadError[3]);
			} else {
				throw new Exception("GENERAL:" + "com.sy.sentencias.listar:"
						+ "ejecutar:" + ex.getMessage().replace(":", ""));
			}
		}
	}

}
