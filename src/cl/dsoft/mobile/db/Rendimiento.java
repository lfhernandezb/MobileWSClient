/**
 * 
 */
package cl.dsoft.mobile.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author lfhernandez
 *
 */
public class Rendimiento {
	private Date initialDate;
	private Date finalDate;
	private Float rendimiento;
	
	/**
	 * @return the initialDate
	 */
	public Date getInitialDate() {
		return initialDate;
	}
	/**
	 * @return the initialDate as String
	 */
	public String getInitialDateAsString() {
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(this.initialDate);

	}
	/**
	 * @param initialDate the initialDate to set
	 */
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	/**
	 * @param initialDate the initialDate to set as String
	 * @throws ParseException 
	 */
	public void setInitialDate(String sInitialDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this.initialDate = formatter.parse(sInitialDate);
	}
	/**
	 * @return the finalDate
	 */
	public Date getFinalDate() {
		return finalDate;
	}
	/**
	 * @return the finalDate as String
	 */
	public String getFinalDateAsString() {
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(this.finalDate);

	}
	/**
	 * @param finalDate the finalDate to set
	 */
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	/**
	 * @param initialDate the initialDate to set as String
	 * @throws ParseException 
	 */
	public void setFinialDate(String sFinalDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this.finalDate = formatter.parse(sFinalDate);
	}
	/**
	 * @return the rendimiento
	 */
	public Float getRendimiento() {
		return rendimiento;
	}
	/**
	 * @param rendimiento the rendimiento to set
	 */
	public void setRendimiento(Float rendimiento) {
		this.rendimiento = rendimiento;
	}
	
    public String toString() {
        return "Rendimiento [" +
	           "    initialDate = " + (initialDate != null ? "'" + this.getInitialDateAsString() + "'" : "null") + "," +
	           "    finalDate = " + (finalDate != null ? "'" + this.getFinalDateAsString() + "'" : "null") + "," +
	           "    rendimiento = " + (rendimiento != null ? rendimiento.toString() : "null") +
			   "]";
    }
	
}
