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
public class Estilo {
    @Element(name = "puertas")
    private Byte _puertas;
    @Element(name = "rendimientoCarretera", required = false)
    private Short _rendimientoCarretera;
    @Element(name = "id")
    private Long _id;
    @Element(name = "nombre")
    private String _nombre;
    @Element(name = "traccion")
    private String _traccion;
    @Element(name = "idModeloAnio")
    private Long _idModeloAnio;
    @Element(name = "rendimientoCiudad", required = false)
    private Short _rendimientoCiudad;

    private final static String _str_sql = 
        "    SELECT" +
        "    es.puertas AS puertas," +
        "    es.rendimiento_carretera AS rendimiento_carretera," +
        "    es.id_estilo AS id," +
        "    es.nombre AS nombre," +
        "    es.traccion AS traccion," +
        "    es.id_modelo_anio AS id_modelo_anio," +
        "    es.rendimiento_ciudad AS rendimiento_ciudad" +
        "    FROM estilo es";

    public Estilo() {
        _puertas = null;
        _rendimientoCarretera = null;
        _id = null;
        _nombre = null;
        _traccion = null;
        _idModeloAnio = null;
        _rendimientoCiudad = null;

    }
    /**
     * @return the _puertas
     */
    public Byte getPuertas() {
        return _puertas;
    }
    /**
     * @return the _rendimientoCarretera
     */
    public Short getRendimientoCarretera() {
        return _rendimientoCarretera;
    }
    /**
     * @return the _id
     */
    public Long getId() {
        return _id;
    }
    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }
    /**
     * @return the _traccion
     */
    public String getTraccion() {
        return _traccion;
    }
    /**
     * @return the _idModeloAnio
     */
    public Long getIdModeloAnio() {
        return _idModeloAnio;
    }
    /**
     * @return the _rendimientoCiudad
     */
    public Short getRendimientoCiudad() {
        return _rendimientoCiudad;
    }
    /**
     * @param _puertas the _puertas to set
     */
    public void setPuertas(Byte _puertas) {
        this._puertas = _puertas;
    }
    /**
     * @param _rendimientoCarretera the _rendimientoCarretera to set
     */
    public void setRendimientoCarretera(Short _rendimientoCarretera) {
        this._rendimientoCarretera = _rendimientoCarretera;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Long _id) {
        this._id = _id;
    }
    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }
    /**
     * @param _traccion the _traccion to set
     */
    public void setTraccion(String _traccion) {
        this._traccion = _traccion;
    }
    /**
     * @param _idModeloAnio the _idModeloAnio to set
     */
    public void setIdModeloAnio(Long _idModeloAnio) {
        this._idModeloAnio = _idModeloAnio;
    }
    /**
     * @param _rendimientoCiudad the _rendimientoCiudad to set
     */
    public void setRendimientoCiudad(Short _rendimientoCiudad) {
        this._rendimientoCiudad = _rendimientoCiudad;
    }

    public static Estilo fromRS(ResultSet p_rs) throws SQLException {
        Estilo ret = new Estilo();

        ret.setPuertas(p_rs.getByte("puertas"));
        ret.setRendimientoCarretera(p_rs.getShort("rendimiento_carretera"));
        ret.setId(p_rs.getLong("id"));
        ret.setNombre(p_rs.getString("nombre"));
        ret.setTraccion(p_rs.getString("traccion"));
        ret.setIdModeloAnio(p_rs.getLong("id_modelo_anio"));
        ret.setRendimientoCiudad(p_rs.getShort("rendimiento_ciudad"));

        return ret;
    }

    public static Estilo getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Estilo ret = null;
        
        String str_sql = _str_sql +
            "  WHERE es." + p_key + " = " + p_value +
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

    public static Estilo getById(Connection p_conn, String p_id) throws Exception {
        return getByParameter(p_conn, "id_estilo", p_id);
    }
    
    public static ArrayList<Estilo> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Estilo> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Estilo>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_estilo")) {
                    array_clauses.add("es.id_estilo = " + p.getValue());
                }
                else if (p.getKey().equals("id_modelo_anio")) {
                    array_clauses.add("es.id_modelo_anio = " + p.getValue());
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
            "    UPDATE estilo" +
            "    SET" +
            "    puertas = " + (_puertas != null ? _puertas : "null") + "," +
            "    rendimiento_carretera = " + (_rendimientoCarretera != null ? _rendimientoCarretera : "null") + "," +
            "    nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    traccion = " + (_traccion != null ? "'" + _traccion + "'" : "null") + "," +
            "    rendimiento_ciudad = " + (_rendimientoCiudad != null ? _rendimientoCiudad : "null") +
            "    WHERE" +
            "    id_estilo = " + Long.toString(this._id);

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
            "    INSERT INTO estilo" +
            "    (" +
            "    puertas, " +
            "    rendimiento_carretera, " +
            "    id_estilo, " +
            "    nombre, " +
            "    traccion, " +
            "    id_modelo_anio, " +
            "    rendimiento_ciudad)" +
            "    VALUES" +
            "    (" +
            "    " + (_puertas != null ? "'" + _puertas + "'" : "null") + "," +
            "    " + (_rendimientoCarretera != null ? "'" + _rendimientoCarretera + "'" : "null") + "," +
            "    " + (_id != null ? "'" + _id + "'" : "null") + "," +
            "    " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    " + (_traccion != null ? "'" + _traccion + "'" : "null") + "," +
            "    " + (_idModeloAnio != null ? "'" + _idModeloAnio + "'" : "null") + "," +
            "    " + (_rendimientoCiudad != null ? "'" + _rendimientoCiudad + "'" : "null") +
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
            "    DELETE FROM estilo" +
            "    WHERE" +
            "    id_estilo = " + Long.toString(this._id);

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
        Estilo obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_estilo = " + Long.toString(this._id) +
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

                _puertas = obj.getPuertas();
                _rendimientoCarretera = obj.getRendimientoCarretera();
                _nombre = obj.getNombre();
                _traccion = obj.getTraccion();
                _idModeloAnio = obj.getIdModeloAnio();
                _rendimientoCiudad = obj.getRendimientoCiudad();
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
            "    id_estilo = " + Long.toString(this._id) +
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
        return "Estilo [" +
	           "    _puertas = " + (_puertas != null ? _puertas : "null") + "," +
	           "    _rendimientoCarretera = " + (_rendimientoCarretera != null ? _rendimientoCarretera : "null") + "," +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
	           "    _traccion = " + (_traccion != null ? "'" + _traccion + "'" : "null") + "," +
	           "    _idModeloAnio = " + (_idModeloAnio != null ? _idModeloAnio : "null") + "," +
	           "    _rendimientoCiudad = " + (_rendimientoCiudad != null ? _rendimientoCiudad : "null") +
			   "]";
    }


    public String toJSON() {
        return "{\"Estilo\" : {" +
	           "    \"_puertas\" : " + (_puertas != null ? _puertas : "null") + "," +
	           "    \"_rendimientoCarretera\" : " + (_rendimientoCarretera != null ? _rendimientoCarretera : "null") + "," +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_nombre\" : " + (_nombre != null ? "\"" + _nombre + "\"" : "null") + "," +
	           "    \"_traccion\" : " + (_traccion != null ? "\"" + _traccion + "\"" : "null") + "," +
	           "    \"_idModeloAnio\" : " + (_idModeloAnio != null ? _idModeloAnio : "null") + "," +
	           "    \"_rendimientoCiudad\" : " + (_rendimientoCiudad != null ? _rendimientoCiudad : "null") +
			   "}}";
    }


    public String toXML() {
        return "<Estilo>" +
	           "    <puertas" + (_puertas != null ? ">" + _puertas + "</puertas>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <rendimientoCarretera" + (_rendimientoCarretera != null ? ">" + _rendimientoCarretera + "</rendimientoCarretera>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <id" + (_id != null ? ">" + _id + "</id>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <nombre" + (_nombre != null ? ">" + _nombre + "</nombre>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <traccion" + (_traccion != null ? ">" + _traccion + "</traccion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idModeloAnio" + (_idModeloAnio != null ? ">" + _idModeloAnio + "</idModeloAnio>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <rendimientoCiudad" + (_rendimientoCiudad != null ? ">" + _rendimientoCiudad + "</rendimientoCiudad>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</Estilo>";
    }


/*
    public static Estilo fromXMLNode(Node xmlNode) {
        Estilo ret = new Estilo();

        Element element = (Element) xmlNode;

        ret.setPuertas(Byte.decode(element.getElementsByTagName("puertas").item(0).getTextContent()));
        ret.setRendimientoCarretera(Short.decode(element.getElementsByTagName("rendimiento_carretera").item(0).getTextContent()));
        ret.setId(Long.decode(element.getElementsByTagName("id_estilo").item(0).getTextContent()));
        ret.setNombre(element.getElementsByTagName("nombre").item(0).getTextContent());
        ret.setTraccion(element.getElementsByTagName("traccion").item(0).getTextContent());
        ret.setIdModeloAnio(Long.decode(element.getElementsByTagName("id_modelo_anio").item(0).getTextContent()));
        ret.setRendimientoCiudad(Short.decode(element.getElementsByTagName("rendimiento_ciudad").item(0).getTextContent()));

        return ret;
    }
    */
}
