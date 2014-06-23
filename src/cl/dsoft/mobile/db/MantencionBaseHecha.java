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
public class MantencionBaseHecha {
    @Element(name = "fechaModificacion")
    private String _fechaModificacion;
    @Element(name = "fecha", required = false)
    private String _fecha;
    @Element(name = "idMantencionBase")
    private Long _idMantencionBase;
    @Element(name = "borrado")
    private Boolean _borrado;
    @Element(name = "costo", required = false)
    private Integer _costo;
    @Element(name = "km", required = false)
    private Integer _km;
    @Element(name = "id")
    private Integer _id;

    private final static String _str_sql = 
        "    SELECT" +
        "    strftime('%Y-%m-%d %H:%M:%S', ma.fecha_modificacion) AS fecha_modificacion," +
        "    strftime('%Y-%m-%d %H:%M:%S', ma.fecha) AS fecha," +
        "    ma.id_mantencion_base AS id_mantencion_base," +
        "    ma.borrado AS borrado," +
        "    ma.costo AS costo," +
        "    ma.km AS km," +
        "    ma.id_mantencion_base_hecha AS id" +
        "    FROM mantencion_base_hecha ma";

    public MantencionBaseHecha() {
        _fechaModificacion = null;
        _fecha = null;
        _idMantencionBase = null;
        _borrado = null;
        _costo = null;
        _km = null;
        _id = null;

    }
    /**
     * @return the _fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _fecha
     */
    public String getFecha() {
        return _fecha;
    }
    /**
     * @return the _idMantencionBase
     */
    public Long getIdMantencionBase() {
        return _idMantencionBase;
    }
    /**
     * @return the _borrado
     */
    public Boolean getBorrado() {
        return _borrado;
    }
    /**
     * @return the _costo
     */
    public Integer getCosto() {
        return _costo;
    }
    /**
     * @return the _km
     */
    public Integer getKm() {
        return _km;
    }
    /**
     * @return the _id
     */
    public Integer getId() {
        return _id;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _fecha the _fecha to set
     */
    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }
    /**
     * @param _idMantencionBase the _idMantencionBase to set
     */
    public void setIdMantencionBase(Long _idMantencionBase) {
        this._idMantencionBase = _idMantencionBase;
    }
    /**
     * @param _borrado the _borrado to set
     */
    public void setBorrado(Boolean _borrado) {
        this._borrado = _borrado;
    }
    /**
     * @param _costo the _costo to set
     */
    public void setCosto(Integer _costo) {
        this._costo = _costo;
    }
    /**
     * @param _km the _km to set
     */
    public void setKm(Integer _km) {
        this._km = _km;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Integer _id) {
        this._id = _id;
    }

    public static MantencionBaseHecha fromRS(ResultSet p_rs) throws SQLException {
        MantencionBaseHecha ret = new MantencionBaseHecha();

        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setFecha(p_rs.getString("fecha"));
        ret.setIdMantencionBase(p_rs.getLong("id_mantencion_base"));
        ret.setBorrado(p_rs.getBoolean("borrado"));
        ret.setCosto(p_rs.getInt("costo"));
        ret.setKm(p_rs.getInt("km"));
        ret.setId(p_rs.getInt("id"));

        return ret;
    }

    public static MantencionBaseHecha getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        MantencionBaseHecha ret = null;
        
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

    public static MantencionBaseHecha getById(Connection p_conn, String p_id) throws Exception {
        return getByParameter(p_conn, "id_mantencion_base_hecha", p_id);
    }
    
