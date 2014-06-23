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
public class InfoSincro {
    @Element(name = "id")
    private Integer _id;
    @Element(name = "fecha")
    private String _fecha;
    @Element(name = "fechaFinProcesamiento", required = false)
    private String _fechaFinProcesamiento;
    @Element(name = "sentido")
    private Byte _sentido;
    @Element(name = "fechaLectura", required = false)
    private String _fechaLectura;
    @Element(name = "archivoNombre")
    private String _archivoNombre;
    @Element(name = "archivoMd5")
    private String _archivoMd5;
    @Element(name = "archivoTamano")
    private Long _archivoTamano;

    private final static String _str_sql = 
        "    SELECT" +
        "    in.id_info_sincro AS id," +
        "    strftime('%Y-%m-%d %H:%M:%S', in.fecha) AS fecha," +
        "    strftime('%Y-%m-%d %H:%M:%S', in.fecha_fin_procesamiento) AS fecha_fin_procesamiento," +
        "    in.sentido AS sentido," +
        "    strftime('%Y-%m-%d %H:%M:%S', in.fecha_lectura) AS fecha_lectura," +
        "    in.archivo_nombre AS archivo_nombre," +
        "    in.archivo_md5 AS archivo_md5," +
        "    in.archivo_tamano AS archivo_tamano" +
        "    FROM info_sincro in";

