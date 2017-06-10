package com.openfrontino.tools.conection.querys;

import com.openfrontino.tools.format.Formateo;
import java.io.FileInputStream;
import java.sql.*;



public class Insert {
	public PreparedStatement _stm;

	private StringBuffer _tSql;
	private Connection _con = null;

	public Insert(Connection con) {
		_con = con;
	}

	public void sentencia(String tabla, String campos, String valores)
			throws Exception {

		try {

			if (!campos.equals("")) {
				campos = " (" + campos + ") ";
			}

			if (valores.length() > 7) {
				if (!valores.substring(0, 6).toLowerCase().equals("SELECT")) {
					valores = " VALUES (" + valores + ")";
				}
			} else {
				valores = " VALUES (" + valores.toLowerCase() + ")";
			}
			_tSql = new StringBuffer("INSERT INTO ").append(tabla).append(" ")
					.append(campos).append(valores);
			System.out.println(_tSql.toString());
			if (_stm != null) {
				_stm.close();
				_stm = null;
			}

			_stm = _con.prepareStatement(_tSql.toString());

		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.sentencia] " + ex.toString());

			throw new Exception("GENERAL:com.sy.sentencias.incluir:sentencia:"
					+ ex.getMessage());
		}
	}

	public void addParam(int pos, Object o) throws Exception {
		try {
			if (o == null) {
				throw new Exception(
						"GENERAL:com.sy.sentencias.incluir:addParam:"
								+ "Debe Seleccionar Metodos para Valores Nulos");

			}

			if (o instanceof Double) {
				Double v = (Double) o;

				_stm.setDouble(pos,
						Formateo.numeroFormateadoDlb(v.doubleValue(), 2));
			}
			if (o instanceof Date) {
				_stm.setDate(pos, (Date) o);
			}
			if (o instanceof String) {
				_stm.setString(pos, (String) o);
			}
			if (o instanceof Integer) {
				Integer v = (Integer) o;
				_stm.setInt(pos, v.intValue());
			}
			if (o instanceof Long) {
				Long v = (Long) o;
				_stm.setLong(pos, v.longValue());
			}
			if (o instanceof Boolean) {
				Boolean v = (Boolean) o;
				_stm.setBoolean(pos, v.booleanValue());
			}

		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.addparam] " + ex.toString());

			throw new Exception("GENERAL:com.sy.sentencias.incluir:addParam:"
					+ ex.getMessage());
		}

	}

	public void addParam(int pos, int v) throws Exception {
		try {
			_stm.setInt(pos, v);
		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.addparam] " + ex.toString());

			throw new Exception("GENERAL:com.sy.sentencias.incluir:addParam:"
					+ ex.getMessage());

		}
	}

	public void addParam(int pos, double v) throws Exception {
		try {
			_stm.setDouble(pos, Formateo.numeroFormateadoDlb(v, 2));
		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.addparam] " + ex.toString());

			throw new Exception("GENERAL:com.sy.sentencias.incluir:addParam:"
					+ ex.getMessage());

		}
	}
	
	public void addParamPoint(int pos, double v) throws Exception {
		try {
			_stm.setDouble(pos, v);
		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.addParamPoint] " + ex.toString());

			throw new Exception("GENERAL:com.sy.sentencias.incluir:addParamPoint:"
					+ ex.getMessage());

		}
	}

	public void addParam(int pos, long v) throws Exception {
		try {
			_stm.setLong(pos, v);
		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.addparam] " + ex.toString());

			throw new Exception("GENERAL:com.sy.sentencias.incluir:addParam:"
					+ ex.getMessage());

		}
	}

	public void addParamNull(int pos, int tipo) throws Exception {
		try {
			_stm.setNull(pos, tipo);
		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.addparam] " + ex.toString());

			throw new Exception(
					"GENERAL:com.sy.sentencias.incluir:addParamNull:"
							+ ex.getMessage());

		}
	}

	public void setBinaryStream(int pos, FileInputStream f, int lon)
			throws Exception {
		try {
			_stm.setBinaryStream(pos, f, lon);
		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.setBinaryStream] "
					+ ex.toString());

			throw new Exception(
					"GENERAL:com.sy.sentencias.incluir:setBinaryStream:"
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
			System.out.println("[com.sy.Incluir.ejecutar] " + ex.toString());
			r = false;
			throw new Exception("GENERAL:com.sy.sentencias.incluir:ejecutar:"
					+ ex.getMessage().replace(":", ""));

		}
		return r;
	}

	public void cerrar() throws Exception {
		try {
			if (_stm != null ) {
				/*Comentado por error de versiones parace ser que 
				 * versiones de postgres no soportan el metodo 
				 */
				//!_stm.isClosed()
				_stm.close();
			}
			_stm = null;

		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.close] " + ex.toString());

			throw new Exception("GENERAL:com.sy.sentencias.incluir:cerrar:"
					+ ex.getMessage());

		}

	}

}
