/**
 * Precipitation class is used to compare precipitation of two storms.  
 * 
 *  @author Willie Xu
 *	email: xuwillie1@gmail.com
 *	Class CSE 214-R10
 */

import java.io.*;
import java.util.*;

public class PrecipitationComparator implements Comparator{
	/**
	 * compares rainfall of two storms
	 */
	public int compare(Object o1,Object o2) {
		Storm s1 = (Storm) o1;
		Storm s2= (Storm) o2;
		/**
		 * if storm 2 has more rainfall return -1
		 */
		if(s1.getPrecipitation() < s2.getPrecipitation()) {
			return -1;
		}
		/**
		 * return 0 if both storms have same amount of rainfall 
		 */
		else if(s1.getPrecipitation() == s2.getPrecipitation()) {
			return 0;
		}
		/**
		 * return 1 if storm 1 has more rainfall
		 */
		else {
			return 1;
		}
	}
}
