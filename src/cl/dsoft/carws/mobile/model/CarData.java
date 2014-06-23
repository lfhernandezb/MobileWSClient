package cl.dsoft.carws.mobile.model;

import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import cl.dsoft.mobile.db.CargaCombustible;
import cl.dsoft.mobile.db.Comuna;
import cl.dsoft.mobile.db.MantencionUsuario;
import cl.dsoft.mobile.db.MantencionUsuarioHecha;
import cl.dsoft.mobile.db.Pais;
import cl.dsoft.mobile.db.Recordatorio;
import cl.dsoft.mobile.db.CargaCombustible;
import cl.dsoft.mobile.db.Region;
import cl.dsoft.mobile.db.Reparacion;
import cl.dsoft.mobile.db.Usuario;
import cl.dsoft.mobile.db.Vehiculo;

@Root(name = "CarData")
@Order(elements={"paises", "regiones", "comunas", "usuarios", "vehiculos", "mantencionUsuarios", "mantencionUsuarioHechas", "recordatorios", "cargaCombustibles", "reparaciones"})
//If you want you can define the order in which the fields are written
//Optional
//@Order(elements = { "usuarios", "vehiculos", "mantencionUsuarios", "mantencionUsuarioHechas", "recordatorios", "rendimientos", "reparaciones" })
public class CarData {

	@ElementList(required=false)
	protected ArrayList<cl.dsoft.mobile.db.Pais> paises;
	@ElementList(required=false)
	protected ArrayList<cl.dsoft.mobile.db.Region> regiones;
	@ElementList(required=false)
	protected ArrayList<cl.dsoft.mobile.db.Comuna> comunas;
	@ElementList(required=false)
	protected ArrayList<cl.dsoft.mobile.db.MantencionUsuarioHecha> mantencionUsuarioHechas;
	@ElementList(required=false)
	protected ArrayList<cl.dsoft.mobile.db.MantencionUsuario> mantencionUsuarios;
	@ElementList(required=false)
	protected ArrayList<cl.dsoft.mobile.db.Recordatorio> recordatorios;
	@ElementList(required=false)
	protected ArrayList<cl.dsoft.mobile.db.CargaCombustible> cargaCombustibles;
	@ElementList(required=false)
	protected ArrayList<cl.dsoft.mobile.db.Reparacion> reparaciones;
	@ElementList(required=false)
	protected ArrayList<cl.dsoft.mobile.db.Usuario> usuarios;
	@ElementList(required=false)
	protected ArrayList<cl.dsoft.mobile.db.Vehiculo> vehiculos;
	
	public CarData() {

		this.paises = null;
		this.regiones = null;
		this.comunas = null;
		this.usuarios = null;
		this.vehiculos = null;
		this.mantencionUsuarios = null;
		this.mantencionUsuarioHechas = null;
		this.recordatorios = null;
		this.cargaCombustibles = null;
		this.reparaciones = null;
	}
	
	public CarData(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {

    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", "'" + fechaModificacion + "'"));
			
			//this.paises = Pais.seek(conn, listParameters, null, null, 0, 1);
			
			//this.regiones = Region.seek(conn, listParameters, null, null, 0, 1);
			
			//this.comunas = Comuna.seek(conn, listParameters, null, null, 0, 1);
			
			this.mantencionUsuarios = MantencionUsuario.seek(conn, listParameters, null, null, 0, 1);
			
			this.mantencionUsuarioHechas = MantencionUsuarioHecha.seek(conn, listParameters, null, null, 0, 1);
			
			this.recordatorios = Recordatorio.seek(conn, listParameters, null, null, 0, 1);
			
			this.cargaCombustibles = CargaCombustible.seek(conn, listParameters, null, null, 0, 1);
			
			this.reparaciones = Reparacion.seek(conn, listParameters, null, null, 0, 1);
			
			this.usuarios = Usuario.seek(conn, listParameters, null, null, 0, 1);
			
			this.vehiculos = Vehiculo.seek(conn, listParameters, null, null, 0, 1);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * @return the paises
	 */
	public ArrayList<cl.dsoft.mobile.db.Pais> getPaises() {
		return paises;
	}

	/**
	 * @param paises the paises to set
	 */
	public void setPaises(ArrayList<cl.dsoft.mobile.db.Pais> paises) {
		this.paises = paises;
	}

	/**
	 * @return the regiones
	 */
	public ArrayList<cl.dsoft.mobile.db.Region> getRegiones() {
		return regiones;
	}

	/**
	 * @param regiones the regiones to set
	 */
	public void setRegiones(ArrayList<cl.dsoft.mobile.db.Region> regiones) {
		this.regiones = regiones;
	}

	/**
	 * @return the comunas
	 */
	public ArrayList<cl.dsoft.mobile.db.Comuna> getComunas() {
		return comunas;
	}

	/**
	 * @param comunas the comunas to set
	 */
	public void setComunas(ArrayList<cl.dsoft.mobile.db.Comuna> comunas) {
		this.comunas = comunas;
	}

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
	public ArrayList<CargaCombustible> getCargaCombustibles() {
		return cargaCombustibles;
	}

	/**
	 * @param rendimientos the rendimientos to set
	 */
	public void setCargaCombustibles(ArrayList<CargaCombustible> cargaCombustibles) {
		this.cargaCombustibles = cargaCombustibles;
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
		
		for (cl.dsoft.mobile.db.Pais pais : this.getPaises()) {
			
			pais.save(conn);
		}

		for (cl.dsoft.mobile.db.Region region : this.getRegiones()) {
			
			region.save(conn);
		}

		for (cl.dsoft.mobile.db.Comuna comuna : this.getComunas()) {
			
			comuna.save(conn);
		}

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

		for (cl.dsoft.mobile.db.CargaCombustible rendimiento : this.getCargaCombustibles()) {
			
			rendimiento.save(conn);
		}

		for (cl.dsoft.mobile.db.Reparacion reparacion : this.getReparaciones()) {
			
			reparacion.save(conn);
		}
	}
}
