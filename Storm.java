/**
 * Storm class is used to create a storm.  
 * 
 *  @author Willie Xu
 *	email: xuwillie1@gmail.com
 *	Class CSE 214-R10
 */

import java.io.*;
import java.util.*;

public class Storm implements Serializable {
	private String name;
	private double precipitation;
	private double windspeed;
	private String date; //must be formatted Internet-Style YYYY-MM-DD
	/**
	 * Constructor for storm
	 * name of storm
	 * @param name
	 * how much rain of storm
	 * @param precipitation
	 * how much wind of storm
	 * @param windspeed
	 * date of storm
	 * @param date
	 */
	public Storm(String name,double precipitation,double windspeed, String date){
		this.name=name;
		this.precipitation=precipitation;
		this.windspeed=windspeed;
		this.date=date;
	}
	/**
	 * returns name of storm
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * returns precipitation of storm	
	 * @return
	 */
	public double getPrecipitation() {
		return this.precipitation;
	}
	/**
	 * returns windspeed of storm
	 * @return
	 */
	public double getWindspeed() {
		return this.windspeed;
	}
	/**
	 * returns date of storm
	 * @return
	 */
	public String getDate() {
		return this.date;
	}
	/**
	 * set name of storm
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * sets precipitation of storm
	 * @param precipitation
	 */
	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}
	/**
	 * sets windspeed of storm
	 * @param windspeed
	 */
	public void setWindspeed(double windspeed) {
		this.windspeed = windspeed;
	}
	/**
	 * sets date of storm
	 * @param date
	 * throws DateException if date is not in YYYY-MM-DD format
	 * @throws DateException
	 */
	public void setDate(String date){
		this.date = date;
	}
	/**
	 *returns information of storm 
	 */
	public String toString() {
		return "Storm " +this.name+": Date "+this.date+", "+this.windspeed+ "km/h winds, "+this.precipitation+" cm of rain";	
	}
	/**
	 * retuns storm information for list
	 */
	public void print() {
		System.out.printf("%-20s%-13.2f%-20.2f\n",this.name,this.windspeed,this.precipitation);
	}
}
