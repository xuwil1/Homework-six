/**
 * WindSpeedComparator class is used to compare wind speed of two storms.  
 * 
 *  @author Willie Xu
 *	email: xuwillie1@gmail.com
 *	Class CSE 214-R10
 */

import java.io.*;
import java.util.*;

public class WindSpeedComparator implements Comparator{
	/**
	 * compares two windspeed of two storms 
	 */
	public int compare(Object o1,Object o2) {
		Storm s1 = (Storm) o1;
		Storm s2= (Storm) o2;
		/**
		 * returns -1 if storm 2 windspeed is faster
		 */
		if(s1.getWindspeed() < s2.getWindspeed()) {
			return -1;
		}
		/**
		 * returns 0 if both storms have same windspeed
		 */
		else if(s1.getWindspeed() == s2.getWindspeed()) {
			return 0;
		}
		/**
		 * returns 1 if storm 1 has faster windspeed
		 */
		else {
			return 1;
		}
	}
}
