/**
 * 
 */
package cl.dsoft.mobile.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author petete-ntbk
 *
 */
@Root
public class MantencionBase {
    @Element(name = "diasEntreMantenciones", required = false)
    private Integer _diasEntreMantenciones;
    @Element(name = "tipoTransmision")
    private String _tipoTransmision;
    @Element(name = "codigoMotor")
    private String _codigoMotor;
    @Element(name = "kmEntreMantenciones", required = false)
    private Integer _kmEntreMantenciones;
    @Element(name = "dependeKm", required = false)
    private Boolean _dependeKm;
    @Element(name = "accion", required = false)
    private String _accion;
    @Element(name = "url", required = false)
    private String _url;
    @Element(name = "descripcionItem", required = false)
    private String _descripcionItem;
    @Element(name = "fechaModificacion", required = false)
    private String _fechaModificacion;
    @Element(name = "idModeloAnio")
    private Long _idModeloAnio;
    @Element(name = "id")
    private Long _id;
    @Element(name = "item")
    private String _item;
    @Element(name = "tipoTraccion")
    private String _tipoTraccion;
    @Element(name = "beneficios", required = false)
    private String _beneficios;

    private final static String _str_sql = 
        "    SELECT" +
        "    ma.dias_entre_mantenciones AS dias_entre_mantenciones," +
        "    ma.tipo_transmision AS tipo_transmision," +
        "    ma.codigo_motor AS codigo_motor," +
        "    ma.km_entre_mantenciones AS km_entre_mantenciones," +
        "    ma.depende_km AS depende_km," +
        "    ma.accion AS accion," +
        "    ma.url AS url," +
        "    ma.descripcion_item AS descripcion_item," +
        "    strftime(ma.fecha_modificacion, '%Y-%m-%d %H:%M:%S') AS fecha_modificacion," +
        "    ma.id_modelo_anio AS id_modelo_anio," +
        "    ma.id_mantencion_base AS id," +
        "    ma.item AS item," +
        "    ma.tipo_traccion AS tipo_traccion," +
        "    ma.beneficios AS beneficios" +
        "    FROM mantencion_base ma";

