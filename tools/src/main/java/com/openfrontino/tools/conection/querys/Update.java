package com.openfrontino.tools.conection.querys;

import com.openfrontino.tools.format.Formateo;
import java.io.FileInputStream;
import java.sql.*;



public class Update {
	public PreparedStatement _stm;

	private String _tSql = "";

	private Connection _con = null;

	public Update(Connection con) {
		_con = con;

	}

	public void sentencia(String tabla, String campos, String condicion)
			throws Exception {

		try {
			Statement stm;
			stm = _con.createStatement();

			_tSql = "update " + tabla + " set "
			/*
			 * OJO le quiter el lower porque cambian el ID de series a
			 * minusculas y daba error de constraint + campos.toLowerCase();
			 */
			+ campos;
			if (!condicion.equals("")) {
				_tSql = _tSql + " where " + condicion.trim();
			}
			stm.close();
			System.out.println(_tSql.toString());

			if (_stm != null) {
				_stm.close();
				_stm = null;
			}

			_stm = _con.prepareStatement(_tSql);

		} catch (SQLException ex) {
			System.out.println("[com.sy.Modificarr.addparam] " + ex.toString());

			throw new Exception(
					"GENERAL:com.sy.sentencias.modificar:sentencia:"
							+ex.getMessage());

		}
	}

	public void addParam(int pos, Object o) throws Exception {
		try {
			if (o == null) {
				_stm.setString(pos, "");
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
			System.out.println("[com.sy.Modificarr.addparam] " + ex.toString());
			throw new Exception("GENERAL:com.sy.sentencias.modificar:addParam:"
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

	public void addParamNull(int pos, int tipo) throws Exception {
		try {
			_stm.setNull(pos, tipo);
		} catch (SQLException ex) {
			System.out.println("[com.sy.Modificarr.addparam] " + ex.toString());

			throw new Exception(
					"GENERAL:com.sy.sentencias.modificar:addParamNull:"
							+ ex.getMessage());

		}
	}

	public void addParam(int pos, int v) throws Exception {
		try {
			_stm.setInt(pos, v);
		} catch (SQLException ex) {
			System.out.println("[com.sy.Modificarr.addparam] " + ex.toString());
			throw new Exception("GENERAL:com.sy.sentencias.modificar:addParam:"
					+ ex.getMessage());

		}
	}

	public void addParam(int pos, long v) throws Exception {
		try {
			_stm.setLong(pos, v);
		} catch (SQLException ex) {
			System.out.println("[com.sy.Modificarr.addparam] " + ex.toString());

			throw new Exception("GENERAL:com.sy.sentencias.modificar:addParam:"
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

			System.out.println("[com.sy.Modificar.ejecutar] " + ex.toString());
			r = false;
			throw new Exception("GENERAL:com.sy.sentencias.modificar:k:"
					+ ex.getMessage().replace(":",""));

		}
		return r;
	}

	public void setBinaryStream(int pos, FileInputStream f, int lon)
			throws Exception {
		try {
			_stm.setBinaryStream(pos, f, lon);
		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.setBinaryStream] "
					+ ex.toString());

			throw new Exception(
					"GENERAL:com.sy.sentencias.modificar:setBinaryStream:"
							+ ex.getMessage());

		}
	}

	public void setBytes(int pos, byte[] bytes) throws Exception {
		try {
			_stm.setBytes(pos, bytes);
		} catch (SQLException ex) {
			System.out.println("[com.sy.Incluir.setBytes] " + ex.toString());

			throw new Exception("GENERAL:com.sy.sentencias.modificar:setBytes:"
					+ ex.getMessage());

		}
	}

	public boolean ejecutarUpdate(boolean hacerCommit, String _query)
			throws Exception {
		boolean r = true;
		try {

			Statement stm;
			stm = _con.createStatement();
			_tSql = _query;
			stm.close();
			// System.out.println(_tSql.toString());
			if (_stm != null) {
				_stm.close();
				_stm = null;
			}
			_stm = _con.prepareStatement(_tSql);
			_stm.executeUpdate();
			if (hacerCommit) {
				_con.commit();
			}
		} catch (SQLException ex) {
			System.out.println("[com.sy.Modificar.ejecutar] " + ex.toString());
			r = false;
			throw new Exception(
					"GENERAL:com.sy.sentencias.modificar:ejecutarUpdate:"
							+ ex.getMessage().replace(":", ""));

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
			System.out.println("[com.sy.Modificar.close] " + ex.toString());
			throw new Exception("GENERAL:com.sy.sentencias.modificar:cerrar:"
					+ ex.getMessage());

		}

	}
}