    public static ArrayList<MantencionBaseHecha> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<MantencionBaseHecha> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<MantencionBaseHecha>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_mantencion_base_hecha")) {
                    array_clauses.add("ma.id_mantencion_base_hecha = " + p.getValue());
                }
                else if (p.getKey().equals("id_mantencion_base")) {
                    array_clauses.add("ma.id_mantencion_base = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("ma.fecha_modificacion > " + p.getValue());
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("ma.borrado = 0");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("ma.borrado = 1");
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
            "    UPDATE mantencion_base_hecha" +
            "    SET" +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
            "    fecha = " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
            "    borrado = " + (_borrado != null ? _borrado : "null") + "," +
            "    costo = " + (_costo != null ? _costo : "null") + "," +
            "    km = " + (_km != null ? _km : "null") +
            "    WHERE" +
            "    id_mantencion_base_hecha = " + Integer.toString(this._id);

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
            "    INSERT INTO mantencion_base_hecha" +
            "    (" +
            "    fecha_modificacion, " +
            "    fecha, " +
            "    id_mantencion_base, " +
            "    borrado, " +
            "    costo, " +
            "    km, " +
            "    id_mantencion_base_hecha)" +
            "    VALUES" +
            "    (" +
            "    " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
            "    " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
            "    " + (_idMantencionBase != null ? "'" + _idMantencionBase + "'" : "null") + "," +
            "    " + (_borrado != null ? "'" + _borrado + "'" : "null") + "," +
            "    " + (_costo != null ? "'" + _costo + "'" : "null") + "," +
            "    " + (_km != null ? "'" + _km + "'" : "null") + "," +
            "    " + (_id != null ? "'" + _id + "'" : "null") +
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
            "    DELETE FROM mantencion_base_hecha" +
            "    WHERE" +
            "    id_mantencion_base_hecha = " + Integer.toString(this._id);

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
        MantencionBaseHecha obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_mantencion_base_hecha = " + Integer.toString(this._id) +
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

                _fechaModificacion = obj.getFechaModificacion();
                _fecha = obj.getFecha();
                _idMantencionBase = obj.getIdMantencionBase();
                _borrado = obj.getBorrado();
                _costo = obj.getCosto();
                _km = obj.getKm();
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
            "    id_mantencion_base_hecha = " + Integer.toString(this._id) +
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
        return "MantencionBaseHecha [" +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _fecha = " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
	           "    _idMantencionBase = " + (_idMantencionBase != null ? _idMantencionBase : "null") + "," +
	           "    _borrado = " + (_borrado != null ? _borrado : "null") + "," +
	           "    _costo = " + (_costo != null ? _costo : "null") + "," +
	           "    _km = " + (_km != null ? _km : "null") + "," +
	           "    _id = " + (_id != null ? _id : "null") +
			   "]";
    }


    public String toJSON() {
        return "{\"MantencionBaseHecha\" : {" +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") + "," +
	           "    \"_fecha\" : " + (_fecha != null ? "\"" + _fecha + "\"" : "null") + "," +
	           "    \"_idMantencionBase\" : " + (_idMantencionBase != null ? _idMantencionBase : "null") + "," +
	           "    \"_borrado\" : " + (_borrado != null ? _borrado : "null") + "," +
	           "    \"_costo\" : " + (_costo != null ? _costo : "null") + "," +
	           "    \"_km\" : " + (_km != null ? _km : "null") + "," +
	           "    \"_id\" : " + (_id != null ? _id : "null") +
			   "}}";
    }


    public String toXML() {
        return "<MantencionBaseHecha>" +
	           "    <fechaModificacion" + (_fechaModificacion != null ? ">" + _fechaModificacion + "</fechaModificacion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fecha" + (_fecha != null ? ">" + _fecha + "</fecha>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idMantencionBase" + (_idMantencionBase != null ? ">" + _idMantencionBase + "</idMantencionBase>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <borrado" + (_borrado != null ? ">" + _borrado + "</borrado>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <costo" + (_costo != null ? ">" + _costo + "</costo>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <km" + (_km != null ? ">" + _km + "</km>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <id" + (_id != null ? ">" + _id + "</id>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</MantencionBaseHecha>";
    }


/*
    public static MantencionBaseHecha fromXMLNode(Node xmlNode) {
        MantencionBaseHecha ret = new MantencionBaseHecha();

        Element element = (Element) xmlNode;

        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setFecha(element.getElementsByTagName("fecha").item(0).getTextContent());
        ret.setIdMantencionBase(Long.decode(element.getElementsByTagName("id_mantencion_base").item(0).getTextContent()));
        ret.setBorrado(Boolean.decode(element.getElementsByTagName("borrado").item(0).getTextContent()));
        ret.setCosto(Integer.decode(element.getElementsByTagName("costo").item(0).getTextContent()));
        ret.setKm(Integer.decode(element.getElementsByTagName("km").item(0).getTextContent()));
        ret.setId(Integer.decode(element.getElementsByTagName("id_mantencion_base_hecha").item(0).getTextContent()));

        return ret;
    }
    */
}