    public MantencionBase() {
        _diasEntreMantenciones = null;
        _tipoTransmision = null;
        _codigoMotor = null;
        _kmEntreMantenciones = null;
        _dependeKm = null;
        _accion = null;
        _url = null;
        _descripcionItem = null;
        _fechaModificacion = null;
        _idModeloAnio = null;
        _id = null;
        _item = null;
        _tipoTraccion = null;
        _beneficios = null;

    }
    /**
     * @return the _diasEntreMantenciones
     */
    public Integer getDiasEntreMantenciones() {
        return _diasEntreMantenciones;
    }
    /**
     * @return the _tipoTransmision
     */
    public String getTipoTransmision() {
        return _tipoTransmision;
    }
    /**
     * @return the _codigoMotor
     */
    public String getCodigoMotor() {
        return _codigoMotor;
    }
    /**
     * @return the _kmEntreMantenciones
     */
    public Integer getKmEntreMantenciones() {
        return _kmEntreMantenciones;
    }
    /**
     * @return the _dependeKm
     */
    public Boolean getDependeKm() {
        return _dependeKm;
    }
    /**
     * @return the _accion
     */
    public String getAccion() {
        return _accion;
    }
    /**
     * @return the _url
     */
    public String getUrl() {
        return _url;
    }
    /**
     * @return the _descripcionItem
     */
    public String getDescripcionItem() {
        return _descripcionItem;
    }
    /**
     * @return the _fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _idModeloAnio
     */
    public Long getIdModeloAnio() {
        return _idModeloAnio;
    }
    /**
     * @return the _id
     */
    public Long getId() {
        return _id;
    }
    /**
     * @return the _item
     */
    public String getItem() {
        return _item;
    }
    /**
     * @return the _tipoTraccion
     */
    public String getTipoTraccion() {
        return _tipoTraccion;
    }
    /**
     * @return the _beneficios
     */
    public String getBeneficios() {
        return _beneficios;
    }
    /**
     * @param _diasEntreMantenciones the _diasEntreMantenciones to set
     */
    public void setDiasEntreMantenciones(Integer _diasEntreMantenciones) {
        this._diasEntreMantenciones = _diasEntreMantenciones;
    }
    /**
     * @param _tipoTransmision the _tipoTransmision to set
     */
    public void setTipoTransmision(String _tipoTransmision) {
        this._tipoTransmision = _tipoTransmision;
    }
    /**
     * @param _codigoMotor the _codigoMotor to set
     */
    public void setCodigoMotor(String _codigoMotor) {
        this._codigoMotor = _codigoMotor;
    }
    /**
     * @param _kmEntreMantenciones the _kmEntreMantenciones to set
     */
    public void setKmEntreMantenciones(Integer _kmEntreMantenciones) {
        this._kmEntreMantenciones = _kmEntreMantenciones;
    }
    /**
     * @param _dependeKm the _dependeKm to set
     */
    public void setDependeKm(Boolean _dependeKm) {
        this._dependeKm = _dependeKm;
    }
    /**
     * @param _accion the _accion to set
     */
    public void setAccion(String _accion) {
        this._accion = _accion;
    }
    /**
     * @param _url the _url to set
     */
    public void setUrl(String _url) {
        this._url = _url;
    }
    /**
     * @param _descripcionItem the _descripcionItem to set
     */
    public void setDescripcionItem(String _descripcionItem) {
        this._descripcionItem = _descripcionItem;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _idModeloAnio the _idModeloAnio to set
     */
    public void setIdModeloAnio(Long _idModeloAnio) {
        this._idModeloAnio = _idModeloAnio;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Long _id) {
        this._id = _id;
    }
    /**
     * @param _item the _item to set
     */
    public void setItem(String _item) {
        this._item = _item;
    }
    /**
     * @param _tipoTraccion the _tipoTraccion to set
     */
    public void setTipoTraccion(String _tipoTraccion) {
        this._tipoTraccion = _tipoTraccion;
    }
    /**
     * @param _beneficios the _beneficios to set
     */
    public void setBeneficios(String _beneficios) {
        this._beneficios = _beneficios;
    }

    public static MantencionBase fromRS(ResultSet p_rs) throws SQLException {
        MantencionBase ret = new MantencionBase();

        ret.setDiasEntreMantenciones(p_rs.getInt("dias_entre_mantenciones"));
        ret.setTipoTransmision(p_rs.getString("tipo_transmision"));
        ret.setCodigoMotor(p_rs.getString("codigo_motor"));
        ret.setKmEntreMantenciones(p_rs.getInt("km_entre_mantenciones"));
        ret.setDependeKm(p_rs.getBoolean("depende_km"));
        ret.setAccion(p_rs.getString("accion"));
        ret.setUrl(p_rs.getString("url"));
        ret.setDescripcionItem(p_rs.getString("descripcion_item"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setIdModeloAnio(p_rs.getLong("id_modelo_anio"));
        ret.setId(p_rs.getLong("id"));
        ret.setItem(p_rs.getString("item"));
        ret.setTipoTraccion(p_rs.getString("tipo_traccion"));
        ret.setBeneficios(p_rs.getString("beneficios"));

        return ret;
    }

    public static MantencionBase getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        MantencionBase ret = null;
        
        String str_sql = _str_sql +
            "  WHERE ma." + p_key + " = " + p_value +
            "  LIMIT 0, 1";
        
        //System.out.println(str_sql);
        
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = p_conn.createStatement();
            //System.out.println("stmt = p_conn.createStatement() ok");
            rs = stmt.executeQuery(str_sql);
            //System.out.println("rs = stmt.executeQuery(str_sql) ok");

            // Now do something with the ResultSet ....
            
            if (rs.next()) {
                //System.out.println("rs.next() ok");
                ret = fromRS(rs);
                //System.out.println("fromRS(rs) ok");
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        
        
        return ret;        
    }

    public static MantencionBase getById(Connection p_conn, String p_id) throws Exception {
        return getByParameter(p_conn, "id_mantencion_base", p_id);
    }
    
    public static ArrayList<MantencionBase> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<MantencionBase> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<MantencionBase>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_mantencion_base")) {
                    array_clauses.add("ma.id_mantencion_base = " + p.getValue());
                }
                else if (p.getKey().equals("id_modelo_anio")) {
                    array_clauses.add("ma.id_modelo_anio = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("ma.fecha_modificacion > '" + p.getValue() + "'");
                }
                else {
                    throw new Exception("Parametro no soportado: " + p.getKey());
                }
            }
                                
            boolean bFirstTime = false;
            
            for(String clause : array_clauses) {
                if (!bFirstTime) {
                     bFirstTime = true;
                     str_sql += " WHERE ";
                }
                else {
                     str_sql += " AND ";
                }
                str_sql += clause;
            }
            
            if (p_order != null && p_direction != null) {
                str_sql += " ORDER BY " + p_order + " " + p_direction;
            }
            
            if (p_offset != -1 && p_limit != -1) {
                str_sql += "  LIMIT " +  Integer.toString(p_offset) + ", " + Integer.toString(p_limit);
            }
            
            //echo "<br>" . str_sql . "<br>";
        
            stmt = p_conn.createStatement();
            
            rs = stmt.executeQuery(str_sql);
            
            while (rs.next()) {
                ret.add(fromRS(rs));
            }
            /*
            if (ret.size() == 0) {
                ret = null;
            }
            */
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        catch (Exception ex) {
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        

        return ret;
    }

    public int update(Connection p_conn) throws SQLException {

        int ret = -1;
        Statement stmt = null;

        String str_sql =
            "    UPDATE mantencion_base" +
            "    SET" +
            "    dias_entre_mantenciones = " + (_diasEntreMantenciones != null ? _diasEntreMantenciones : "null") + "," +
            "    tipo_transmision = " + (_tipoTransmision != null ? "'" + _tipoTransmision + "'" : "null") + "," +
            "    codigo_motor = " + (_codigoMotor != null ? "'" + _codigoMotor + "'" : "null") + "," +
            "    km_entre_mantenciones = " + (_kmEntreMantenciones != null ? _kmEntreMantenciones : "null") + "," +
            "    depende_km = " + (_dependeKm != null ? _dependeKm : "null") + "," +
            "    accion = " + (_accion != null ? "'" + _accion + "'" : "null") + "," +
            "    url = " + (_url != null ? "'" + _url + "'" : "null") + "," +
            "    descripcion_item = " + (_descripcionItem != null ? "'" + _descripcionItem + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
            "    item = " + (_item != null ? "'" + _item + "'" : "null") + "," +
            "    tipo_traccion = " + (_tipoTraccion != null ? "'" + _tipoTraccion + "'" : "null") + "," +
            "    beneficios = " + (_beneficios != null ? "'" + _beneficios + "'" : "null") +
            "    WHERE" +
            "    id_mantencion_base = " + Long.toString(this._id);

        try {
            stmt = p_conn.createStatement();

            ret = stmt.executeUpdate(str_sql);

            load(p_conn);

            /*
            if (stmt.executeUpdate(str_sql) < 1) {
                throw new Exception("No hubo filas afectadas");
            }
            */
            
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }
        
        return ret;
    }
    
    public int insert(Connection p_conn) throws SQLException {
        
        int ret = -1;
        Statement stmt = null;
        ResultSet rs = null;

        String str_sql =
            "    INSERT INTO mantencion_base" +
            "    (" +
            "    dias_entre_mantenciones, " +
            "    tipo_transmision, " +
            "    codigo_motor, " +
            "    km_entre_mantenciones, " +
            "    depende_km, " +
            "    accion, " +
            "    url, " +
            "    descripcion_item, " +
            "    id_modelo_anio, " +
            "    id_mantencion_base, " +
            "    item, " +
            "    tipo_traccion, " +
            "    beneficios)" +
            "    VALUES" +
            "    (" +
            "    " + (_diasEntreMantenciones != null ? "'" + _diasEntreMantenciones + "'" : "null") + "," +
            "    " + (_tipoTransmision != null ? "'" + _tipoTransmision + "'" : "null") + "," +
            "    " + (_codigoMotor != null ? "'" + _codigoMotor + "'" : "null") + "," +
            "    " + (_kmEntreMantenciones != null ? "'" + _kmEntreMantenciones + "'" : "null") + "," +
            "    " + (_dependeKm != null ? "'" + _dependeKm + "'" : "null") + "," +
            "    " + (_accion != null ? "'" + _accion + "'" : "null") + "," +
            "    " + (_url != null ? "'" + _url + "'" : "null") + "," +
            "    " + (_descripcionItem != null ? "'" + _descripcionItem + "'" : "null") + "," +
            "    " + (_idModeloAnio != null ? "'" + _idModeloAnio + "'" : "null") + "," +
            "    " + (_id != null ? "'" + _id + "'" : "null") + "," +
            "    " + (_item != null ? "'" + _item + "'" : "null") + "," +
            "    " + (_tipoTraccion != null ? "'" + _tipoTraccion + "'" : "null") + "," +
            "    " + (_beneficios != null ? "'" + _beneficios + "'" : "null") +
            "    )";
        
        try {
            stmt = p_conn.createStatement();
            
            ret = stmt.executeUpdate(str_sql);

            load(p_conn);

        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }
        
        return ret;
    }

    public int delete(Connection p_conn) throws SQLException {

        int ret = -1;
        Statement stmt = null;

        String str_sql =
            "    DELETE FROM mantencion_base" +
            "    WHERE" +
            "    id_mantencion_base = " + Long.toString(this._id);

        try {
            stmt = p_conn.createStatement();
            
            ret = stmt.executeUpdate(str_sql);
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }
        
        return ret;
    }

    public void load(Connection p_conn) throws SQLException {
        MantencionBase obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_mantencion_base = " + Long.toString(this._id) +
            "    LIMIT 0, 1";
        
        //System.out.println(str_sql);
        
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = p_conn.createStatement();
            //System.out.println("stmt = p_conn.createStatement() ok");
            rs = stmt.executeQuery(str_sql);
            //System.out.println("rs = stmt.executeQuery(str_sql) ok");

            // Now do something with the ResultSet ....
            
            if (rs.next()) {
                //System.out.println("rs.next() ok");
                obj = fromRS(rs);
                //System.out.println("fromRS(rs) ok");

                _diasEntreMantenciones = obj.getDiasEntreMantenciones();
                _tipoTransmision = obj.getTipoTransmision();
                _codigoMotor = obj.getCodigoMotor();
                _kmEntreMantenciones = obj.getKmEntreMantenciones();
                _dependeKm = obj.getDependeKm();
                _accion = obj.getAccion();
                _url = obj.getUrl();
                _descripcionItem = obj.getDescripcionItem();
                _fechaModificacion = obj.getFechaModificacion();
                _idModeloAnio = obj.getIdModeloAnio();
                _item = obj.getItem();
                _tipoTraccion = obj.getTipoTraccion();
                _beneficios = obj.getBeneficios();
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        
        
    }

    public void save(Connection p_conn) throws SQLException {
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_mantencion_base = " + Long.toString(this._id) +
            "    LIMIT 0, 1";
        
        //System.out.println(str_sql);
        
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        Boolean exists = false;
        
        try {
            stmt = p_conn.createStatement();
            //System.out.println("stmt = p_conn.createStatement() ok");
            rs = stmt.executeQuery(str_sql);
            //System.out.println("rs = stmt.executeQuery(str_sql) ok");

            // Now do something with the ResultSet ....

            if (rs.next()) {
                // registro existe
                exists = true;
            }

            rs.close();
            stmt.close();

            if (exists) {
            	// update
            	update(p_conn);
            }
            else {
            	// insert
            	insert(p_conn);
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        
        
    }

@Override
    public String toString() {
        return "MantencionBase [" +
	           "    _diasEntreMantenciones = " + (_diasEntreMantenciones != null ? _diasEntreMantenciones : "null") + "," +
	           "    _tipoTransmision = " + (_tipoTransmision != null ? "'" + _tipoTransmision + "'" : "null") + "," +
	           "    _codigoMotor = " + (_codigoMotor != null ? "'" + _codigoMotor + "'" : "null") + "," +
	           "    _kmEntreMantenciones = " + (_kmEntreMantenciones != null ? _kmEntreMantenciones : "null") + "," +
	           "    _dependeKm = " + (_dependeKm != null ? _dependeKm : "null") + "," +
	           "    _accion = " + (_accion != null ? "'" + _accion + "'" : "null") + "," +
	           "    _url = " + (_url != null ? "'" + _url + "'" : "null") + "," +
	           "    _descripcionItem = " + (_descripcionItem != null ? "'" + _descripcionItem + "'" : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _idModeloAnio = " + (_idModeloAnio != null ? _idModeloAnio : "null") + "," +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _item = " + (_item != null ? "'" + _item + "'" : "null") + "," +
	           "    _tipoTraccion = " + (_tipoTraccion != null ? "'" + _tipoTraccion + "'" : "null") + "," +
	           "    _beneficios = " + (_beneficios != null ? "'" + _beneficios + "'" : "null") +
			   "]";
    }


    public String toJSON() {
        return "{\"MantencionBase\" : {" +
	           "    \"_diasEntreMantenciones\" : " + (_diasEntreMantenciones != null ? _diasEntreMantenciones : "null") + "," +
	           "    \"_tipo_transmision\" : " + (_tipoTransmision != null ? "\"" + _tipoTransmision + "\"" : "null") + "," +
	           "    \"_codigo_motor\" : " + (_codigoMotor != null ? "\"" + _codigoMotor + "\"" : "null") + "," +
	           "    \"_kmEntreMantenciones\" : " + (_kmEntreMantenciones != null ? _kmEntreMantenciones : "null") + "," +
	           "    \"_dependeKm\" : " + (_dependeKm != null ? _dependeKm : "null") + "," +
	           "    \"_accion\" : " + (_accion != null ? "\"" + _accion + "\"" : "null") + "," +
	           "    \"_url\" : " + (_url != null ? "\"" + _url + "\"" : "null") + "," +
	           "    \"_descripcion_item\" : " + (_descripcionItem != null ? "\"" + _descripcionItem + "\"" : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") + "," +
	           "    \"_idModeloAnio\" : " + (_idModeloAnio != null ? _idModeloAnio : "null") + "," +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_item\" : " + (_item != null ? "\"" + _item + "\"" : "null") + "," +
	           "    \"_tipo_traccion\" : " + (_tipoTraccion != null ? "\"" + _tipoTraccion + "\"" : "null") + "," +
	           "    \"_beneficios\" : " + (_beneficios != null ? "\"" + _beneficios + "\"" : "null") +
			   "}}";
    }


    public String toXML() {
        return "<MantencionBase>" +
	           "    <diasEntreMantenciones" + (_diasEntreMantenciones != null ? ">" + _diasEntreMantenciones + "</diasEntreMantenciones>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <tipoTransmision" + (_tipoTransmision != null ? ">" + _tipoTransmision + "</tipoTransmision>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <codigoMotor" + (_codigoMotor != null ? ">" + _codigoMotor + "</codigoMotor>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <kmEntreMantenciones" + (_kmEntreMantenciones != null ? ">" + _kmEntreMantenciones + "</kmEntreMantenciones>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <dependeKm" + (_dependeKm != null ? ">" + _dependeKm + "</dependeKm>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <accion" + (_accion != null ? ">" + _accion + "</accion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <url" + (_url != null ? ">" + _url + "</url>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <descripcionItem" + (_descripcionItem != null ? ">" + _descripcionItem + "</descripcionItem>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaModificacion" + (_fechaModificacion != null ? ">" + _fechaModificacion + "</fechaModificacion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idModeloAnio" + (_idModeloAnio != null ? ">" + _idModeloAnio + "</idModeloAnio>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <id" + (_id != null ? ">" + _id + "</id>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <item" + (_item != null ? ">" + _item + "</item>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <tipoTraccion" + (_tipoTraccion != null ? ">" + _tipoTraccion + "</tipoTraccion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <beneficios" + (_beneficios != null ? ">" + _beneficios + "</beneficios>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</MantencionBase>";
    }


/*
    public static MantencionBase fromXMLNode(Node xmlNode) {
        MantencionBase ret = new MantencionBase();

        Element element = (Element) xmlNode;

        ret.setDiasEntreMantenciones(Integer.decode(element.getElementsByTagName("dias_entre_mantenciones").item(0).getTextContent()));
        ret.setTipoTransmision(element.getElementsByTagName("tipo_transmision").item(0).getTextContent());
        ret.setCodigoMotor(element.getElementsByTagName("codigo_motor").item(0).getTextContent());
        ret.setKmEntreMantenciones(Integer.decode(element.getElementsByTagName("km_entre_mantenciones").item(0).getTextContent()));
        ret.setDependeKm(Boolean.decode(element.getElementsByTagName("depende_km").item(0).getTextContent()));
        ret.setAccion(element.getElementsByTagName("accion").item(0).getTextContent());
        ret.setUrl(element.getElementsByTagName("url").item(0).getTextContent());
        ret.setDescripcionItem(element.getElementsByTagName("descripcion_item").item(0).getTextContent());
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setIdModeloAnio(Long.decode(element.getElementsByTagName("id_modelo_anio").item(0).getTextContent()));
        ret.setId(Long.decode(element.getElementsByTagName("id_mantencion_base").item(0).getTextContent()));
        ret.setItem(element.getElementsByTagName("item").item(0).getTextContent());
        ret.setTipoTraccion(element.getElementsByTagName("tipo_traccion").item(0).getTextContent());
        ret.setBeneficios(element.getElementsByTagName("beneficios").item(0).getTextContent());

        return ret;
    }
    */
}
