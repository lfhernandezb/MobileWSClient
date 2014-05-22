package cl.dsoft.carws.mobile.model;

import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import cl.dsoft.mobile.db.MantencionUsuario;
import cl.dsoft.mobile.db.MantencionUsuarioHecha;
import cl.dsoft.mobile.db.Recordatorio;
import cl.dsoft.mobile.db.Rendimiento;
import cl.dsoft.mobile.db.Reparacion;
import cl.dsoft.mobile.db.Vehiculo;

@Root
//If you want you can define the order in which the fields are written
//Optional
//@Order(elements = { "usuarios", "vehiculos", "mantencionUsuarios", "mantencionUsuarioHechas", "recordatorios", "rendimientos", "reparaciones" })
public class CarData {

	@ElementList
	protected ArrayList<cl.dsoft.mobile.db.MantencionUsuarioHecha> mantencionUsuarioHechas;
	@ElementList
	protected ArrayList<cl.dsoft.mobile.db.MantencionUsuario> mantencionUsuarios;
	@ElementList
	protected ArrayList<cl.dsoft.mobile.db.Recordatorio> recordatorios;
	@ElementList
	protected ArrayList<cl.dsoft.mobile.db.Rendimiento> rendimientos;
	@ElementList
	protected ArrayList<cl.dsoft.mobile.db.Reparacion> reparaciones;
	@ElementList
	protected ArrayList<cl.dsoft.mobile.db.Usuario> usuarios;
	@ElementList
	protected ArrayList<cl.dsoft.mobile.db.Vehiculo> vehiculos;
	
	public CarData() {

		this.usuarios = null;
		this.vehiculos = null;
		this.mantencionUsuarios = null;
		this.mantencionUsuarioHechas = null;
		this.recordatorios = null;
		this.rendimientos = null;
		this.reparaciones = null;
	}
	/*
	public CarData(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {

    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", "'" + fechaModificacion + "'"));
			
			this.mantencionUsuarios = cl.dsoft.sqlite.db.MantencionUsuario.seek(conn, listParameters, null, null, 0, 1);
			
			this.mantencionUsuarioHechas = cl.dsoft.sqlite.db.MantencionUsuarioHecha.seek(conn, listParameters, null, null, 0, 1);
			
			this.recordatorios = cl.dsoft.sqlite.db.Recordatorio.seek(conn, listParameters, null, null, 0, 1);
			
			this.rendimientos = cl.dsoft.sqlite.db.Rendimiento.seek(conn, listParameters, null, null, 0, 1);
			
			this.reparaciones = cl.dsoft.sqlite.db.Reparacion.seek(conn, listParameters, null, null, 0, 1);
			
			this.usuarios = cl.dsoft.sqlite.db.Usuario.seek(conn, listParameters, null, null, 0, 1);
			
			this.vehiculos = cl.dsoft.sqlite.db.Vehiculo.seek(conn, listParameters, null, null, 0, 1);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	*/
	/**
	 * @return the usuarios
	 */
	public ArrayList<cl.dsoft.mobile.db.Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(ArrayList<cl.dsoft.mobile.db.Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the vehiculos
	 */
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	/**
	 * @param vehiculos the vehiculos to set
	 */
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	/**
	 * @return the mantencionUsuarios
	 */
	public ArrayList<MantencionUsuario> getMantencionUsuarios() {
		return mantencionUsuarios;
	}

	/**
	 * @param mantencionUsuarios the mantencionUsuarios to set
	 */
	public void setMantencionUsuarios(ArrayList<MantencionUsuario> mantencionUsuarios) {
		this.mantencionUsuarios = mantencionUsuarios;
	}

	/**
	 * @return the mantencionUsuarioHechas
	 */
	public ArrayList<MantencionUsuarioHecha> getMantencionUsuarioHechas() {
		return mantencionUsuarioHechas;
	}

	/**
	 * @param mantencionUsuarioHechas the mantencionUsuarioHechas to set
	 */
	public void setMantencionUsuarioHechas(
			ArrayList<MantencionUsuarioHecha> mantencionUsuarioHechas) {
		this.mantencionUsuarioHechas = mantencionUsuarioHechas;
	}

	/**
	 * @return the recordatorios
	 */
	public ArrayList<Recordatorio> getRecordatorios() {
		return recordatorios;
	}

	/**
	 * @param recordatorios the recordatorios to set
	 */
	public void setRecordatorios(ArrayList<Recordatorio> recordatorios) {
		this.recordatorios = recordatorios;
	}

	/**
	 * @return the rendimientos
	 */
	public ArrayList<Rendimiento> getRendimientos() {
		return rendimientos;
	}

	/**
	 * @param rendimientos the rendimientos to set
	 */
	public void setRendimientos(ArrayList<Rendimiento> rendimientos) {
		this.rendimientos = rendimientos;
	}

	/**
	 * @return the reparaciones
	 */
	public ArrayList<Reparacion> getReparaciones() {
		return reparaciones;
	}

	/**
	 * @param reparaciones the reparaciones to set
	 */
	public void setReparaciones(ArrayList<Reparacion> reparaciones) {
		this.reparaciones = reparaciones;
	}
	
	public void save(java.sql.Connection conn) throws SQLException {
		
		for (cl.dsoft.mobile.db.Usuario usuario : this.getUsuarios()) {
			
			usuario.save(conn);
		}

		for (cl.dsoft.mobile.db.Vehiculo vehiculo : this.getVehiculos()) {
			
			vehiculo.save(conn);
		}
	
		for (cl.dsoft.mobile.db.MantencionUsuario mantencionUsuario : this.getMantencionUsuarios()) {
			
			mantencionUsuario.save(conn);
		}

		for (cl.dsoft.mobile.db.MantencionUsuarioHecha mantencionUsuarioHecha : this.getMantencionUsuarioHechas()) {
			
			mantencionUsuarioHecha.save(conn);
		}

		for (cl.dsoft.mobile.db.Recordatorio recordatorio : this.getRecordatorios()) {
			
			recordatorio.save(conn);
		}

		for (cl.dsoft.mobile.db.Rendimiento rendimiento : this.getRendimientos()) {
			
			rendimiento.save(conn);
		}

		for (cl.dsoft.mobile.db.Reparacion reparacion : this.getReparaciones()) {
			
			reparacion.save(conn);
		}
	}
}