    public InfoSincro() {
        _id = null;
        _fecha = null;
        _fechaFinProcesamiento = null;
        _sentido = null;
        _fechaLectura = null;
        _archivoNombre = null;
        _archivoMd5 = null;
        _archivoTamano = null;

    }
    /**
     * @return the _id
     */
    public Integer getId() {
        return _id;
    }
    /**
     * @return the _fecha
     */
    public String getFecha() {
        return _fecha;
    }
    /**
     * @return the _fechaFinProcesamiento
     */
    public String getFechaFinProcesamiento() {
        return _fechaFinProcesamiento;
    }
    /**
     * @return the _sentido
     */
    public Byte getSentido() {
        return _sentido;
    }
    /**
     * @return the _fechaLectura
     */
    public String getFechaLectura() {
        return _fechaLectura;
    }
    /**
     * @return the _archivoNombre
     */
    public String getArchivoNombre() {
        return _archivoNombre;
    }
    /**
     * @return the _archivoMd5
     */
    public String getArchivoMd5() {
        return _archivoMd5;
    }
    /**
     * @return the _archivoTamano
     */
    public Long getArchivoTamano() {
        return _archivoTamano;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Integer _id) {
        this._id = _id;
    }
    /**
     * @param _fecha the _fecha to set
     */
    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }
    /**
     * @param _fechaFinProcesamiento the _fechaFinProcesamiento to set
     */
    public void setFechaFinProcesamiento(String _fechaFinProcesamiento) {
        this._fechaFinProcesamiento = _fechaFinProcesamiento;
    }
    /**
     * @param _sentido the _sentido to set
     */
    public void setSentido(Byte _sentido) {
        this._sentido = _sentido;
    }
    /**
     * @param _fechaLectura the _fechaLectura to set
     */
    public void setFechaLectura(String _fechaLectura) {
        this._fechaLectura = _fechaLectura;
    }
    /**
     * @param _archivoNombre the _archivoNombre to set
     */
    public void setArchivoNombre(String _archivoNombre) {
        this._archivoNombre = _archivoNombre;
    }
    /**
     * @param _archivoMd5 the _archivoMd5 to set
     */
    public void setArchivoMd5(String _archivoMd5) {
        this._archivoMd5 = _archivoMd5;
    }
    /**
     * @param _archivoTamano the _archivoTamano to set
     */
    public void setArchivoTamano(Long _archivoTamano) {
        this._archivoTamano = _archivoTamano;
    }

    public static InfoSincro fromRS(ResultSet p_rs) throws SQLException {
        InfoSincro ret = new InfoSincro();

        ret.setId(p_rs.getInt("id"));
        ret.setFecha(p_rs.getString("fecha"));
        ret.setFechaFinProcesamiento(p_rs.getString("fecha_fin_procesamiento"));
        ret.setSentido(p_rs.getByte("sentido"));
        ret.setFechaLectura(p_rs.getString("fecha_lectura"));
        ret.setArchivoNombre(p_rs.getString("archivo_nombre"));
        ret.setArchivoMd5(p_rs.getString("archivo_md5"));
        ret.setArchivoTamano(p_rs.getLong("archivo_tamano"));

        return ret;
    }

    public static InfoSincro getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        InfoSincro ret = null;
        
        String str_sql = _str_sql +
            "  WHERE in." + p_key + " = " + p_value +
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

    public static InfoSincro getById(Connection p_conn, String p_id) throws Exception {
        return getByParameter(p_conn, "id_info_sincro", p_id);
    }
    
    public static ArrayList<InfoSincro> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<InfoSincro> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<InfoSincro>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_info_sincro")) {
                    array_clauses.add("in.id_info_sincro = " + p.getValue());
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
            "    UPDATE info_sincro" +
            "    SET" +
            "    fecha = " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
            "    fecha_fin_procesamiento = " + (_fechaFinProcesamiento != null ? "'" + _fechaFinProcesamiento + "'" : "null") + "," +
            "    sentido = " + (_sentido != null ? _sentido : "null") + "," +
            "    fecha_lectura = " + (_fechaLectura != null ? "'" + _fechaLectura + "'" : "null") + "," +
            "    archivo_nombre = " + (_archivoNombre != null ? "'" + _archivoNombre + "'" : "null") + "," +
            "    archivo_md5 = " + (_archivoMd5 != null ? "'" + _archivoMd5 + "'" : "null") + "," +
            "    archivo_tamano = " + (_archivoTamano != null ? _archivoTamano : "null") +
            "    WHERE" +
            "    id_info_sincro = " + Integer.toString(this._id);

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
            "    INSERT INTO info_sincro" +
            "    (" +
            "    id_info_sincro, " +
            "    fecha, " +
            "    fecha_fin_procesamiento, " +
            "    sentido, " +
            "    fecha_lectura, " +
            "    archivo_nombre, " +
            "    archivo_md5, " +
            "    archivo_tamano)" +
            "    VALUES" +
            "    (" +
            "    " + (_id != null ? "'" + _id + "'" : "null") + "," +
            "    " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
            "    " + (_fechaFinProcesamiento != null ? "'" + _fechaFinProcesamiento + "'" : "null") + "," +
            "    " + (_sentido != null ? "'" + _sentido + "'" : "null") + "," +
            "    " + (_fechaLectura != null ? "'" + _fechaLectura + "'" : "null") + "," +
            "    " + (_archivoNombre != null ? "'" + _archivoNombre + "'" : "null") + "," +
            "    " + (_archivoMd5 != null ? "'" + _archivoMd5 + "'" : "null") + "," +
            "    " + (_archivoTamano != null ? "'" + _archivoTamano + "'" : "null") +
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
            "    DELETE FROM info_sincro" +
            "    WHERE" +
            "    id_info_sincro = " + Integer.toString(this._id);

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
        InfoSincro obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_info_sincro = " + Integer.toString(this._id) +
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

                _fecha = obj.getFecha();
                _fechaFinProcesamiento = obj.getFechaFinProcesamiento();
                _sentido = obj.getSentido();
                _fechaLectura = obj.getFechaLectura();
                _archivoNombre = obj.getArchivoNombre();
                _archivoMd5 = obj.getArchivoMd5();
                _archivoTamano = obj.getArchivoTamano();
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
            "    id_info_sincro = " + Integer.toString(this._id) +
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
        return "InfoSincro [" +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _fecha = " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
	           "    _fechaFinProcesamiento = " + (_fechaFinProcesamiento != null ? "'" + _fechaFinProcesamiento + "'" : "null") + "," +
	           "    _sentido = " + (_sentido != null ? _sentido : "null") + "," +
	           "    _fechaLectura = " + (_fechaLectura != null ? "'" + _fechaLectura + "'" : "null") + "," +
	           "    _archivoNombre = " + (_archivoNombre != null ? "'" + _archivoNombre + "'" : "null") + "," +
	           "    _archivoMd5 = " + (_archivoMd5 != null ? "'" + _archivoMd5 + "'" : "null") + "," +
	           "    _archivoTamano = " + (_archivoTamano != null ? _archivoTamano : "null") +
			   "]";
    }


    public String toJSON() {
        return "{\"InfoSincro\" : {" +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_fecha\" : " + (_fecha != null ? "\"" + _fecha + "\"" : "null") + "," +
	           "    \"_fecha_fin_procesamiento\" : " + (_fechaFinProcesamiento != null ? "\"" + _fechaFinProcesamiento + "\"" : "null") + "," +
	           "    \"_sentido\" : " + (_sentido != null ? _sentido : "null") + "," +
	           "    \"_fecha_lectura\" : " + (_fechaLectura != null ? "\"" + _fechaLectura + "\"" : "null") + "," +
	           "    \"_archivo_nombre\" : " + (_archivoNombre != null ? "\"" + _archivoNombre + "\"" : "null") + "," +
	           "    \"_archivo_md5\" : " + (_archivoMd5 != null ? "\"" + _archivoMd5 + "\"" : "null") + "," +
	           "    \"_archivoTamano\" : " + (_archivoTamano != null ? _archivoTamano : "null") +
			   "}}";
    }


    public String toXML() {
        return "<InfoSincro>" +
	           "    <id" + (_id != null ? ">" + _id + "</id>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fecha" + (_fecha != null ? ">" + _fecha + "</fecha>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaFinProcesamiento" + (_fechaFinProcesamiento != null ? ">" + _fechaFinProcesamiento + "</fechaFinProcesamiento>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <sentido" + (_sentido != null ? ">" + _sentido + "</sentido>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaLectura" + (_fechaLectura != null ? ">" + _fechaLectura + "</fechaLectura>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <archivoNombre" + (_archivoNombre != null ? ">" + _archivoNombre + "</archivoNombre>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <archivoMd5" + (_archivoMd5 != null ? ">" + _archivoMd5 + "</archivoMd5>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <archivoTamano" + (_archivoTamano != null ? ">" + _archivoTamano + "</archivoTamano>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</InfoSincro>";
    }


/*
    public static InfoSincro fromXMLNode(Node xmlNode) {
        InfoSincro ret = new InfoSincro();

        Element element = (Element) xmlNode;

        ret.setId(Integer.decode(element.getElementsByTagName("id_info_sincro").item(0).getTextContent()));
        ret.setFecha(element.getElementsByTagName("fecha").item(0).getTextContent());
        ret.setFechaFinProcesamiento(element.getElementsByTagName("fecha_fin_procesamiento").item(0).getTextContent());
        ret.setSentido(Byte.decode(element.getElementsByTagName("sentido").item(0).getTextContent()));
        ret.setFechaLectura(element.getElementsByTagName("fecha_lectura").item(0).getTextContent());
        ret.setArchivoNombre(element.getElementsByTagName("archivo_nombre").item(0).getTextContent());
        ret.setArchivoMd5(element.getElementsByTagName("archivo_md5").item(0).getTextContent());
        ret.setArchivoTamano(Long.decode(element.getElementsByTagName("archivo_tamano").item(0).getTextContent()));

        return ret;
    }
    */
}
